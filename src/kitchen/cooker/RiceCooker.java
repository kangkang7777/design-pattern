package kitchen.cooker;

import java.util.*;

/**
 * 
 */
public class RiceCooker extends Cooker {

    /**
     * Default constructor
     */
    public RiceCooker() {

        //设置优先级
        this.priority=Cooker.SECOND;
       


        availableTypes = new ArrayList<>(Arrays.asList(         //todo 米饭、(水)
                IngredientType.RICE,
                IngredientType.WATER));
        name = "电饭煲";
    }

    /**
     *
     */
    @Override
    protected void startCooking(Ingredient ingredient) {
        System.out.println("用电饭煲开始烹饪 【" + ingredient.getName() + "】 ...");
        //todo Maybe Time Tick
    }

    /**
     *
     */
    @Override
    protected void finishCooking(Ingredient ingredient) {
        ingredient.changeState(IngerdientType.COOKED);
        System.out.println("热气腾腾~ 【" + ingredient.getName() + "】 熟啦！");
    }

    /**
     *
     */
    @Override
    protected void startCooking(ArrayList<Ingredient> ingredientList) {
        for (Ingredient ingredient : ingredientList) {
            System.out.println("用电饭煲开始烹饪 【" + ingredient.getName() + "】 ...");
        }
        //todo Maybe Time Tick
    }

    /**
     *
     */
    @Override
    protected void finishCooking(ArrayList<Ingredient> ingredientList) {
        for (Ingredient ingredient : ingredientList) {
            ingredient.changeState(IngerdientType.COOKED);
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