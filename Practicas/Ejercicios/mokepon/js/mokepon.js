let ataqueJugador;
let ataqueEnemigo;


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
    } else {
        ataqueEnemigo = 'Error';
    }
    crearMensaje();
}

function crearMensaje(){
let sectionMensaje = document.getElementById('s-mensajes');

    let parrafo = document.createElement('p');
    parrafo.innerHTML = "Tu mascota ataco con "+ataqueJugador +", la Mascota del enemigo ataco con " + ataqueEnemigo+" - GANASTE 🎉";

    sectionMensaje.appendChild(parrafo);
}

function combate(){
    if (jugador == pc) {
        alert("Empate");
    } else if (jugador == 1 && pc == 3) {
        alert("¡Ganaste! Piedra gana sobre tijera");
        triunfo = triunfo +1;
    } else if (jugador == 2 && pc == 1) {
        alert("¡Ganaste! Papel gana sobre piedra");
        triunfo = triunfo +1;
    } else if (jugador == 3 && pc == 2) {
        alert("¡Ganaste! Tijera gana sobre papel ");
        triunfo = triunfo +1;
    } else {
        alert("¡Perdiste! La PC gana esta ronda ");
        perdida = perdida +1;
    }
}


function numeroAleatorio(min , max){
    return Math.floor(Math.random()*(max-min+1)+min);
}

window.addEventListener('load',iniciarJuego)