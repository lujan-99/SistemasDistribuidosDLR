package com.mycompany.ejercicio1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author david
 */
public class Fibonaci {
    
    int num;

    public Fibonaci(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    
    public String sumatoria(){
        if (num < 0) return "El número debe ser mayor o igual a 0";
        if (num == 0) return "0";
        long sumatoria = 0;
        for (int i = 1 ; i <= num ; i++){
            sumatoria +=i;
        }return String.valueOf(sumatoria);
        
    }
    
    
    public String seriafibo() {
        if (num < 0) return "El número debe ser mayor o igual a 0";
        if (num == 0) return "0";

        String serie = "0";
        if (num >= 1) {
            serie += ", 1";
        }

        long a = 0, b = 1;
        for (int i = 2; i <= num; i++) {
            long temp = a + b;
            serie += ", " + temp; // Vamos agregando cada número a la cadena
            a = b;
            b = temp;
        }
        return serie;
    }
    
    public String  factorial(){
        if (num < 0) return "El número debe ser mayor o igual a 0";
        if (num == 0) return "0";
        long factorial = 1;
        for (int i = 1 ; i <= num ; i++){
            factorial = factorial * i;
        }return String.valueOf(factorial);
    }
}

