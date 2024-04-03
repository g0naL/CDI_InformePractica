package com.mycompany.admintheatre_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.concurrent.locks.Lock;

/**
 *
 * @author Guillermo
 */
public class Theatre {
    
    private Boolean[][] seats;
    
    public Theatre(Boolean[][] seats){
        this.seats = seats;
    }
    
    public boolean checkSeat(int row, int column, Lock lock){
        boolean toRet = false;
        lock.lock();
        if (seats.length > row && seats[0].length > column){
            if (seats[row-1][column-1] == true){
                toRet = true;
                seats[row-1][column-1] = false;
            }
        }else{
            System.out.println("El asiento introducido no es válido");
        }
        
        return toRet;
    
    }
    
}
