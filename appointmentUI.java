import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class appointmentUI {

	JFrame frame;
	private JTextField textField;
	private JTextField customerIDTF;
	private JTextField dateTF;
	private JLabel CustomerIDLabel;
	private JLabel DateLabel;
	private JTextField timeTF;
	private JLabel TimeLabel;
	private JButton scheduleButton;
	private JLabel customerIDLabel;
	private JLabel dateLabel;
	private JLabel timeLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appointmentUI window = new appointmentUI();
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
	public appointmentUI() {
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
		
		createAppointmentButton();
		createCustomerIDTF();
		createDateTF();
		createTimeTF();
		createCustomerIDLabel();
		createDateLabel();
		createTimeLabel();	
	}
	
	//creates button	
	public void createAppointmentButton() {
		scheduleButton = new JButton("schedule");
		scheduleButton.setBounds(151, 222, 117, 29);
		frame.getContentPane().add(scheduleButton);
		scheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createAppointment();
				
				// TODO Auto-generated method stub
				//send data to appointment table
			}
			
		});
}
	
	//creates text field
	public void createCustomerIDTF() {
		customerIDTF = new JTextField();
		customerIDTF.setBounds(151, 45, 130, 26);
		frame.getContentPane().add(customerIDTF);
		customerIDTF.setColumns(10);
	}
	
	public void createDateTF() {
		
		dateTF = new JTextField();
		dateTF.setBounds(151, 111, 130, 26);
		frame.getContentPane().add(dateTF);
		dateTF.setColumns(10);
	
		}
	
	public void createTimeTF() {
		timeTF = new JTextField();
		timeTF.setBounds(151, 177, 130, 26);
		frame.getContentPane().add(timeTF);
		timeTF.setColumns(10);
	}
	
	
	//creates labels
	public void createCustomerIDLabel() {
		customerIDLabel = new JLabel("Customer ID");
		customerIDLabel.setBounds(171, 17, 97, 16);
		frame.getContentPane().add(customerIDLabel);
	}
	
	public void createDateLabel() {
		dateLabel = new JLabel("Date");
		dateLabel.setBounds(185, 83, 61, 16);
		frame.getContentPane().add(dateLabel);
	}
	
	public void createTimeLabel() {
		timeLabel = new JLabel("Time");
		timeLabel.setBounds(185, 149, 61, 16);
		frame.getContentPane().add(timeLabel);
	}
	
	int randomEmployeeID = (int) (Math.random()*50 +1);
	
	//makes appointment into database
	public void createAppointment() {
		
		try {
		Connection connection = Database.connection;
		String query = "INSERT INTO Appointments VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stm = connection.prepareStatement(query);
		
		stm.setInt(1, randomEmployeeID);
		stm.setInt(2,  Integer.parseInt(customerIDTF.getText()));
		stm.setString(3, dateTF.getText());
		stm.setString(4, timeTF.getText());
		stm.setInt(5, randomEmployeeID);
		stm.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "New Appointment made!", "Appointment Added!", JOptionPane.DEFAULT_OPTION);
		
	}catch(Exception e) {
		System.out.println(e);
		
	}
	}
	
	

}

