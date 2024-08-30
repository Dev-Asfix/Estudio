let lista = ['Manzana', 'Banana']
console.log(lista);

let primero = lista[0];

let ultimo = lista[lista.length - 1];

console.log(primero);
console.log(ultimo);

lista.forEach(function(elemento, indice , array)){
    console.log(elemento, indice);
}