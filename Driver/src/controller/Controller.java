/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Model.*;
import java.util.*;
/**
 *
 * @author Zara
 */
public class Controller {
    private Database db = new Database();
    private Admin admin_log;
    private Customer cust_log;
    
    public boolean cekAdmin(String id, String pwd){
        ArrayList<Admin> admin = new ArrayList();
        admin = db.getAdmin();
        for (Admin a : admin){
            if ((a.getIdAdmin().equals(id))&&(a.getPwd().equals(pwd))){
                admin_log = new Admin(a.getNama(), a.getNoHP(), a.getPwd());
                return true;
            }
        }
        return false;
    }
    
    public boolean cekCustomer(String user, String pwd){
        ArrayList<Customer> cust = new ArrayList();
        cust = db.getCustomer();
        for (Customer c : cust){
            if ((c.getIdCustomer().equals(user))&&(c.getPwd().equals(pwd))){
                cust_log = new Customer(c.getNama(), c.getNoHP(), c.getPwd());
                return true;
            }
        }
        return false;
    }
    
    public Admin getAdminLog(){
        return admin_log;
    }
    
    public Customer getCustomerLog() {
        return cust_log;
    }
    
    
    
}
