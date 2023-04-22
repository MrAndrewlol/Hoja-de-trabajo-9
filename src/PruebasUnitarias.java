//Pruebas Unitarias
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class PruebasUnitarias {
    
    Assertation<String, String> asociacoin = new Assertation<>();
    EstructuraArbol<String> arbol = null;

    //Prueba para añadir un elemento
    @Test 
    public void addTest(){
        arbol = asociacoin.getInstance(1);
        String palabra = "SIUUUU";
        arbol.add(palabra);
        assertEquals("SIUUUU", arbol.get(palabra));
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