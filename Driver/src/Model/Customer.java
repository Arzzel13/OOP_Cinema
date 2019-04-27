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
public class Customer extends People {
    private String idCustomer;
    private String username;
    private String pwd;
    
    public Customer(String nama, String noHP,String pwd){
        super(nama,noHP);
        idCustomer = "C"+getLastThree(noHP);
    }
    
    public void setIdCustomer(String noHP) {
        if(noHP.length()>3){
            idCustomer = "C"+getLastThree(noHP);
        }
    }
    
    public String getIdCustomer(){
        return idCustomer;
    }

    public String getPwd() {
        return pwd;
    }
    
}
