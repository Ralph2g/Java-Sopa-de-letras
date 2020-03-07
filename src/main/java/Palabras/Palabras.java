package Palabras;
import java.util.LinkedList;
import java.io.*;
import java.util.*;

public class Palabras {     
    
    public void inicializaRegistro ()throws IOException, ClassNotFoundException{
        LinkedList <Palabra> List = new LinkedList<>();
        List.add(new Palabra("","",0));
        List.add(new Palabra());
        ListaProductos listProduct = new ListaProductos (products);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
        o.writeObject(listProduct);
        o.close();
    }
    
    public String getRuta (){
        File carpeta = new File(".");
        String ruta = carpeta.getAbsolutePath();
        String pathProject = ruta.substring(0,ruta.length()-1).replace("\\", "/");
        return pathProject+nombreArchivo;
    }

    public boolean exists (){
        File carpeta = new File(".");
        String ruta = carpeta.getAbsolutePath();
        String pathProject = ruta.substring(0,ruta.length()-1).replace("\\", "/");
        File fileRegistro = new File (pathProject+nombreArchivo);
        return fileRegistro.exists();
    }    
    
    public ListaProductos leeFichero (String rutaFichero) throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream (new FileInputStream(getRuta ()));
         return (ListaProductos)ois.readObject();
    }
    
    public void modificaFichero (ListaProductos listProduct)throws IOException, ClassNotFoundException{
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
        o.writeObject(listProduct);
        o.close();
    }
}