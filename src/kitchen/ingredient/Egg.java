package ingredient;

import java.util.*;

/**
 * 
 */
public class Egg extends Ingredient {

    /**
     * Default constructor
     */
    public Egg() {
    }

    /**
     * @return
     */
    public String getName(){
        return("鸡蛋");
    }

    /**
     * 
     */
    public IngredientType getIngredientType(){
        return IngredientType.EGG;

    }

    /**
     * 每次减1
     */
    public void update()
    {
        state -= 1;
    }

}