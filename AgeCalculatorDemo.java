package JavaSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.*;

class AgeCalculatorBean extends JPanel implements ActionListener, FocusListener {
    
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel;
    private JLabel dobLabel;
    private JTextField nameField;
    private JTextField dobField;
    private JButton calculateButton;
    private JLabel ageLabel;
    
    public AgeCalculatorBean() {
        // Initialize the components
        nameLabel = new JLabel("Name:");
        dobLabel = new JLabel("Date of Birth (MM/DD/YYYY):");
        nameField = new JTextField(20);
        dobField = new JTextField(10);
        calculateButton = new JButton("Calculate");
        ageLabel = new JLabel("");
        
        // Add event listeners to the components
        nameField.addActionListener(this);
        dobField.addActionListener(this);
        nameField.addFocusListener(this);
        dobField.addFocusListener(this);
        calculateButton.addActionListener(this);
        
        // Add the components to the panel
        add(nameLabel);
        add(nameField);
        add(dobLabel);
        add(dobField);
        add(calculateButton);
        add(ageLabel);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton || e.getSource() == nameField || e.getSource() == dobField) {
            // Get the name and date of birth from the text fields
            String name = nameField.getText();
            String dobStr = dobField.getText();
            LocalDate dob = LocalDate.parse(dobStr, java.time.format.DateTimeFormatter.ofPattern("MM/dd/yyyy"));

            // Calculate the user's age
            Period age = Period.between(dob, LocalDate.now());

            // Update the age label with the result
            ageLabel.setText(name + "'s age is " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days.");
        }
    }
    
    public void focusGained(FocusEvent e) {
        if (e.getSource() == nameField) {
            nameField.selectAll();
        } else if (e.getSource() == dobField) {
            dobField.selectAll();
        }
    }
    
    public void focusLost(FocusEvent e) {
        // Do nothing
    }
}



public class AgeCalculatorDemo {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Age Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        AgeCalculatorBean ageCalculator = new AgeCalculatorBean();
        frame.add(ageCalculator);
        
        frame.setVisible(true);
    }
}

