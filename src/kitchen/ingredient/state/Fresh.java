package kitchen.ingredient.state;
import kitchen.ingredient.*;

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
        return "新鲜";
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
    public boolean isStale(Ingredient ingredient){return false;}

}