package JavaSwing;
import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class firstSwing {

	private JFrame frmFieldForm;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnCancel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstSwing window = new firstSwing();
					window.frmFieldForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public firstSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFieldForm = new JFrame();
		frmFieldForm.getContentPane().setBackground(new Color(0, 128, 192));
		frmFieldForm.setTitle("FIELD FORM");
		frmFieldForm.setBounds(100, 100, 566, 470);
		frmFieldForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFieldForm.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setBounds(99, 81, 65, 32);
		frmFieldForm.getContentPane().add(lblNewLabel);
		
		JLabel lblAddr = new JLabel("ADDR");
		lblAddr.setBounds(99, 123, 65, 32);
		frmFieldForm.getContentPane().add(lblAddr);
		
		JLabel lblMob = new JLabel("MOB");
		lblMob.setBounds(99, 170, 65, 32);
		frmFieldForm.getContentPane().add(lblMob);
		
		textField = new JTextField();
		textField.setBounds(174, 88, 221, 19);
		frmFieldForm.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(174, 130, 221, 19);
		frmFieldForm.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(174, 177, 221, 19);
		frmFieldForm.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("Button");
		btnNewButton.setBounds(118, 322, 111, 37);
		frmFieldForm.getContentPane().add(btnNewButton);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFieldForm.dispose();
				
			}
		});
		btnCancel.setBounds(329, 322, 111, 37);
		frmFieldForm.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("FORM FIELD");
		lblNewLabel_1.setBackground(new Color(255, 255, 0));
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(241, 30, 154, 32);
		frmFieldForm.getContentPane().add(lblNewLabel_1);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(99, 212, 65, 32);
		frmFieldForm.getContentPane().add(lblGender);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("M");
		chckbxNewCheckBox.setBounds(174, 218, 55, 21);
		frmFieldForm.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxF = new JCheckBox("F");
		chckbxF.setBounds(257, 218, 55, 21);
		frmFieldForm.getContentPane().add(chckbxF);
		
		JLabel lblGender_1 = new JLabel("Check");
		lblGender_1.setBounds(99, 254, 65, 32);
		frmFieldForm.getContentPane().add(lblGender_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
		rdbtnNewRadioButton.setBounds(174, 260, 55, 21);
		frmFieldForm.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.setBounds(257, 260, 55, 21);
		frmFieldForm.getContentPane().add(rdbtnNewRadioButton_1);
		
		
		
		
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//sql connection
				Connection conn=null;
				Statement stmt=null;
				ResultSet rs=null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				 
				String conn_string="jdbc:mysql://localhost:3306/Student?"+"user=root&password=7261888792";
				//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","7261888792");
				conn=DriverManager.getConnection(conn_string);
				stmt=conn.createStatement();
				
				String name=textField.getText();
				String addr=textField_1.getText();
				String mob=textField_2.getText();
				int nMob=Integer.parseInt(mob);
				String query="insert into student3(name,addr,mob) values('"+name+"','"+addr+"','"+nMob+"')";
     			stmt.executeUpdate(query);
     			//stmt.executeUpdate("insert into student3(name,addr,mob) values(\"Anand\",\"Abcde\",200)");
				rs=stmt.executeQuery("select* from student3");
				while(rs.next()) {
					String dbname=rs.getString("name");
					String dbaddr=rs.getString("addr");
					int dbmob=rs.getInt("mob");
					
					System.out.println(dbname+" "+dbaddr+" "+dbmob);
				}
				System.out.println("Executed Successfuly");   
				
				rs.close();
				stmt.close();
				conn.close();
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Submit Successfuly");
				HomePage homepage=new HomePage();
				homepage.setVisible(true);
			}
		});
		
		
		
	}
}
