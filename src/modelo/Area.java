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
public class Area {
    private int id;
    private int cod_polideportivo;
    private String localizacion;
    private String deporte;

    public Area(int id,int cod_polideportivo, String localizacion, String deporte){
        
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public int getCod_polideportivo() {
        return cod_polideportivo;
    }

    public void setCod_polideportivo(int cod_polideportivo) {
        this.cod_polideportivo = cod_polideportivo;
    }
}
