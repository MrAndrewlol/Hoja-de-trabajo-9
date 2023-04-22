
// Java Program to Print Colored Text in Console
  
// Importing input output classes
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
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
      Scanner in = new Scanner(System.in);
      System.out.println("Bienvenido por favor seleccionar una opción" + decoration.YELLOW_BRIGHT  + "\n1.Splay Tree \n2.AVL Tree \n3.Red Black Tree" + decoration.RESET);
      int opcion = in.nextInt();
      in.nextLine();
      Assertation<String, String> asociacoin = new Assertation<>();
      EstructuraArbol<String> arbolspan = asociacoin.getInstance(opcion);
      EstructuraArbol<String> arbolin = asociacoin.getInstance(opcion);
      ArrayList<String> arreglos = new ArrayList<String>();
      ArrayList<String> arreglosspan = new ArrayList<String>();
        


        // Printing the text on console prior adding
        // the desired color
        System.out.println(decoration.YELLOW_BRIGHT + "Ingrese la ruta del archivo ej C:\\ejemplos\\example1.txt" + decoration.RESET);
        String fpath = in.nextLine();
        Diccionario.esperando(150);
        
        
        
      try {
        
        File myObj = new File(fpath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          arbolin.add(data);
          arreglos.add(data);
          String listas[] = data.split(",");
          arbolspan.add(listas[1] + "," + listas[0]);
          arreglosspan.add(listas[1] + "," + listas[0]);
         
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


            String data = myReader.nextLine();
            //traduccion auto
            lStrings = data.split(" ");
        
            System.out.println( decoration.PURPLE_BACKGROUND + "                       Inicio                         " + decoration.RESET);
            System.out.println(decoration.WHITE_BRIGHT + "Bienvenido, por favor seleccionar la opción que desea traducir la oracion del texto" + decoration.RESET); 
            System.out.println(decoration.CYAN_UNDERLINED + "1.Ingles-Español\n2.Español-Ingles" + decoration.RESET );
            opcion = in.nextInt();
            in.nextLine();
        
            System.out.println(decoration.WHITE + "                   " + decoration.RESET);
            System.out.println(asociacoin.traductor(arbolin, arbolspan, opcion, lStrings, arreglos, arreglosspan));
 
          }
          myReader.close();



        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }

        
    }
}
