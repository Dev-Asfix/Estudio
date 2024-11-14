import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class  bienvenida extends JFrame implements ActionListener{
	private JLabel label1, label2, label3, label4;
	private JTextField field;
	private JButton button;
	public static String name = "";

	public bienvenida(){
		setLayout(null);
	getContentPane().setBackground(new Color(255,0,0));
	
	setTitle("Bienvenido");
	
	setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
	ImageIcon image = new ImageIcon("images/logo-coca.png");
	
	label1 = new JLabel(image);
	label1.setBounds(50,20,250,100);
	add(label1);
	
	label2 = new JLabel("Sistema de Control Vacacional");
	label2.setBounds(50,130,280,30);
	label2.setFont(new Font("Andale Mono",3,18));
	label2.setForeground(new Color(255,255,255));
	add(label2);
	

	label3 = new JLabel("Ingrese su nombre :");
	label3.setBounds(70,185,150,20);
	label3.setFont(new Font("Andale Mono",1,12));
	label3.setForeground(new Color(255,255,255));
	add(label3);
	
	field = new JTextField();
	field.setBounds(70,212,230,27);
	field.setFont(new Font("Andale Mono",1,15));
	field.setBackground(new Color(220,220,220));
	field.setForeground(new Color(255,0,0));
	add(field);

	button = new JButton("Ingresar");
	button.setBounds(130,255,100,28);
	button.setBackground(new Color(255,255,255));
	button.setForeground(new Color(255,0,0));
	add(button);
	button.addActionListener(this);

	label4 = new JLabel("@2017 The Coca-cola Company");
	label4.setBounds(95,340,190,20);
	label4.setForeground(new Color(255,255,255));
	add(label4);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == button){
			name = field.getText().trim();
	
			if(name.equals("")){
				JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre aqui");
			
			} else {
				
			 licencia windows2 = new licencia();
       		         windows2.setBounds(0,0,600,360);
         		 windows2.setVisible(true);
                	 windows2.setResizable(false);
        	  	 windows2.setLocationRelativeTo(null);
			 this.setVisible(false);	


		
			}
	
		}
	
	}

	public static void main(String args[]){
		bienvenida windows = new bienvenida();
		windows.setBounds(0,0,340,445);
		windows.setVisible(true);
		windows.setResizable(false);
		windows.setLocationRelativeTo(null);
	}
}
