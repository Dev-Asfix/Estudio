function iniciarJuego(){
    let botonMascotaJugador = document.getElementById('btn-mascotas');

    botonMascotaJugador.addEventListener('click', seleccionarMascotaJugador);
}

function seleccionarMascotaJugador(){

    let inputHipodoge = document.getElementById('hipodoge');
    let inputCapipepo = document.getElementById('capipepo');
    let inputRatigueya = document.getElementById('ratigueya')

    if(inputHipodoge.checked){
        alert('Seleccionaste tu mascota Hipodoge')
    } else if(inputCapipepo.checked){
        alert('Seleccionaste tu mascota Capipepo')
    } else if(inputRatigueya.checked){
        alert('Seleccionaste tu mascota Ratigueya')
    } else {
        alert('Selecciona una mascota');
    }


    
}



window.addEventListener('load',iniciarJuego)