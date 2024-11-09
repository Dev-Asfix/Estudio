import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class Licencia extends JFrame implements ActionListener,ChangeListener{
  private JLabel label1 ,label2;
  private JCheckBox box;
  private JTextArea area;
  private JScrollPane scroll;
  private JButton boton1,boton2;
  String nombre = "";

  public Licencia(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Licencia de uso");
    setIconImage(new ImageIcon(getClass().getResource("images/com.jpg")).getImage());
    Bienvenida ventanabi= new Bienvenida();
    nombre =  ventanabi.texto;
    
    label1 = new JLabel("Terminos y condiciones");
    label1.setBounds(215,5,200,35);
    label1.setFont(new Font("Andale Mono",1,14));
    label1.setForeground(new Color(0, 0, 0));
    add(label1);    

    area = new JTextArea();
    area.setEditable(false);
    area.setFont(new Font("Andale Mono",0,9));
    area.setText("\n\n          TÉRMINOS Y CONDICIONES" +
                    "\n\n            A.  PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN DE LA Pablito del Amanecer." +
                    "\n            B.  PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRÁFICAS." +
                    "\n            C. NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE NI  DE GUERRAS." +
                    "\n\n          LOS ACUERDOS LEGALES EXPUESTOS ACONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
                    "\n          (PABLITO)), NO SE RESPONSABILIZA DEL USO QUE USTED" + 
                    "\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (Acepto)" +
                    "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE." + 
                    "\n\n          PARA MAYOR INFORMACIÓN , POR FAVOR YA NO SE ATIENDE ASI QUE F");
        
    scroll = new JScrollPane(area);
    scroll.setBounds(10,40,575,200);
    add(scroll);

    box = new JCheckBox("Yo "+nombre+" acepto");
    box.setBounds(10,250,300,30);
    box.addChangeListener(this);
    add(box);

   boton1 = new JButton("Continuar");
   boton1.setBounds(10,290,100,30);
   boton1.addActionListener(this);
   boton1.setEnabled(false);
   add(boton1);
    
   boton2 = new JButton("No Acepto");
   boton2.setBounds(120,290,100,30);
   boton2.addActionListener(this);
   boton2.setEnabled(true);
   add(boton2);






    ImageIcon imagen =new ImageIcon("images/coca-cola.png");
    label2 = new JLabel(imagen);
    label2.setBounds(315,135,300,300);
    add(label2);

  }
  public void stateChanged(ChangeEvent e){
    if(box.isSelected() == true){
      boton1.setEnabled(true);
      boton2.setEnabled(false);
    } else {
      boton1.setEnabled(false);
      boton2.setEnabled(true);
    }
   

  }
  public void actionPerformed(ActionEvent e){

   if(e.getSource() == boton1){
     Principal ventana2 = new Principal();
     ventana2.setBounds(0,0,640,535);
     ventana2.setVisible(true);
     ventana2.setResizable(false);
     ventana2.setLocationRelativeTo(null);
     this.setVisible(false);

   } else if(e.getSource() == boton2) {
      Bienvenida ventana = new Bienvenida();
      ventana.setBounds(0,0,350,450);
      ventana.setVisible(true);
      ventana.setResizable(false); 
      ventana.setLocationRelativeTo(null);  
      this.setVisible(false);     

   }

  }
  public static void main(String args[]){
    Licencia ventana1 = new Licencia();
    ventana1.setBounds(0,0,600,360);
    ventana1.setVisible(true);
    ventana1.setResizable(false);
    ventana1.setLocationRelativeTo(null);

  }
}















