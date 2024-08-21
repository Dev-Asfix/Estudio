        // Función para generar un número aleatorio entre min y max 
        function numeroAleatorio(max, min){
            return Math.floor(Math.random() * (max - min + 1) + min);
        }

        function eleccion(elegido){

            let result = "";
            if (elegido == 1) {
                result = "Piedra";
            } else if (elegido == 2) {
                result = "Papel";
            } else if (elegido == 3) {
                result = "Tijera";
            } else {
                result = "Elección inválida";
            }
            return result;
        }

        // Genera un número aleatorio 
        let pc = 0;
        // Pide al usuario que elija
        let jugador = 0;
        let triunfo = 0;
        let perdida = 0;

        while(triunfo < 3 && perdida < 3 ){

            let pc = numeroAleatorio(3, 1);
            // Pide al usuario que elija
            let jugador = prompt("Elige 1 para piedra, 2 para papel, 3 para tijera");
            alert("PC eligio " + eleccion(pc));
            alert("Tu elegiste " + eleccion(jugador));
            
            // Lógica para determinar el resultado del juego
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

            alert("Ganaste " +triunfo + (triunfo == 1 ? " vez":" veces")+" y perdiste "+perdida +(perdida == 1 ? " vez.":" veces."));  
        }
