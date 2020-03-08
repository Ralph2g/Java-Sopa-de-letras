package Cliente;

import Palabras.Palabra;
import java.io.*;
import java.net.Socket;
import java.io.IOException;
import java.util.LinkedList;
public class Cliente {
    private Socket cl;
    
    public Cliente (Socket cl) throws IOException{
        this.cl = cl;
    }
    
    public InputStream getInputStream () throws IOException{
        return cl.getInputStream();
    }
    
    public OutputStream getOutputStream () throws IOException{
        return cl.getOutputStream();
    }

    
    public LinkedList <Palabra> recibirPalabras(DataInputStream dis) throws IOException{
        LinkedList <Palabra> palabras;
        palabras = new LinkedList <Palabra>();
        return palabras;
    }
    
}
