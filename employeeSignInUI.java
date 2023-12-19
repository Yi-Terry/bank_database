import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class employeeSignInUI {

	public JFrame frame;
	private JTextField userNameTF;
	private JTextField passwordTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeSignInUI window = new employeeSignInUI();
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
	public employeeSignInUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		employeeSignInLabel();
		userNameLabel();
		passWordLabel();
		uNameTF();
		pWordTF();	
		createSignInButton();
	}
	
	//frames
	public void homePage() {
		frame.dispose();
		VariousQueriesAndScannerFinalProject main = new VariousQueriesAndScannerFinalProject();
		main.initialize();
		main.frame.setVisible(true);
		
	}
	
	public void employeePage()
	{
		frame.dispose();
		employeePageUI EP = new employeePageUI();
		EP.initialize();
		EP.frame.setVisible(true);
		
	}
	
	//creating labels
	public void employeeSignInLabel() {
		JLabel EmployeeTitle = new JLabel("Employee Sign in");
		EmployeeTitle.setBounds(148, 19, 130, 16);
		frame.getContentPane().add(EmployeeTitle);
	}
	
	
	public void userNameLabel() {
		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setBounds(183, 71, 72, 16);
		frame.getContentPane().add(userNameLabel);
	}
	
	
	public void passWordLabel() {
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(183, 154, 61, 16);
		frame.getContentPane().add(passwordLabel);
	}
	
	//creating text fields
	public void uNameTF() {
		userNameTF = new JTextField();
		userNameTF.setBounds(148, 85, 130, 26);
		frame.getContentPane().add(userNameTF);
		userNameTF.setColumns(10);
	}
	
	public void pWordTF() {
		
		passwordTF = new JTextField();
		passwordTF.setBounds(148, 166, 130, 26);
		frame.getContentPane().add(passwordTF);
		passwordTF.setColumns(10);	
	}
	
	//creating buttons
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
	
	public void createSignInButton() {
		JButton signInBT = new JButton("Sign In");
		signInBT.setBounds(148, 204, 117, 29);
		frame.getContentPane().add(signInBT);
		signInBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				signInButton();
			}
		});
		
	}

	
	//uses query to compare if username and password matches these varaibles in the database
	public void signInButton() {
		try {
			frame.dispose();
			Connection connection = Database.connection; 
			String dbUsername = "SELECT * FROM Employees WHERE e_username = ?";
			String dbPassWord = "SELECT * FROM Employees WHERE e_password = ?";
			PreparedStatement statement1 = connection.prepareStatement(dbUsername);
			PreparedStatement statement2 = connection.prepareStatement(dbPassWord);
                statement1.setString(1, userNameTF.getText());
                statement2.setString(1, passwordTF.getText());
                
                ResultSet resultSet1 = statement1.executeQuery();
                ResultSet resultSet2 = statement2.executeQuery();
                
                if(resultSet1.next()&& resultSet2.next())
                {
                	JOptionPane.showMessageDialog(null, "Authentification Passed!", "Welcome Employee.", JOptionPane.DEFAULT_OPTION);
                	employeePage();
                	
                }else {
                	
                	JOptionPane.showMessageDialog(null, "Authentification Failed!", "Try Again.", JOptionPane.DEFAULT_OPTION);
                	homePage();
                }
                    
		}catch (SQLException ex) {
            ex.printStackTrace();
            
        }
		
	}
	
	
	
}
