import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class MyCalculator implements ActionListener {
	
	// Declaration
	JFrame frame;
	JTextField mainTextField, previewTextField;
	JButton[] numButtons = new JButton[10]; // for number buttons
	JButton[] opButtons = new JButton[10]; // Operational buttons
	JButton addBtn, mulBtn, divBtn, subBtn, modBtn;
	JButton delBtn, clrBtn, eqBtn, decBtn, negBtn;
	JPanel panel;
	JLayeredPane layeredPane;
	
	Font myFont = new Font("Monospaced", Font.PLAIN, 25);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	// Constructor
	MyCalculator(){
		
		// Main Text Field
		mainTextField = new JTextField();
		mainTextField.setBounds(8, 5, 419, 105);
		mainTextField.setFont(myFont);
		mainTextField.setHorizontalAlignment(JTextField.RIGHT);
		mainTextField.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		mainTextField.setEditable(false);
		
		// Preview Text Field
		previewTextField = new JTextField();
		previewTextField.setBounds(8, 5, 419, 40);
		previewTextField.setFont(new Font("Monospaced", Font.ITALIC, 18));
		previewTextField.setForeground(Color.GRAY);
		previewTextField.setHorizontalAlignment(JTextField.RIGHT);
		previewTextField.setBorder(BorderFactory.createEmptyBorder(10, 20 , 0, 20));
		previewTextField.setEditable(false);
		
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
		modBtn = new JButton("%");
		
		opButtons[0] = divBtn;
		opButtons[1] = mulBtn;
		opButtons[2] = subBtn;
		opButtons[3] = addBtn;
		opButtons[4] = eqBtn;
		opButtons[5] = decBtn;
		opButtons[6] = clrBtn;
		opButtons[7] = delBtn;
		opButtons[8] = negBtn;
		opButtons[9] = modBtn;
		
		// Setting up properties/functionalities to each buttons in array
		// For Operational Buttons
		for(int i = 0; i < 10; i++) {
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
		panel.add(modBtn);
			
		panel.add(numButtons[7]);
		panel.add(numButtons[8]);
		panel.add(numButtons[9]);
		panel.add(divBtn);
		
		panel.add(numButtons[4]);
		panel.add(numButtons[5]);
		panel.add(numButtons[6]);
		panel.add(mulBtn);
		
		panel.add(numButtons[3]);
		panel.add(numButtons[2]);
		panel.add(numButtons[1]);
		panel.add(subBtn);
		
		panel.add(decBtn);
		panel.add(numButtons[0]);
		panel.add(eqBtn);
		panel.add(addBtn);
		
		// Layered Pane
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 450, 105);
		layeredPane.setBorder(null);
		layeredPane.add(mainTextField, Integer.valueOf(0));
		layeredPane.add(previewTextField, Integer.valueOf(1));
		
		//Frame
		frame = new JFrame("My Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 550);
		frame.getContentPane().setBackground(new Color(53, 47, 68));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // to center the frame
		frame.setLayout(null);
		frame.add(layeredPane);
		frame.add(panel);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		try {
			MyCalculator calc = new MyCalculator();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Functionalities for buttons
		
		for(int i = 0; i < 10; i++) { // For number btns
			if(e.getSource() == numButtons[i]) {
				mainTextField.setText(mainTextField.getText().concat(String.valueOf(i)));
			}
		}
	
		if (e.getSource() == decBtn) { // For decimal btn
			mainTextField.setText(mainTextField.getText().concat("."));
		}
		
		if (e.getSource() == addBtn) { // For add btn
			num1 = Double.parseDouble(mainTextField.getText());
			operator = '+';
			previewTextField.setText(mainTextField.getText().concat("+"));
			mainTextField.setText("");
		}
		if (e.getSource() == mulBtn) { // For mul btn
			num1 = Double.parseDouble(mainTextField.getText());
			operator = 'x';
			previewTextField.setText(mainTextField.getText().concat("x"));
			mainTextField.setText("");
		}
		if (e.getSource() == subBtn) { // For sub btn
			num1 = Double.parseDouble(mainTextField.getText());
			operator = '-';
			previewTextField.setText(mainTextField.getText().concat("-"));
			mainTextField.setText("");
		}
		if (e.getSource() == divBtn) { // For div btn
			num1 = Double.parseDouble(mainTextField.getText());
			operator = '\u00F7';
			previewTextField.setText(mainTextField.getText().concat("\u00F7"));
			mainTextField.setText("");
		}
		if (e.getSource() == modBtn) { // For mod btn
			num1 = Double.parseDouble(mainTextField.getText());
			operator = '%';
			previewTextField.setText(mainTextField.getText().concat("%"));
			mainTextField.setText("");
		}
		if (e.getSource() == eqBtn ) { // For equal btn
			num2 = Double.parseDouble(mainTextField.getText());
			
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
				case '%':
					result = num1%num2;
					break;
				default:
					mainTextField.setText("Error");
			}
			
			// Checks if the answer is a whole number or decimal
			if(result == (int)result) {
				int intResult = (int)result; // conversion double to int
				previewTextField.setText(previewTextField.getText().concat(String.valueOf((int)num2).concat("=")));
				mainTextField.setText(String.valueOf(intResult));
				num1 = result;
			} else {
				previewTextField.setText(previewTextField.getText().concat(String.valueOf(num2).concat("=")));
				mainTextField.setText(String.valueOf(result));
				num1 = result; // to continue operation after
			}
		}
		
		if (e.getSource() == clrBtn) { // For clr btn
			previewTextField.setText("");
			mainTextField.setText("");
		}
		
		if (e.getSource() == delBtn) { // For del btn
			String currentText = mainTextField.getText();
			mainTextField.setText("");
			for(int i = 0; i < (currentText.length()-1); i++) {
				mainTextField.setText(mainTextField.getText() + currentText.charAt(i));
			}
		}
		
		if (e.getSource() == negBtn) { // For negative btn
			double temp = Double.parseDouble(mainTextField.getText());
			temp*=-1;
			// Checks if the temp is a whole number or decimal
			if(temp == (int)temp) {
				int intTemp = (int)temp;
				mainTextField.setText(String.valueOf(intTemp));
			} else {
				mainTextField.setText(String.valueOf(temp));
			}
			
		}
		
	}

}