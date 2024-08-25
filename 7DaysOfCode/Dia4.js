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

