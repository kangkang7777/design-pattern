package container;

import java.util.ArrayList;

import ingredient.Cucumber;
import ingredient.Egg;
import ingredient.Ingredient;
import ingredient.IngredientType;

/**
 * 
 */
public abstract class Container {

    /**
     * 
     */
    protected ArrayList<Ingredient> ingredients = new ArrayList<>();

    /**
     * Default constructor
     */
    public Container() {

    }

    /**
     * 放入食材
     * 
     * @param ingredient 放入食材的实例
     */
    public void put(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    /**
     * 放入食材重载，根据参数生成实例
     * 
     * @param type 食材种类
     * @param count 此食材数量
     */
    public void put(IngredientType type, int count) {
        // 这里可以改写abstrace factory
        if(type == IngredientType.CUCUMBER)
        {
            while(count>0)
            {
                ingredients.add(new Cucumber());
                count--;
            }
        }
        else if(type == IngredientType.EGG)
        {
            while(count>0)
            {
                ingredients.add(new Egg());
                count--;
            }
        }

    }

    /**
     * 消耗食材
     * 
     * @param type 食材种类
     * @param count 此种食材合格数
     * @return 此容器含有超过此数量的此食材，返回ture，其他返回false。
     */
    public boolean get(IngredientType type, int count) 
    {
        int ans = 0;
        ArrayList<Ingredient> temp = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getIngredientType() == type) {
                temp.add(ingredient);
                ans++;
            }
        }
        if(ans>=count)
        {
            while(count>0)
            {
                count--;
                temp.get(count).setState(-1);
            }
            return true;
        }
        else
            return false;
    }

    /**
     * 查找食材
     * 
     * @param type 食材种类
     * @return 存在此种食材返回ture，否则反回false。
     */
    public int seek(IngredientType type) {
        int ans = 0;
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getIngredientType() == type) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * @return
     */
    public abstract String getName();

}