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
    
        this.palabras = new ArrayList<>();
        this.palabras.add(new Palabra("Computadora","Máquina electrónica que, mediante determinados programas, permite almacenar y tratar información, y resolver problemas de diversa índole.",0));
        this.palabras.add(new Palabra("Pais","erritorio, con características geográficas y culturales propias, que puede constituir una entidad política dentro de un Estado",0));
        this.palabras.add(new Palabra("Laboratorio","ugar dotado de los medios necesarios para realizar investigaciones, experimentos y trabajos de carácter científico o técnico.",0));
        this.palabras.add(new Palabra("Libro","Conjunto de muchas hojas de papel u otro material semejante que, encuadernadas, forman un volumen.",0));
        this.palabras.add(new Palabra("Tienda","Casa, puesto o lugar donde se venden al público artículos de comercio al por menor.",0));
        this.palabras.add(new Palabra("Llave","nstrumento, comúnmente metálico, que, introducido en una cerradura, permite activar el mecanismo que la abre y la cierra.",0));
        this.palabras.add(new Palabra("Mochila","olsa de lona o de otro material resistente que, provista de correas para ser cargada a la espalda, sirve para llevar provisiones o equipos en excursiones, expediciones, viajes",0));
        this.palabras.add(new Palabra("Espejo","olsa de lona o de otro material resistente que, provista de correas para ser cargada a la espalda, sirve para llevar provisiones o equipos en excursiones, expediciones, viajes",0));
        this.palabras.add(new Palabra("Colina","Elevación natural de terreno, menor que una montaña.",0));
        this.palabras.add(new Palabra("Huracan","Viento muy impetuoso y temible que, a modo de torbellino, gira en grandes círculos, cuyo diámetro crece a medida que avanza apartándose de las zonas de calma tropicales, donde suele tener origen.",0));
        this.palabras.add(new Palabra("Sociedad","Conjunto de personas, pueblos o naciones que conviven bajo normas comunes.",0));
        this.palabras.add(new Palabra("Cultura","Conjunto de modos de vida y costumbres, conocimientos y grado de desarrollo artístico, científico, industrial, en una época, grupo social, etc.",0));
        this.palabras.add(new Palabra("Empresa","Unidad de organización dedicada a actividades industriales, mercantiles o de prestación de servicios con fines lucrativos.",0));
        this.palabras.add(new Palabra("Ciudad","Conjunto de edificios y calles, regidos por un ayuntamiento, cuya población densa y numerosa se dedica por lo común a actividades no agrícolas.",0));
        
    }
    public void startToListen()throws IOException{
        while(true){
            Socket cliente = this.serverSocket.accept();
            new Thread(new ClientWorker(cliente,this.palabras)).start();
        
        }
    }
    //Enviamos la lista de palabras a el cliente para que las procese
    public static void enviarPalabras(ArrayList <Palabra> words,OutputStream os){
        try{
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeInt(words.size());
        Iterator<Palabra> aux  = words.iterator();
        while (aux.hasNext()){
            oos.writeObject(aux.next());
        }
        oos.close();
        System.out.println("Lista de palabras enviada con exito");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    //Recibimos las cordenas iniciales y finales de cada palabra desde el cliente
    public static void recibirCoordenadas(){
    
    
    }
    //Recibimos la coordenada de la palabra que intenta encontrar en la sopa el usuario
    public static void recibirCoordenada(){
    
    
    }
    //Envia  la respuesta de el servidor para ver si el resultado es valido
    public static void enviarRespuesta(){
    
    
    }
    

    public static void main(String[] args) {
        try {
            new Servidor().startToListen();
            }catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//main
}//class