package ingredient;

import java.util.*;

/**
 * 
 */
public abstract class Ingredient implements TimeObserver {

    /**
     * state = 0 为变质，= -1 为用掉，其他情况为新鲜
     * 
     * Default constructor
     */
    public Ingredient() {
        state = 100;
        Time.getInstance().addObserver(this);
    }

    /**
     * 
     */
    protected int state;

    /**
     * 食材状态
     * 
     * @return 新鲜为ture，其他为false。
     */
    public boolean isState() {
        return state>0;
    }

    /**
     * 设定状态
     * 
     */
    public boolean setState(int num) {
        state = num;
    }
    
    /**
     * @return
     */
    public abstract String getName();

    /**
     * 
     */
    public abstract IngredientType getIngredientType();

    /**
     * 
     */
    public abstract void update();

}