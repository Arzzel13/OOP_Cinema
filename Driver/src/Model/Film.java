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
public class Film {
    private int idFilm;
    private String judulFilm;
    private String theater;
    private final int harga = 50000;
    private ArrayList<String> waktu = new ArrayList<String>();
    
    public Film(String judulFilm, String theater, ArrayList<String> waktu){
        this.judulFilm = judulFilm;
        this.theater = theater;
        this.waktu = waktu;
    }
    
    public void setJudulFilm(String judulFilm){
        this.judulFilm = judulFilm;
    }
    
    public void setTheater(String theater){
        this.theater = theater;
    }
    
    public void setWaktu(ArrayList<String> waktu){
        this.waktu = waktu;
    }
    
    public String getJudulFilm(){
        return judulFilm;
    }
    
    public String getTheater() {
        return theater;
    }
    
    public int getHarga(){
        return harga;
    }
    
    public ArrayList<String> getWaktu() {
        return waktu;
    }
}
