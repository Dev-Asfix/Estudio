// Comparaciones con == y ===
console.log(5 == "5");    
// true: El operador `==` compara solo los valores, no los tipos. 
// JavaScript convierte la cadena "5" en el número 5 para la comparación. 
// Como ambos son 5, la comparación es verdadera.

console.log(5 === "5");   
// false: El operador `===` compara tanto el valor como el tipo de los datos.
// Aquí, 5 es un número y "5" es una cadena, por lo que no son estrictamente iguales. 
// La comparación es falsa.

console.log(0 == false);  
// true: El operador `==` convierte `false` en 0, y 0 == 0 es verdadero.
// Así que la comparación retorna true.

console.log(0 === false); 
// false: El operador `===` no realiza ninguna conversión de tipo.
// Aquí, 0 es un número y false es un booleano, por lo que no son iguales. 
// La comparación es falsa.

// Comparaciones con != y !==
console.log("10" != 10);   
// false: El operador `!=` compara valores después de la conversión de tipos.
// JavaScript convierte la cadena "10" en el número 10, y 10 no es diferente de 10. 
// Por lo tanto, la comparación es falsa.

console.log("10" !== 10);  
// true: El operador `!==` compara valores y tipos sin conversión. 
// "10" es una cadena y 10 es un número, por lo que no son estrictamente iguales. 
// La comparación es verdadera.

console.log(null == undefined); 
// true: En JavaScript, `null` y `undefined` son considerados iguales cuando se usa `==`. 
// Por lo tanto, la comparación es verdadera.

console.log(null === undefined);
// false: Aunque `null` y `undefined` son similares, no son estrictamente iguales. 
// Con `===`, la comparación devuelve falso porque son de tipos diferentes.

// Comparaciones numéricas y de cadenas
console.log(7 > 5);    
// true: Este es un caso simple de comparación numérica. 
// 7 es mayor que 5, por lo tanto, la comparación es verdadera.

console.log(7 >= 7);   
// true: `>=` significa "mayor o igual que". 
// Como 7 es igual a 7, la comparación es verdadera.

console.log(3 < 4);    
// true: 3 es menor que 4, por lo tanto, la comparación es verdadera.

console.log(3 <= 3);   
// true: `<=` significa "menor o igual que". 
// Como 3 es igual a 3, la comparación es verdadera.

console.log("apple" < "banana"); 
// true: JavaScript compara cadenas de texto usando el orden lexicográfico (como en un diccionario).
// Aquí, "apple" viene antes que "banana", por lo tanto, la comparación es verdadera.

// Operadores lógicos && (AND) y || (OR)
console.log(5 > 3 && 2 < 4);  
// true: El operador `&&` requiere que ambas condiciones sean verdaderas.
// 5 es mayor que 3 y 2 es menor que 4, por lo tanto, toda la expresión es verdadera.

console.log(5 > 3 && 2 > 4);  
// false: Aquí, aunque 5 es mayor que 3, 2 no es mayor que 4. 
// Como `&&` necesita que ambas condiciones sean verdaderas, la expresión es falsa.

console.log(0 && true);       
// 0: El operador `&&` devuelve el primer valor falso que encuentra, o el último si todos son verdaderos.
// Aquí, 0 es considerado falso en JavaScript, por lo que la expresión retorna 0.

console.log(5 > 3 || 2 > 4);  
// true: El operador `||` requiere que al menos una de las condiciones sea verdadera.
// 5 es mayor que 3, por lo que la primera condición es verdadera y la expresión completa es verdadera.

console.log(false || 0);      
// 0: `||` retorna el primer valor verdadero que encuentra, o el último si todos son falsos.
// Tanto `false` como `0` son falsos en JavaScript, así que la expresión retorna 0.

console.log(null || "hello"); 
// "hello": `null` es un valor falso en JavaScript, mientras que "hello" es un valor verdadero.
// Como `||` retorna el primer valor verdadero, la expresión retorna "hello".

// Operador ! (NOT)
console.log(!true);          
// false: `!` es el operador de negación. 
// Invierte el valor booleano, por lo que `!true` es `false`.

console.log(!0);             
// true: En JavaScript, 0 es considerado falso. 
// La negación de falso es verdadero, por lo que `!0` es `true`.

console.log(!(5 > 3));       
// false: 5 es mayor que 3, lo que es verdadero. 
// La negación de verdadero es falso, por lo que `!(5 > 3)` es `false`.

console.log(!!"text");       
// true: `!!` es una doble negación, que convierte un valor a su valor booleano.
// Una cadena de texto no vacía es considerada verdadera, por lo que `!!"text"` es `true`.

// Combinaciones complejas
console.log((5 > 3 && 2 < 4) || (5 < 3 && 2 > 4)); 
// true: Primero, `&&` evalúa ambas condiciones dentro de cada paréntesis. 
// (5 > 3 && 2 < 4) es verdadero, mientras que (5 < 3 && 2 > 4) es falso.
// Luego, `||` evalúa las dos expresiones. Como una es verdadera, toda la expresión es verdadera.

console.log(!(5 == 5) && (true || false));         
// false: `(5 == 5)` es verdadero, pero `!` invierte esto a falso.
// `true || false` es verdadero, pero como `&&` requiere que ambas condiciones sean verdaderas,
// toda la expresión es falsa.

// Comparaciones de tipos mixtos
console.log("5" > 2);        
// true: JavaScript convierte "5" (una cadena) en 5 (un número) para esta comparación. 
// 5 es mayor que 2, por lo tanto, la comparación es verdadera.

console.log("5" < 12);       
// false: Aunque JavaScript convierte "5" en 5, la comparación aquí es menos intuitiva.
// 5 no es menor que 12, por lo que la comparación es falsa.

console.log("true" == true); 
// false: La cadena "true" no se convierte en el booleano `true`.
// La comparación entre una cadena y un booleano es falsa.

console.log("false" === false); 
// false: La cadena "false" y el booleano `false` son de tipos diferentes. 
// El operador `===` no realiza ninguna conversión de tipo, por lo que la comparación es falsa.
