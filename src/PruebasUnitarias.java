//Pruebas Unitarias
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class PruebasUnitarias {

    arbolbinario arbolspan = new arbolbinario();
    arbolbinario arbolin = new arbolbinario();
    arbolbinario arbolrance = new arbolbinario();
    Assertation<arbolbinario, arbolbinario> asociacoin = new Assertation<>();

    //Prueba para añadir un elemento
    @Test 
    public void addTest(){
        String palabra = "SIUUUU";
        arbolspan.add(palabra);
        assertEquals("SIUUUU", arbolspan.getNode(palabra));
    }

    //Prueba para buscar un elemento
    @Test
    public void searchTest() {
        arbolspan.add("CR7");
        arbolspan.add("Cristiano");
        arbolspan.add("Ronaldo");
        arbolspan.add("SIUUUUU");

        assertEquals(true, arbolspan.containsNode("SIUUUUU"));
    }

    //Prueba para obtener un elemento del árbol
    @Test 
    public void getTest() {
        arbolin.add("chien");
        assertEquals("chien", arbolin.getNode("chien"));
    }

  

    //Prueba traduccion
    @Test
    public void traductortest() {
        String oracion = "La casa";
        String[] words = oracion.split(" ");
        
        arbolin.add("house,casa");
        arbolspan.add("casa,house");

        assertEquals("*La* *casa* ", asociacoin.traductor(arbolin, arbolspan,1 , words));
    }
    
}