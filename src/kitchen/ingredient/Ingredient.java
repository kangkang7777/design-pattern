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
        fresh = 100;
        state = new Fresh();
        Time.getInstance().addObserver(this);
    }

    /**
     * 新鲜度
     * 
     */
    protected int fresh;

    /**
     * 食材状态
     * 
     */
    protected State state;

    /**
     * 是否可用
     * 
     * @return 新鲜为ture，其他为false。
     */
    public boolean isState() {
        return !(state.isStale(this) || state.isCooked(this));
    }

    /**
     * 设定已用
     * 
     */
    public void setCooked() {
        state = new Cooked();
    }

    /**
     * 设定腐烂
     * 
     */
    public void setStale() {
        state = new Stale();
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