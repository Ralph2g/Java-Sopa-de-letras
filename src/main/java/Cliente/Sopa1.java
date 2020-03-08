package Cliente;

import java.io.*;
import java.net.Socket;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
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
      while(!aux.equalsIgnoreCase("Close")){
          System.out.println("Escriba su opcion");
          aux = sc.nextLine();
          if(aux.equalsIgnoreCase("Message")){
              System.out.println("Mensaje del servidor: "+c.recibirMensaje());
          }else if(aux.equalsIgnoreCase("lista"))
              System.out.println("LA lista es : "+c.palabras());
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