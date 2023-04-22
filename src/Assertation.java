import java.util.ArrayList;

import structure5.Association;


/*
 * The Author of this  @Andre Jo
 */



public class Assertation<K, V> {

    public EstructuraArbol<String> getInstance(int instance) {
        EstructuraArbol<String> priority = null;

        if (instance == 1){
            priority = new ArbolSplay<String>();
         
        } else if (instance == 2){
         
            priority = new AVLTree<String>(); // con numeros
        }
        else if (instance == 3){
            priority = new ArbolRojoNegro<String>();  
        }

        return priority;

    }
    
    public String traductor(EstructuraArbol<String> arbolingles, EstructuraArbol<String> arbolspan,  int opcion, String[] palabras, ArrayList<String> arregloingles, ArrayList<String> arreglosespan){
        Association<EstructuraArbol<String>, EstructuraArbol<String>>[] classesTaken = new Association[1];
        String Resultado = "";
        classesTaken[0] = new Association<EstructuraArbol<String>,EstructuraArbol<String>>(arbolingles, arbolspan);
        Resultado= traduccions(palabras ,classesTaken[0], opcion, arregloingles, arreglosespan);// ingles a span
        return Resultado;
    }
   
// System.out.println(decoration.CYAN_UNDERLINED + "1.Ingles-Español
//\n2.Español-Ingles" + decoration.RESET );
    public String traduccions(String[] palabras, Association<EstructuraArbol<String>,EstructuraArbol<String>> arbolIdioma, int opcion, ArrayList<String> arregloingles, ArrayList<String> arreglosespan){
        String traduccion = "";
    
   
        for (String palabra : palabras) {
            boolean noes = true;
            String[] lista;
            String a = "";
             //ingles a Español
            for (int i = 0; i < arregloingles.size(); i++){
                if(opcion == 1 ){
                a = arbolIdioma.getKey().get(arregloingles.get(i));
                lista = a.split(",");

                if(palabra.matches(lista[0])){
                    traduccion = traduccion + lista[1] + " "; 
                    noes = false;
                } 
            }
                if(opcion == 2){
                    a = arbolIdioma.getKey().get(arregloingles.get(i));
                    lista = a.split(",");
    
                if(palabra.matches(lista[1])){
                        traduccion = traduccion + lista[0] + " "; 
                        noes = false;
                        } 
                    
                    
                }
            

            
            
        }
        
        if (noes == true){
            traduccion = traduccion +"*" + palabra + "* ";
        }
    }
        return traduccion;
    }



    

}