package kitchen.ingredient.state;
import kitchen.ingredient.*;

/**
 * ????
 * ???????????
 * @author ??
 */
public class Cooked implements State {

    /**
     * Default constructor
     */
    public Cooked() {
    }

    /**
     * @return ??
     */
    public String toString() {
        return "已用";
    }

    /**
     * ????
     * 
     * @param ingredient 
     * @return true
     */
    @Override
    public boolean isCooked(Ingredient ingredient){return true;}

    /**
     * ?????
     * 
     * @param ingredient 
     * @return true
     */
    @Override
    public boolean isStale(Ingredient ingredient){return false;}

}