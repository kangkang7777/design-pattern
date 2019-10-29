package ingredient.state
import java.util.*;

/**
 * 
 */
public class Cooked implements State {

    /**
     * Default constructor
     */
    public Cooked() {
    }

    /**
     * @return
     */
    public String toString() {
        return "??";
    }

    /**
     * @param ingredient 
     * @return
     */
    public boolean isCooked(Ingredient ingredient){return true;}

    /**
     * @param ingredient 
     * @return
     */
    public boolean isStale(Ingredient ingredient){return false;}

}