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
public class Sede {
    private int cod;
    private String nombre;
    private double presupuesto;

    public Sede(String nombre, double presupuesto){
        this.nombre=nombre;
        this.presupuesto=presupuesto;
    }
    
    public Sede(int cod,String nombre, double presupuesto){
        this.cod=cod;
        this.nombre=nombre;
        this.presupuesto=presupuesto;
    }
    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the presupuesto
     */
    public double getPresupuesto() {
        return presupuesto;
    }

    /**
     * @param presupuesto the presupuesto to set
     */
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
