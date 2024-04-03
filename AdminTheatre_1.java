package com.mycompany.admintheatre_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Guillermo
 */
public class AdminTheatre_1 {

    public static void main(String[] args) {
        Boolean[][] seats = {
                    {true, false, true, true, true, true, true, true},
                    {true, true, false, true, true, true, true, true},
                    {true, false, true, false, false, true, true, true},
                    {false, false, false, false, false, false, false, false},
                    {true, false, true, true, false, true, true, true}
                };
        
        
        Theatre theatre = new Theatre(seats);
        ArrayList<Thread> threads = new ArrayList<>();
        Lock lock = new ReentrantLock();
        
        
        Thread t1 = new Thread(new BuyTicket("Ringo Star", 1,1, theatre, lock));
        threads.add(t1);
        Thread t2 = new Thread(new BuyTicket("John Lennon", 3,6, theatre, lock));
        threads.add(t2);
        Thread t3 = new Thread(new BuyTicket("George Harrison", 4,3, theatre, lock));
        threads.add(t3);
        Thread t4 = new Thread(new BuyTicket("Paul McCartney", 1,1, theatre, lock));
        threads.add(t4);
        Thread t5 = new Thread(new BuyTicket("Billy Preson", 5,6, theatre, lock));
        threads.add(t5);
        
        for (Thread thread : threads){
            thread.start();
        }

        for (Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException ex) {
                System.out.println("Error de interrupción");
            }
        }
        
        System.out.println("Fin de ejecución del programa");
                
    }
}
