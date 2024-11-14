import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class licencia extends JFrame implements ActionListener , ChangeListener{
  	private JLabel label1,label2  ;
	private JTextArea area;
	private JScrollPane scroll;
	private JCheckBox box;
	private JButton button1 , button2;
	String name1 = "";
	
	public licencia(){
	     	setLayout(null);
	setTitle("LIcencia de uso");
	setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
	
	bienvenida ventanaprincipal = new bienvenida();
	name1 = ventanaprincipal.name;

	label1 = new JLabel("TERMINOS Y CONDICIONES");
	label1.setBounds(215,5,200,30);
	label1.setFont(new Font ("Andale Mono",1,14));
	label1.setForeground(new Color(0,0,0));
	add(label1);
	area = new JTextArea();
	area.setEditable(false);
	area.setFont(new Font("Andale Mono",0,9));
	area.setText("\n\n          TÉRMINOS Y CONDICIONES" +
                    "\n\n            A.  PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACION DE PABLITO (MULTA DE 1000000000 EN DOLARES)." +
                    "\n            B.  PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRÁFICAS." +
                    "\n            C. PABLITO NO SE HACE CARGO DEL MAL USO DE ESTE SOFTWARE." +
                    "\n\n          LOS ACUERDOS LEGALES EXPUESTOS ACONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
                    "\n          PABLITO NO SE RESPONSABILIZA DEL USO QUE USTED" + 
                    "\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)" +
                    "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE." + 
                    "\n\n          PARA MAYOR INFORMACIÓN SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE" + 
                    "\n          http://www.Pablito.com.pe/e");
	scroll = new JScrollPane(area);
	scroll.setBounds(10,40,575,200);
	add(scroll);
	
	box = new JCheckBox("Yo " + name1 + " Acepto");
	box.setBounds(10,250,300,30);
	box.addChangeListener(this);
	add(box);
	
	button1 = new JButton("Continuar");
	button1.setBounds(10,290,100,30);
	button1.addActionListener(this);
	button1.setEnabled(false);
	add(button1);
	
	button2 = new JButton("No Acepto");
	button2.setBounds(120,290,100,30);
	button2.addActionListener(this);
	button2.setEnabled(true);
	add(button2);
	
	ImageIcon image = new ImageIcon("images/coca-cola.png");
	label2 = new JLabel(image);
	label2.setBounds(315,135,300,300);
	add(label2);
	
	
	}
	
	public void stateChanged(ChangeEvent e){
		if(box.isSelected() == true){
		  button1.setEnabled(true);
		  button2.setEnabled(false);	
		
		} else {
		  button1.setEnabled(false);
		  button2.setEnabled(true);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == button1){
	         
  	   	   principal windows2 = new principal();
                   windows2.setBounds(0,0,640,535);
                   windows2.setResizable(false);
                   windows2.setVisible(true);
                   windows2.setLocationRelativeTo(null);
		   this.setVisible(false);	  

		} else if(e.getSource() == button2){
		 
		   bienvenida windows = new bienvenida();
                   windows.setBounds(0,0,340,445);
                   windows.setVisible(true);
                   windows.setResizable(false);
                   windows.setLocationRelativeTo(null);
		   this.setVisible(false);
		}
	}
	
	
	public static void main(String args[]){
          licencia windows2 = new licencia();
          windows2.setBounds(0,0,600,360);
          windows2.setVisible(true);
          windows2.setResizable(false);
          windows2.setLocationRelativeTo(null);

	

	 	}

}
