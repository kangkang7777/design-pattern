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
     * 腐烂速度
     * 
     */
    private int staleSpeed = 1;

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
     * 时间更新，进行腐烂
     * 
     */
    public void update()
    {
        if(isState())
        {
            fresh -= staleSpeed;
            if(fresh<=0)
                setStale();
        }
    }

}