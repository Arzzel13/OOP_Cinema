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
public class People {
    private String nama;
    private String noHP;

    public People (String nama, String noHP) {
        this.nama = nama;
        this.noHP = noHP;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getNoHP() {
        return noHP;
    }
    
    public String getLastThree(String noHP) {
    if(noHP.length() > 3)
        return noHP.substring(noHP.length()-3);
    else
        return noHP;
    }
      
}
