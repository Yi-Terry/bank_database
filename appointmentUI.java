import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class appointmentUI {

	private JFrame frame;
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
	private void initialize() {
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
	
		
	public void createAppointmentButton() {
		scheduleButton = new JButton("schedule");
		scheduleButton.setBounds(151, 222, 117, 29);
		frame.getContentPane().add(scheduleButton);
		scheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				// TODO Auto-generated method stub
				//send data to appointment table
			}
			
		});
}
	
	
	public void createCustomerIDTF() {
		customerIDTF = new JTextField();
		customerIDTF.setBounds(151, 81, 130, 26);
		frame.getContentPane().add(customerIDTF);
		customerIDTF.setColumns(10);
	}
	
	public void createCustomerIDLabel() {
		customerIDLabel = new JLabel("Customer ID");
		customerIDLabel.setBounds(169, 64, 97, 16);
		frame.getContentPane().add(customerIDLabel);
	}
	

	public void createDateTF() {
	
		dateTF = new JTextField();
		dateTF.setBounds(151, 137, 130, 26);
		frame.getContentPane().add(dateTF);
		dateTF.setColumns(10);
	
		}

	public void createDateLabel() {
		dateLabel = new JLabel("Date");
		dateLabel.setBounds(185, 119, 61, 16);
		frame.getContentPane().add(dateLabel);
	}
	
	
	public void createTimeTF() {
		timeTF = new JTextField();
		timeTF.setBounds(151, 190, 130, 26);
		frame.getContentPane().add(timeTF);
		timeTF.setColumns(10);
	}

	public void createTimeLabel() {
		timeLabel = new JLabel("New label");
		timeLabel.setBounds(185, 175, 61, 16);
		frame.getContentPane().add(timeLabel);
	}
	
	
	
	

}

