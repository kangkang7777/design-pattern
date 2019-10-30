package kitchen.ingredient;

/**
 * 
 */
public class Flour extends Ingredient {

    /**
     * Default constructor
     */
    public Flour() {
    }

    /**
     * 腐烂速度
     * 
     */
    private double staleSpeed = 0.1;

    /**
     * @return
     */
    @Override
    public String getName(){
        return("面粉");
    }

    /**
     * 
     */
    @Override
    public IngredientType getIngredientType(){
        return IngredientType.FLOUR;
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