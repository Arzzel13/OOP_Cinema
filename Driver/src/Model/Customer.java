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
    private static int num = 1;
    
    public Customer(String nama, String noHP){
        super(nama,noHP);
        setIdCustomer();
        
    }
    
    public void setIdCustomer() {
        idCustomer = "Cust-"+getLastThree(getNoHP())+num;
        num++;
    }
    
    public String getIdCustomer(){
        return idCustomer;
    }
}
