package Library;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

public class Student extends JFrame implements ActionListener 
{

	JTextField l,t;
	JLabel d,d2;
	
	Student() 
	{

		super("Student Details");	
		l=new JTextField("Book ID");
		l.setBounds(150,50,200,50);
		t=new JTextField("Name of Reciepent ...");
		t.setBounds(150,150,200,50);
		Calendar calendar = Calendar.getInstance(); 
		d=new JLabel("Today : "+calendar.getTime());
		d.setBounds(150,250,300,30);
		calendar.add(Calendar.DATE, +30);  
		d2=new JLabel("Expiry : "+calendar.getTime());
		d2.setBounds(150,350,300,30);
	
		JButton b1=new JButton("Submit");
		b1.setFont(new Font("Arial", Font.BOLD, 15));
		b1.setBackground(Color.DARK_GRAY);
		b1.setForeground(Color.white);
		b1.setBounds(200,450,100,50);
		b1.addActionListener(this);

		add(l);
		add(t);
		add(d);
		add(d2);
		add(b1);
		setBackground(Color.white);
		setLocationRelativeTo(null); 
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
		setLayout(null);
		setSize(500,600);
		setLocationRelativeTo(null); 
		setVisible(true);		

	}

	public void actionPerformed(ActionEvent e)
	{

		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException ee){
            System.out.println(ee.getMessage());
        }
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("create table if not exists issue(bid varchar(20),name varchar(20),date varchar(100),expiry varchar(100));");
			st.executeUpdate("insert into issue values('"+l.getText().toString()+"','"+t.getText().toString()+"','"+d.getText().toString()+"','"+d2.getText().toString()+"');");
			con.close();
		}
		catch(Exception ex)
		{System.out.println(ex);}
	}

	
}
