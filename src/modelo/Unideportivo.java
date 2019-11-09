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
public class Unideportivo extends Complejo {

    private int cod_complejo;
    private String deporte;
    private String info;

    public Unideportivo(String location, String boss, int cod_sede, int cod_complejo, String deporte, String info) {
        super(location, boss, cod_sede);
        this.cod_complejo = cod_complejo;
        this.deporte = deporte;
        this.info = info;
    }
    
    public Unideportivo(int id,String location, String boss, int cod_sede, int cod_complejo, String deporte, String info) {
        super(id,location, boss, cod_sede);
        this.cod_complejo = cod_complejo;
        this.deporte = deporte;
        this.info = info;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
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
        return "Unideportivo "+localizacion;
    }
}
