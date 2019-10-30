package kitchen.ingredient;

/**
 * 
 */
public class Fish extends Ingredient {

    /**
     * Default constructor
     */
    public Fish() {
    }

    /**
     * 腐烂速度
     * 
     */
    private double staleSpeed = 1;

    /**
     * @return
     */
    @Override
    public String getName(){
        return("鱼");
    }

    /**
     * 
     */
    @Override
    public IngredientType getIngredientType(){
        return IngredientType.FISH;
    }

    /**
     * 时间更新，进行腐烂
     * 
     */
    @Override
    public void update(){
        if(isState())
        {
            fresh -= staleSpeed;
            if(fresh<=0)
                setStale();
        }
    }

}