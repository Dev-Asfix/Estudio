// Inicializa las categorías y la lista de compras
let categorias = {
    1: 'Frutas',
    2: 'Lácteos',
    3: 'Congelados',
    4: 'Dulces',
    5: 'Otros' // Para alimentos que no encajan en las categorías predefinidas
};

let listaCompras = {
    1: [],
    2: [],
    3: [],
    4: [],
    5: []
};

// Función para agregar alimentos a la lista de compras
function agregarAlimento() {
    let continuar = prompt('¿Deseas agregar un alimento a tu lista de compras? Responde con "1" para Sí o "2" para No');
    
    // Mientras el usuario quiera seguir agregando alimentos
    while (continuar === '1') {
        let alimento = prompt('¿Qué alimento deseas agregar?');
        
        let categoria = parseInt(prompt('¿En qué categoría se encaja ese alimento? (1: Frutas, 2: Lácteos, 3: Congelados, 4: Dulces, 5: Otros)'), 10);
        
        // Verifica si la categoría es válida
        if (categoria in listaCompras) {
            listaCompras[categoria].push(alimento);
        } else {
            alert('Categoría no válida. Se añadirá a "Otros".');
            listaCompras[5].push(alimento);
        }

        // Pregunta si el usuario desea agregar otro alimento
        continuar = prompt('¿Deseas agregar otro alimento a tu lista de compras? Responde con "1" para Sí o "2" para No');
    }

    // Muestra la lista de compras organizada por categorías
    mostrarLista();
}

// Función para mostrar la lista de compras
function mostrarLista() {
    let mensaje = 'Lista de compras:\n';

    for (const [key, categoria] of Object.entries(categorias)) {
        let alimentos = listaCompras[key].join(', ');
        mensaje += `${categoria}: ${alimentos || 'No hay alimentos'}\n`;
    }

    alert(mensaje);
}

// Llama a la función para comenzar el proceso
agregarAlimento();
