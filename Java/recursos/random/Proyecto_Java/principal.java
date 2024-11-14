import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class principal extends JFrame implements  ActionListener{
	private JMenuBar bar;
	private JMenu options ,calculate, info , color;
	private JMenuItem red, black, purple, redo,leave, vacation, creator;
	private JLabel imagen , welcome , data, name, lastname1, lastname2 , select1, select2 , result ,legend;
	private JTextField field1 , field2, field3;
	private JComboBox box1, box2 ;
	private JTextArea area ;
	private JScrollPane scroll;
	String name3 = "";


	public principal(){
		setLayout(null);

	setTitle("Menu Principal");
	getContentPane().setBackground(new Color(255,0,0));
	setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
	
	bienvenida nameprincipal = new bienvenida();
	name3 = nameprincipal.name;
		
	bar = new JMenuBar();
	bar.setBackground(new Color(255,0,0));
	setJMenuBar(bar);
	
	
	options = new JMenu("Options");
	options.setBackground(new Color(255,0,0));
	options.setFont(new Font("Andale Mono",1,14));
	options.setForeground(new Color(255,255,255));
	bar.add(options);
	
	calculate = new JMenu("Calcular");
	calculate.setBackground(new Color(255,0,0));
	calculate.setFont(new Font("Andale Mono",1,14));
	calculate.setForeground(new Color(255,255,255));
	bar.add(calculate);
	
	info = new JMenu("Acerca de ");
	info.setBackground(new Color(255,0,0));
	info.setFont(new Font("Andale Mono",1,14));
	info.setForeground(new Color(255,255,255));
	bar.add(info);
	
	color = new JMenu("Colors");
	
	color.setFont(new Font("Andale Mono",1,14));
	color.setForeground(new Color(255,0,0));
	options.add(color);

	red = new JMenuItem("Red");
	red.addActionListener(this);
	red.setFont(new Font("Andale Mono",1,14));
	red.setForeground(new Color(255,0,0));
	color.add(red);

	black = new JMenuItem("Black");
	black.addActionListener(this);
	black.setFont(new Font("Andale Mono",1,14));
	black.setForeground(new Color(255,0,0));
	color.add(black);

	purple = new JMenuItem("Purple");	
	purple.addActionListener(this);
	purple.setFont(new Font("Andale Mono",1,14));
	purple.setForeground(new Color(255,0,0));
	color.add(purple);

	redo = new JMenuItem("Redo");
	redo.addActionListener(this);	
	redo.setFont(new Font("Andale Mono",1,14));
	redo.setForeground(new Color(255,0,0));
	options.add(redo);

	leave = new JMenuItem("Leave");
	leave.addActionListener(this);
	leave.setFont(new Font("Andale Mono",1,14));
	leave.setForeground(new Color(255,0,0));
	options.add(leave);

	vacation = new JMenuItem("Vacations");
	vacation.addActionListener(this);
	vacation.setFont(new Font("Andale Mono",1,14));
	vacation.setForeground(new Color(255,0,0));
	calculate.add(vacation);

	creator = new JMenuItem("Creator");
	creator.addActionListener(this);
	creator.setBackground(new Color(255,0,0));
	creator.setFont(new Font("Andale Mono",1,14));
	creator.setForeground(new Color(255,255,255));
	info.add(creator);


	ImageIcon image = new ImageIcon("images/logo-coca.png");
	
	imagen = new JLabel(image);
	imagen.setBounds(5,5,250,100);
	add(imagen);


  	welcome = new JLabel("Welcome "+name3);
	welcome.setBounds(280,30,300,50);
	welcome.setFont(new Font("Andale Mono",0,32));
	welcome.setForeground(new Color(255,255,255));
	add(welcome);
	
	data = new JLabel("Datos del trabajodor | Calculo de Vacaciones");
	data.setBounds(45,140,900,25);
	data.setFont(new Font("Andale Mono",1,24));
	data.setForeground(new Color(255,255,255));
	add(data);


	name = new JLabel("Name complete");
	name.setBounds(25,188,180,25);
	name.setFont(new Font("Andale Mono",1,12));
	name.setForeground(new Color(255,255,255));
	add(name);

	field1 = new JTextField();
	field1.setBounds(25,213,150,25);
	field1.setBackground(new java.awt.Color(224,224,224));
	field1.setFont(new java.awt.Font("Andale Mono",1,14));
	field1.setForeground(new java.awt.Color(255,0,0));
	add(field1);



	lastname1 = new JLabel("Last Name 1");
	lastname1.setBounds(25,248,180,25);
	lastname1.setFont(new Font("Andale Mono",1,12));
	lastname1.setForeground(new Color(255,255,255));
	add(lastname1);
	
	field2 = new JTextField();
	field2.setBounds(25,273,150,25);
	field2.setBackground(new java.awt.Color(224,224,224));
	field2.setFont(new java.awt.Font("Andale Mono",1,14));
	field2.setForeground(new java.awt.Color(255,0,0));
	add(field2);



	lastname2 = new JLabel("Last name 2");
	lastname2.setBounds(25,308,180,25);
	lastname2.setFont(new Font("Andale Mono",1,12));
	lastname2.setForeground(new Color(255,255,255));
	add(lastname2);
	
	field3 = new JTextField();
	field3.setBounds(25,334,150,25);
	field3.setBackground(new java.awt.Color(224,224,224));
	field3.setFont(new java.awt.Font("Andale Mono",1,14));
	field3.setForeground(new java.awt.Color(255,0,0));
	add(field3);
	
	select1 = new JLabel("Select Depa");
	select1.setBounds(220,188,180,25);
	select1.setFont(new Font("Andale Mono",1,12));
	select1.setForeground(new Color(255,255,255));
	add(select1);

	box1 = new JComboBox();
	box1.setBounds(220,213,220,25);
	box1.setBackground(new java.awt.Color(224,224,224));
	box1.setFont(new java.awt.Font("Andale Mono",1,14));
	box1.setForeground(new java.awt.Color(255,0,0));
	add(box1);
	box1.addItem("");
	box1.addItem("Atencion al Cliente");
	box1.addItem("Departamento de logística");
	box1.addItem("Departamento de Gerencia");
	

	
	select2= new JLabel("Select Antiguedad");
	select2.setBounds(220,248,180,25);
	select2.setFont(new Font("Andale Mono",1,12));
	select2.setForeground(new Color(255,255,255));
	add(select2);

	box2 = new JComboBox();
	box2.setBounds(220,273,220,25);
	box2.setBackground(new java.awt.Color(224,224,224));
	box2.setFont(new java.awt.Font("Andale Mono",1,14));
	box2.setForeground(new java.awt.Color(255,0,0));
	add(box2);
	box2.addItem("");
	box2.addItem("1 año de servicio");
	box2.addItem("2 a 6 años de servicio");
	box2.addItem("7 a más años de servicio");
	


	area = new JTextArea();
	area.setFont(new Font("Andale Mono",1,11));
	area.setEditable(false);
	area.setText("Here show the result");
	scroll = new JScrollPane(area);
	scroll.setBounds(220,333,385,90);
	add(scroll);

	legend = new JLabel("©2017 The Coca-Cola Company | Todos los derechos reservados");
	legend.setBounds(135,445,500,30);
	legend.setFont(new Font("Andale Mono",1,12));
	legend.setForeground(new Color(255,255,255));
	add(legend);
	}

	public void actionPerformed(ActionEvent e){
		
		String nombre1 = field1.getText();
		String apellido1 = field2.getText();
		String apellido2 = field3.getText();
		String departamento =  box1.getSelectedItem().toString();
		String antiguedad = box2.getSelectedItem().toString();


		if(e.getSource() == red){
			getContentPane().setBackground(new Color(255,0,0));
		}
		if(e.getSource() == black){
			getContentPane().setBackground(new Color(1,1,1));
		}
		if(e.getSource() == purple){
			getContentPane().setBackground(new Color(128,0,128));
		}
 		if(e.getSource() == redo){
			field1.setText("");
			field2.setText("");
			field3.setText("");
			box1.setSelectedIndex(0);
			box2.setSelectedIndex(0);
			area.setText("Aqui aparece el Resultado del calculo de las vacaciones :");
		}
		if(e.getSource() == vacation){
			if(nombre1.equals("")|| apellido1.equals("") || apellido2.equals("") ||
                	                      departamento.equals("")|| antiguedad.equals("")){
		
			JOptionPane.showMessageDialog(null, "Debes llenar todos los espacios.");

			} else {
			
				if(departamento.equals("Atencion al Cliente")){
						if(antiguedad.equals("1 año de servicio")){
							area.setText("\n  El trabajador "+nombre1+" "+apellido1+" "+apellido2+
								     "\n  quein labora en " +departamento+" con "+antiguedad+
								     "\n  Recibe 6 dias de vacaciones.");
					
						}
						if(antiguedad.equals("2 a 6 años de servicio")){
			       				 area.setText("\n  El trabajador "+nombre1+" "+apellido1+" "+apellido2+
                                        		             "\n  quein labora en " +departamento+" con "+antiguedad+
                                                		     "\n  Recibe 14 dias de vacaciones.");

			
						}
						if(antiguedad.equals("7 a más años de servicio")){
							area.setText("\n  El trabajador "+nombre1+" "+apellido1+" "+apellido2+
                                        		             "\n  quein labora en " +departamento+" con "+antiguedad+
                                                		     "\n  Recibe 20 dias de vacaciones.");

						}	
				}
                                
                	        if(departamento.equals("Departamento de Logística")){
                        	                if(antiguedad.equals("1 año de servicio")){
                                	                area.setText("\n  El trabajador "+nombre1+" "+apellido1+" "+apellido2+
                                        	                     "\n  quein labora en " +departamento+" con "+antiguedad+
                                                	             "\n  Recibe 7 dias de vacaciones.");
                               	          }
                                	        if(antiguedad.equals("2 a 6 años de servicio")){
                                        	         area.setText("\n  El trabajador "+nombre1+" "+apellido1+" "+apellido2+
                                                	             "\n  quein labora en " +departamento+" con "+antiguedad+
                                                        	     "\n  Recibe 15 dias de vacaciones.");


                                      	  }
			
                                       	 if(antiguedad.equals("7 a más años de servicio")){
                                        	        area.setText("\n  El trabajador "+nombre1+" "+apellido1+" "+apellido2+
                                                	             "\n  quein labora en " +departamento+" con "+antiguedad+
                                                        	     "\n  Recibe 22 dias de vacaciones.");

                          	              } 
				}             
			
				if(departamento.equals("Departamento de Gerencia")){
                        	                if(antiguedad.equals("1 año de servicio")){
                                	                area.setText("\n  El trabajador "+nombre1+" "+apellido1+" "+apellido2+
                                        	                     "\n  quein labora en " +departamento+" con "+antiguedad+
                                                	             "\n  Recibe 10 dias de vacaciones.");
        
                                  	     	 }
                                       	 if(antiguedad.equals("2 a 6 años de servicio")){
                                        	         area.setText("\n  El trabajador "+nombre1+" "+apellido1+" "+apellido2+
                                                	             "\n  quein labora en " +departamento+" con "+antiguedad+
                                                        	     "\n  Recibe 20 dias de vacaciones.");


                                    	    }
                                       	 if(antiguedad.equals("7 a más años de servicio")){
                                        	        area.setText("\n  El trabajador "+nombre1+" "+apellido1+" "+apellido2+
                                                	             "\n  quein labora en " +departamento+" con "+antiguedad+
                                                        	     "\n  Recibe 30  dias de vacaciones.");

                                  	      }  
				}	
	}	
       }	
	
	if(e.getSource() == creator){
		JOptionPane.showMessageDialog(null ,"Creator = YO");
	}
 	if(e.getSource() == leave){
		
		bienvenida windows = new bienvenida();
                windows.setBounds(0,0,340,445);
                windows.setVisible(true);
                windows.setResizable(false);
                windows.setLocationRelativeTo(null);
		this.setVisible(false);
		
	}
    }	
	

	public static void main(String args[]){
		principal windows2 = new principal();
		
		windows2.setBounds(0,0,640,535);
		windows2.setResizable(false);
		windows2.setVisible(true);
		windows2.setLocationRelativeTo(null);
		
	}
}

