package kitchen;

import kitchen.container.Cabinet;
import kitchen.container.Fridge;
import kitchen.ingredient.IngredientType;
import kitchen.time.Time;

/**
 *部分模块的测试请写在此Main中，标注信息并注释
 */
public class Main{
    public static void main(String[] args)
    {

    }

//这里是container与ingredient的测试
/*
    public static void main(String[] args)
    {
        Fridge fri = Fridge.getInstance();//获取冰箱单例
        Cabinet cab = Cabinet.getInstance();//获取橱柜单例
        System.out.println(fri.getName());//名字
        System.out.println(cab.getName());//名字
        fri.put(IngredientType.FLOUR,20);//冰箱放入不可放入的原料
        cab.put(IngredientType.FLOUR,20);//橱柜放入可放入的原料
        System.out.println(cab.seek(IngredientType.FLOUR));//当前可用的面粉原料数量
        cab.get(IngredientType.FLOUR,19);//橱柜取出原料
        System.out.println(cab.seek(IngredientType.FLOUR));//当前可用的面粉原料数量
        Time.getInstance().update(15);//时间流失
    }
 */
}