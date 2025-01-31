let numeroSecreto = Math.floor(Math.random()*(10-0+1)+0)
console.log(numeroSecreto);
let acierto = false;

for(let intento = 0; intento <= 3; intento++){
    let numeroJugador = parseInt(prompt('Ingresa un numero del 1 al 10'),10)
    
    if(numeroJugador == numeroSecreto){
        alert('Ganaste!');
        acierto = true
        break;
    } else {
        alert(`Incorrecto te quedan ${3-intento} ${(3-intento) == 1 ?'intento.':'intentos.'}`)
    }
}

if(!acierto){
    alert('Perdiste todos los intentos');
}