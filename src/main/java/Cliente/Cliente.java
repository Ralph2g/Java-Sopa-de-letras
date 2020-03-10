package Cliente;

import Palabras.Palabra;
import java.io.*;
import java.net.Socket;
import java.io.IOException;
import java.util.ArrayList;
public class Cliente{
    private Socket cl;
    private String nombre;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private ObjectInputStream ois;
    private ArrayList<Palabra> palabras;
    private ObjectOutputStream oos;
    private ArrayList<String> score;
    
    public Cliente(){
        try{
            this.cl = new Socket("localhost",7001);
            this.inputStream = new DataInputStream(this.cl.getInputStream());
            this.outputStream = new DataOutputStream(this.cl.getOutputStream());
            this.ois = new ObjectInputStream(this.cl.getInputStream());
            this.oos = new ObjectOutputStream(this.cl.getOutputStream());
            this.palabras = new ArrayList<Palabra>();
            this.score = new ArrayList<String>();
            this.nombre = "";
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
    public void enviarCoordenadas(String [] listcoordenadasInicio,String [] listcoordenadasFinal)throws IOException{
        this.outputStream.writeUTF(Options.COORDINATES.toString());
        this.outputStream.writeInt(listcoordenadasInicio.length);
        //Enviamos las coordenadas iniciales
        for (int i = 0; i<listcoordenadasInicio.length;i++)
            this.outputStream.writeUTF(listcoordenadasInicio[i]);  
        for (int i = 0; i<listcoordenadasFinal.length;i++)
            this.outputStream.writeUTF(listcoordenadasFinal[i]);
    }
    
    public boolean enviarRespuesta(String ini,String fin) throws IOException{
        this.outputStream.writeUTF(ini);
        this.outputStream.writeUTF(fin);
        boolean respuesta = this.inputStream.readBoolean();
        return respuesta;
    }
    
}
