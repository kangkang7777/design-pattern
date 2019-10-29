package ingredient.state
import java.util.*;

/**
 * 
 */
public interface State {

    /**
     * @param ingredient 
     * @return
     */
    public abstract boolean isCooked(Ingredient ingredient);

    /**
     * @param ingredient 
     * @return
     */
    public abstract boolean isStale(Ingredient ingredient);

}