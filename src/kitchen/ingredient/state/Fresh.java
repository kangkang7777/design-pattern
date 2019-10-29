package ingredient.state
import java.util.*;

/**
 * 
 */
public class Fresh implements State {

    /**
     * Default constructor
     */
    public Fresh() {
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
    public boolean isCooked(Ingredient ingredient){return false;}

    /**
     * @param ingredient 
     * @return
     */
    public boolean isStale(Ingredient ingredient){return false;}

}