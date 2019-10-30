package kitchen.ingredient;

/**
 * 
 */
public class Tofu extends Ingredient {

    /**
     * Default constructor
     */
    public Tofu() {
    }

    /**
     * 腐烂速度
     * 
     */
    private double staleSpeed = 0.5;

    /**
     * @return
     */
    @Override
    public String getName(){
        return("豆腐");
    }

    /**
     * 
     */
    @Override
    public IngredientType getIngredientType(){
        return IngredientType.TOFU;

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