package Cliente;

import Palabras.Palabra;
import java.io.*;
import java.net.Socket;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

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
 
  public static void main(String[] args){
      try{
      Cliente c = new Cliente();
      Scanner sc = new Scanner(System.in);
      String aux = "";
      ArrayList<Palabra> listPalabras = new ArrayList<Palabra>();;
      while(!aux.equalsIgnoreCase("Close")){
          System.out.println("Bienvenido a la Sopa de Letras!!!");
          System.out.println("Para iniciar un juego escriba : Iniciar ");
          System.out.println("Para Finalizar escriba : close ");
          aux = sc.nextLine();
          if(aux.equalsIgnoreCase("iniciar")){
            System.out.println("Mensaje del servidor: "+c.recibirMensaje());
            listPalabras = c.recibirPalabras();
              
            System.out.println("Escriba el modo de juego a elegir: Anagrama, Conceptos");
            Scanner md = new Scanner(System.in);
                if(aux.equalsIgnoreCase("Anagrama")){
                    //Crear metodo que extraiga las palabras de la lista y a cada una le asigne un anagrama para poner en la sopa
                    
                    //LLEnar la sopa con la lista de anagramas
                    
                    //Obtener las coordenadas de cada palabra iniciales y finales
                    
                    //enviar las coordenadas iniciales y finales de cada palabra al servidor para verificar 
                    
                    //Desplegar la sopa y solicitar que meta las coordenadas y niciales y finales  de cada palabra que encuentre
                            //Coordenada inicial
                            
                            //coordenada final
                    //Se Verifican las coordenadas ingresadas con las que están en el servidor
                    
                    //si es correcto se despliega algo en la sopa para decir que la encontró suma 1 al contador de palabras correctas(Para que cuando llegue a 14 finalice el juego )
                    
                    //en caso de que no sea correcto se muestra un mensaje de vuelva a ingresar las coordanadas
                    
                    //Cuando el contador de palabras encontradas (linea 150) sea igual a 14 finaliza el juego y suma los puntos de las palabras (En caso de mostrar los score)
                }else if(aux.equalsIgnoreCase("Conceptos")){
                    
                }
                        
          }
      }
      sc.close();
      c.cerrarConexion();
      
      String[] palabras={"LETRAS","SOPA","SOL","SAL","SALON","SUECO"};
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