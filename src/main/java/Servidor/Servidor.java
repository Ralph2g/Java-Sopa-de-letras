package Servidor;
import Palabras.Palabras;
import java.net.*;
import java.io.*;
public class Servidor{
    //Recibimos todas las palabras y conceptos de Palabras.Lista
    public static void registrarPalabras(){
    
    
    }
    //Enviamos la lista de palabras a el cliente para que las procese
    public static void enviarPalabras(){
    
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
            //Creamos el socket
            ServerSocket s = new ServerSocket(7000);
            System.out.println("Servidor iniciado esperando conexión...");
            Palabras palabras = new Palabras();
            System.out.println(palabras);
            for(;;){ 
                //Esperamos una conexión
                Socket cl = s.accept();
                DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
                DataInputStream dis = new DataInputStream(cl.getInputStream());
                System.out.println("Conexión establecida: "+cl.getInetAddress()+":"+cl.getPort());
                boolean Conexion = true;
                
                do{
                    enviarPalabras();
                    recibirCoordenada();
                    System.out.println("Respuesta recibida...");
                    Conexion = dis.readBoolean();
                }while (Conexion);
                System.out.println("Cliente desconectado...");
                dis.close ();
                dos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//main
}//class