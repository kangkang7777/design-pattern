
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
        // TODO implement here
        return "熟";
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
    public abstract boolean isStale(Ingredient ingredient){return false;}

}