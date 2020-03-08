package Servidor;
import Palabras.Palabras;
import Palabras.Palabra;
import java.net.*;
import java.io.*;
import java.util.LinkedList;
import java.util.*;
public class Servidor{
    private ServerSocket serverSocket;
    private Palabras registro;
    private DataInputStream inputStream;
    private LinkedList <Palabra> palabras;
    
    
    public Servidor()throws IOException{
    try{
        this.serverSocket = new ServerSocket(7000);
    }catch(Exception e){
        e.printStackTrace();
        }
    };
    public void startToListen()throws IOException{
        while(true){
            Socket cliente = this.serverSocket.accept();
            new Thread(new ClientWorker(cliente)).start();
        
        }
            

    
    }
    //Enviamos la lista de palabras a el cliente para que las procese
    public static void enviarPalabras(LinkedList <Palabra> words,OutputStream os){
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