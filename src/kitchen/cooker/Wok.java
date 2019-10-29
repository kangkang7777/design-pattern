package kitchen.cooker;

import java.util.*;

/**
 * 
 */
public class Wok extends Cooker {

    /**
     * Default constructor
     */
    public Wok() {

        //设置优先级
        this.priority=Cooker.SECOND;
       

        availableTypes = new ArrayList<>(Arrays.asList(         //todo undefined
                IngredientType.UNDEFINED));
        name = "锅";
    }

    /**
     *
     */
    @Override
    protected void startCooking(Ingredient ingredient) {
        System.out.println("用锅开始烹饪 【" + ingredient.getName() + "】 ...");
        //todo Maybe Time Tick
    }

    /**
     *
     */
    @Override
    protected void finishCooking(Ingredient ingredient) {
        ingredient.changeState(IngerdientType.COOKED);
        System.out.println("香喷喷~ 【" + ingredient.getName() + "】 熟啦！");
    }

    /**
     *
     */
    @Override
    protected void startCooking(ArrayList<Ingredient> ingredientList) {
        for (Ingredient ingredient : ingredientList) {
            System.out.println("用锅开始烹饪 【" + ingredient.getName() + "】 ...");
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
            System.out.println("香喷喷~ 【" + ingredient.getName() + "】 熟啦！");
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