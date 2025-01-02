package Library;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

public class Book extends JFrame implements ActionListener
{
	
	JTextField l;
	JLabel r;
	
	Book()
	{

		super("Book Details");	
		l=new JTextField("Book ID");
		l.setBounds(150,200,200,50);
	
		r=new JLabel("Name Of Recepient..");
		r.setBounds(200,250,200,50);
		
		JButton b1=new JButton("Submit");
		b1.setFont(new Font("Arial", Font.BOLD, 15));
		b1.setBackground(Color.DARK_GRAY);
		b1.setForeground(Color.white);
		b1.setBounds(200,300,100,50);
		b1.addActionListener(this);

		add(l);
		add(b1);
		add(r);
		setLayout(null);
		setBackground(Color.white);
		setLocationRelativeTo(null); 
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
		setSize(500,500);
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
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from issue where bid='"+l.getText().toString()+"';");
			rs.next();
			r.setText("Occupied by , "+rs.getString(2));
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
}
