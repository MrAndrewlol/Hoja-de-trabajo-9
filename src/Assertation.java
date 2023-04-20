import structure5.Association;


public class Assertation<K, V> {
    
    public String traductor(arbolbinario arbolingles, arbolbinario arbolspan, arbolbinario arbolfrance, int opcion, String[] palabras){
        Association<arbolbinario, arbolbinario>[] classesTaken = new Association[6];
        String Resultado = "";
        classesTaken[0] = new Association<arbolbinario,arbolbinario>(arbolingles, arbolspan);
        classesTaken[1] = new Association<arbolbinario,arbolbinario>(arbolingles, arbolfrance);
        classesTaken[2] = new Association<arbolbinario,arbolbinario>(arbolspan, arbolingles);
        classesTaken[3] = new Association<arbolbinario,arbolbinario>(arbolspan, arbolfrance);
        classesTaken[4] = new Association<arbolbinario,arbolbinario>(arbolfrance, arbolingles);
        classesTaken[5] = new Association<arbolbinario,arbolbinario>(arbolfrance, arbolspan);



        switch(opcion-1){
            case 0:{
                Resultado= traduccions(palabras ,classesTaken[0], 1);// ingles a span

                break;
            }
            case 1:{
                Resultado= traduccions(palabras ,classesTaken[1], 2); //ingles a frances

                break;
            }
            case 2:{
                Resultado= traduccions(palabras ,classesTaken[2], 1); //span a ingles

                break;
            }
            case 3:{
                Resultado = traduccions(palabras ,classesTaken[3], 2); //span a france

                break;
            }
            case 4:{
                Resultado = traduccions(palabras ,classesTaken[4], 1);// Frances a ingles

                break;
            }
            case 5:{
                Resultado = traduccions(palabras ,classesTaken[5], 2); //Frances a span

                break;
            }
            case 6:{
                 //span a ingles
                System.out.println("Spanish a Ingles "+traduccions(palabras ,classesTaken[2], 1));
                System.out.println("Spanish a Frances "+traduccions(palabras ,classesTaken[3], 2));
                System.out.println("Ingles a Spanish "+traduccions(palabras ,classesTaken[0], 1));
                System.out.println("Ingles a Frances "+traduccions(palabras ,classesTaken[1], 2));
                System.out.println("Frances a Ingles "+traduccions(palabras ,classesTaken[4], 1));
                System.out.println("Frances a Spanish "+traduccions(palabras ,classesTaken[5], 2));
                

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