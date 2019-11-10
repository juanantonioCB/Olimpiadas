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
public class Polideportivo extends Complejo {

    private int cod_complejo;
    private String info;

    public Polideportivo(int cod, String localizacion, String jefe, int cod_sede, int cod_complejo, String info) {
        super(cod, localizacion, jefe, cod_sede);
        this.cod_complejo = cod_complejo;
        this.info = info;
    }
    


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCod_complejo() {
        return cod_complejo;
    }

    public void setCod_complejo(int cod_complejo) {
        this.cod_complejo = cod_complejo;
    }
    
    @Override
    public String toString(){
        return "Polideportivo "+localizacion;
    }
}
