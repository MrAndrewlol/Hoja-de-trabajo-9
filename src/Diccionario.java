
// Java Program to Print Colored Text in Console
  
// Importing input output classes
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.lang.Thread; 
 
/*
 * Hecho por Andre Jo
 * Estructura de datos 
 * 25/03/2023
 */

// Main class
public class Diccionario {

    public static void esperando(int segundo){
        String loading = "Esperando.";

        try {
            for (int i = 0; i < 10; i++) {
                
               
                // it will sleep the main thread for 1 sec
                // ,each time the for loop runs
                Thread.sleep(segundo);
                loading = loading + ".";

                if ( i%2 == 0){
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();  
                    System.out.print(decoration.YELLOW_BRIGHT + loading + "\n" + decoration.RESET);
                }
                else{
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();  
                    System.out.print(decoration.CYAN_BRIGHT + loading + "\n" + decoration.RESET);
                }
               
                // This Thread.sleep() method will sleep the
                // thread 0.
                // printing the value of the variable
                
                
                
            }
        }
        catch (Exception e) {
           
            // catching the exception
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){ 
      
        arbolbinario arbolspan = new arbolbinario();
        arbolbinario arbolin = new arbolbinario();

        Assertation<arbolbinario, arbolbinario> asociacoin = new Assertation<>();
        


        // Printing the text on console prior adding
        // the desired color
        System.out.println(decoration.YELLOW_BRIGHT + "Ingrese la ruta del archivo ej C:\\ejemplos\\example1.txt" + decoration.RESET);
        Scanner in = new Scanner(System.in);
        String fpath = in.nextLine();
        Diccionario.esperando(150);
        
        
        
      try {
        File myObj = new File(fpath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          arbolin.add(data);
          String[] listatarget = data.split(",");
          String datain = ""+ listatarget [0] +"," + listatarget[1] + "";
          arbolin.add(datain);
          String dataspa = listatarget[1] +","+ listatarget [0] + "";
          arbolspan.add(dataspa);
        }
        System.out.println(decoration.WHITE_BACKGROUND + "    " + decoration.RESET + " Se llenaron las palabaras del diccionario " +  decoration.WHITE_BACKGROUND + "    " + decoration.RESET);
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }




      
      System.out.println("Ingrese la ruta del archivo que desea usar para traducir \nej C:\\ejemplos\\example1.txt");
      fpath = in.nextLine();


        
        try {
          File myObj = new File(fpath);
          Scanner myReader = new Scanner(myObj);
          String[] lStrings;
          while (myReader.hasNextLine()) {
            int contadorspan = 0;
            int contadorin = 0;
            int contadorrance = 0;

            String data = myReader.nextLine();
            //traduccion auto
            lStrings = data.split(" ");
            for (int k = 0; k < lStrings.length ; k++ ){
              if (arbolin.containsNode(lStrings[k]) == true){
                contadorin ++;
              }
              if (arbolspan.containsNode(lStrings[k]) == true){
                contadorspan ++;
              }
            }
        
            System.out.println( decoration.PURPLE_BACKGROUND + "                       Inicio                         " + decoration.RESET);
            System.out.println("Se detecto los siguientes idiomas con su cantidad de palabras en la oracion " + data + ": \nIngles = "+ contadorin + "\nEspañol = " + contadorspan+ "\nFrances = " + contadorrance);
            System.out.println(decoration.WHITE_BRIGHT + "Bienvenido, por favor seleccionar la opción que desea traducir la oracion del texto" + decoration.RESET); 
            System.out.println(decoration.CYAN_UNDERLINED + "1.Ingles-Español\n2.Ingles-Frances\n3.Español-Ingles\n4.Español-Frances\n5.Frances-Ingles\n6.Frances-Español\n7.No se imprima todas las opciones" + decoration.RESET );
            int opcion = in.nextInt();
            in.nextLine();
            System.out.println(decoration.WHITE + "                   " + decoration.RESET);
            System.out.println(asociacoin.traductor(arbolin, arbolspan, opcion, lStrings));
 
          }
          myReader.close();


          System.out.println("Imprimiendo el diccionario en orden, Pulsa ENTER PARA CONTINUAR ");
          in.nextLine();
          Diccionario.esperando(100);

          System.out.println(decoration.BLACK_BRIGHT + "Diccionario en Ingles ordenado" + decoration.RESET);
          arbolin.inorder();
          System.out.println(decoration.RED_BRIGHT + "\nDiccionario en Ingles ordenado" + decoration.RESET);
          arbolspan.inorder();



        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }

        
    }
}
