package Palabras;
import java.util.LinkedList;
import java.io.*;
import java.util.*;

public class Palabras {     
    private LinkedList <Palabra> list;
    
    public void inicializaRegistro ()throws IOException, ClassNotFoundException{
        this.list = new LinkedList<>();
        this.list.add(new Palabra("hola","hola",0));
        this.list.add(new Palabra("gg","gg",0));
    };
    public LinkedList <Palabra> getLista(){
        return this.list;
    };
  }