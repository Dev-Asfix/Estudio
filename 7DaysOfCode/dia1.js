console.log(5 == "5");    // true  : el número 5 es igual a la cadena "5" después de la conversión de tipos
console.log(5 === "5");   // false : el número 5 no es estrictamente igual a la cadena "5" (diferentes tipos)
console.log(0 == false);  // true : 0 es igual a false después de la conversión de tipos
console.log(0 === false); // false   : 0 (número) no es estrictamente igual a false (booleano)

console.log("10" != 10);   // false: "10" es igual a 10 después de la conversión de tipos
console.log("10" !== 10);  // true: "10" no es estrictamente igual a 10 (diferentes tipos)
console.log(null == undefined); // true: null y undefined se consideran iguales con `==`
console.log(null === undefined);// false: null y undefined no son estrictamente iguales

console.log(7 > 5);    // true: 7 es mayor que 5
console.log(7 >= 7);   // true: 7 es mayor o igual a 7
console.log(3 < 4);    // true: 3 es menor que 4
console.log(3 <= 3);   // true: 3 es menor o igual a 3
console.log("apple" < "banana"); // true: En orden lexicográfico, "apple" viene antes que "banana"
