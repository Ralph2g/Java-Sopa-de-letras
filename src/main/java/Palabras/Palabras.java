package Palabras;
import java.util.LinkedList;
import java.io.*;
import java.util.*;

public class Palabras {     
    
    public void inicializaRegistro ()throws IOException, ClassNotFoundException{
        LinkedList <Palabra> list = new LinkedList<>();
        list.add(new Palabra("","",0));
        list.add(new Palabra("","",0));
    }
}