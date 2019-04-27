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
    private int jmlTiket;
    private int totalHarga;
    private String idBooking;
    private static int numBook;
    private Film f;
    private ArrayList<String> seat;
    
    public Booking(int jmlTiket, int totalHarga, ArrayList<String> seat) {
        this.jmlTiket = jmlTiket;
        this.totalHarga = totalHarga;
        this.seat = seat;
        f.getJudulFilm();
        f.getTheater();
        f.getHarga();
        setIdBooking();
    }
    
    public void setJmlTiket(int jmlTiket) {
        this.jmlTiket = jmlTiket;
    }
    
    public void setTotalHarga() {
        this.totalHarga = totalHarga;
    }
    
    public void setIdBooking() {
        idBooking = "Book-"+numBook;
        numBook++;
    }
    
    public void setSeat(ArrayList<String> seat){
        this.seat = seat;
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
    
    public ArrayList<String> getSeat() {
        return seat;
    }
    
    public void calculateTotal(){
        totalHarga = f.getHarga()*jmlTiket;
    }

}
