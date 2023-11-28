import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signInUI {

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
					signInUI window = new signInUI();
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
	public signInUI() {
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
		
		
		createSignInButton();
		createUserNameLabel();
		createUserNameTF();
		createPassWordLabel();
		createPassWordTF();
		
	
	}
	
	//creating buttons, text fields, and labels
	public void createSignInButton() {
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setBounds(168, 174, 117, 29);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				//sign into account
				
				
			}
		});
	}
	
	public void createUserNameLabel()
	{
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(197, 33, 73, 16);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void createUserNameTF() {
		textField = new JTextField();
		textField.setBounds(148, 61, 155, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	public void createPassWordLabel() {
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(197, 109, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
	}
	
	public void createPassWordTF() {
		textField_1 = new JTextField();
		textField_1.setBounds(148, 136, 155, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
	
	
}
