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
    private ArrayList<Palabra> palabras;
    
    public Cliente(){
        try{
            this.cl = new Socket("localhost",7001);
            this.inputStream = new DataInputStream(this.cl.getInputStream());
            this.outputStream = new DataOutputStream(this.cl.getOutputStream());
            this.ois = new ObjectInputStream(this.cl.getInputStream());
            this.palabras = new ArrayList<Palabra>();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public String recibirMensaje() {
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
    public ArrayList<Palabra> recibirPalabras()throws IOException, ClassNotFoundException{
        this.outputStream.writeUTF(Options.GETLIST.toString());
        int cont = this.inputStream.readInt();
        Palabra auxpal;
        while(cont>0){
            this.palabras.add( (Palabra)this.ois.readObject()  );
            cont--;
        }
        return this.palabras;
    }
    
}
