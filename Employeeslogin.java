package src;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.sql.*;

public class Employeeslogin extends JFrame {

    private JPanel contentPane;
    private JTextField employee;
    private JTextField password;
    private JButton login;
    private String urlToDatabase = "jdbc:mysql://localhost:3306/Mysql";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Employeeslogin frame = new Employeeslogin();
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
    public Employeeslogin() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 593);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton back = new JButton("");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Homepage hom = new Homepage();
                hom.setVisible(true);
                dispose();
            }
        });
        back.setBounds(899, 38, 56, 36);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setOpaque(false);
        contentPane.add(back);

        employee = new JTextField();
        employee.setForeground(new Color(255, 255, 255));
        employee.setBounds(577, 261, 298, 30);
        employee.setFont(new Font("Tahoma", Font.PLAIN, 14));
        employee.setBackground(null);
        employee.setBorder(null);
        employee.setOpaque(false);
        contentPane.add(employee);
        employee.setColumns(10);

        password = new JTextField();
        password.setForeground(new Color(255, 255, 255));
        password.setText("");
        password.setBounds(577, 363, 298, 30);
        password.setFont(new Font("Tahoma", Font.PLAIN, 14));
        password.setBackground(null);
        password.setBorder(null);
        password.setOpaque(false);
        contentPane.add(password);
        password.setColumns(10);

        login = new JButton("Login");
        login.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent c) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    try (Connection con = DriverManager.getConnection(urlToDatabase, "root", "Wky!2jy#")) {
                        String sql = "SELECT * FROM employee WHERE username=? AND password=?";
                        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                            pstmt.setString(1, employee.getText());
                            pstmt.setString(2, password.getText());
                            try (ResultSet rs = pstmt.executeQuery()) {
                                if (rs.next()) {
                                    JOptionPane.showMessageDialog(null, "Login Success");
                                    Homepage hom = new Homepage();
                                    hom.setVisible(true);
                                    dispose();
                                    // Add code here to open a new window or perform other actions after successful login
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        login.setBounds(687, 450, 144, 36);
        contentPane.add(login);

        JLabel label = new JLabel("New label");
        label.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\12.png"));
        label.setBounds(0, 0, 1000, 563);
        contentPane.add(label);
    }
}
