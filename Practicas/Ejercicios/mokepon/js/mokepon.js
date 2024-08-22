let ataqueJugador;


function iniciarJuego(){
    let botonMascotaJugador = document.getElementById('btn-mascotas');

    botonMascotaJugador.addEventListener('click', seleccionarMascotaJugador);
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

    let   = document.getElementById('mascota-enemiga');
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


function numeroAleatorio(min , max){
    return Math.floor(Math.random()*(max-min+1)+min);
}

window.addEventListener('load',iniciarJuego)