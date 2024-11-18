// Importa el cliente de Prometheus para definir y recopilar métricas
const express = require('express'); // Importa el framework Express para manejar rutas HTTP
const promClient = require('prom-client'); // Importa la librería prom-client para Prometheus

const app = express(); // Crea una aplicación de Express
const port = 3000; // Define el puerto donde el servidor se ejecutará

// Configura el cliente de Prometheus
const register = promClient.register; // Objeto donde se registran todas las métricas
promClient.collectDefaultMetrics(); // Recopila métricas estándar del sistema (como uso de memoria, CPU, etc.)

// Define una métrica personalizada: contador
const httpRequestCounter = new promClient.Counter({
  name: 'http_requests_total', // Nombre de la métrica (debe ser único y descriptivo)
  help: 'Total de solicitudes HTTP', // Descripción de la métrica
  labelNames: ['method', 'route', 'status'] // Etiquetas asociadas para clasificar las métricas
});

// Define una métrica personalizada: histograma
const httpRequestDuration = new promClient.Histogram({
  name: 'http_request_duration_seconds', // Nombre del histograma
  help: 'Duración de las solicitudes HTTP en segundos', // Descripción de la métrica
  labelNames: ['method', 'route', 'status'] // Etiquetas para clasificar los datos del histograma
});

// Middleware para capturar métricas de cada solicitud HTTP
app.use((req, res, next) => {
  const start = Date.now(); // Marca el tiempo inicial cuando llega la solicitud

  res.on('finish', () => {
    // Evento que se ejecuta al terminar la respuesta
    const duration = (Date.now() - start) / 1000; // Calcula la duración de la solicitud en segundos

    // Incrementa el contador de solicitudes HTTP con las etiquetas correspondientes
    httpRequestCounter.inc({
      method: req.method, // Método HTTP (GET, POST, etc.)
      route: req.path, // Ruta solicitada
      status: res.statusCode // Código de estado HTTP de la respuesta
    });

    // Registra la duración de la solicitud en el histograma con las mismas etiquetas
    httpRequestDuration.observe(
      {
        method: req.method,
        route: req.path,
        status: res.statusCode
      },
      duration // Duración de la solicitud
    );
  });

  next(); // Pasa al siguiente middleware o controlador de ruta
});

// Ruta principal
app.get('/', (req, res) => {
  res.send('¡Hola, Prometheus!'); // Responde con un mensaje simple al visitar la raíz del servidor
});

// Ruta para exponer métricas a Prometheus
app.get('/metrics', async (req, res) => {
  res.set('Content-Type', register.contentType); // Establece el encabezado de tipo de contenido para Prometheus
  res.end(await register.metrics()); // Envía todas las métricas recopiladas en el formato esperado por Prometheus
});

// Inicia el servidor en el puerto especificado
app.listen(port, () => {
  console.log(`Servidor escuchando en http://localhost:${port}`); // Mensaje de confirmación al iniciar el servidor
  console.log(`Métricas disponibles en http://localhost:${port}/metrics`); // URL donde se pueden consultar las métricas
});
