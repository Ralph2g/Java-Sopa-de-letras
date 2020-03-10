package Palabras;

import java.io.Serializable;


public class Palabra implements Serializable{
    private String nombre;
    private String concepto;
    private String coordInicio;
    private String coordFin;
    private int puntos;

    public Palabra(String nombre, String concepto,int puntos) {
        this.nombre = nombre;
        this.concepto = concepto;
        this.puntos = puntos;
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
    
    public int getPuntos(){
    return this.puntos;
    }
    public void setCoordInicio(String coordInicio){
        this.coordInicio = coordInicio;
    }
    public void setCoordFin(String coordFin){
        this.coordInicio = coordFin;
    }
}
