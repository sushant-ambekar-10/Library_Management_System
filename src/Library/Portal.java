package Library;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Portal extends JFrame implements ActionListener
{

	JButton b1,b2,b3,b4;
	Portal()
	{
		super("Portal");
		setSize(500,600);
		
		JLabel b=new JLabel(new ImageIcon(""));
		b.setBounds(0,0,500,600);
		add(b);
		
		JLabel l=new JLabel("Details");
		l.setFont(new Font("Arial", Font.BOLD, 22));
		l.setBounds(200,100,100,30);

		b1=new JButton("Issue");
		b1.setFont(new Font("Arial", Font.BOLD, 15));
		b1.setBackground(Color.gray);
		b1.setForeground(Color.white);
		b1.setBounds(150,150,200,50);
		b1.addActionListener(this);

		b2=new JButton("Return");
		b2.setFont(new Font("Arial", Font.BOLD, 15));
		b2.setBackground(Color.gray);
		b2.setForeground(Color.white);
		b2.setBounds(150,250,200,50);
		b2.addActionListener(this);
		
		b3=new JButton("Book");
		b3.setFont(new Font("Arial", Font.BOLD, 15));
		b3.setBackground(Color.DARK_GRAY);
		b3.setForeground(Color.white);
		b3.setBounds(150,350,200,50);
		b3.addActionListener(this);
		
		b4=new JButton("Student");
		b4.setFont(new Font("Arial", Font.BOLD, 15));
		b4.setBackground(Color.black);
		b4.setForeground(Color.white);
		b4.setBounds(150,450,200,50);
		b4.addActionListener(this);

		b.add(l);
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);
		
		b.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0, 255, 0, 1));
		setLocationRelativeTo(null); 
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==b1)
			new Student();	
		else if(e.getSource()==b2)
			new Return();
		else if(e.getSource()==b3)
			new Book();
		else
			new Occupy();
	}


}
