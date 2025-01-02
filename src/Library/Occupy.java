package Library;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;


public class Occupy extends JFrame implements ActionListener
{

	JTextField l;
	JFrame f=new JFrame("Student Occupation");
	JButton b1;
	
	Occupy()
	{	
		l=new JTextField("Name");
		l.setBounds(150,50,200,50);
	
		b1=new JButton("Submit");
		b1.setBounds(200,400,100,50);
		b1.addActionListener(this);

		f.add(l);
		f.add(b1);
		f.setLayout(null);
		f.setBackground(Color.white);
		f.setLocationRelativeTo(null); 
		f.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
		f.setSize(500,600);
		f.setLocationRelativeTo(null); 
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int x,y,i=0;
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException ee){
            System.out.println(ee.getMessage());
        }
			try
			{
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","root");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from issue where name='"+l.getText().toString()+"';");
				
				f.setVisible(false);
				x=250;
				y=200;
				JLabel ar[]=new JLabel[6];
				while(rs.next())
				{
					ar[i]=new JLabel(rs.getString(1));
					ar[i].setBounds(x,y,200,50);
					f.add(ar[i]);
					y+=50;
					i++;
				}
				f.setVisible(true);
				con.close();
			}
			catch(Exception ex)
			{}
		
	}
	
}
