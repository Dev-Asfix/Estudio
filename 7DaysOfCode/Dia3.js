//Flujo de controles

function preguntarEspecialidad() {
    let especialidad = prompt('Qué especialidad te interesa? Frontend = 2 o Backend = 1');
    let intentos = 0;

    while (intentos < 3) {
        if (especialidad == "1" || especialidad.toLowerCase() === "backend") {
            return preguntarLenguajeBackend();
        } else if (especialidad == "2" || especialidad.toLowerCase() === "frontend") {
            return preguntarFrameworkFrontend();
        } else {
            alert(`Elige un número correcto, tienes ${2 - intentos} intentos`);
            especialidad = prompt('Qué especialidad te interesa? Frontend = 2 o Backend = 1');
            intentos++;
        }
    }
    alert("Has excedido el número de intentos.");
}

function preguntarLenguajeBackend() {
    let intentos = 0;

    while (intentos < 3) {
        let especialidadBackend = prompt('Quieres aprender \nJava = 1  \nC# = 2 \nElige un número');

        if (especialidadBackend == "1") {
            alert('Perfecto, Java es un buen Lenguaje');
            return;
        } else if (especialidadBackend == "2") {
            alert('Genial, C# es un buen Lenguaje');
            return;
        } else {
            alert(`Elige un número correcto, tienes ${2 - intentos} intentos`);
            intentos++;
        }
    }
    alert("Has excedido el número de intentos.");
}

function preguntarFrameworkFrontend() {
    let intentos = 0;

    while (intentos < 3) {
        let especialidadFrontend = prompt('Quieres aprender \nReact = 1  \nVue = 2 \nElige un número');

        if (especialidadFrontend == "1") {
            alert('Perfecto, REACT es un buen Framework');
            return;
        } else if (especialidadFrontend == "2") {
            alert('Genial, Vue es un buen Framework');
            return;
        } else {
            alert(`Elige un número correcto, tienes ${2 - intentos} intentos`);
            intentos++;
        }
    }
    alert("Has excedido el número de intentos.");
}

preguntarEspecialidad();
