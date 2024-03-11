package src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Employee_Overtime extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_Overtime frame = new Employee_Overtime();
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
	public Employee_Overtime() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\14.png"));
		lblNewLabel.setBounds(0, 0, 1000, 563);
		contentPane.add(lblNewLabel);
		
		JButton overtime = new JButton("");
        overtime.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Employee_Overtime empo = new Employee_Overtime();
        		empo.setVisible(true);
        		dispose();
        	}
        });
        overtime.setBounds(76, 225, 89, 23);
        overtime.setBorderPainted(false);
		overtime.setContentAreaFilled(false);
		overtime.setOpaque(false);
        contentPane.add(overtime);
        
        JButton requestleave = new JButton("");
        requestleave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Employee_Requestleave empr = new Employee_Requestleave();
        		empr.setVisible(true);
        		dispose();
        	}
        });
        requestleave.setBounds(76, 270, 89, 23);
        requestleave.setBorderPainted(false);
		requestleave.setContentAreaFilled(false);
		requestleave.setOpaque(false);
        contentPane.add(requestleave);
                
        JButton shifthours = new JButton("");
        shifthours.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Employee_Shifthours emps = new Employee_Shifthours();
        		emps.setVisible(true);
        		dispose();
        	}
        });
        shifthours.setBounds(76, 326, 89, 23);
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
        logout.setBounds(88, 508, 77, 23);
        logout.setBorderPainted(false);
		logout.setContentAreaFilled(false);
		logout.setOpaque(false);
        contentPane.add(logout);
	}
}
