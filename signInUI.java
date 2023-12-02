import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		//calls functions
		createSignInButton();
		createUserNameLabel();
		createUserNameTF();
		createPassWordLabel();
		createPassWordTF();
		createBackButton();
	
	}
	
	//creating button
	public void createSignInButton() {
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setBounds(168, 174, 117, 29);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				//sign into account
				loginButton();
				
			}
		});
	}
	
	public void createBackButton() {
	JButton backBT = new JButton("< Back");
	backBT.setBounds(6, 237, 117, 29);
	frame.getContentPane().add(backBT);
	backBT.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			homePage();
		}
	});
	
}
	
	//creates labels
	public void createUserNameLabel()
	{
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(197, 33, 73, 16);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void createPassWordLabel() {
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(197, 109, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
	}
	
	//creates text fields
	public void createUserNameTF() {
		textField = new JTextField();
		textField.setBounds(148, 61, 155, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	public void createPassWordTF() {
		textField_1 = new JTextField();
		textField_1.setBounds(148, 136, 155, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
	}
	
	
	//frame changers
	public void signInPage()
	{
		frame.dispose();
		signInUI SIP = new signInUI();
		SIP.initialize();
		SIP.frame.setVisible(true);
		
	}
	
	public void bankPage()
	{
		frame.dispose();
		bankAccountUI BP = new bankAccountUI();
		BP.initialize();
		BP.frame.setVisible(true);
		
	}
	
	public void homePage() {
		frame.dispose();
		VariousQueriesAndScannerFinalProject main = new VariousQueriesAndScannerFinalProject();
		main.initialize();
		main.frame.setVisible(true);
		
	}
	
	//login button
	public void loginButton()
	{
		try {
			frame.dispose();
			Connection connection = Database.connection; 
			String dbUsername = "SELECT * FROM Customers WHERE c_username = ?";
			String dbPassWord = "SELECT * FROM Customers WHERE c_password = ?";
			PreparedStatement statement1 = connection.prepareStatement(dbUsername);
			PreparedStatement statement2 = connection.prepareStatement(dbPassWord);
                statement1.setString(1, textField.getText());
                statement2.setString(1, textField_1.getText());
                
                ResultSet resultSet1 = statement1.executeQuery();
                ResultSet resultSet2 = statement2.executeQuery();
                
                if(resultSet1.next()&& resultSet2.next())
                {
                	JOptionPane.showMessageDialog(null, "Authentification Passed!", "Welcome User.", JOptionPane.DEFAULT_OPTION);
                	bankPage();
                	
                }else {
                	
                	JOptionPane.showMessageDialog(null, "Authentification Failed!", "Try Again.", JOptionPane.DEFAULT_OPTION);
                	signInPage();
                }
                    
		}catch (SQLException ex) {
            ex.printStackTrace();
            
        }
		
		
		
		
	}
}
