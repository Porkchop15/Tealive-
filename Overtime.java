package src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Overtime extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Overtime frame = new Overtime();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Overtime() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\7.png"));
		lblNewLabel.setBounds(0, 0, 1000, 563);
		contentPane.add(lblNewLabel);
		
		JButton employeedetails = new JButton("");
		employeedetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeDetails det = new EmployeeDetails();
				det.setVisible(true);
				dispose();
			}
		});
		employeedetails.setBounds(82, 207, 89, 29);
		employeedetails.setBorderPainted(false);
		employeedetails.setContentAreaFilled(false);
		employeedetails.setOpaque(false);
		contentPane.add(employeedetails);
		
		JButton employeeattendance = new JButton("");
		employeeattendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeAttendance att = new EmployeeAttendance();
				att.setVisible(true);
				dispose();
			}
		});
		employeeattendance.setBounds(82, 270, 89, 29);
		employeeattendance.setBorderPainted(false);
		employeeattendance.setContentAreaFilled(false);
		employeeattendance.setOpaque(false);
		contentPane.add(employeeattendance);
		
		JButton overtime = new JButton("");
		overtime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Overtime ovr = new Overtime();
				ovr.setVisible(true);
				dispose();
			}
		});
		overtime.setBounds(82, 331, 89, 23);
		overtime.setBorderPainted(false);
		overtime.setContentAreaFilled(false);
		overtime.setOpaque(false);
		contentPane.add(overtime);
		
		JButton leaverequest = new JButton("");
		leaverequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeaveRequest leave = new LeaveRequest();
				leave.setVisible(true);
				dispose();
			}
		});
		leaverequest.setBounds(82, 380, 95, 23);
		leaverequest.setBorderPainted(false);
		leaverequest.setContentAreaFilled(false);
		leaverequest.setOpaque(false);
		contentPane.add(leaverequest);
		
		JButton shifthours = new JButton("");
		shifthours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeesShiftHour sft = new EmployeesShiftHour();
				sft.setVisible(true);
				dispose();
			}
		});
		shifthours.setBounds(82, 428, 89, 23);
		shifthours.setBorderPainted(false);
		shifthours.setContentAreaFilled(false);
		shifthours.setOpaque(false);
		contentPane.add(shifthours);
		
		JButton logout = new JButton("");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage home = new Homepage();
				home.setVisible(true);
				dispose();
			}
		});
		logout.setBounds(88, 511, 89, 23);
		logout.setBorderPainted(false);
		logout.setContentAreaFilled(false);
		logout.setOpaque(false);
		contentPane.add(logout);
	}

}
