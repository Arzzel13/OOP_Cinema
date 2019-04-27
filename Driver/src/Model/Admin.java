/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Farizan Cesario
 */
public class Admin extends People {
    private String idAdmin;
    private String pwd;
    
    public Admin(String nama, String noHP, String idAdmin, String pwd){
        super(nama,noHP);
        this.idAdmin = idAdmin;
        this.pwd = pwd;
    }
    
    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    public String getIdAdmin() {
        return idAdmin;
    }
    
    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    
    public String getPwd() {
        return pwd;
    }
    
    public void addFilm(){
        
    }
}
