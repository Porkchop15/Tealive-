package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeViews extends JFrame {

    private JPanel contentPane;
    private Connection conn;
    private DefaultTableModel tableModel;
    private JLabel dateTimeLabel;
    private JTextField employeeIdTextField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EmployeeViews frame = new EmployeeViews();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EmployeeViews() {
        initialize();
        connectToDatabase();
        startClock();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 593);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        dateTimeLabel.setBounds(731, 90, 200, 30);
        contentPane.add(dateTimeLabel);

        JButton btnTimeIn = new JButton("Time In");
        btnTimeIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEmployeeIdTextField(); // Dynamically add employee ID text field
            }
        });
        btnTimeIn.setBounds(329, 409, 176, 49);
        btnTimeIn.setBorderPainted(false);
		btnTimeIn.setContentAreaFilled(false);
		btnTimeIn.setOpaque(false);
        contentPane.add(btnTimeIn);

        JButton btnTimeOut = new JButton("Time Out");
        btnTimeOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeOut();
            }
        });
        btnTimeOut.setBounds(679, 409, 185, 49);
        btnTimeOut.setBorderPainted(false);
		btnTimeOut.setContentAreaFilled(false);
		btnTimeOut.setOpaque(false);
        contentPane.add(btnTimeOut);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(254, 134, 696, 240);
        contentPane.add(scrollPane);

        JTable table = new JTable();
        tableModel = new DefaultTableModel();
        table.setModel(tableModel);
        tableModel.addColumn("Time Type");
        tableModel.addColumn("Time Stamp");
        scrollPane.setViewportView(table);
        
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
                
                        JLabel lblNewLabel = new JLabel("New label");
                        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\13.png"));
                        lblNewLabel.setBounds(0, 0, 1000, 563);
                        contentPane.add(lblNewLabel);
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/time_table";
            String username = "root";
            String password = "Wky!2jy#";
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("Connected to the database!");
                loadTableData(); // Load existing data from the database
            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void addEmployeeIdTextField() {
        // Add employee ID text field dynamically
        if (employeeIdTextField == null) {
            employeeIdTextField = new JTextField();
            employeeIdTextField.setBounds(329, 350, 200, 30);
            contentPane.add(employeeIdTextField);
            contentPane.revalidate();
            contentPane.repaint();
            contentPane.updateUI(); // Update UI to reflect changes
        } else {
            // Check if employee ID is empty
            if (employeeIdTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Employee ID.");
            } else {
                timeIn(); // Proceed with time-in operation
            }
        }
    }

    private void timeOut() {
        insertTime("Time Out");
    }

    private void timeIn() {
        insertTime("Time In");
    }

    private void insertTime(String type) {
        String employeeId = employeeIdTextField.getText();
        if (employeeId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Employee ID.");
            return;
        }

        String sql = "INSERT INTO time_table (time_type, time_stamp) VALUES (?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, type);
            pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            pstmt.executeUpdate();
            System.out.println("Time inserted successfully!");
            loadTableData(); // Reload table data after inserting new record
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadTableData() {
        try {
            String sql = "SELECT * FROM time_table";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            tableModel.setRowCount(0); // Clear existing table data
            while (rs.next()) {
                String timeType = rs.getString("time_type");
                Timestamp timeStamp = rs.getTimestamp("time_stamp");
                tableModel.addRow(new Object[]{timeType, timeStamp});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date());
        dateTimeLabel.setText(currentTime);
    }

    private void startClock() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();
    }
}
