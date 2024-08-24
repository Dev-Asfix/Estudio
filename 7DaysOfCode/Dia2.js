let lenguaje = prompt('¿Qué lenguaje de programación estas aprendiendo?');
let gusto = prompt('¿Te gusta estudiar '+lenguaje+"? Responde con el número 1 para SI o 2 para NO");
let numero = 0;

while(numero <=2){
    if(gusto == 1){
        alert('¡Muy bien! Sigue estudiando y tendrás mucho éxito.');
        numero = 4
    } else if(gusto == 2){
        alert('Oh, qué pena ... ¿Ya intestaste aprender otros lenguajes?');
        numero = 4;
    } else {
        alert('Intenta de nuevo con otro numero, Tienes '+(3-numero) +' intentos');
        gusto = prompt('¿Te gusta estudiar '+lenguaje+"? Responde con el número 1 para SI o 2 para NO");
        numero++;
    }
}