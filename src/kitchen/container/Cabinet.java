package kitchen.container;

import kitchen.ingredient.IngredientType;

import java.util.*;

/**
 * 
 */
public class Cabinet extends Container {

    /**
     * Default constructor
     */
    public Cabinet() {
        if (instance == null) {
            instance = this;
            availableTypes = new ArrayList<>(Arrays.asList(
                    IngredientType.VEGETABLES,
                    IngredientType.FLOUR,
                    IngredientType.EGG));
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * 
     */
    private static Cabinet instance;

    /**
     * @return instance
     */
    public static synchronized Cabinet getInstance() {
        if (instance == null) {
            instance = new Cabinet();
        }
        return instance;
    }

    /**
     * @return
     */
    @Override
    public String getName()
    {
        return("橱柜");
    }
}