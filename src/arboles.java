/*
 * The Author of this arbolbinario @Andre Jo
 */



public class arboles{



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


       
}