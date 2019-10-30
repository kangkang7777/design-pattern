package kitchen.ingredient.state;
import kitchen.ingredient.*;

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
        return "腐烂";
    }

    /**
     * @param ingredient 
     * @return
     */
    @Override
    public boolean isCooked(Ingredient ingredient){return false;}

    /**
     * @param ingredient 
     * @return
     */
    @Override
    public boolean isStale(Ingredient ingredient){return true;}

}