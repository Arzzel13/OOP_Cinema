/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import com.mysql.jdbc.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Zara
 */
public class Database {
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    ArrayList<Customer> cust;
    ArrayList<Film> film;
    ArrayList<Booking> book;
    ArrayList<Admin> admin;
    
    public void connect() {
        try {
            String url = "jdbc:mysql://localhost/cinemadb";
            String username = "root";
            String pass = "";
            con = DriverManager.getConnection(url, username, pass);
            stmt = con.createStatement();
            System.out.println("Connected");
        }
        catch (SQLException ex){
            System.out.println("connection error");
            ex.printStackTrace();
        }
    } 
    public void disconnect()  {
        try{
            con.close();
            stmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void loadCustomer(){
        connect();
        try {
            cust = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM customer");
            while (rs.next()){
                cust.add(new Customer(rs.getString("nama"), rs.getString("noHp"), rs.getString("username"), rs.getString("pwd")));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
    }
    
    public void loadFilm(){
        connect();
        try{
            film = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM film");
            while (rs.next()){
                film.add(new Film(rs.getString("idFilm"),rs.getString("judulFilm"), rs.getString("theater"), rs.getString("waktu")));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
    }
    
    public void loadBooking(){
        connect();
        try{
            book = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM booking");
            while (rs.next()){
                Film f = cariFilm(rs.getString("idFilm"));
                Customer c = cariCustomer(rs.getString("idCustomer"));
                book.add(new Booking(c, f, (ArrayList<String>) rs.getArray("seat")));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
    }
    
    public void loadAdmin(){
        connect();
        try{
            admin = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM admin");
            while (rs.next()){
                admin.add(new Admin(rs.getString("nama"), rs.getString("noHp"), rs.getString("pwd")));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
    }
    
    public Film cariFilm(String id){
        connect();
        Film f = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM film");
            while(rs.next()){
                if (id.equals(rs.getString("idFilm"))){
                    f = new Film(rs.getString("idFilm"),rs.getString("judulFilm"), rs.getString("theater"), rs.getString("waktu"));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
        return f;
    }
    
    public Customer cariCustomer(String id){
        connect();
        Customer c = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM customer");
            while(rs.next()){
                if (id.equals(rs.getString("idCustomer"))){
                    c = new Customer(rs.getString("nama"), rs.getString("noHp"), rs.getString("username"), rs.getString("pwd"));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
        return c;
    }    
    
    public boolean insertCustomer(Customer c){
        connect();
        boolean cek = false;
        int row;
        try {
            row = stmt.executeUpdate("INSERT INTO customer(nama, noHP, idCustomer, username, pwd)VALUES('"+c.getNama()+"', '"+c.getNoHP()+"', '"+c.getIdCustomer()+"', '"+c.getUsername()+"', '"+c.getPwd()+"')");
            if (row > 0){
                cek = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
        return cek;
    }
    
    public boolean insertFilm(Film f){
        connect();
        boolean cek = false;
        int row;
        try {
            row = stmt.executeUpdate("INSERT INTO film(idFilm, judulFilm, theater, waktu)VALUES('"+f.getIdFilm()+"', '"+f.getJudulFilm()+"', '"+f.getTheater()+"', '"+f.getWaktu()+"')");
            if (row > 0){
                cek = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
        return cek;
    }
    
    public boolean insertBooking(Booking b){
        connect();
        boolean cek = false;
        int row;
        try {
            row = stmt.executeUpdate("INSERT INTO booking(idBooking,judulFilm, jmlTiket, totalHarga, kursiDipilih)VALUES('"+b.getIdBooking()+"', '"+b.getJudulBK()+"', '"+b.getJmlTiket()+"', '"+b.getTotalHarga()+"', '"+b.getSeat()+"')");
            if (row > 0){
                cek = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
        return cek;
    }
    
    public boolean deleteFilm(String id){
        boolean cek = false;
        connect();
        int row;
        try {
            row = stmt.executeUpdate("DELETE FROM film WHERE idFilm = '"+ id +"'");
            if (row > 0 ){
                cek = true;
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Delete Film", JOptionPane.ERROR_MESSAGE);
        }
        return cek;
    }
    
    public ArrayList<Admin> getAdmin(){
        loadAdmin();
        return admin;
    }
    
    public ArrayList<Booking> getBooking(){
        loadBooking();
        return book;
    }
    
    public ArrayList<Film> getFilm(){
        loadFilm();
        return film;
    }
    
    public ArrayList<Customer> getCustomer(){
        loadCustomer();
        return cust;
    }
}
