package com.dev.floatbin.service;

import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Sgd;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NeuralNetworkService {
    private final MultiLayerNetwork model;
    private final List<double[]> trainingData = new ArrayList<>();
    private boolean isTrained = false;

    public NeuralNetworkService() {
        this.model = new MultiLayerNetwork(new NeuralNetConfiguration.Builder()
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .weightInit(WeightInit.XAVIER)
                .updater(new Sgd(0.01))
                .list()
                .layer(0, new OutputLayer.Builder(LossFunctions.LossFunction.MSE)
                        .activation(Activation.IDENTITY)
                        .nIn(1) // Entrada: distancia normalizada
                        .nOut(1) // Salida: tiempoParaLlenar normalizado
                        .build())
                .build());
        this.model.init();
        // 🚀 Agregar entrenamiento manual para probar si se ejecuta
        trainAndTest();
    }

    public void trainModel(double distance, double tiempoParaLlenar) {
        double normalizedDistance = distance / 30.0; // Cambio de normalización
        double normalizedTiempo = tiempoParaLlenar / 10000.0;

        trainingData.add(new double[]{normalizedDistance, normalizedTiempo});
        System.out.println("📊 Datos en trainingData: " + trainingData.size());

        if (trainingData.size() > 5) {
            int dataSize = trainingData.size();
            INDArray inputs = Nd4j.zeros(dataSize, 1);
            INDArray outputs = Nd4j.zeros(dataSize, 1);

            for (int i = 0; i < dataSize; i++) {
                inputs.putScalar(i, 0, trainingData.get(i)[0]);
                outputs.putScalar(i, 0, trainingData.get(i)[1]);
            }

            model.fit(inputs, outputs);
            isTrained = true;
            System.out.println("🔧 Modelo entrenado con " + dataSize + " datos.");
        }
    }

    public String predictEstado(double distance) {
        if (!isTrained) {
            return "No hay datos suficientes para proporcionar una recomendación";
        }

        INDArray input = Nd4j.create(new double[]{distance / 30.0}, new int[]{1, 1});
        INDArray output = model.output(input);
        double tiempoParaLlenar = output.getDouble(0) * 10000.0; // Desnormalización

        System.out.println("🔍 Predicción: Distancia=" + distance + ", Tiempo para llenar=" + tiempoParaLlenar);

        if (tiempoParaLlenar < 0 || tiempoParaLlenar > 50000) {
            return "Predicción fuera de rango";
        }

        if (tiempoParaLlenar > 30000) return "Vacio";
        if (tiempoParaLlenar > 25000) return "Bajo";
        if (tiempoParaLlenar > 20000) return "Medio";
        if (tiempoParaLlenar > 10000) return "Alto";
        return "Lleno";
    }

    // Método para pruebas manuales
    public void trainAndTest() {
        trainModel(10, 5000);
        trainModel(20, 10000);
        trainModel(30, 15000);
        trainModel(40, 20000);
        trainModel(50, 25000);

        System.out.println("🔍 Predicción manual: " + predictEstado(20));
    }
}
