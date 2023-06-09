package JavaSwing;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.*;


class MyComponent extends JPanel implements Serializable{
	private JLabel label;
	private JTextField textField;
	private JButton button;
	MyComponent(){
		label=new JLabel("Enter your name:");
		textField=new JTextField(20);
		button=new JButton("Click Me");
		button.setSize(20,20);
		button.addActionListener(new ButtonListener());
		add(label);
		add(textField);
		add(button);
		
	}
	public String getName() {
		return textField.getText();
	}
	public void setName(String name) {
		textField.setText(name);
	}
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("button clicked");
			String name=getName();
			System.out.println("Name Entered: "+name);
			JOptionPane.showMessageDialog(null,"Hello "+name);
		}
	}
	
	
}
public class BeanDemo {

	public static void main(String[] args) {
		MyComponent myComponent=new MyComponent();
		JFrame frame=new JFrame("My Component");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(myComponent);
		frame.pack();
		frame.setVisible(true);
		
//		String name=myComponent.getName();
//		System.out.println("Name: "+name);
//		myComponent.setVisible(true);
		

	}

}
