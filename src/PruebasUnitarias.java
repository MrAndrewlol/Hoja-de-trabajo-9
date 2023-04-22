//Pruebas Unitarias
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class PruebasUnitarias {
    
    Assertation<String, String> asociacoin = new Assertation<>();
    EstructuraArbol<String> arbol = null;
    EstructuraArbol<String> arbolin = null;

    //Prueba para añadir un elemento
    @Test 
    public void addTest(){
        arbol = asociacoin.getInstance(1);
        String palabra = "SIUUUU";
        arbol.add(palabra);
        assertEquals("SIUUUU", arbol.get(palabra));
    }


  

    //Prueba traduccion
    @Test
    public void encontrar() {
        arbol = asociacoin.getInstance(2);
        arbolin = asociacoin.getInstance(2);
       
        
        
        arbolin.add("house,casa");
        arbol.add("casa,house");
        

        assertEquals("house,casa",  arbolin.get("house,casa"));
    }
    
}