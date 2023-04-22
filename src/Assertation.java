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
    
    public String traductor(EstructuraArbol<String> arbolingles, EstructuraArbol<String> arbolspan,  int opcion, String[] palabras){
        Association<EstructuraArbol<String>, EstructuraArbol<String>>[] classesTaken = new Association[1];
        String Resultado = "";
        classesTaken[0] = new Association<EstructuraArbol<String>,EstructuraArbol<String>>(arbolingles, arbolspan);
        Resultado= traduccions(palabras ,classesTaken[0], 1);// ingles a span
        return Resultado;
    }
   

    public String traduccions(String[] palabras, Association<EstructuraArbol<String>,EstructuraArbol<String>> arbolIdioma, int opcion){
        String traduccion = "";
        if(opcion == 1){
            

            for (String palabra : palabras) {
                String a = arbolIdioma.getKey().get(palabra);
                if(arbolIdioma.getKey().get(palabra) != null){
                    traduccion = traduccion + arbolIdioma.getKey().get(palabra) + " "; 
                } else {
                    String word =palabra;
                    String[] words = word.split(",");

                    traduccion = traduccion + palabra + " ";
                }

            }
            
        }
        else if(opcion == 2){
            for (String palabra : palabras) {
                String a = arbolIdioma.getKey().get(palabra);
                if(arbolIdioma.getKey().get(palabra) != null){
                    traduccion = traduccion + arbolIdioma.getKey().get(palabra) + " "; 
                } else {
                    String word =palabra;
                    String[] words = word.split(",");

                    traduccion = traduccion + palabra + " ";
                }

            }
            
        }

        
       
        return traduccion;
    }



    

}