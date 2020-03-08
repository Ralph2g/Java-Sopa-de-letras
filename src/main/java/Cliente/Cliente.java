package Cliente;

import Palabras.Palabra;
import java.io.*;
import java.net.Socket;
import java.io.IOException;
import java.util.LinkedList;
public class Cliente{
    private Socket cl;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    
    public Cliente(){
        try{
            this.cl = new Socket("localhost",7000);
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
            fromServer = this.inputStream.readUTF();
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

    public LinkedList <Palabra> recibirPalabras(InputStream is) throws IOException{
        LinkedList <Palabra> palabras;
        palabras = new LinkedList <Palabra>();
        return palabras;
    }
    
}
