package cooker;

import java.util.ArrayList;
//todo import ingredient package here

/**
 * 
 */
public abstract class Cooker {

    /**
     * Default constructor
     */
    public Cooker() {
    }

    /**
     * 
     */
    protected ArrayList<IngredientType> availableTypes;

    /**
     * 
     */
    protected String name;

    /**
     * @param type 
     * @return
     */
    private boolean isIngredientTypeAvailable(IngredientType type) {
        return availableTypes.contains(type);
    }

    /**
     * @param typeList 
     * @return
     */
    private boolean isIngredientTypeAvailable(ArrayList<IngredientType> typeList) {
        for (IngredientType itype:typeList) {
            if(!availableTypes.contains(itype))return false;
        }
        return true;
    }

    /**
     * @param ingredient 
     * @return
     */
    public final void cook(Ingredient ingredient) {
        if(!isIngredientTypeAvailable(ingredient.getIngredientType())){
            System.out.println("不能用该厨具烹饪该食材！");
            return;
        }
        startCooking(ingredient);
        finishCooking(ingredient);
    }

    /**
     * @param ingredientList 
     * @return
     */
    public final void cook(ArrayList<Ingredient> ingredientList) {
        for (Ingredient ingredient:ingredientList) {
            if(!isIngredientTypeAvailable(ingredient.getIngredientType())){
                System.out.println("不能用该厨具烹饪这些食材！");
                return;
            }
        }
        startCooking(ingredientList);
        finishCooking(ingredientList);
    }

    /**
     *
     */
    protected abstract void startCooking(Ingredient ingredient);

    /**
     *
     */
    protected abstract void finishCooking(Ingredient ingredient);

    /**
     *
     */
    protected abstract void startCooking(ArrayList<Ingredient> ingredientList);

    /**
     *
     */
    protected abstract void finishCooking(ArrayList<Ingredient> ingredientList);

    /**
     * @return
     */
    public abstract String getName();

    /**
     * @return
     */
    public abstract void getAvailableType();

}