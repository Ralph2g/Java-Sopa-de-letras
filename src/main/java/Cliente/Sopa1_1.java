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
import java.util.Calendar;
import java.util.Random;
public class Sopa1_1 {

    public static void horizontalNormal(String tablero[][],String palabra,String coor[][],int sig){
        Random auxf=new Random();
        Random auxc=new Random();
        int fila=(int)(auxf.nextDouble()*(tablero.length-1));
        int col=(int)(auxc.nextDouble()*((tablero.length)-(palabra.length())));
        coor[sig][0]=""+palabra;
        coor[sig][1]=""+fila+","+col;
        coor[sig][2]=""+fila+","+(col+palabra.length()-1);
        for(int i=0; i<palabra.length();i++){
            if(tablero[fila][col+i]==null){
                tablero[fila][col+i]=""+palabra.charAt(i);
            }else{
                for(int j=0;j<palabra.length();j++){
                    tablero[fila+1][col+j]=""+palabra.charAt(j);
                }
                coor[sig][0]=""+palabra;
                coor[sig][1]=""+(fila+1)+","+col;
                coor[sig][2]=""+(fila+1)+","+(col+palabra.length()-1);
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
    public static void verCoor(String coor[][], int palabras){
        for(int i=0;i<palabras;i++){
            for(int j=0;j<3;j++){
                System.out.println(""+coor[i][j]);
            }
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
    public static void obtenerHora(){
        Calendar calendario=Calendar.get;
        int hora, minutos, segundos;
        hora=calendario.get(Calendar.HOUR_OF_DAY);
        minutos=calendario.get(Calendar.MINUTE);
        segundos=calendario.get(Calendar.SECOND);
        System.out.println("Hora de Inicio: "+hora+":"+minutos+":"+segundos);
    }
 
  public static void main(String[] args){
      String[] palabrasHN={"LETRAS","SOPA","PLUMA","SOL","SALTO","TECLADO","MONITOR","AZUL","ROJO"};
      String[] palabrasVN={"LETRAS"};
      String[] palabrasDIA={"LETRAS"};
      String[] palabrasHI={"LETRAS"};
      String tablero[][]=new String[15][15];
      String coor[][]=new String[palabrasHN.length][palabrasHN.length];
      Random auxf=new Random();
      Random auxc=new Random();
      for(int i=0;i<palabrasHN.length;i++){
          String palabra=palabrasHN[i];
          horizontalNormal(tablero,palabra,coor,i);
      }
      System.out.println(""+palabrasHN.length);
      //horizontalNormal(tablero,palabrasHN);
      /*for(int i=0;i<4;i++){
          String palabra=palabrasaux[i];
          verticalNormal(tablero,palabra);
      }*/
      //verticalNormal(tablero,palabra,0,0);
      //horizontalInvertida(tablero,palabra,0,5);
      //diagonalIzqAbajo(tablero,palabra,2,2);
      rellenar(tablero);
      verTablero(tablero);
      verCoor(coor,palabrasHN.length);
      obtenerHora();
  }
}