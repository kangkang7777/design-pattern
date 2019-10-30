package kitchen.ingredient;

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
    private double staleSpeed = 1;

    /**
     * @return
     */
    @Override
    public String getName(){
        return("鸡蛋");
    }

    /**
     * 
     */
    @Override
    public IngredientType getIngredientType(){
        return IngredientType.EGG;
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