package Palabras;

import java.io.Serializable;


public class Palabra implements Serializable{
    private String nombre;
    private String concepto;
    private int[] coordInicio;
    private int[] coordFin;
    private int puntos;

    public Palabra(String nombre, String concepto,int puntos) {
        this.nombre = nombre;
        this.concepto = concepto;
        this.puntos = puntos;
        this.coordInicio = new int[2];
        this.coordFin = new int[2];
    }
    
    // Se incializan lo getters and setters
    public String getNombre (){
        return this.nombre;
    } 
    public String getConcepto(){
        return this.concepto;
    }
    public int[] getCoordInicio(){
        return this.coordInicio;
    
    }
    public int[] getCoordFin(){
        return this.coordFin;
    }
    
    public int getPuntos(){
    return this.puntos;
    }
    public void setCoordInicio(int[] coordInicio){
        this.coordInicio = coordInicio;
    }
    public void setCoordFin(int[] coordFin){
        this.coordInicio = coordFin;
    }
}
