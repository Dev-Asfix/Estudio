let ataqueJugador;
let ataqueEnemigo;
let vidasJugador = 3;
let vidasEnemigo = 3;


function iniciarJuego(){
    let botonMascotaJugador = document.getElementById('btn-mascotas');
    botonMascotaJugador.addEventListener('click', seleccionarMascotaJugador);

    let botonFuego = document.getElementById('btn-fuego');
    botonFuego.addEventListener('click', ataqueFuego);
    let botonAgua = document.getElementById('btn-agua');
    botonAgua.addEventListener('click',ataqueAgua);
    let botonTierra = document.getElementById('btn-tierra');
    botonTierra.addEventListener('click',ataqueTierra);
}

function seleccionarMascotaJugador(){

    let inputHipodoge = document.getElementById('hipodoge');
    let inputCapipepo = document.getElementById('capipepo');
    let inputRatigueya = document.getElementById('ratigueya')
    let spanMascotaJugador = document.getElementById('mascota-jugador')

    if(inputHipodoge.checked){
        spanMascotaJugador.innerHTML = "Hipodoge";
    } else if(inputCapipepo.checked){
        spanMascotaJugador.innerHTML = "Capipepo";
    } else if(inputRatigueya.checked){
        spanMascotaJugador.innerHTML = "Ratigueya"
    } else {
        alert('Selecciona una mascota');
    }

    seleccionarMascotaEnemigo();
}

function seleccionarMascotaEnemigo(){

    let spanMascotaEnemiga = document.getElementById('mascota-enemiga');
    let enemigoAleatorio = numeroAleatorio(1,3);

    if(enemigoAleatorio == 1){
        spanMascotaEnemiga.innerHTML="Hipodoge";
    } else if(enemigoAleatorio == 2){
        spanMascotaEnemiga.innerHTML="Capipepo";
    } else if(enemigoAleatorio){
        spanMascotaEnemiga.innerHTML="Ratigueya";
    } else {
        spanMascotaEnemiga.innerHTML="Error"
    }

}

function ataqueFuego(){
    ataqueJugador = 'FUEGO'
    ataqueAleatorioEnemigo();
}
function ataqueAgua(){
    ataqueJugador = 'AGUA'
    ataqueAleatorioEnemigo();
}
function ataqueTierra(){
    ataqueJugador = 'Tierra'
    ataqueAleatorioEnemigo();
}

function ataqueAleatorioEnemigo(){

    let ataqueAleatorio = numeroAleatorio(1,3)

    if(ataqueAleatorio == 1){
        ataqueEnemigo = 'FUEGO'
    } else if(ataqueAleatorio == 2){
        ataqueEnemigo = 'AGUA'
    } else if(ataqueAleatorio == 3){
        ataqueEnemigo= 'TIERRA'
    } 
    combate();
}

function crearMensaje(resultado){
let sectionMensaje = document.getElementById('s-mensajes');

    let parrafo = document.createElement('p');
    parrafo.innerHTML = "Tu mascota ataco con "+ataqueJugador +", la Mascota del enemigo ataco con " + ataqueEnemigo +" "+resultado;

    sectionMensaje.appendChild(parrafo);
}

function crearMensajeFinal(resultadoFinal){
    let sectionMensaje = document.getElementById('s-mensajes');
    
        let parrafo = document.createElement('p');
        parrafo.innerHTML = resultadoFinal;
    
        sectionMensaje.appendChild(parrafo);
    }


function combate(){
    let spanVidasJugador = document.getElementById('vidas-jugador');
    let spanVidasEnemigo = document.getElementById('vidas-enemigo');

    if (ataqueEnemigo == ataqueJugador) {
        crearMensaje("Empate");
    } else if (ataqueJugador == 'FUEGO' && ataqueEnemigo == 'TIERRA') {
        crearMensaje("¡Ganaste!");
        vidasEnemigo--;
        spanVidasEnemigo.innerHTML= vidasEnemigo;
        
    } else if (ataqueJugador == 'AGUA' && ataqueEnemigo == 'FUEGO') {
        crearMensaje("¡Ganaste!");
        vidasEnemigo--;
        spanVidasEnemigo.innerHTML= vidasEnemigo;
        
    } else if (ataqueJugador == 'TIERRA' && ataqueEnemigo == 'AGUA') {
        crearMensaje("¡Ganaste!");
        vidasEnemigo--;
        spanVidasEnemigo.innerHTML= vidasEnemigo;
        
    } else {
        crearMensaje("¡Perdiste!");
        vidasJugador--;
        spanVidasJugador.innerHTML= vidasJugador;
        
    }

    revisarVidas();
}

function revisarVidas(){
    if(vidasEnemigo ==0){
        crearMensajeFinal('Felicidades Ganaste');
    } else if(vidasJugador == 0){
        crearMensajeFinal('Lo siento, perdiste :(');

    }
}

function numeroAleatorio(min , max){
    return Math.floor(Math.random()*(max-min+1)+min);
}

window.addEventListener('load',iniciarJuego)