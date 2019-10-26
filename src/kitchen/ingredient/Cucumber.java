package ingredient;

import java.util.*;

/**
 * 
 */
public class Cucumber extends Ingredient {

    /**
     * Default constructor
     */
    public Cucumber() {
    }

    /**
     * @return
     */
    public String getName(){
        return("黄瓜");
    }

    /**
     * 
     */
    public IngredientType getIngredientType(){
        return IngredientType.CUCUMBER;
    }

    /**
     * 每次减0.5
     */
    public void update(){
        state -= 0.5;
    }

}