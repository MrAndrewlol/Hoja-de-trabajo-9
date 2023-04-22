import structure5.Association;


/*
 * The Author of this  @Andre Jo
 */



public class Assertation<K, V> {

    public EstructuraArbol<String> getInstance(int instance) {
        EstructuraArbol<String> priority = null;

        if (instance == 1){
            priority = new ArbolRojoNegro<String>();  
         
        } else if (instance == 2){
            priority = new ArbolSplay<String>();
        }
        else if (instance == 3){
            priority = new AVLTree<String>(); // con numeros
        }

        return priority;

    }
    
    public String traductor(EstructuraArbol<String> arbolingles, EstructuraArbol<String> arbolspan, int opcion, String[] palabras){
        Association<EstructuraArbol<String>, EstructuraArbol<String>>[] classesTaken = new Association[2];
        String Resultado = "";
        classesTaken[0] = new Association<EstructuraArbol<String>,EstructuraArbol<String>>(arbolingles, arbolspan);
        classesTaken[1] = new Association<EstructuraArbol<String>,EstructuraArbol<String>>(arbolspan, arbolingles);
        



        switch(opcion-1){
            case 0:{
                Resultado= traduccions(palabras ,classesTaken[0], 1);// ingles a span

                break;
            }
            case 2:{
                Resultado= traduccions(palabras ,classesTaken[2], 1); //span a ingles

                break;
            }
            case 6:{
                 //span a ingles
                System.out.println("Spanish a Ingles "+traduccions(palabras ,classesTaken[1], 1));
                System.out.println("Ingles a Spanish "+traduccions(palabras ,classesTaken[0], 1));
                

            }

        }
        return Resultado;
    }
   

    public String traduccions(String[] palabras, Association<EstructuraArbol<String>,EstructuraArbol<String>> arbolIdioma, int opcion){
        String traduccion = "";
            for (String palabra : palabras) {
                if(arbolIdioma.getKey().get(palabra).contains("*")){
                    traduccion = traduccion + arbolIdioma.getKey().get(palabra) + " "; 
                } else {
                    String word = arbolIdioma.getKey().get(palabra);
                    String[] words = word.split(",");

                    traduccion = traduccion + words[opcion] + " ";
                }

            }
       
        return traduccion;
    }



    

}