import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class MyCalculator implements ActionListener {
	
	// Declaration
	JFrame frame;
	JTextField textField;
	JButton[] numButtons = new JButton[10]; // for number buttons
	JButton[] opButtons = new JButton[9]; // Operational buttons
	JButton addBtn, mulBtn, divBtn, subBtn;
	JButton delBtn, clrBtn, eqBtn, decBtn, negBtn;
	JPanel panel;
	
	Font myFont = new Font("Monospaced",Font.PLAIN,25);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	// Constructor
	MyCalculator(){
		
		//Frame
		frame = new JFrame("My Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 550);
		frame.getContentPane().setBackground(new Color(53, 47, 68));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		
		// Text Field
		textField = new JTextField();
		textField.setBounds(8, 5, 420, 105);
		textField.setFont(myFont);
		textField.setEditable(false);
		
		// Buttons
		divBtn = new JButton("\u00F7");
		mulBtn = new JButton("x");
		subBtn = new JButton("-");
		addBtn = new JButton("+");
		eqBtn = new JButton("=");
		decBtn = new JButton(".");
		clrBtn = new JButton("CE");
		delBtn = new JButton("Delete");
		negBtn = new JButton("(-)");
		
		opButtons[0] = divBtn;
		opButtons[1] = mulBtn;
		opButtons[2] = subBtn;
		opButtons[3] = addBtn;
		opButtons[4] = eqBtn;
		opButtons[5] = decBtn;
		opButtons[6] = clrBtn;
		opButtons[7] = delBtn;
		opButtons[8] = negBtn;
		
		// Setting up properties/functionalities to each buttons in array
		// For Operational Buttons
		for(int i = 0; i < 9; i++) {
			opButtons[i].addActionListener(this);
			opButtons[i].setFont(new Font("Monospaced", Font.PLAIN, 15));
			opButtons[i].setFocusable(false);
			opButtons[i].setBackground(new Color(92, 84, 112));
			opButtons[i].setForeground(Color.WHITE);
			opButtons[i].setBorder(null);		
		}
		// For Number buttons
		for(int i = 0; i < 10; i++) {
			numButtons[i] = new JButton(String.valueOf(i));
			numButtons[i].addActionListener(this);
			numButtons[i].setFont(myFont);
			numButtons[i].setFocusable(false);
			numButtons[i].setBackground(new Color(92, 84, 112));
			numButtons[i].setForeground(Color.WHITE);
			numButtons[i].setBorder(null);
		}
		
		// Panel for button
		panel = new JPanel();
		panel.setBounds(8, 113, 420, 395);
		panel.setBackground(new Color(53, 47, 68));
		panel.setLayout(new GridLayout(5, 4, 5, 5));
		panel.add(negBtn);
		panel.add(clrBtn);
		panel.add(delBtn);
		panel.add(divBtn);
		
		panel.add(numButtons[7]);
		panel.add(numButtons[8]);
		panel.add(numButtons[9]);
		panel.add(mulBtn);
		
		panel.add(numButtons[4]);
		panel.add(numButtons[5]);
		panel.add(numButtons[6]);
		panel.add(subBtn);
		
		panel.add(numButtons[3]);
		panel.add(numButtons[2]);
		panel.add(numButtons[1]);
		panel.add(addBtn);
		
		panel.add(decBtn);
		panel.add(numButtons[0]);
		panel.add(eqBtn);
		
		
		frame.add(panel);
		frame.add(textField);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		MyCalculator calc = new MyCalculator();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Functionalities for buttons
		
		for(int i = 0; i < 10; i++) { // For number btns
			if(e.getSource() == numButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
	
		if (e.getSource() == decBtn) { // For decimal btn
			textField.setText(textField.getText().concat("."));
		}
		
		if (e.getSource() == addBtn) { // For add btn
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if (e.getSource() == mulBtn) { // For mul btn
			num1 = Double.parseDouble(textField.getText());
			operator = 'x';
			textField.setText("");
		}
		if (e.getSource() == subBtn) { // For sub btn
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if (e.getSource() == divBtn) { // For div btn
			num1 = Double.parseDouble(textField.getText());
			operator = '\u00F7';
			textField.setText("");
		}
		if (e.getSource() == eqBtn ) { // For equal btn
			num2 = Double.parseDouble(textField.getText());
			
			switch(operator) {
				case '+':
					result = num1+num2;
					break;
				case 'x':
					result = num1*num2;
					break;
				case '-':
					result = num1-num2;
					break;
				case '\u00F7':
					result = num1/num2;
					break;
				default:
					textField.setText("Error");
			}
			
			// Checks if the answer is a whole number or decimal
			if(result == (int)result) {
				int intResult = (int)result; // conversion double to int
				textField.setText(String.valueOf(intResult));
				num1 = result;
			} else {
				textField.setText(String.valueOf(result));
				num1 = result; // to continue operation after
			}
		}
		
		if (e.getSource() == clrBtn) { // For clr btn
			textField.setText("");
		}
		
		if (e.getSource() == delBtn) { // For del btn
			String currentText = textField.getText();
			textField.setText("");
			for(int i = 0; i < (currentText.length()-1); i++) {
				textField.setText(textField.getText() + currentText.charAt(i));
			}
		}
		
		if (e.getSource() == negBtn) { // For negative btn
			double temp = Double.parseDouble(textField.getText());
			temp*=-1;
			textField.setText(String.valueOf(temp));
		}
		
	}

}