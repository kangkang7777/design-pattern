package kitchen.ingredient.state;
import kitchen.ingredient.*;

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
        return "已用";
    }

    /**
     * @param ingredient 
     * @return
     */
    @Override
    public boolean isCooked(Ingredient ingredient){return true;}

    /**
     * @param ingredient 
     * @return
     */
    @Override
    public boolean isStale(Ingredient ingredient){return false;}

}