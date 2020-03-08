
package Servidor;

import Palabras.Palabra;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ClientWorker implements Runnable{
    private Socket cl;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private ArrayList<Palabra> listpalabras;
    private ObjectOutputStream oos;
    
    public ClientWorker(Socket socket,ArrayList<Palabra> list)throws IOException{
        this.cl = socket;
        this.inputStream = new DataInputStream(this.cl.getInputStream());
        this.outputStream = new DataOutputStream(this.cl.getOutputStream());
        this.oos= new ObjectOutputStream(this.cl.getOutputStream());
        this.listpalabras = list;

        System.out.println("Cliente Conectado");
    }
    public void run(){
        boolean isConnected =true;
        while(isConnected){
            try{
                isConnected = this.chooseOptions(isConnected);
            }catch(IOException e){
            e.printStackTrace();
            }
        }
    
    }
    //Opciones que tiene nuestro servidor para hacer envios 
    private boolean chooseOptions(boolean isConnected)throws IOException{
        OptionsServer aux = OptionsServer.valueOf(this.inputStream.readUTF());
        switch(aux){
        case MESSAGE:
            System.out.println("Solicitud de mensaje recibida de parte del cliente");
            this.message();
            break;
        case GETLIST:
            System.out.println("Solicitud de palabras recibida de parte del cliente");
            this.sendPalabras();
            break;
        case CLOSE:
            System.out.println("Solicitud de Cierres de conexión recibida de parte del cliente");
            isConnected = false;
            break;
        default:
            break;    
        }
        return isConnected;
    }
    //Envío de las palabras a el cliente
    private void sendPalabras()throws IOException{
        this.outputStream.writeInt(this.listpalabras.size());//enviamos al cliente el tamaño de la lista
        Iterator<Palabra> aux = this.listpalabras.iterator();
        while(aux.hasNext()){
            this.oos.writeObject(aux.next());//Enviamos el objeto uno auno
        }
    }
    //Mensaje de Bienvenida a el servidor
    public void message() throws IOException{
        try{
        this.outputStream.writeUTF("Se ha conectado al servidor");
        System.out.println("Respuesta envida");
        }catch( IOException e){
        e.printStackTrace();
        }
    }
    
    protected void finalize() throws Throwable{
    
    
    }
}