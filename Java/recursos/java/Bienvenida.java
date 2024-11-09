import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Bienvenida extends JFrame implements ActionListener{
  private JTextField field;
  private JLabel label1,label2,label3,label4;
  private JButton boton1;
  public static String texto = "";
 
  public Bienvenida(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Bienvenida");
    getContentPane().setBackground(new Color(255,0,0));
    
   setIconImage(new ImageIcon(getClass().getResource("images/com.jpg")).getImage());
   ImageIcon imagen = new ImageIcon("images/logo-coca.png");
   label1 = new JLabel(imagen);
   label1.setBounds(45,15,250,110);
   add(label1); 
   
   label2 = new JLabel("Sistema de control vacacional");
   label2.setBounds(35,135,300,30);
   label2.setFont(new Font("Andale Mono",3,18));
   label2.setForeground(new Color (255,255,255));
   add(label2);

   label3 = new JLabel("Ingrese su Nombre:");
   label3.setBounds(45,212,200,30);
   label3.setFont(new Font("Andale Mono",1,12));
   label3.setForeground(new Color(255,255,255));
   add(label3);

   label4 = new JLabel("©The CocaCola-Company");
   label4.setBounds(85,375,300,30);
   label4.setFont(new Font("Andale Mono",1,12));
   label4.setForeground(new Color(255,255,255));
   add(label4);
 
   field = new JTextField();
   field.setBounds(45,240,255,25);
   field.setBackground(new Color(224,224,224));
   field.setForeground(new Color(255,0,0));
   field.setFont(new Font("Andale Mono",1,14));
   add(field);
   
   boton1 = new JButton("Ingresar");
   boton1.setBounds(125,280,100,30);
   boton1.setBackground(new Color(255,255,255));
   boton1.setFont(new Font("Andale Mono",1,14));
   boton1.setForeground(new Color(255,0,0));
   boton1.addActionListener(this);
   add(boton1);
   
 }

  public void actionPerformed(ActionEvent e){
   if(e.getSource() == boton1){
   
     texto = field.getText().trim();
       if(texto.equals("")){
         JOptionPane.showMessageDialog(null, "Debes Ingresar tu nombre");
       } else {

       Licencia ventana1 = new Licencia();
       ventana1.setBounds(0,0,600,360);
       ventana1.setVisible(true);
       ventana1.setResizable(false);
       ventana1.setLocationRelativeTo(null);
       this.setVisible(false);

       }

   }
  }

  public static void main(String args[]){
    Bienvenida ventana = new Bienvenida();
    ventana.setBounds(0,0,350,450);
    ventana.setVisible(true);
    ventana.setResizable(false); 
    ventana.setLocationRelativeTo(null);  

 }
}




















