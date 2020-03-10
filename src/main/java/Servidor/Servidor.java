package Servidor;
import Palabras.Palabra;
import java.net.*;
import java.io.*;
import java.util.LinkedList;
import java.util.*;
public class Servidor{
    private ServerSocket serverSocket;
    private DataInputStream inputStream;
    private ArrayList <Palabra> palabras;
    
    public Servidor()throws IOException{
    try{
        this.serverSocket = new ServerSocket(7001);
    }catch(Exception e){
        e.printStackTrace();
        }
    this.initList();
    System.out.println("Servidor iniciado, esperando clientes");
    }
    public void initList(){
    
        this.palabras = new ArrayList<>();//95 LETRAS
        this.palabras.add(new Palabra("COMPUTADOR","Máquina electrónica que, mediante determinados programas, permite almacenar y tratar información, y resolver problemas de diversa índole."));
        this.palabras.add(new Palabra("PAIS","Territorio, con características geográficas y culturales propias, que puede constituir una entidad política dentro de un Estado"));
        this.palabras.add(new Palabra("LABORATORIO","ugar dotado de los medios necesarios para realizar investigaciones, experimentos y trabajos de carácter científico o técnico."));
        this.palabras.add(new Palabra("LIBRO","Conjunto de muchas hojas de papel u otro material semejante que, encuadernadas, forman un volumen."));
        this.palabras.add(new Palabra("TIENDA","Casa, puesto o lugar donde se venden al público artículos de comercio al por menor."));
        this.palabras.add(new Palabra("LLAVE","nstrumento, comúnmente metálico, que, introducido en una cerradura, permite activar el mecanismo que la abre y la cierra."));
        this.palabras.add(new Palabra("MOCHILA","olsa de lona o de otro material resistente que, provista de correas para ser cargada a la espalda, sirve para llevar provisiones o equipos en excursiones, expediciones, viajes"));
        this.palabras.add(new Palabra("ESPEJO","olsa de lona o de otro material resistente que, provista de correas para ser cargada a la espalda, sirve para llevar provisiones o equipos en excursiones, expediciones, viajes"));
        this.palabras.add(new Palabra("COLINA","Elevación natural de terreno, menor que una montaña."));
        this.palabras.add(new Palabra("HURACAN","Viento muy impetuoso y temible que, a modo de torbellino, gira en grandes círculos, cuyo diámetro crece a medida que avanza apartándose de las zonas de calma tropicales, donde suele tener origen."));
        this.palabras.add(new Palabra("SOCIEDAD","Conjunto de personas, pueblos o naciones que conviven bajo normas comunes."));
        this.palabras.add(new Palabra("CULTURA","Conjunto de modos de vida y costumbres, conocimientos y grado de desarrollo artístico, científico, industrial, en una época, grupo social, etc."));
        this.palabras.add(new Palabra("EMPRESA","Unidad de organización dedicada a actividades industriales, mercantiles o de prestación de servicios con fines lucrativos."));
        this.palabras.add(new Palabra("CIUDAD","Conjunto de edificios y calles, regidos por un ayuntamiento, cuya población densa y numerosa se dedica por lo común a actividades no agrícolas."));
        
    }
    public void startToListen()throws IOException{
        while(true){           
            Socket cliente = this.serverSocket.accept();
            new Thread(new ClientWorker(cliente,this.palabras)).start();
        
        }
    }
    public static void main(String[] args) {
        try {
            new Servidor().startToListen();
            }catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//main
}//class