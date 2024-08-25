//Juego Numero secreto

let intentos = 0;
let intentosJugar = 0;
let numeroMaquina = Math.floor(Math.random()*((10-0)+1)+0);
console.log(numeroMaquina);

function elegir(){
    
    let numeroJugador = parseInt(prompt('Elige un numero del 1 al 10'), 10);
    
    
        if(numeroJugador >=0 &&numeroJugador <= 10){
            return jugar(numeroJugador);
        } else {

            intentos ++;
            if(intentos<3){
                alert(`Número no válido. Te quedan ${3 - intentos} intentos.`);
                elegir();
            } else {
                alert('Has alcanzado el numero maximo de intentos. Fin del juego')
            }
        } 
}

function jugar(numeroJugador){
        
        
            if(numeroMaquina == numeroJugador){
                alert('Ganaste');
            } else {
                intentosJugar++;
                
                if(intentosJugar < 3){
                    alert('Numero incorrecto. Intenta de nuevo');
                    elegir();
                } else {
                    alert(`Perdiste. El número era ${numeroMaquina}.`);
                }
            } 
         
}

elegir();


// Solucion en menos codigo

/*

const numeroAdivinacion = Math.floor(Math.random() * (10 - 0 + 1) + 0);
let intento = "";
let acerto = false;

for(let contador = 0; contador < 3; contador++){    
    intento = prompt("Intenta adivinar el número del 0 al 10:");
    if(intento == numeroAdivinacion){
        alert("¡Felicidades, acertaste! El número era ${numeroAdivinacion}.");
        acerto = true;
        break;
    }
    alert("¡Incorrecto!");
}
if(!acerto){
    alert("Desafortunadamente, no acertaste. ¡El número era ${numeroAdivinacion}!");
}
*/ 