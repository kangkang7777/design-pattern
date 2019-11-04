package kitchen.cooker;

import java.util.*;
import kitchen.ingredient.IngredientType;
import kitchen.ingredient.*;
/**
 * 
 */
public class Steamer extends Cooker {

    /**
     * Default constructor
     */
    public Steamer() {
        //设置优先级
        this.priority=Cooker.FIRST;
        availableTypes = new ArrayList<>(Arrays.asList(
                IngredientType.FLOUR));
        name = "蒸笼";
    }

    /**
     *
     */
    @Override
    protected void startCooking(Ingredient ingredient) {
        System.out.println("用蒸笼开始烹饪 【" + ingredient.getName() + "】 ...");
        //todo Maybe Time Tick
    }

    /**
     *
     */
    @Override
    protected void finishCooking(Ingredient ingredient) {
        ingredient.setCooked();
        FancyCut fancyCut = new FancyCut(ingredient);
        System.out.println("热气腾腾~ 【" + ingredient.getName() + "】 熟啦！");
    }

    /**
     *
     */
    @Override
    protected void startCooking(ArrayList<Ingredient> ingredientList) {
        for (Ingredient ingredient : ingredientList) {
            System.out.println("用蒸笼开始烹饪 【" + ingredient.getName() + "】 ...");
        }
        //todo Maybe Time Tick
    }

    /**
     *
     */
    @Override
    protected void finishCooking(ArrayList<Ingredient> ingredientList) {
        for (Ingredient ingredient : ingredientList) {
            ingredient.setCooked();
            FancyCut fancyCut = new FancyCut(ingredient);
            System.out.println("热气腾腾~ 【" + ingredient.getName() + "】 熟啦！");
        }
    }


    /**
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    @Override
    public void getAvailableType() {
        for (IngredientType type : availableTypes) {
            //todo undefined
        }
    }

}