package Cliente;

import java.util.Calendar;
import Palabras.Palabra;
import java.io.*;
import java.util.Collections;
import java.net.Socket;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Sopa1 {
public static final String ANSI_GREEN = "\u001B[32m";//Color verde en el texto 
public static final String ANSI_RED = "\u001B[31m";//Color rojo en el el texto
public static final String ANSI_RESET = "\u001B[0m";//Restablece los colores
    public static void horizontalNormal(String tablero[][],String palabra,String coorF[],String coorC[],int sig){
        Random auxf=new Random();
        Random auxc=new Random();
        int fila=(int)(auxf.nextDouble()*(tablero.length-1));
        int col=(int)(auxc.nextDouble()*((tablero.length)-(palabra.length())));
        coorF[sig]=""+fila+","+col;
        coorC[sig]=""+fila+","+(col+palabra.length()-1);
        for(int i=0; i<palabra.length();i++){
            if(tablero[fila][col+i]==null){
                tablero[fila][col+i]=""+palabra.charAt(i);
            }else{
                for(int j=0;j<palabra.length();j++){
                    tablero[fila+1][col+j]=""+palabra.charAt(j);
                }
                coorF[sig]=""+fila+","+col;
                coorC[sig]=""+fila+","+(col+palabra.length()-1);
                break;
            }
        }
    }
    public static void horizontalInvertida(String tablero[][],String palabra){
        int a=0;
        Random auxf=new Random();
        Random auxc=new Random();
        int fila=(int)(auxf.nextDouble()*(tablero.length));
        int col=(int)(auxc.nextDouble()*((tablero.length)-(palabra.length())));
        for(int i=palabra.length()-1; i>=0;i--){
            tablero[fila][col+a]=""+palabra.charAt(i);
            a++;
        }
    }
    public static void verticalNormal(String tablero[][],String palabra){
        Random auxf=new Random();
        Random auxc=new Random();
        int fila=(int)(auxf.nextDouble()*((tablero.length)-(palabra.length())));
        int col=(int)(auxc.nextDouble()*tablero.length);
        for(int i=0; i<palabra.length();i++){
                tablero[fila+i][col]=""+palabra.charAt(i);
        }
    }
    public static void verticalInvertida(String tablero[][],String palabra){
        Random auxf=new Random();
        Random auxc=new Random();
        int a=0;
        int fila=(int)(auxf.nextDouble()*((tablero.length)-(palabra.length())));
        int col=(int)(auxc.nextDouble()*tablero.length);
        for(int i=palabra.length()-1; i>=0;i--){
            tablero[fila+a][col]=""+palabra.charAt(i);
            a++;
        }
    }
    public static void diagonalIzqAbajo(String tablero[][],String palabra){
        Random auxf=new Random();
        Random auxc=new Random();
        int fila=(int)(auxf.nextDouble()*((tablero.length)-(palabra.length())));
        int col=(int)(auxc.nextDouble()*((tablero.length)-(palabra.length())));
        for(int i=0; i<palabra.length();i++){
            tablero[fila+i][col+i]=""+palabra.charAt(i);
        }
    }
    public static void diagonalAbajoIzq(String tablero[][],String palabra){
        Random auxf=new Random();
        Random auxc=new Random();
        int a=0;
        int fila=(int)(auxf.nextDouble()*((tablero.length)-(palabra.length())));
        int col=(int)(auxc.nextDouble()*((tablero.length)-(palabra.length())));
        for(int i=palabra.length()-1; i>=0;i--){
            tablero[fila+a][col+a]=""+palabra.charAt(i);
            a++;
        }
    }
    public static void diagonalAbajoDer(String tablero[][],String palabra){
        Random auxf=new Random();
        Random auxc=new Random();
        int fila=(int)(auxf.nextDouble()*((tablero.length)-(palabra.length()))+palabra.length());
        int col=(int)(auxc.nextDouble()*((tablero.length)-(palabra.length())));
        for(int i=0; i<palabra.length();i++){
            tablero[fila-i][col+i]=""+palabra.charAt(i);
        }
    }
    public static void diagonalDerAbajo(String tablero[][],String palabra){
        Random auxf=new Random();
        Random auxc=new Random();
        int a=0;
        int fila=(int)(auxf.nextDouble()*((tablero.length)-(palabra.length()))+palabra.length());
        int col=(int)(auxc.nextDouble()*((tablero.length)-(palabra.length())));
        for(int i=palabra.length()-1; i>=0;i--){
            tablero[fila-a][col+a]=""+palabra.charAt(i);
            a++;
        }
    }
    public static void verTablero(String tablero[][]){
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero.length;j++){
                System.out.print(" "+tablero[i][j]);
            }
            System.out.println("");
        }
    }
    public static void rellenar(String tablero[][]){
        Random rnd=new Random();
        String[] alfab={"A","B","C","D","E","F","G","H","I","J",
                        "K","L","M","N","O","P","Q","R","S","T",
                        "U","V","W","X","Y","Z"};
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero.length;j++){
                int aux=(int)(rnd.nextDouble()*26);
                if(tablero[i][j]==null){
                    tablero[i][j]=alfab[aux];
                    //tablero[i][j]="O";
                }
            }
        }
    }
    //Genera un anagrama a partir de una cadena 
    public static String crearAnagrama(String palabra){
	String str[] = palabra.split("");
	List<String> al = Arrays.asList(str);
	Collections.shuffle(al);
        String anagrama = al.stream()// Stream<Character>
                .map(String::valueOf)   // Stream<String>
                .collect(Collectors.joining());
        return anagrama;
    }
    //Regresa una lista de anagramas a partir de un arreglo de Strings
    public static String[] generarAnagramas(String [] pal){
        String[] anagrama = new String[pal.length];
        for (int i = 0; i < pal.length;i++){
            anagrama[i] = crearAnagrama(pal[i]);
        }
        
        return anagrama;
    }
    
 
    public static void main(String[] args){
        try{
        Cliente c = new Cliente();

        ArrayList<Palabra> listPalabras = new ArrayList<Palabra>();;
        System.out.println("Bienvenido a la Sopa de Letras!!!");
        Scanner sc = new Scanner(System.in);
        String tablero[][]=new String[15][15];//tablero
        String aux = "";
        System.out.println("Ingrese su nombre de usuario");
        String nombre = sc.nextLine();
        int numPalabras = 14;
        String listCoordenadasInicio[]=new String[numPalabras];
        String listCoordenadasFinal[]=new String[numPalabras];
        while(!aux.equalsIgnoreCase("Close")){
            System.out.println("Para iniciar un juego escriba : Iniciar ");
            System.out.println("Para Finalizar escriba : close ");
            aux = sc.nextLine();
            System.out.println(c.recibirMensaje());
            if(aux.equalsIgnoreCase("iniciar")){
                c.enviarNombre(nombre);
                listPalabras = c.recibirPalabras();//REcibimos las palabras de la sopa desde el servidor
                System.out.println("Juego iniciado escoja un modo de juego: Anagrama, Conceptos");
                aux = sc.nextLine();
                while(!aux.equalsIgnoreCase("Anagrama") && !aux.equalsIgnoreCase("Conceptos")){
                    System.out.println("Opción invalida ingrese: Anagrama o Conceptos");
                    aux = sc.nextLine();
                }
                //Se guardan las palabras recibidas desde el servidor en una variable
                String[] palabras = new String[numPalabras];
                for (int i=0; i<palabras.length ;i++){
                    palabras[i]= listPalabras.get(i).getNombre();//guardamos cada palabra en la lista
                }
                if(aux.equalsIgnoreCase("Anagrama")){
                    Calendar ini=Calendar.getInstance();
                    System.out.println("Hora de Inicio: "+ini.get(Calendar.HOUR_OF_DAY)+":"+ini.get(Calendar.MINUTE)+":"+ini.get(Calendar.SECOND));
                    //Crear metodo que extraiga las palabras de la del arreglo y a cada una le asigne un anagrama para poner en la sopa
                    String [] anagramas= generarAnagramas(palabras);
                    //Obtener las coordenadas de cada palabra iniciales y finales
                    for(int i=0;i<palabras.length;i++){
                        String palabra=palabras[i];
                        horizontalNormal(tablero,palabra,listCoordenadasInicio,listCoordenadasFinal,i);
                    }
                    rellenar(tablero);
                    //enviar las coordenadas iniciales y finales de cada palabra al servidor para verificar 
                    c.enviarCoordenadas(listCoordenadasInicio, listCoordenadasFinal);
                    //Desplegar la sopa y solicitar que meta las coordenadas y niciales y finales  de cada palabra que encuentre
                    System.out.println("Juego iniciado: Para salir escriba: CANCELAR");
                    System.out.println("Escriba la coordenada Inicial y final de donde inicie la palabra (x,y):");
                    int correctas= 0;
                    int [] vectorCorrectas = new int[numPalabras];
                    while(!(aux.equalsIgnoreCase("cancelar") ) ){
                        //Lista anagramas
                        for(int i=0;i<anagramas.length ;i++ ){
                            if(vectorCorrectas[i] != 1)
                                System.out.println(ANSI_RED + "Anagrama ["+(i+1)+"]: "+anagramas[i]+ ANSI_RESET);
                            else 
                                System.out.println(ANSI_GREEN + "Anagrama ["+(i+1)+"]: "+anagramas[i]+ ANSI_RESET);
                        }
                        verTablero(tablero);
                        System.out.println("Ejemplo: 1,2");
                        System.out.println("Coordenada Inicial:");
                        aux = sc.nextLine();
                        String coordinicial = aux;
                        if(!aux.equalsIgnoreCase("cancelar")){
                            System.out.println("Coordenada final");
                            aux = sc.nextLine();
                            String coordfinal = aux;
                            int verificacion = c.enviarRespuesta(coordinicial, coordfinal);
                            if( (verificacion != -1) ){
                                //Metodo para marcar las celdas encontradas o rayar las letras
                                vectorCorrectas[verificacion] = 1;
                                System.out.println("Correcto!! La palabra "+ palabras[verificacion]+ " encontrada en la sopa");
                                correctas++;
                            }
                        }
                        
                        if(correctas > 13){
                            Calendar fin=Calendar.getInstance();
                            System.out.println("Hora de Finalización del juego: "+fin.get(Calendar.HOUR_OF_DAY)+":"+fin.get(Calendar.MINUTE)+":"+fin.get(Calendar.SECOND));
                            aux="cancelar";
                            c.enviarTiempo(ini,fin);
                        }
                    }
                }else if(aux.equalsIgnoreCase("Conceptos")){
                    Calendar ini=Calendar.getInstance();
                    System.out.println("Hora de Inicio: "+ini.get(Calendar.HOUR_OF_DAY)+":"+ini.get(Calendar.MINUTE)+":"+ini.get(Calendar.SECOND));
                    //Se guardan los conceptos de las palabras recibidas desde el servidor
                    String[] conceptos = new String[numPalabras];
                    for (int i=0; i<conceptos.length ;i++){
                        conceptos[i]= listPalabras.get(i).getConcepto();//guardamos cada palabra en la lista
                    }
                    //Obtener las coordenadas de cada palabra iniciales y finales
                    for(int i=0;i<palabras.length;i++){
                        String palabra=palabras[i];
                        horizontalNormal(tablero,palabra,listCoordenadasInicio,listCoordenadasFinal,i);
                    }
                    rellenar(tablero);
                    //Enviamos las coordenadas iniciales y finales al servidor
                    c.enviarCoordenadas(listCoordenadasInicio, listCoordenadasFinal);
                    //Desplegar la sopa y solicitar que meta las coordenadas y niciales y finales  de cada palabra que encuentre
                    System.out.println("Juego iniciado: Para salir escriba: CANCELAR");
                    System.out.println("Escriba la coordenada Inicial y final de donde inicie la palabra (x,y):");
                    int correctas= 12;
                    int [] vectorCorrectas = new int[numPalabras];
                    while(!(aux.equalsIgnoreCase("cancelar") ) ){
                        //Lista anagramas
                        for(int i=0;i<palabras.length ;i++ ){
                            if(vectorCorrectas[i] != 1)
                                System.out.println(ANSI_RED + "Concepto ["+(i+1)+"]: "+conceptos[i]+ ANSI_RESET);
                            else 
                                System.out.println(ANSI_GREEN + "Concepto ["+(i+1)+"]: "+conceptos[i]+ ANSI_RESET);
                        }
                        verTablero(tablero);
                        System.out.println("Ejemplo: 1,2");
                        System.out.println("Coordenada Inicial:");
                        aux = sc.nextLine();
                        String coordinicial = aux;
                        if(!aux.equalsIgnoreCase("cancelar")){
                            System.out.println("Coordenada final");
                            aux = sc.nextLine();
                            String coordfinal = aux;
                            int verificacion = c.enviarRespuesta(coordinicial, coordfinal);
                            if( (verificacion != -1) ){
                                //Metodo para marcar las celdas encontradas o rayar las letras
                                vectorCorrectas[verificacion] = 1;
                                System.out.println("Correcto!! La palabra "+ palabras[verificacion]+ " encontrada en la sopa");
                                correctas++;
                            }
                        }
                        
                        if(correctas > 13){
                            Calendar fin=Calendar.getInstance();
                            System.out.println("Hora de Finalización del juego: "+fin.get(Calendar.HOUR_OF_DAY)+":"+fin.get(Calendar.MINUTE)+":"+fin.get(Calendar.SECOND));
                            aux="cancelar";
                            c.enviarTiempo(ini,fin);
                        }
                    }//Fin coordenadas
                }//Fin conceptos
                
            }//Fin iniciar
            //Menu de reinicio
            System.out.println("FIN DEL JUEGO");
            System.out.println("Teclee: 'reintentar' para intentarlo de nuevo o 'close' para finalizar");
            aux = sc.nextLine();
            if(aux.equalsIgnoreCase("reintentar")){
                
                System.out.println("Se reinicia el juego");
            }
        }
        sc.close();
        c.cerrarConexion();
      /*for(int i=0;i<6;i++){
          String palabra=palabrasHN[i];
          horizontalNormal(tablero,palabra);
      }*/
      /*for(int i=0;i<4;i++){
          String palabra=palabrasaux[i];
          verticalNormal(tablero,palabra);
      }*/
      //verticalNormal(tablero,palabra,0,0);
      //horizontalInvertida(tablero,palabra,0,5);
      //diagonalIzqAbajo(tablero,palabra,2,2);
      //rellenar(tablero);
      //verTablero(tablero);
      
      
      }catch(Exception e){
          e.printStackTrace();
      }

  }
}