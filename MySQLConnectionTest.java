package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionTest {
    public static void main(String[] args) {
        
    	Connection conn = null;
    	try {
    		conn = (Connection)DriverManager.getConnection("jdbc:mysql:/localhost:3306/Mysql","root","Wky!2jy#");
    		
    		if (conn!=null)
    		{
    			System.out.println("Connected");
    		}
    	}catch(Exception e) {
    		System.out.println("Connected");
    	}
    }
}
