
import java.util.*;

/**
 * 
 */
public class ContainerIterator {


    /**
     * 
     */
    private ArrayList<Ingredient> ingredients;

    /**
     * 
     */
    private int index;

    /**
     * @param ingredients
     */
    public ContainerIterator(ArrayList<Ingredient> ingredients) {
       this.ingredients = ingredients;
       index = 0;
    }

    /**
     * @return
     */
    public boolean hasNext() {
        return index < ingredients.size();
    }

    /**
     * @return
     */
    public Ingredient next() {
        return ingredients.get(index++);
    }

}