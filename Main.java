package proyecto1;

import java.util.Scanner;

public class Main {
    
    //VARIABLES COMPARTIDAS
    public static int[] memoriaInst = new int[640];
    public static int[] memoriaDatos=new int[384];
    public static int quantum=0;
    public static int ciclos=0;
    public static int numHilos;
    public static int[] instrucHilos = new int[13];
    private static Scanner sc;

    
    //VARIABLES NUCLEO1
    public static int[][] cacheDatosN1= new int[6][4];
    public static int[][] cacheInstN1= new int[5][16];
    //public static int[] contexto1= new int[33]; //32 para registros, 1 para pc: Este vector creo que es mejor separarlo asi:
    public static int[] registrosN1= new int[32];
    public static int PCN1=-1;
    public static int RLN1=-1;
    public static int quantumN1=0;

    //VARIABLES NUCLEO2
    public static int[][] cacheDatosN2= new int[6][4];
    public static int[][] cacheInstN2= new int[5][16];
    //public static int[] contexto2= new int[33]; //32 para registros, 1 para pc
    public static int[] registrosN2= new int[32];
    public static int PCN2=-1;
    public static int RLN2=-1;
    public static int quantumN2=0;

    //VARIABLES NUCLEO3
    public static int[][] cacheDatosN3= new int[6][4];
    public static int[][] cacheInstN3= new int[5][16];
    //public static int[] contexto3= new int[33]; //32 para registros, 1 para pc
    public static int[] registrosN3= new int[32];
    public static int PCN3=-1;
    public static int RL3=-1;
    public static int quantumN3=0;
        
    //Inicializa las caches de instrucciones en 1
    public static void IniciaCachesInt(){
        for(int i=0; i<5; i++){
            for(int j=0; j<16; j++){
                cacheInstN1[i][j]=1;
                cacheInstN2[i][j]=1;
                cacheInstN3[i][j]=1;
            }
        }
    }
   
    //Inicializa las caches de datos en 1
    public static void IniciaCachesDatos(){
        for(int i=0; i<6; i++){
            for(int j=0; j<4; j++){
                cacheDatosN1[i][j]=1;
                cacheDatosN2[i][j]=1;
                cacheDatosN3[i][j]=1;
            }
        }
    }
    
    //Inicializa la memoria de Instrucciones en 1
    public static void IniciaMemInst(){
        for(int i=0; i<memoriaInst.length; i++){
            memoriaInst[i]=1;
        }
    }
    
    //Inicializa la memoria de Datos en 1
    public static void IniciaMemDatos(){
        for(int i=0; i<memoriaDatos.length; i++){
            memoriaDatos[i]=1;
        }
    }
    
    //Inicializa los registros de los nucleos en 0
    public static void IniciaRegistros(){
        for(int i=0; i<registrosN1.length; i++){
            registrosN1[i]=0;
            registrosN2[i]=0;
            registrosN3[i]=0;
        }
    }
    
    public static int [] leerArchivo(String direccion, int numH){
        String vecAux []=new String[640];
        int []memAux =new int [640];
        Archivo arc = new Archivo();
        String hilillo =arc.leerTxt(direccion, numH);
        vecAux=hilillo.split(" ");
        for(int i=0; i<vecAux.length; i++){
            memAux[i]=Integer.parseInt(vecAux[i]);
        }
        return memAux;
    }
     
    public static void main(String[] args) throws InterruptedException {
        sc = new Scanner(System.in);
        String ubicacion =System.getProperty("user.dir");
        if(args.length<=0){
            System.out.println("Digite el numero de hillillos que desea ejecutar: ");
            numHilos=sc.nextInt();
            System.out.println("Digite el numero del quantum");
            quantum=sc.nextInt();
            System.out.println("Num. Hilillos: "+ numHilos + " Quantum: "+quantum);
        }      
        IniciaCachesInt();
        IniciaCachesDatos();
        IniciaMemInst();
        IniciaMemDatos();
        IniciaRegistros();
        int [] mem= new int[640];
        
        for(int i=0; i<=numHilos; i++){
            mem= leerArchivo(ubicacion+"\\"+String.valueOf(i)+".txt",i); 
         //   System.arraycopy(mem, 0, memoriaInst, 0, instrucHilos[i]*4);
        }
        
        //Imprimir hilillos en mem
        for(int i=0; i<memoriaInst.length; i++){
            System.out.print(memoriaInst[i]+" ");
        }
        
    }
}
