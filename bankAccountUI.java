import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bankAccountUI {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bankAccountUI window = new bankAccountUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bankAccountUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//calls functions
		createTotalLabel();
		createDepositLabel();
		createWithDrawlLabel();
		createDepositButton();
		createWithDrawlButton();
		createDepositTF();
		createWithDrawlTF();
		
		
		
		
		
		
		
		
		
		
		
	
	}
	
	
	//creates Labels
	public void createTotalLabel()
	{
		JLabel moneyTotal = new JLabel("Total");
		moneyTotal.setBounds(174, 20, 61, 16);
		frame.getContentPane().add(moneyTotal);
	}
	
	public void createDepositLabel() {
		JLabel depositLabel = new JLabel("Deposit");
		depositLabel.setBounds(174, 84, 61, 16);
		frame.getContentPane().add(depositLabel);
	}
	
	public void createWithDrawlLabel() {
		JLabel withDrawlLabel = new JLabel("Withdrawl");
		withDrawlLabel.setBounds(174, 183, 88, 16);
		frame.getContentPane().add(withDrawlLabel);
	}
	
	
	//Creates buttons
	public void createDepositButton() {

		JButton depositBT = new JButton("Submit");
		depositBT.setBounds(145, 142, 117, 29);
		frame.getContentPane().add(depositBT);
		depositBT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	
	public void createWithDrawlButton() {
		JButton withdrawlBT = new JButton("Submit");
		withdrawlBT.setBounds(145, 226, 117, 29);
		frame.getContentPane().add(withdrawlBT);
		withdrawlBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	
	//Creates text fields
	public void createDepositTF() {
		textField = new JTextField();
		textField.setBounds(133, 104, 142, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	public void createWithDrawlTF() {
		textField_1 = new JTextField();
		textField_1.setBounds(133, 198, 142, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
	
	
	
}
