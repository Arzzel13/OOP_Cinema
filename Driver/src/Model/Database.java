/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Zara
 */
public class Database {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/selftix";
            String username = "root";
            String pass = "";
            con = DriverManager.getConnection(url, username, pass);
            System.out.println("Connected");
        }
        catch (SQLException ex){
            System.out.println("connection error");
            ex.printStackTrace();
        }
    }
    
    
}
