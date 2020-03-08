
package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientWorker implements Runnable{
    private Socket cl;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    
    public ClientWorker(Socket socket)throws IOException{
        this.cl = socket;
        this.inputStream = new DataInputStream(this.cl.getInputStream());
        this.outputStream = new DataOutputStream(this.cl.getOutputStream());
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
    private boolean chooseOptions(boolean isConnected)throws IOException{
        OptionsServer aux = OptionsServer.valueOf(this.inputStream.readUTF());
        switch(aux){
        
        case MESSAGE:
            this.message();
            break;
        case CLOSE:
            isConnected = false;
            break;
        default:
            break;    
        }
        return isConnected;
    }
    public void message() throws IOException{
        try{
        System.out.println("Solicitud de mensaje recibida de parte del cliente");
        this.outputStream.writeUTF("Se ha conectado al servidor");
        
        }catch( IOException e){
        e.printStackTrace();
        }
    }
    
    protected void finalize() throws Throwable{
    
    
    }
}