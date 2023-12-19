import java.sql.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VariousQueriesAndScannerFinalProject {
	
	JFrame frame;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VariousQueriesAndScannerFinalProject window = new VariousQueriesAndScannerFinalProject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
			
	}
	

	public VariousQueriesAndScannerFinalProject() { initialize(); }

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 253);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		Database.connect(); // Establish connection to database
		setupClosingDBConnection(); // Handles closing the database connection if the user closes the program
		
		//calls the buttons 
		customerAccountButton();
		signInButton();
		appointmentButton();
		employeeSignInButton();
	
	}
	

	
	
	// Handles closing the database connection if the user closes the program
		public static void setupClosingDBConnection() {
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
		        public void run() {
		            try { Database.connection.close(); System.out.println("Application Closed - DB Connection Closed");
					} catch (SQLException e) { e.printStackTrace(); }
		        }
		    }, "Shutdown-thread"));
		}
		
		public static void getNumberOfRows() {
			try {
				Connection connection = Database.connection; // Connect to database
				String query = "SELECT COUNT(*) FROM Customers"; // Enter the query
				Statement stm = connection.createStatement(); // Create statement
				ResultSet result = stm.executeQuery(query); // Execute the query
				
				while (result.next()) {
					System.out.println("Number of rows in Customers table: " + result.getInt("COUNT(*)"));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
		//get methods
		public static void getCustomers() {
			try {
				Connection connection = Database.connection; // Connect to database
				String query = "SELECT * FROM Customers WHERE customer_name = '" + "Thomas Tank" + "'"; // Enter the query
				Statement stm = connection.createStatement(); // Create statement
				ResultSet result = stm.executeQuery(query); // Execute the query
				
				while (result.next()) {
					System.out.println("Customer ID: " + result.getInt("customer_id"));
					System.out.println("Customer Name: " + result.getString("customer_name"));
					System.out.println("Customer's Username: " + result.getString("c_username"));
					System.out.println("Customer's Password: " + result.getString("c_password"));
					System.out.println("Customer's Address: " + result.getString("address"));
					System.out.println("Account Type: " + result.getInt("account_type"));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		public static void getEmployees() {
			try {
				Connection connection = Database.connection; // Connect to database
				String query = "SELECT * FROM Employees WHERE employee_name = '" + "Thomas Tank" + "'"; // Enter the query
				Statement stm = connection.createStatement(); // Create statement
				ResultSet result = stm.executeQuery(query); // Execute the query
				
				while (result.next()) {
					System.out.println("Employee ID: " + result.getInt("employee_id"));
					System.out.println("Employee Name: " + result.getString("employee_name"));
					System.out.println("Employees's Username: " + result.getString("e_username"));
					System.out.println("Employee's Password: " + result.getString("e_password"));
					System.out.println("Account Type: " + result.getInt("account_type"));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		public static void getAdmin() {
			try {
				Connection connection = Database.connection; // Connect to database
				String query = "SELECT * FROM Admin WHERE admin_name = '" + "Thomas Tank" + "'"; // Enter the query
				Statement stm = connection.createStatement(); // Create statement
				ResultSet result = stm.executeQuery(query); // Execute the query
				
				while (result.next()) {
					System.out.println("Admin ID: " + result.getInt("admin_id"));
					System.out.println("Admin Name: " + result.getString("admin_name"));
					System.out.println("Admin's Username: " + result.getString("a_username"));
					System.out.println("Admin's Password: " + result.getString("a_password"));
					System.out.println("Account Type: " + result.getInt("account_type"));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	public static void getBankAccount() {
			try {
				Connection connection = Database.connection; // Connect to database
				String query = "SELECT * FROM BankAccounts WHERE bankaccount_id = '1'"; // Enter the query
				Statement stm = connection.createStatement(); // Create statement
				ResultSet result = stm.executeQuery(query); // Execute the query
				
				while (result.next()) {
					System.out.println("Bank Account ID: " + result.getInt("bankaccount_id"));
					System.out.println("Balance: " + result.getInt("balance"));
					System.out.println("Customer ID: " + result.getInt("customer_id"));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		public static void getAppointment() {
			try {
				Connection connection = Database.connection;
				String query = "SELECT * FROM Appointments WHERE appointment_id = '1'";
				Statement stm = connection.createStatement();
				ResultSet result = stm.executeQuery(query);
				
				while (result.next()) {
					System.out.println("Appointment ID: " + result.getInt("appointment_id"));
					System.out.println("Date: " + result.getString("date"));
					System.out.println("Time: " + result.getString("time"));
					System.out.println("Customer ID: " + result.getInt("customer_id"));
					System.out.println("Employee ID: " + result.getInt("employee_id"));
				}
			}catch (Exception e) {
				System.out.println(e);
			}
			
		}

		
		
		//Buttons for main menu
		public void customerAccountButton() {
			JButton button1 = new JButton("Create Customer Account");
			button1.setBounds(62,53,310,29);
			frame.getContentPane().add(button1);
			button1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					goToCustomerPage();
				}
				
			});
			
		}
		
		public void signInButton()
		{
			JButton button2 = new JButton("Customer Sign In");
			button2.setBounds(62,94,310,29);
			frame.getContentPane().add(button2);
			button2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					signInPage();
				}
				
			});
		}
		
		public void appointmentButton()
		{
			JButton button3 = new JButton("Make Appointment");
			button3.setBounds(62,135,310,29);
			frame.getContentPane().add(button3);
			button3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					appointmentPage();
				}
				
			});
		}
		
		public void employeeSignInButton()
		{
			JButton button3 = new JButton("Employee Sign In");
			button3.setBounds(62,176,310,29);
			frame.getContentPane().add(button3);
			button3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					employeePage();
				}
				
			});
		}
		
		
		//frame changers
		public void goToCustomerPage()
		{
			frame.dispose();
			customerAccountUI GTCP = new customerAccountUI(); 
			GTCP.initialize();
			GTCP.frame.setVisible(true);
		}
		
		public void signInPage()
		{
			frame.dispose();
			signInUI SIP = new signInUI();
			SIP.initialize();
			SIP.frame.setVisible(true);
			
		}
		
		public void appointmentPage()
		{
			frame.dispose();
			appointmentUI SIP = new appointmentUI();
			SIP.initialize();
			SIP.frame.setVisible(true);
			
		}
		
		public void employeePage() {
			frame.dispose();
			employeeSignInUI ESI = new employeeSignInUI();
			ESI.initialize();
			ESI.frame.setVisible(true);
		}
		
		
		
		
		

}
