package Palabras;

import java.io.Serializable;


public class Palabra implements Serializable{
    private String nombre;
    private String concepto;
    private String coordInicio;
    private String coordFin;

    public Palabra(String nombre, String concepto) {
        this.nombre = nombre;
        this.concepto = concepto;
        this.coordInicio = "";
        this.coordFin = "";
    }
    
    // Se incializan lo getters and setters
    public String getNombre (){
        return this.nombre;
    } 
    public String getConcepto(){
        return this.concepto;
    }
    public String getCoordInicio(){
        return this.coordInicio;
    
    }
    public String getCoordFin(){
        return this.coordFin;
    }
    
    public void setCoordInicio(String coordInicio){
        this.coordInicio = coordInicio;
    }
    public void setCoordFin(String coordFin){
        this.coordFin = coordFin;
    }
}
