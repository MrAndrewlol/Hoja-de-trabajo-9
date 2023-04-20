import structure5.Association;


public class Assertation<K, V> {
    
    public String traductor(arbolbinario arbolingles, arbolbinario arbolspan, int opcion, String[] palabras){
        Association<arbolbinario, arbolbinario>[] classesTaken = new Association[4];
        String Resultado = "";
        classesTaken[0] = new Association<arbolbinario,arbolbinario>(arbolingles, arbolspan);
        classesTaken[1] = new Association<arbolbinario,arbolbinario>(arbolspan, arbolingles);
        



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
   

    public String traduccions(String[] palabras, Association<arbolbinario,arbolbinario> arbolIdioma, int opcion){
        String traduccion = "";
            for (String palabra : palabras) {
                if(arbolIdioma.getKey().getNode(palabra).contains("*")){
                    traduccion = traduccion + arbolIdioma.getKey().getNode(palabra) + " "; 
                } else {
                    String word = arbolIdioma.getKey().getNode(palabra);
                    String[] words = word.split(",");

                    traduccion = traduccion + words[opcion] + " ";
                }

            }
       
        return traduccion;
    }



    

}