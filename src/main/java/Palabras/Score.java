/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Palabras;

import java.io.Serializable;

/**
 *
 * @author Ralph
 */
public class Score implements Serializable{
    private int minutos;
    private int segundos;
    public Score (){
        this.minutos = 0;
        this.segundos = 0;        
    }
    
    public int getMinutos(){
        return this.minutos;
    }
    public int getSegundos(){
        return this.segundos;
    }
    public void setMinutos(int minutos){
        this.minutos = minutos;
    }
    public void setSegundos(int segundos){
        this.segundos = segundos;
    }
    
}
