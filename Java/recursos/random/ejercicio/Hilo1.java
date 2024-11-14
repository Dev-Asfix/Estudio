

/**
 *
 * @author Pablo
 */

import java.io.IOException;
public class Hilo1 extends Thread {


    @Override
    public void run(){
        for(int i = 1 ; i<=60; i++){
            System.out.println(i);
            
            try{
            Hilo1.sleep(1000);
                
            }catch(InterruptedException e){

                System.out.println("Error el hilo de la clase hilo 1 : " +e);

                
            }
            clearConsole();
        }
        
    }
    
    public void clearConsole(){
        try{
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                
            }else{
                Runtime.getRuntime().exec("clear");
                
            }
            
        }catch(IOException | InterruptedException e){
            System.out.println("Error al intentar limpiar la consola:  " + e.getMessage());
        }
    }

    
}
