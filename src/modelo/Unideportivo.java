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

    private String deporte;
    private String info;

    public Unideportivo(int cod, String localizacion, String jefe, int cod_sede, String info) {
        super(cod, localizacion, jefe, cod_sede);
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
}
