import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class student_info implements ActionListener
{
	JLabel l1,l2,l4,l5,l6,l7,l8,f2l1,f2l2,f2l3,f2l4,l3,roll,div,l9,username,password,rpassword;
	JFrame f,f1,f2;
	JPanel p;
	JButton b1,b2,b3,b4,b5,update;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,p1,p2;
	JCheckBox kan,eng,java,cc,st;
	JRadioButton cn,stat;
	ButtonGroup bg1;
	Font font;
	student_info()
	{
		f = new JFrame("");
		l1 = new JLabel("Username : ");
		l2 = new JLabel("Password : ");
		
		font = new Font("Helvetica",Font.ITALIC,20);
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);

		l1.setFont(font);
		l2.setFont(font);
		l1.setBounds(600,350,200,30);
		l2.setBounds(600,400,200,30);
		
		t1 = new JTextField("");
		t2 = new JTextField("");
		t3 = new JTextField("");

		b1 = new JButton("Login");
		b1.setBounds(700,450,100,30);
		
		b2 = new JButton("Clear");
		b2.setBounds(750,500,100,30);
		
		b3 = new JButton("Create");
		b3.setBounds(800,450,100,30);
		
		t1.setBounds(700,350,200,30);
		t2.setBounds(700,400,200,30);

		
		l4 = new JLabel();
		l4.setBounds(50,250,500,30);
		
		l5 = new JLabel("FName :");
		l5.setBounds(50,50,100,30);
		t4 = new JTextField("");
		t4.setBounds(100,50,100,30);
		
		
		l6 = new JLabel("LName :");
		l6.setBounds(50,100,100,30);
		t5 = new JTextField("");
		t5.setBounds(100,100,100,30);
		
		l7 = new JLabel("Roll :");
		l7.setBounds(50,150,100,30);
		t6 = new JTextField("");
		t6.setBounds(100,150,100,30);
		
		l8 = new JLabel("Div :");
		l8.setBounds(50,200,100,30);
		t3.setBounds(100,200,100,30);
		
		f.setLayout(new BorderLayout());
		JLabel bg=new JLabel(new ImageIcon

		("D:\\Brave downloads\\klebca.jpg"));
		bg.add(l1);bg.add(t1);
		bg.add(l2);bg.add(t2);

		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		f.add(bg);
		f.setSize(1920,1080);
		f.setVisible(true);
		
		f1 = new JFrame("New Window");
		f1.setLayout(null);
		f1.setSize(1920,1080);
		b4 = new JButton("Sign-Up");
		b4.setBounds(300,650,100,30);
		b5 = new JButton("Reset");
		b5.setBounds(400,650,100,30);	
			
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f2 = new JFrame("LOGIN");
		f2.setLayout(null);
		f2.setSize(1920,1080);
		f2.setVisible(false);
				
		
		kan = new JCheckBox("Kannada");
		kan.setBounds(100,250,100,30);
		eng = new JCheckBox("English");
		eng.setBounds(100,300,100,30);
		java = new JCheckBox("Adv Java");
		java.setBounds(100,350,100,30);
		st = new JCheckBox("ST");
		st.setBounds(100,400,100,30);
		cc = new JCheckBox("CC");
		cc.setBounds(100,450,100,30);
		
		cn = new JRadioButton("CN");
		cn.setBounds(250,300,100,30);
		stat = new JRadioButton("STAT");
		stat.setBounds(250,250,100,30);
		
		bg1 = new ButtonGroup();
		bg1.add(cn);bg1.add(stat);
		
		update = new JButton("Update");
		update.setBounds(250,250,100,30);

		f2l1 = new JLabel("Name :");
		f2l1.setBounds(100,50,100,30);
		
		f2l2 = new JLabel("Roll :");
		f2l2.setBounds(100,150,100,30);
		
		f2l3 = new JLabel("Div :");
		f2l3.setBounds(100,200,100,30);
		
		l3 = new JLabel("");
		l3.setBounds(200,50,100,30);

		l9 = new JLabel("");
		l9.setBounds(300,50,100,30);

		roll = new JLabel("");
		roll.setBounds(200,150,100,30);
		
		div = new JLabel("");
		div.setBounds(200,200,100,30);
		
		username = new JLabel("username");
		username.setBounds(300,50,100,30);
		
		t7 = new JTextField("");
		t7.setBounds(400,50,100,30);
		
		password = new JLabel("password");
		password.setBounds(300,100,100,30);
		
		p1 = new JTextField("");
		p1.setBounds(400,100,100,30);
		
		rpassword = new JLabel("re-pass");
		rpassword.setBounds(300,150,100,30);
		
		p2 = new JTextField("");
		p2.setBounds(400,150,100,30);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		if(s.equals("Login"))
		{
		String username = (t1.getText());
		String password1 = (t2.getText());
		if(username.equals("") || password1.equals(""))
		{ 
			JOptionPane.showMessageDialog(null, "Enter Your Credentials!!");
		}
		else
		{
		boolean visible = f2.isShowing();
		if(visible)
		{
			f2.setVisible(false);
 		}
		else
		{
			try
			{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					String URL = "jdbc:oracle:thin:@localhost:1521:XE";
					String user = "system";
					String pass = "12345";
					Connection con = DriverManager.getConnection(URL,user,pass);
					System.out.println("Connection Established");
					Statement st = con.createStatement();
					
					String fname = (t1.getText());
					
					String password = (t2.getText());
					
					ResultSet rs =st.executeQuery("select * from student100 where username ='"+fname+"' and password='"+password+"'");
					
					if(rs.next())
					{
							JOptionPane.showMessageDialog(null,"Logged In");
						    System.out.println("Logged In");
							f2.setVisible(true);
							
							f2.add(f2l1);
							f2.add(f2l2);
							f2.add(f2l3);
							
							f2.add(l3);
							f2.add(l9);f2.add(div);
							f2.add(roll);
//							f2.add(update);
							
							l3.setText(rs.getString("first_name"));
							l9.setText(rs.getString("last_name"));
							roll.setText(rs.getString("roll"));
							div.setText(rs.getString("div"));
						}
					else
					{
						System.out.println("else");
						JOptionPane.showMessageDialog(null,"Invalid");
					}
					
					t1.setText("");
					t2.setText("");
					st.close();
					con.close();
					System.out.println("Connection Closed");
				}
				
				catch(ClassNotFoundException a)
				{
					System.out.println("driver not found");
				}
				catch(SQLException e1)
				{
					System.out.println("query error");
				}
			l4.setText("hi");	
		}
		}
		}
		else if(s.equals("Clear"))
		{
			{
				t1.setText("");
				t2.setText("");
			}
		}
		else if(s.equals("Create"))
		{
				boolean visible = f1.isShowing();
				if(visible)
				{
					f1.setVisible(false);
					b3.setText("create");
				}
				else
				{
					f1.setVisible(true);
					f1.add(l4);
					f1.add(l5);f1.add(l6);f1.add(l7);f1.add(l8);f1.add(t3);
					f1.add(t4);f1.add(t5);f1.add(t6);
					f1.add(b4);
					f1.add(kan);f1.add(eng);f1.add(java);f1.add(cc);f1.add(st);f1.add(cn);f1.add(stat);
					f1.add(p1);f1.add(p2);
					f1.add(username);f1.add(password);f1.add(t7);f1.add(rpassword);
					f1.add(b5);
				}
			}
		else if(s.equals("Sign-Up"))
			{
			String rb = "";
			String rb1 = "";
			String pf2;
			String fname = (t4.getText());
			String lname = (t5.getText());
			String roll  = (t6.getText());
			String div = (t3.getText());
			String user1 = (t7.getText());
			String pass1 = (p1.getText());
			pf2 = (p2.getText());
			
			if(cn.isSelected())
			{
				rb = "CN";
			}
			if(stat.isSelected())
			{
				rb = "Statistics";
			}
			if(kan.isSelected())
			{
				rb1 = "Kannada";
			}
			System.out.println("checked is : "+rb);
			System.out.println("checked is : "+rb1);
			System.out.println("checked");
			if(fname.equals("") || lname.equals("")  || roll.equals("") || div.equals("") || user1.equals("") || pass1.equals("") )
			{
				JOptionPane.showMessageDialog(null, "Fill all the required Columns");
				
			}
			else if(pass1.equals(pf2))
			{
			try
			{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					String URL = "jdbc:oracle:thin:@localhost:1521:XE";
					String user = "system";
					String pass = "12345";
					Connection con = DriverManager.getConnection(URL,user,pass);
					System.out.println("Connection Established");

					PreparedStatement ps=con.prepareStatement("insert into student100 values(?,?,?,?,?,?)");

					ps.setString(1,fname);
		            ps.setString(2,lname);
		            ps.setString(3, roll);
		            ps.setString(4, div);
		            ps.setString(5, user1);
		            ps.setString(6, pass1);
		            ps.executeUpdate();

		            
		            JOptionPane.showMessageDialog(null,"Inserted");
					System.out.println("inserted");
					ps.close();
					con.close();
				}
				
				catch(ClassNotFoundException a)
				{
					System.out.println("driver not found");
					
				}
				
				catch(SQLException e1)
				{
					System.out.println("query error");
				}
			l4.setText("Inserted");
			f1.setVisible(false);
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			p1.setText("");
			p2.setText("");			
			}
			else if(pass1!=pf2)
			{
				JOptionPane.showMessageDialog(null, "Password Mismatch");
				p2.setText("");
			}
		}
		else if(s.equals("Reset"))
		{
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			p1.setText("");
			p2.setText("");		
			cn.isSelected();
		}
	}
	
		
	public static void main(String...args)
	{
	new student_info();
	}

	
}	

	



