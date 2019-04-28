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
    private int jmlTiket;
    private int totalHarga=0;
    private Film f;
    private final int harga = 50000;
    private ArrayList<String> seat;
    private String tempSeat;
    
    public Booking(ArrayList<String> seat) {
        Random rand = new Random();
        int n = rand.nextInt(100);
        idBooking = "BK" + n;
        for(String s:seat){
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
    
    public String getSeat() {
        for(String s: seat){
            tempSeat += s + ",";
        }
        return tempSeat;
    }
    
//    public void calculateTotal(){
//        totalHarga = f.getHarga()*jmlTiket;
//    }
}
