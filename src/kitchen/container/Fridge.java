package kitchen.container;

import kitchen.ingredient.IngredientType;

import java.util.*;

/**
 * 
 */
public class Fridge extends Container {

    /**
     * Default constructor
     */
    public Fridge() {
        if (instance == null) {
            instance = this;
            availableTypes = new ArrayList<>(Arrays.asList(
                    IngredientType.TOFU,
                    IngredientType.FISH));
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * 
     */
    private static Fridge instance;

    /**
     * @return instance
     */
    public static synchronized Fridge getInstance() {
        if (instance == null) {
            instance = new Fridge();
        }
        return instance;
    }

    /**
     * @return
     */
    @Override
    public String getName()
    {
        return("冰箱");
    }

}