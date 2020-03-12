
package Servidor;

import Palabras.Palabra;
import Palabras.Score;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientWorker implements Runnable{
    private Socket cl;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private ArrayList<Palabra> listpalabras;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private String name;
    
    public ClientWorker(Socket socket,ArrayList<Palabra> list)throws IOException{
        this.cl = socket;
        this.inputStream = new DataInputStream(this.cl.getInputStream());
        this.outputStream = new DataOutputStream(this.cl.getOutputStream());
        this.oos= new ObjectOutputStream(this.cl.getOutputStream());
        this.ois= new ObjectInputStream(this.cl.getInputStream());
        this.listpalabras = list;
        this.name = "";
        System.out.println("Cliente Conectado");
    }
    public void run(){
        boolean isConnected =true;
        while(isConnected){
            try{
                isConnected = this.chooseOptions(isConnected);
            }catch(IOException e){
            e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    //Opciones que tiene nuestro servidor para hacer envios 
    private boolean chooseOptions(boolean isConnected)throws IOException, ClassNotFoundException{
        OptionsServer aux = OptionsServer.valueOf(this.inputStream.readUTF());
        switch(aux){
                
        case MESSAGE:
            System.out.println("Solicitud de mensaje recibida de parte del cliente");
            this.message();
            break;
        case NAME:
            System.out.println("Cliente envia nombre");
            this.guardarNombre();
            break;
        case GETLIST:
            System.out.println("Solicitud de palabras recibida de parte del cliente");
            this.sendPalabras();
            break;
        case CLOSE:
            System.out.println("Solicitud de Cierre de conexión recibida de parte del cliente");
            isConnected = false;
            break;
        case COORDINATES:
            System.out.println("Cliente envía las coordenadas de las palabras");
            this.recibirCoordenadas();
            break;
        case ANSWER:
            System.out.println("Cliente envia coordenada");
            this.enviarRespuesta();
            break;
        case TIME:
            System.out.println("Cliente envia las el score");
            this.guardarScore();
            break;
        default:
            break;    
        }
        return isConnected;
    }
    private void guardarNombre() throws IOException{
        this.name = this.inputStream.readUTF();
        System.out.println("Usuario: "+ this.name+ " Conectado");
    }
    //Envío de las palabras a el cliente
    private void sendPalabras()throws IOException{
        this.outputStream.writeInt(this.listpalabras.size());//enviamos al cliente el tamaño de la lista
        this.outputStream.flush();
        Iterator<Palabra> aux = this.listpalabras.iterator();
        while(aux.hasNext()){
            this.oos.writeObject(aux.next());//Enviamos el objeto uno auno
            this.oos.flush();
        }
    }
    //Mensaje de Bienvenida a el servidor
    public void message() throws IOException{
        try{
        this.outputStream.writeUTF("Se ha conectado al servidor");
        this.outputStream.flush();
        System.out.println("Respuesta envida");
        }catch( IOException e){
        e.printStackTrace();
        }
    }
    //recibe y guarda las coordenadas en la lista 
    public void recibirCoordenadas() throws IOException, ClassNotFoundException{
        //Recibimos el numero de letras
        int cont = this.inputStream.readInt();
 
        //Recibimos cada una de las coordenadas de inicio
        for (int i=0; i< cont ;i++){
            this.listpalabras.get(i).setCoordInicio(this.inputStream.readUTF());
            System.out.println(this.listpalabras.get(i).getCoordInicio());
        }
        System.out.println("------------");
        //Recibimos y guardamos las coordenadas finales
        for (int i=0; i< cont ;i++){
            this.listpalabras.get(i).setCoordFin(this.inputStream.readUTF());
            System.out.println(this.listpalabras.get(i).getCoordFin());
        }
    }
    
        //Recibimos la coordenada de la palabra que intenta encontrar en la sopa el usuario
    public void enviarRespuesta() throws IOException{
        String coordInicio = this.inputStream.readUTF();
        String coordFinal = this.inputStream.readUTF();
        int bandera = -1;
        //Se compara con cada una de las coordenadas iniciales y finales de nuestra lista de palabras
        for (int i= 0; i< this.listpalabras.size();i++)
            if ((this.listpalabras.get(i).getCoordInicio().equalsIgnoreCase(coordInicio)) && (this.listpalabras.get(i).getCoordFin().equalsIgnoreCase(coordFinal)))
                bandera = i;
        //Regresamos la respuesta
        this.outputStream.writeInt(bandera);
        this.outputStream.flush();
        
    }
    public void guardarScore() throws IOException, ClassNotFoundException{
        Score puntuacion = (Score)this.ois.readObject();
        System.out.println("El tiempo en resolver el crucigrmaa fue: "+ puntuacion.getMinutos()+"minutos con "+puntuacion.getSegundos()+"segundos");
    }
    protected void finalize() throws Throwable{
    
    
    }
}