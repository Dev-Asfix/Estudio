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

console.log(5 > 3 && 2 < 4);  // true: ambas condiciones son verdaderas
console.log(5 > 3 && 2 > 4);  // false: una de las condiciones es falsa
console.log(0 && true);       // 0: el operador `&&` retorna el primer valor falso (o el último si ambos son verdaderos)

console.log(5 > 3 || 2 > 4);  // true: una de las condiciones es verdadera
console.log(false || 0);      // 0: el operador `||` retorna el primer valor verdadero o el último si ambos son falsos
console.log(null || "hello"); // "hello": `null` es falso, así que retorna "hello"

console.log(!true);          // false: la negación de true es false
console.log(!0);             // true: la negación de 0 (falso) es true
console.log(!(5 > 3));       // false: la negación de true es false
console.log(!!"text");       // true: doble negación convierte un valor a su valor booleano verdadero

console.log((5 > 3 && 2 < 4) || (5 < 3 && 2 > 4)); // true: el primer conjunto de condiciones es verdadero
console.log(!(5 == 5) && (true || false));         // false: la negación de true es false, lo que hace que todo sea false

console.log("5" > 2);        // true: "5" se convierte a 5, y 5 es mayor que 2
console.log("5" < 12);       // false: "5" se convierte a 5, y 5 no es menor que 12
console.log("true" == true); // false: la cadena "true" no es igual al booleano true
console.log("false" === false); // false: la cadena "false" no es estrictamente igual al booleano false
