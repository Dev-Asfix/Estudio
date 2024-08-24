let especialidad = prompt('Qué especialidad te interesa ? Frontend = 2 o Backend = 1 ');
let especialidadBackend = 0;
let especialidadFrontend = 0;
let intentos = 0;
while(intentos <3){
    if(especialidad == 1 || especialidad =="backend"){
        especialidadBackend = prompt('Quieres aprender \nJava = 1  \nC# = 2 \nElige un numero ');
        
        let intentoBack = 0;

        while(intentoBack < 3){

            if(especialidadBackend == 1){
                alert('Perfecto , Java es un buen Lenguaje');
                intentoBack = 4;
            } else if(especialidadBackend == 2){
                alert('Genial , C# es un Buen Lenguaje');
                intentoBack = 4;
            } else {
                alert('Elige un numero correcto, tienes '+(3 - intentoBack) + "Intentos");
                especialidadBackend = prompt('Quieres aprender \nJava = 1  \nC# = 2 \nElige un numero ');
                intentoBack ++;

            }
        }

        intentos = 4;
        
       

    } else if(especialidad == 2 || especialidad =="frontend"){
        especialidadFrontend = prompt('Quieres aprender \nReact = 1  \nVue = 2 \nElige un numero ');
        let intentoFront = 0;

        while(intentoFront < 3){

            if(especialidadFrontend == 1){
                alert('Perfecto , REACT es un buen Framework');
                intentoFront = 4;
            } else if(especialidadFrontend == 2){
                alert('Genial , Vue es un buen Framework');
                intentoFront = 4;
            } else {
                alert('Elige un numero correcto, tienes '+(3 - intentoBack) + "Intentos");
                especialidadFrontend = prompt('Quieres aprender \nReact = 1  \nVue = 2 \nElige un numero ');
                intentoFront ++;

            }
        }
        intentos = 4;

    } else {

        alert('Elige un numero correcto tienes ' +(3 - intentos)+" intentos");
        especialidad = prompt('Qué especialidad te interesa ? Frontend = 2 o Backend = 1 ');
        intentos++;

    }
    
}