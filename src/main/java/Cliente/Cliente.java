package Cliente;
import Palabras.Score;
import java.util.Calendar;
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
            this.outputStream.flush();
            fromServer = this.inputStream.readUTF();
        }catch(IOException e){
           e.printStackTrace();
        }
        return fromServer;
    }
    public void enviarNombre(String nombre) throws IOException{
        this.outputStream.writeUTF(Options.NAME.toString());
        this.outputStream.flush();
        this.outputStream.writeUTF(nombre);
        this.outputStream.flush();
        
    }
    public void cerrarConexion(){
        try{
            this.outputStream.writeUTF(Options.CLOSE.toString());
            this.outputStream.flush();
        }catch(IOException e){
           e.printStackTrace();
        }
    }
    public ArrayList<Palabra> recibirPalabras()throws IOException, ClassNotFoundException{
        this.outputStream.writeUTF(Options.GETLIST.toString());
        this.outputStream.flush();
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
        this.outputStream.flush();
        this.outputStream.writeInt(listcoordenadasInicio.length);
        this.outputStream.flush();
        //Enviamos las coordenadas iniciales
        for (int i = 0; i<listcoordenadasInicio.length;i++){
            this.outputStream.writeUTF(listcoordenadasInicio[i]);
            this.outputStream.flush();
        }
        for (int i = 0; i<listcoordenadasFinal.length;i++){
            this.outputStream.writeUTF(listcoordenadasFinal[i]);
            this.outputStream.flush();
        }
    }
    //Regresa el indice de la palabra que está correcta
    public int enviarRespuesta(String ini,String fin) throws IOException{
        this.outputStream.writeUTF(Options.ANSWER.toString());
        this.outputStream.flush();
        this.outputStream.writeUTF(ini);
        this.outputStream.flush();
        this.outputStream.writeUTF(fin);
        this.outputStream.flush();
        int respuesta = this.inputStream.readInt();
        return respuesta;
    }
    
    public void enviarTiempo(Calendar inicio, Calendar fin) throws IOException{
        int hora = fin.get(Calendar.HOUR_OF_DAY) - inicio.get(Calendar.HOUR_OF_DAY);
        int minutos = ( ((hora*60)-inicio.get(Calendar.MINUTE))+(fin.get(Calendar.MINUTE)));
        int segundos = ( ((minutos*60)-inicio.get(Calendar.SECOND))+ fin.get(Calendar.SECOND));
        
        Score puntos = new Score();
        puntos.setMinutos(minutos);
        puntos.setSegundos(segundos);
        this.outputStream.writeUTF(Options.TIME.toString());
        this.outputStream.flush();
        this.oos.writeObject(puntos);
        this.oos.flush();
        
        
    }
    
}
