package Cliente;

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

    public static void horizontalNormal(String tablero[][],String palabra){
        Random auxf=new Random();
        Random auxc=new Random();
        int fila=(int)(auxf.nextDouble()*(tablero.length));
        int col=(int)(auxc.nextDouble()*((tablero.length)-(palabra.length())));
        for(int i=0; i<palabra.length();i++){
                tablero[fila][col+i]=""+palabra.charAt(i);
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
                    //tablero[i][j]=alfab[aux];
                    tablero[i][j]="O";
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
        for (int i = 0; i < pal.length;i++){
            pal[i] = crearAnagrama(pal[i]);
        }
        
        return pal;
    }
    
 
    public static void main(String[] args){
        try{
        Cliente c = new Cliente();

        ArrayList<Palabra> listPalabras = new ArrayList<Palabra>();;
        System.out.println("Bienvenido a la Sopa de Letras!!!");
        Scanner sc = new Scanner(System.in);
        String aux = "";
        int numPalabras = 14;
        while(!aux.equalsIgnoreCase("Close")){
            System.out.println("Para iniciar un juego escriba : Iniciar ");
            System.out.println("Para Finalizar escriba : close ");
            aux = sc.nextLine();
            if(aux.equalsIgnoreCase("iniciar")){
                System.out.println(c.recibirMensaje());
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
                    //Crear metodo que extraiga las palabras de la del arreglo y a cada una le asigne un anagrama para poner en la sopa
                    String [] anagramas= generarAnagramas(palabras); ///FALTATERMINAR EL METODO
                    //LLEnar la sopa con las palabras recibidas del servidor 
                    //Desplegar la lista de ANAGRAMAs a encontrar en la sopa
                    for(int i=0;i<anagramas.length ;i++ ){
                        System.out.println("Anagrama ["+(i+1)+"]: "+anagramas[i]);
                    }
                    //Obtener las coordenadas de cada palabra iniciales y finales

                    String [] listCoordenadasInicio = new String[numPalabras];
                    for(int i= 0;i <numPalabras;i++)
                        listCoordenadasInicio[i] = ("["+i+"]"+"["+(i+2)+"]");
                    
                    String [] listCoordenadasFinal = new String[numPalabras];
                    for(int i= 0;i <numPalabras;i++)
                        listCoordenadasFinal[i] = ("["+(i+2)+"]"+"["+(i+4)+"]");
                    
//enviar las coordenadas iniciales y finales de cada palabra al servidor para verificar 
                    c.enviarCoordenadas(listCoordenadasInicio, listCoordenadasFinal);
                    //Desplegar la sopa y solicitar que meta las coordenadas y niciales y finales  de cada palabra que encuentre
                    System.out.println("Juego iniciado: Para salir escriba: cancelar");
                    System.out.println("Escriba la coordenada Inicial y final de donde inicie la palabra (x,y):");
                    System.out.println("Ejemplo: 1,2");
                    int correctas= 13;
                    while( !(correctas >13) | !(aux.equalsIgnoreCase("cancelar") ) ){
                        System.out.println("Coordenada Inicial:");
                        aux = sc.nextLine();
                        String coordinicial = aux;
                        if(!aux.equalsIgnoreCase("cancelar")){
                            System.out.println("Coordenada final");
                            aux = sc.nextLine();
                            String coordfinal = aux;
                            boolean verificacion = c.enviarRespuesta(coordinicial, coordfinal);
                            if(verificacion)
                                correctas++;
                        }
                        System.out.println(correctas);
                        correctas++;//LINEA DE PRUEBA BORRAR
                        System.out.println(correctas);
                    }
                            //Coordenada inicial
                            
                            //coordenada final
                    //Se Verifican las coordenadas ingresadas con las que están en el servidor
                    
                    //si es correcto se despliega algo en la sopa para decir que la encontró suma 1 al contador de palabras correctas(Para que cuando llegue a 14 finalice el juego )
                    
                    //en caso de que no sea correcto se muestra un mensaje de vuelva a ingresar las coordanadas
                    
                    //Cuando el contador de palabras encontradas (linea 150) sea igual a 14 finaliza el juego y suma los puntos de las palabras (En caso de mostrar los score)
                    aux = "close";
                }else if(aux.equalsIgnoreCase("Conceptos")){
                    //Se guardan los conceptos de las palabras recibidas desde el servidor
                    String[] conceptos = new String[numPalabras];
                    for (int i=0; i<conceptos.length ;i++){
                        conceptos[i]= listPalabras.get(i).getConcepto();//guardamos cada palabra en la lista
                    }
                    for(int i=0;i<conceptos.length ;i++ ){
                        System.out.println("Concepto ["+(i+1)+"]: "+conceptos[i]);
                    }
                    
                    aux = "close";
                }
            }
            System.out.println("Se reinicia el juego");
        }
        sc.close();
        c.cerrarConexion();
      
      String[] palabrasaux={"SOPA","SOL","SAL","SALON"};
      String palabrasHN="LETRAS";
      String[] palabrasVN={"LETRAS"};
      String[] palabrasDIA={"LETRAS"};
      String[] palabrasHI={"LETRAS"};
      String tablero[][]=new String[15][15];
      Random auxf=new Random();
      Random auxc=new Random();
      /*for(int i=0;i<6;i++){
          String palabra=palabrasHN[i];
          horizontalNormal(tablero,palabra);
      }*/
      diagonalDerAbajo(tablero,palabrasHN);
      /*for(int i=0;i<4;i++){
          String palabra=palabrasaux[i];
          verticalNormal(tablero,palabra);
      }*/
      //verticalNormal(tablero,palabra,0,0);
      //horizontalInvertida(tablero,palabra,0,5);
      //diagonalIzqAbajo(tablero,palabra,2,2);
      rellenar(tablero);
      verTablero(tablero);
      
      
      }catch(Exception e){
          e.printStackTrace();
      }

  }
}