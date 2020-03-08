package Cliente;

import Palabras.Palabra;
import java.io.*;
import java.net.Socket;
import java.io.IOException;
import java.util.ArrayList;
public class Cliente{
    private Socket cl;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private ObjectInputStream ois;
    
    public Cliente(){
        try{
            this.cl = new Socket("localhost",7001);
            this.inputStream = new DataInputStream(this.cl.getInputStream());
            this.outputStream = new DataOutputStream(this.cl.getOutputStream());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public String recibirMensaje(){
        String fromServer ="";
        try{
            this.outputStream.writeUTF(Options.MESSAGE.toString());
                        System.out.println("Esperando respuesta...");
            fromServer = this.inputStream.readUTF();
                        System.out.println("Rescpuesta recibida");
        }catch(IOException e){
           e.printStackTrace();
        }
        return fromServer;
    }
    public void cerrarConexion(){
        try{
            this.outputStream.writeUTF(Options.CLOSE.toString());
        }catch(IOException e){
           e.printStackTrace();
        }
    }
    private StringBuilder recibirPalabras()throws IOException, ClassNotFoundException{
        this.outputStream.writeUTF(Options.GETLIST.toString());
        StringBuilder result = new StringBuilder();
        int cont = this.inputStream.readInt();
        while(cont>0){
            Palabra auxPer = (Palabra)this.ois.readObject();
            result.append("Palabra: "+auxPer.getNombre()+ " Concepto: " + auxPer.getConcepto());
            cont--;
        }
        return result;
    }
    
    public StringBuilder palabras(){
    StringBuilder s = new StringBuilder();
    try{
        s = this.recibirPalabras();
    }catch(ClassNotFoundException |IOException e){
        e.printStackTrace();
    }
    return s;
    
    }
}
