/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooalonso;

/**
 *
 * @author guzma
 */
public class Animal {
    
    private String Nombre;
    private int Edad;
    private String Raza;
    private double Peso;
    
    
   //Contructor: Se debe hacer click derecho, insertar codigo y soleccionar constructor, lueso seleccionas los datos (elementos)

    public Animal(String Nombre, int Edad, String Raza, double Peso) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Raza = Raza;
        this.Peso = Peso;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public String getRaza() {
        return Raza;
    }

    public double getPeso() {
        return Peso;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }
    
   
    
    
    
}
