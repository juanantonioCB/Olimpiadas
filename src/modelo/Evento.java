/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Juan Antonio
 */
public class Evento {

    private int cod;
    private String nombre;
    private int cod_complejo;
    private Date fecha;
    private int cod_area;
    
    public Evento(int cod, String nombre, int cod_complejo, Date fecha, int cod_area){
        this.cod=cod;
        this.nombre=nombre;
        this.cod_complejo=cod_complejo;
        this.fecha=fecha;
        this.cod_area=cod_area;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getDate() {
        return getFecha();
    }

    public void setDate(Date date) {
        this.setFecha(date);
    }

    public int getCod_complejo() {
        return cod_complejo;
    }

    public void setCod_complejo(int cod_complejo) {
        this.cod_complejo = cod_complejo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCod_area() {
        return cod_area;
    }

    public void setCod_area(int cod_area) {
        this.cod_area = cod_area;
    }
}
