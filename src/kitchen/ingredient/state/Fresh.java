
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
        // TODO implement here
        return "新鲜";
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