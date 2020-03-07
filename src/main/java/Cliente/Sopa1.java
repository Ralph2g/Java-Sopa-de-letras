/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

/**
 *
 * @author luise
 */
import java.util.Random;
public class Sopa1 {

    public static void horizontalNormal(String tablero[][],String palabra){
        Random auxf=new Random();
        Random auxc=new Random();
        int fila=(int)(auxf.nextDouble()*14);
        int col=(int)(auxc.nextDouble()*10);
        for(int i=0; i<palabra.length();i++){
            if(tablero[fila][col+i]==null){
                tablero[fila][col+i]=""+palabra.charAt(i);
            }else{
                horizontalNormal(tablero,palabra);
            }
        }
    }
    public static void horizontalInvertida(String tablero[][],String palabra,int fila,int colum){
        int a=0;
        for(int i=palabra.length()-1; i>=0;i--){
            tablero[fila][colum+a]=""+palabra.charAt(i);
            a++;
        }
    }
    public static void verticalNormal(String tablero[][],String palabra){
        Random auxf=new Random();
        Random auxc=new Random();
        int fila=(int)(auxf.nextDouble()*14);
        int col=(int)(auxc.nextDouble()*10);
        for(int i=0; i<palabra.length();i++){
            if(tablero[fila+i][col]==null){
                tablero[fila+i][col]=""+palabra.charAt(i);
            }else{
                horizontalNormal(tablero,palabra);
            }
        }
    }
    public static void diagonalIzqAbajo(String tablero[][],String palabra,int fila,int colum){
        for(int i=0; i<palabra.length();i++){
            tablero[fila+i][colum+i]=""+palabra.charAt(i);
        }
    }
    public static int[] GenerarCoordenadas(String tablero[][],String palabra){
        int[] coordenadas = new int[2];
        Random auxf=new Random();
        Random auxc=new Random();
        do{
            coordenadas[1] = (int)(auxf.nextDouble()*14);
            coordenadas[2] = (int)(auxc.nextDouble()*10);
        }while(verificar(palabra,tablero,coordenadas[1],coordenadas[2]));
        return coordenadas;
    }
    public static boolean verificar(String palabra, String tablero[][], int fila, int colum){
    
        return true;
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
      String[] palabras={"LETRAS","SOPA","SOL","SAL","SALON","SUECO"};
      String[] palabrasaux={"SOPA","SOL","SAL","SALON"};
      String tablero[][]=new String[15][15];
      Random auxf=new Random();
      Random auxc=new Random();
      for(int i=0;i<6;i++){
          String palabra=palabras[i];
          horizontalNormal(tablero,palabra);
      }
      for(int i=0;i<4;i++){
          String palabra=palabrasaux[i];
          verticalNormal(tablero,palabra);
      }
      //verticalNormal(tablero,palabra,0,0);
      //horizontalInvertida(tablero,palabra,0,5);
      //diagonalIzqAbajo(tablero,palabra,2,2);
      rellenar(tablero);
      verTablero(tablero);
  }
}