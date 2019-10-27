
import java.util.*;

/**
 * 
 */
public class Stale implements State {

    /**
     * Default constructor
     */
    public Stale() {
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
    public boolean isStale(Ingredient ingredient){return true;}

}