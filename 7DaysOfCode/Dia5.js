// Inicializa las categorías y la lista de compras
let categorias = {
    Frutas: [],
    Lácteos: [],
    Congelados: [],
    Dulces: [],
    Otros: [] // Para alimentos que no encajan en las categorías predefinidas
};

// Función para agregar alimentos a la lista de compras
function agregarAlimento() {
    let continuar = prompt('¿Deseas agregar un alimento a tu lista de compras? Responde "sí" o "no"').toLowerCase();
    
    // Mientras el usuario quiera seguir agregando alimentos
    while (continuar === 'sí') {
        let alimento = prompt('¿Qué alimento deseas agregar?');
        let categoria = prompt('¿En qué categoría se encaja ese alimento? (Frutas, Lácteos, Congelados, Dulces, Otros)').toLowerCase();

        // Añade el alimento a la categoría correspondiente
        switch (categoria) {
            case 'frutas':
                categorias.Frutas.push(alimento);
                break;
            case 'lácteos':
                categorias.Lácteos.push(alimento);
                break;
            case 'congelados':
                categorias.Congelados.push(alimento);
                break;
            case 'dulces':
                categorias.Dulces.push(alimento);
                break;
            default:
                categorias.Otros.push(alimento);
                break;
        }

        // Pregunta si el usuario desea agregar otro alimento
        continuar = prompt('¿Deseas agregar otro alimento a tu lista de compras? Responde "sí" o "no"').toLowerCase();
    }

    // Muestra la lista de compras organizada por categorías
    mostrarLista();
}

// Función para mostrar la lista de compras
function mostrarLista() {
    console.log('Lista de compras:');
    for (const [categoria, alimentos] of Object.entries(categorias)) {
        if (alimentos.length > 0) {
            console.log(`${categoria}: ${alimentos.join(', ')}`);
        } else {
            console.log(`${categoria}: `);
        }
    }
}

// Llama a la función para comenzar el proceso
agregarAlimento();


