package Model;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Farizan Cesario
 */
public class Booking {
    private String idBooking;
    private int jmlTiket=0;
    private int totalHarga=0;
    private Film f;
    private Customer c;
    private ArrayList<String> seat;
    private String tempSeat;
    
    public Booking(Customer cust, Film fil, ArrayList<String> seat) {
        f = fil;
        c = cust;
        Random rand = new Random();
        int n = rand.nextInt(100);
        idBooking = "BK" + n;
        this.seat = seat;
        for(String s:seat){
            jmlTiket++;
            totalHarga += f.getHarga();
        }
        n +=1;
    }
    
//    public void setJmlTiket() {
//        for(int counter = 0; counter < seat.size();counter++){
//            jmlTiket = counter;
//        }
//    }    
//    public void setTotalHarga() {
//        this.totalHarga = totalHarga;
//    }
    
//    public void setIdBooking() {
//        idBooking = "Book-"+numBook;
//    }
    
 //   public void setSeat(ArrayList<String> seat){
 //       this.seat = seat;
 //   }
    public String getJudulBK() {
        return f.getJudulFilm();
    }
    
    public int getJmlTiket() {
        return jmlTiket;
    }
    
    public int getTotalHarga() {
        return totalHarga;
    }
    
    public String getIdBooking(){
        return idBooking;
    }
 
    public ArrayList<String> getSeat(){
        return seat;
    }
    
//    public String getSeat() {
//        for(String s: seat){
//            tempSeat += s + ",";
//        }
//        return tempSeat;
//    }
    
//    public void calculateTotal(){
//        totalHarga = f.getHarga()*jmlTiket;
//    }
}
