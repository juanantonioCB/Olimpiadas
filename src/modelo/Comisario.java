/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Juan Antonio
 */
public class Comisario {
    private int cod;
    private String dni;
    private String nombre;

    
    public Comisario(int cod, String dni, String nombre){
        this.cod=cod;
        this.dni=dni;
        this.nombre=nombre;
    }
    
    public Comisario(String dni, String nombre){
        this.dni=dni;
        this.nombre=nombre;
    }
    
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
