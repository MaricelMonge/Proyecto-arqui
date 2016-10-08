package proyecto1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Archivo {
    public static int[] tamHilos= new int[12];
    
    public String leerTxt(String direccion, int numH){ //direccion del archivo
        String texto = "";

        try(BufferedReader bf = new BufferedReader(new FileReader(direccion))) {
            String temp = "";
            String bfRead;
            int contInstruc = 0;
            while((bfRead = bf.readLine()) != null){ 
                contInstruc ++;
                temp = temp + bfRead + " "; //guardado el texto del archivo
            }
            Main.instrucHilos[numH]=contInstruc;
            texto = temp;
        }catch(Exception e){ 
            System.err.println("No se encontro archivo");
        }
        return texto;

    } 
}