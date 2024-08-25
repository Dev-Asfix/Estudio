
let filtro = parseInt(prompt('Quiere guardar SI : 1 - NO 2'),10);
    if(filtro == 1){

        let parametro = parseInt(prompt('Cuantos nombres quieres ingresar ?'),10);
        let nombre = ""; 
        let numero = 0; 
        let intento = 0;
        let filtroNombre = [[],[],[]];

        while(intento < parametro ){
                

                nombre = prompt('Ingrese el nombre');
                numero = parseInt(prompt('Ingrese la categoria 1 - 2 - 3'),10);
                
                if(numero >= 1 && numero <=3){
                    filtroNombre[numero -1].push(nombre);
                    intento ++;
                } else {
                    alert('Numero categoria incorrecto');
                }
        }
        
        for(let i = 0; i< filtroNombre.length; i++){
            console.log(`categoria ${i+1}: ${filtroNombre[i].join(', ')}`);
        }
    
    
    } else if(filtro == 2){
        console.log('No se guardaron nombres.');
    } else {
        alert('numero incorrecto. Por favor ingresa 1 par Si , o 2 para NO.')
    }




