/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.*;
import java.awt.event.ActionEvent;
import view.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Zara
 */
public class Handler extends MouseAdapter implements ActionListener {
    private Home home;
    private LoginAs logAs;
    private LoginAdmin logAd;
    private LoginCust logCust;
    private Manage manage;
    private RegisCust regcust;
    private Resi resi;
    
    private Controller con = new Controller();
        private Admin admin_log;
        private Customer cust_log;
        public Handler() {
            home = new Home();
            logAs = new LoginAs();
            logAd = new LoginAdmin();
            logCust = new LoginCust();
            manage = new Manage();
            regcust = new  RegisCust();
            resi = new Resi();
            
            home.setVisible(false);
            logAs.setVisible(true);
            logAd.setVisible(false);
            logCust.setVisible(false);
            manage.setVisible(false);
            regcust.setVisible(false);
            resi.setVisible(false);
            
            home.addActionListener(this);
            logAs.addActionListener(this);
            logAd.addActionListener(this);
            logCust.addActionListener(this);
            manage.addActionListener(this);
            regcust.addActionListener(this);
            resi.addActionListener(this);
        }    
        public void actionPerformed(ActionEvent ae) {
            Object source =ae.getSource();
//            if(source.equals(home.getBtnApply())){
            
//            }
//            else if(source.equals(home.getListFilm())){
            
//            }
            if(source.equals(home.getBtnBook())){
                InDataBook();
            }
            else if(source.equals(home.getBtnLogOutCust())){
                home.setVisible(false);
                logAs.setVisible(true);
                cust_log = null;
            }
            
            if(source.equals(logAs.getBtnAdmin())) {
                logAs.setVisible(false);
                logAd.setVisible(true);
            }
            else if (source.equals(logAs.getBtnCustomer())){
                logAs.setVisible(false);
                logCust.setVisible(true);
            }
            
            if(source.equals(logAd.getBtnBackAdm())){
                logAd.setVisible(false);
                logAs.setVisible(true);
            }
            else if (source.equals(logAd.getBtnLoginAdm())){
                LoginAdm(logAd.getIdAdm().getText(),logAd.getPassAdm().getText());
                logAd.getIdAdm().setText("");
                logAd.getPassAdm().setText("");
            }
            
            if(source.equals(logCust.getBtnBack())){
                logCust.setVisible(false);
                logAs.setVisible(true);
            }
            else if(source.equals(logCust.getBtnLogin())){
                LoginCust(logCust.getUsernameCust().getText(), logCust.getPassCust().getText());
                logCust.getUsernameCust().setText("");
                logCust.getPassCust().setText("");
            }
            else if(source.equals(logCust.getBtnRegister())){
                logCust.setVisible(false);
                regcust.setVisible(true);
            }
            
            if(source.equals(manage.getBtnAdd())){
                AddFilm(manage.getTfIdFilm().getText());
            }
            else if(source.equals(manage.getBtnDelete())){
                if(con.hapusFilm(manage.getTfDelete().getText())){
                    JOptionPane.showMessageDialog(manage, "Data berhasil di hapus dengan id " + manage.getTfDelete().getText(), "Hapus Data", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(manage, "Gagal hapus data","Hapus Data", JOptionPane.ERROR_MESSAGE);
                }
                manage.setTabel(con.loadTableModel());
                manage.getTfDelete().setText("");
                manage.setTabel(con.loadTableModel());
            }
            
            else if(source.equals(manage.getBtnLogoutAdm())){
                manage.setVisible(false);
                logAs.setVisible(true);
                admin_log = null;
            }
            
            if(source.equals(regcust.getBtnConfirm())){
                InDataReg();
                regcust.getTfNama().setText("");
                regcust.getTfnoHP().setText("");
                regcust.getTfUsername().setText("");
                regcust.getTfPassword().setText("");
                JOptionPane.showMessageDialog(null, "Registrasi berhasil");
            }
            else if(source.equals(regcust.getBtnBackRegis())){
                regcust.setVisible(false);
                logCust.setVisible(true);
            }
            else if(source.equals(resi.getBtnPrint())){
                JOptionPane.showMessageDialog(null, "Terimakasih, mohon segera melakukan pembayaran ke kasir");
                resi.setVisible(false);
                logAs.setVisible(true);
            }
        }
        
        public void mousePressed(MouseEvent ae) {
//           Object source = ae.getSource();
//            if(source.equals(home.getLstFilm())){
//                int i = home.getSelectedFilm();
//                Film f = 
//            }
        }
        
        public void LoginAdm(String id, String pwd){
            if(con.cekAdmin(id, pwd)){
                admin_log = con.getAdminLog();
                manage.setVisible(true);
                logAd.setVisible(false);
                manage.setTabel(con.loadTableModel());
            }
            else{
                JOptionPane.showMessageDialog(null, "idAdmin atau password salah");
            }
        }
        
        public void LoginCust(String un, String pwd){
            if(con.cekCustomer(un, pwd)){
                cust_log = con.getCustomerLog();
                home.setVisible(true);
                logCust.setVisible(false);
                home.setTabel(con.loadTableModel());
            }
            else{
                JOptionPane.showMessageDialog(null, "username atau password salah");
            }
        }
        
        public void AddFilm(String id){
            if(con.cekFilm(id)){
                JOptionPane.showMessageDialog(null, "Film sudah ada di database");
            }
            else{
                InDataFilm();
                manage.getTfIdFilm().setText("");
                manage.getTfJudul().setText("");
                manage.getTfTheater().setText("");
                manage.getTfWaktuTayang().setText("");
                manage.setTabel(con.loadTableModel());
                JOptionPane.showMessageDialog(null, "Add film berhasil");
            }
        }
        
        public void InDataReg(){
            Customer c = new Customer(regcust.getTfNama().getText(),regcust.getTfnoHP().getText(), regcust.getTfUsername().getText(), regcust.getTfPassword().getText());
            con.insertReg(c);
        }
        
        public void InDataFilm(){
            Film f = new Film(manage.getTfIdFilm().getText(),manage.getTfJudul().getText(), manage.getTfTheater().getText(), manage.getTfWaktuTayang().getText());
            con.insertFilm(f);
        }
        
        public void InDataBook(){
            Film f = new Film(home.getTfBookIdFilm().getText(), home.getTfBookJudul().getText(),home.getTfBookTheater().getText(), home.getTfBookWaktu().getText());
            Customer c = con.getCustomerLog();
            Booking b = new Booking(c, f, getSeat());
            con.insertBook(b);
            resi.getTfIdBook().setText(b.getIdBooking());
            resi.getTfIdCustomer().setText(c.getIdCustomer());
            resi.getTfJudulFilm().setText(f.getJudulFilm());
            resi.getTfJmlTiket().setText(Integer.toString(b.getJmlTiket()));
            resi.getTfHargaTotal().setText(Integer.toString(b.getTotalHarga()));
            resi.getTfTmptDuduk().setText(getSeat().toString());
            home.getCbSeatA1().setSelected(false);
            home.getCbSeatA2().setSelected(false);
            home.getCbSeatA3().setSelected(false);
            home.getCbSeatA4().setSelected(false);
            home.getCbSeatA5().setSelected(false);
            home.getCbSeatA6().setSelected(false);
            home.getCbSeatA7().setSelected(false);
            home.getCbSeatA8().setSelected(false);
            home.getCbSeatA9().setSelected(false);
            home.getCbSeatB1().setSelected(false);            
            home.getCbSeatB2().setSelected(false);
            home.getCbSeatB3().setSelected(false);
            home.getCbSeatB4().setSelected(false);
            home.getCbSeatB5().setSelected(false);
            home.getCbSeatB6().setSelected(false);
            home.getCbSeatB7().setSelected(false);
            home.getCbSeatB8().setSelected(false);
            home.getCbSeatB9().setSelected(false);
            home.getCbSeatC1().setSelected(false);
            home.getCbSeatC2().setSelected(false);
            home.getCbSeatC3().setSelected(false);
            home.getCbSeatC4().setSelected(false);
            home.getCbSeatC5().setSelected(false);
            home.getCbSeatC6().setSelected(false);
            home.getCbSeatC7().setSelected(false);
            home.getCbSeatC8().setSelected(false);
            home.getCbSeatC9().setSelected(false);
            home.setVisible(false);
            resi.setVisible(true);
        }
        
        public ArrayList<String> getSeat(){
            ArrayList<String> s = new ArrayList();
            if (home.getCbSeatA1().isSelected()){
                s.add(home.getCbSeatA1().getText());
                
            }
            if (home.getCbSeatA2().isSelected()){
                s.add(home.getCbSeatA2().getText());
                
            }
            if (home.getCbSeatA3().isSelected()){
                s.add(home.getCbSeatA3().getText());
                
            }
            if (home.getCbSeatA4().isSelected()){
                s.add(home.getCbSeatA4().getText());
                
            }
            if (home.getCbSeatA5().isSelected()){
                s.add(home.getCbSeatA5().getText());
                
            }
            if (home.getCbSeatA6().isSelected()){
                s.add(home.getCbSeatA6().getText());
                
            }
            if (home.getCbSeatA7().isSelected()){
                s.add(home.getCbSeatA7().getText());
                
            }
            if (home.getCbSeatA8().isSelected()){
                s.add(home.getCbSeatA8().getText());
                
            }
            if (home.getCbSeatA9().isSelected()){
                s.add(home.getCbSeatA9().getText());
                
            }
            if (home.getCbSeatB1().isSelected()){
                s.add(home.getCbSeatB1().getText());
            }
            if (home.getCbSeatB2().isSelected()){
                s.add(home.getCbSeatB2().getText());
                
            }
            if (home.getCbSeatB3().isSelected()){
                s.add(home.getCbSeatB3().getText());
                
            }
            if (home.getCbSeatB4().isSelected()){
                s.add(home.getCbSeatB4().getText());
                
            }
            if (home.getCbSeatB5().isSelected()){
                s.add(home.getCbSeatB5().getText());
                
            }
            if (home.getCbSeatB6().isSelected()){
                s.add(home.getCbSeatB6().getText());
                
            }
            if (home.getCbSeatB7().isSelected()){
                s.add(home.getCbSeatB7().getText());
                
            }
            if (home.getCbSeatB8().isSelected()){
                s.add(home.getCbSeatB8().getText());
                
            }
            if (home.getCbSeatB9().isSelected()){
                s.add(home.getCbSeatB9().getText());
                
            }
            if (home.getCbSeatC1().isSelected()){
                s.add(home.getCbSeatC1().getText());
                
            }
            if (home.getCbSeatC2().isSelected()){
                s.add(home.getCbSeatC2().getText());
                
            }
            if (home.getCbSeatC3().isSelected()){
                s.add(home.getCbSeatC3().getText());
                
            }
            if (home.getCbSeatC4().isSelected()){
                s.add(home.getCbSeatC4().getText());
                
            }
            if (home.getCbSeatC5().isSelected()){
                s.add(home.getCbSeatC5().getText());
                
            }
            if (home.getCbSeatC6().isSelected()){
                s.add(home.getCbSeatC6().getText());
                
            }
            if (home.getCbSeatC7().isSelected()){
                s.add(home.getCbSeatC7().getText());
                
            }
            if (home.getCbSeatC8().isSelected()){
                s.add(home.getCbSeatC8().getText());
                
            }
            if (home.getCbSeatC9().isSelected()){
                s.add(home.getCbSeatC9().getText());
                
            }
            return s;
        }
        
        
}
