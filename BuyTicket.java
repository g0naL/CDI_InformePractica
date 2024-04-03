package com.mycompany.admintheatre_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Guillermo
 */
public class  BuyTicket implements Runnable{
    
    private int row;
    private int column;
    private Theatre theatre;
    private String username;
    private Lock lock;
    
    public BuyTicket(String username, int row, int column, Theatre theatre, Lock lock){
        this.username = username;
        this.row = row;
        this.column = column;
        this.theatre = theatre;
        this.lock = new ReentrantLock();
    }
       
    @Override
    public synchronized void run(){
        System.out.println("Reservando asiento para "+username);
        lock.lock();
        try{
            boolean seat = theatre.checkSeat(row, column, lock);
            if (seat){
                System.out.println("El asiento para "+ username + " ha sido reservado correctamente");
            }else{
                System.out.println("Lo lamentamos "+ username + " ese asiento no está disponible");
            }
        }finally{
            lock.unlock();
        }
    }
}
