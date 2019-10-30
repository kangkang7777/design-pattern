package kitchen.ingredient;

/**
 * 
 */
public class Vegetables extends Ingredient {

    /**
     * Default constructor
     */
    public Vegetables() {
    }

    /**
     * 腐烂速度
     * 
     */
    private double staleSpeed = 0.3;

    /**
     * @return
     */
    @Override
    public String getName(){
        return("青菜");
    }

    /**
     * 
     */
    @Override
    public IngredientType getIngredientType(){
        return IngredientType.VEGETABLES;

    }

    /**
     * 时间更新，进行腐烂
     * 
     */
    @Override
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