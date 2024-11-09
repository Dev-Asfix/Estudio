import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame implements ActionListener{
  private JMenuBar mb;
  private JMenu  menuopciones,menucalcular,menuacerca,colorfondo;
  private JMenuItem itemnuevo , itemsalir,itemrojo,itemmorado ,itemnegro,itemvacaciones,
                    itemcreador;
  private JTextField fieldnombre,fieldmaterno,fieldpaterno;
  private JLabel labelimagen,labelbienvenida,labeldatos,labelnombre,labelpaterno,labelmaterno,
                  labeldepa,labelantiguedad,labelresultado,labelcoca;
  private JComboBox<String> boxdepa,boxantiguedad;
  private JTextArea areacalculo;
  private JScrollPane scroll;
  String nombreadmin = "";
  
  public Principal(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Pantalla Principal");
    setIconImage(new ImageIcon(getClass().getResource("images/anime-info.png")).getImage());
    getContentPane().setBackground(new Color(255,0,0));
    
    Bienvenida ventanab = new Bienvenida();
    nombreadmin = ventanab.texto;

    mb = new JMenuBar();
    mb.setBackground(new Color(255,0,0));
    setJMenuBar(mb);
   
    menuopciones = new JMenu("Opciones");
    menuopciones.setBackground(new Color(255,0,0));
    menuopciones.setFont(new Font("Andale Mono",1,14));
    menuopciones.setForeground(new Color (255,255,255));
    mb.add(menuopciones);
  
    menucalcular = new JMenu("Calcular");
    menucalcular.setBackground(new Color(255,0,0));
    menucalcular.setFont(new Font("Andale Mono",1,14));
    menucalcular.setForeground(new Color(255,255,255));
    mb.add(menucalcular);

    menuacerca = new JMenu("Acerca de");
    menuacerca.setBackground(new Color(255,0,0));
    menuacerca.setFont(new Font("Andale MOno",1,14));
    menuacerca.setForeground(new Color(255,255,255));
    mb.add(menuacerca);
    
    colorfondo = new JMenu("Color de Fondo");

    colorfondo.setFont(new Font("Andale Mono",1,14));
    colorfondo.setForeground(new Color(255,0,0));
    menuopciones.add(colorfondo);

    itemrojo = new JMenuItem("Rojo");
    itemrojo.setFont(new Font("Andale Mono",1,14));
    itemrojo.setForeground(new Color(255,0,0));
    colorfondo.add(itemrojo);
    itemrojo.addActionListener(this);

    itemmorado = new JMenuItem("Morado");
    itemmorado.setFont(new Font("Andale Mono",1,14));
    itemmorado.setForeground(new Color(255,0,0));
    colorfondo.add(itemmorado);
    itemmorado.addActionListener(this);
    
    itemnegro = new JMenuItem("Negro");
    itemnegro.setFont(new Font("Andale Mono",1,14));
    itemnegro.setForeground(new Color(255,0,0));
    colorfondo.add(itemnegro);
    itemnegro.addActionListener(this);

    itemnuevo = new JMenuItem("Nuevo");
    itemnuevo.setFont(new Font("Andale Mono",1,14));
    itemnuevo.setForeground(new Color(255,0,0));
    menuopciones.add(itemnuevo);
    itemnuevo.addActionListener(this);
  
    itemsalir = new JMenuItem("Salir");
    itemsalir.setFont(new Font("Andale Mono",1,14));
    itemsalir.setForeground(new Color(255,0,0));
    menuopciones.add(itemsalir);
    itemsalir.addActionListener(this);
   
    itemvacaciones = new JMenuItem("Vacaciones");
    itemvacaciones.setFont(new Font("Andale Mono",1,14));
    itemvacaciones.setForeground(new Color (255,0,0));
    menucalcular.add(itemvacaciones);
    itemvacaciones.addActionListener(this);

    itemcreador = new JMenuItem("Creador");
    itemcreador.setFont(new Font("Andale Mono",1,14));
    itemcreador.setForeground(new Color(255,0,0));
    menuacerca.add(itemcreador);
    itemcreador.addActionListener(this);
   
    ImageIcon imagen = new ImageIcon("images/logo-coca.png");
    labelimagen = new JLabel(imagen);
    labelimagen.setBounds(5,5,250,100);
    add(labelimagen);

    labelbienvenida = new JLabel("Bienvenido " + nombreadmin);
    labelbienvenida.setBounds(280,30,300,50);
    labelbienvenida.setFont(new Font("Andale Mono",1,32));
    labelbienvenida.setForeground(new Color(255,255,255));
    add(labelbienvenida);

    labeldatos = new JLabel("Datos del trabajador para calculo de vacaciones");
    labeldatos.setBounds(45,140,900,25);
    labeldatos.setFont(new Font("Andale Mono",0,24));
    labeldatos.setForeground(new Color(255,255,255));
    add(labeldatos);

    labelnombre = new JLabel("Nombre Completo");
    labelnombre.setBounds(25,188,180,25);
    labelnombre.setFont(new Font("Andale Mono",1,12));
    labelnombre.setForeground(new Color(255,255,255));
    add(labelnombre);
    
    fieldnombre = new JTextField();
    fieldnombre.setBounds(25,213,150,25);
    fieldnombre.setBackground(new java.awt.Color(224, 224, 224));
    fieldnombre.setFont(new java.awt.Font("Andale Mono",1,14));
    fieldnombre.setForeground(new java.awt.Color(224,0,0));
    add(fieldnombre);

    labelpaterno = new JLabel("Apellido Paterno");
    labelpaterno.setBounds(25,248,180,25);
    labelpaterno.setForeground(new Color (255,255,255));
    labelpaterno.setFont(new Font("Andale Mono",1,12));
    add(labelpaterno);
  
    fieldpaterno = new JTextField();
    fieldpaterno.setBounds(25,273,150,25);
    fieldpaterno.setBackground(new java.awt.Color(224,224,224));
    fieldpaterno.setFont(new java.awt.Font("Andale Mono",1,14));
    fieldpaterno.setForeground(new java.awt.Color(255,0,0));
    add(fieldpaterno);
  
    labelmaterno = new JLabel("Apellido Materno");
    labelmaterno.setBounds(25,308,180,25);
    labelmaterno.setFont(new Font("Andale Mono",1,12));
    labelmaterno.setForeground(new Color(255,255,255));
    add(labelmaterno);
  
    fieldmaterno = new JTextField();
    fieldmaterno.setBounds(25,334,150,25);
    fieldmaterno.setBackground(new java.awt.Color(224,224,224));
    fieldmaterno.setFont(new java.awt.Font ("Andale Mono",1,14));
    fieldmaterno.setForeground(new java.awt.Color(255,0,0));
    add(fieldmaterno);
    
    labeldepa =new JLabel("Selecciona el departamento:");
    labeldepa.setBounds(220,188,180,25);
    labeldepa.setFont(new Font("Andale Mono",1,12));
    labeldepa.setForeground(new Color(255,255,255));
    add(labeldepa);

    boxdepa = new JComboBox<String>();
    boxdepa.setBounds(220,213,220,25);
    boxdepa.setBackground(new java.awt.Color(224,224,224));
    boxdepa.setFont(new java.awt.Font("Andale Mono",1,14));
    boxdepa.setForeground(new java.awt.Color(255,0,0));
    add(boxdepa);
    boxdepa.addItem("");
    boxdepa.addItem("Atencion al Cliente");
    boxdepa.addItem("Departamento de Logistica");
    boxdepa.addItem("Departamento de gerencia");

    labelantiguedad = new JLabel("Selecciona la Antiguedad:");
    labelantiguedad.setBounds(220,248,180,25);
    labelantiguedad.setFont(new Font("Andale Mono",1,12));
    labelantiguedad.setForeground(new Color(255,255,255));
    add(labelantiguedad);
   
    boxantiguedad = new JComboBox<String>();
    boxantiguedad.setBounds(220,273,220,25);
    boxantiguedad.setBackground(new java.awt.Color(224,224,224));
    boxantiguedad.setFont(new java.awt.Font("Andale Mono",1,14));
    boxantiguedad.setForeground(new java.awt.Color(255,0,0));
    add(boxantiguedad);
    boxantiguedad.addItem("");
    boxantiguedad.addItem("1 año de servicio");
    boxantiguedad.addItem("2 A 6 AÑOS DE servicio");
    boxantiguedad.addItem("7 a más años de servicio");
 
   labelresultado = new JLabel("Resultado del Cálculo");
   labelresultado.setBounds(220,307,180,25);
   labelresultado.setFont(new Font("Andale Mono",1,12));
   labelresultado.setForeground(new Color(255,255,255));
   add(labelresultado);

   areacalculo= new JTextArea();
   areacalculo.setEditable(false);
   areacalculo.setBackground(new Color(224,224,224));
   areacalculo.setFont(new Font("Andale Mono",1,11));
   areacalculo.setForeground(new Color(255,0,0));
   areacalculo.setText("\n Aqui aparece el resultado");
   scroll = new JScrollPane(areacalculo);
   scroll.setBounds(220,333,385,90);
   add(scroll);

   labelcoca = new JLabel("©2017 The Coca-Cola Company | Todos los derechos reservados");
   labelcoca.setBounds(135,445,500,30);
   labelcoca.setFont(new java.awt.Font("Andale Mono",1,12));
   labelcoca.setForeground(new java.awt.Color(255,255,255));
   add(labelcoca); 

  }
  public void actionPerformed(ActionEvent e){        
     if(e.getSource() == itemvacaciones){
       String nc = fieldnombre.getText();
       String ap = fieldpaterno.getText();
       String am = fieldmaterno.getText();
       String dp = boxdepa.getSelectedItem().toString();
       String at= boxantiguedad.getSelectedItem().toString();
      
       if(nc.equals("") || ap.equals("") || am.equals("") || dp.equals("") || at.equals("")){
         JOptionPane.showMessageDialog(null, "Complete todos los campos.");
   
       } else { 

           if(dp.equals("Atencion al Cliente")){
  
			if(at.equals("1 año de servicio")){
                          areacalculo.setText("\n El Trabajador "+ nc +" "+ ap +" "+am+" "+
                                              "\n Quien Labora en "+ dp +" con " + at + " "+
                                              "\n Recibe 6 dias de vaciones");
  				

 			}
			if(at.equals("2 A 6 AÑOS DE servicio")){
                          areacalculo.setText("\n El Trabajador "+ nc +" "+ ap +" "+am+" "+
                                              "\n Quien Labora en "+ dp +" con " + at + " "+
                                              "\n Recibe 14 dias de vaciones");
  				

  			}
    			if(at.equals("7 a más años de servicio")){
                          areacalculo.setText("\n El Trabajador "+ nc +" "+ ap +" "+am+" "+
                                              "\n Quien Labora en "+ dp +" con " + at + " "+
                                              "\n Recibe 20 dias de vaciones");
  				
			
			}
	

           } 
	   if(dp.equals("Departamento de Logistica")){

			if(at.equals("1 año de servicio")){
                          areacalculo.setText("\n El Trabajador "+ nc +" "+ ap +" "+am+" "+
                                              "\n Quien Labora en "+ dp +" con " + at + " "+
                                              "\n Recibe 7 dias de vaciones");
  				

 			}
			if(at.equals("2 A 6 AÑOS DE servicio")){
                          areacalculo.setText("\n El Trabajador "+ nc +" "+ ap +" "+am+" "+
                                              "\n Quien Labora en "+ dp +" con " + at + " "+
                                              "\n Recibe 15 dias de vaciones");
  				

  			}
    			if(at.equals("7 a más años de servicio")){
                          areacalculo.setText("\n El Trabajador "+ nc +" "+ ap +" "+am+" "+
                                              "\n Quien Labora en "+ dp +" con " + at + " "+
                                              "\n Recibe 22 dias de vaciones");
  				
			
			}
          
           }
	   if(dp.equals("Departamento de gerencia")){
			if(at.equals("1 año de servicio")){
                          areacalculo.setText("\n El Trabajador "+ nc +" "+ ap +" "+am+" "+
                                              "\n Quien Labora en "+ dp +" con " + at + " "+
                                              "\n Recibe 10 dias de vaciones");
  				

 			}
			if(at.equals("2 A 6 AÑOS DE servicio")){
                          areacalculo.setText("\n El Trabajador "+ nc +" "+ ap +" "+am+" "+
                                              "\n Quien Labora en "+ dp +" con " + at + " "+
                                              "\n Recibe 20 dias de vaciones");
  				

  			}
    			if(at.equals("7 a más años de servicio")){
                          areacalculo.setText("\n El Trabajador "+ nc +" "+ ap +" "+am+" "+
                                              "\n Quien Labora en "+ dp +" con " + at + " "+
                                              "\n Recibe 30 dias de vaciones");
  				
			
			}

           
           }
       }
                         
     }


     if(e.getSource()== itemrojo){
       getContentPane().setBackground(new Color (255,0,0));

     }
     if(e.getSource() == itemmorado){
       getContentPane().setBackground(new Color(51,0,51));

     }
     if(e.getSource() == itemnegro){
       getContentPane().setBackground(new Color(0,0,0));
     }
     if(e.getSource() == itemnuevo){
     
       fieldnombre.setText("");
       fieldmaterno.setText("");
       fieldpaterno.setText("");
       boxdepa.setSelectedIndex(0);
       boxantiguedad.setSelectedIndex(0);
       areacalculo.setText("\n Aqui aparece el resultado");
    

     }
     if(e.getSource() == itemsalir){
       Bienvenida ventana = new Bienvenida();
       ventana.setBounds(0,0,350,450);
       ventana.setVisible(true);
       ventana.setResizable(false); 
       ventana.setLocationRelativeTo(null);  
       this.setVisible(false);

    
     }
     if(e.getSource() == itemcreador){
       JOptionPane.showMessageDialog(null,"El creador es TAM TAM TAM");

     }


  }

   public static void main(String args[]){

   Principal ventana2 = new Principal();
   ventana2.setBounds(0,0,640,535);
   ventana2.setVisible(true);
   ventana2.setResizable(false);
   ventana2.setLocationRelativeTo(null);
   
  }

} 











