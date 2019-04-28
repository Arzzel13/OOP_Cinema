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
    
    public Admin(String nama, String noHP, String pwd){
        super(nama,noHP);
        idAdmin = "AD"+getLastThree(noHP);
        this.pwd = pwd;
    }
    
    public void setIdAdmin(String noHP) {
        if(noHP.length()>3){
            idAdmin = "AD"+getLastThree(noHP);
        }
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
