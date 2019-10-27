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
     * 腐烂速度
     * 
     */
    private int staleSpeed = 0.5;

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
     * 时间更新，进行腐烂
     * 
     */
    public void update(){
        if(isState())
        {
            fresh -= staleSpeed;
            if(fresh<=0)
                setStale();
        }
    }

}