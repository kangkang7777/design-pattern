package kitchen.container;

import kitchen.ingredient.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 容器迭代器类
 * 
 * 
 * @author 谢康
 */
public class ContainerIterator implements Iterator<Ingredient>{


    /**
     * 存储已有原料
     */
    private ArrayList<Ingredient> ingredients;

    /**
     * 序列指针
     */
    private int index;

    /**
     * 构造函数
     * @param ingredients 传入的列表
     */
    public ContainerIterator(ArrayList<Ingredient> ingredients) {
       this.ingredients = ingredients;
       index = 0;
    }

    /**
     * 判断迭代器是否到达尾部
     * 
     * @return 是否已满，是false，否true
     */
    public boolean hasNext() {
        return index < ingredients.size();
    }

    /**
     * 获得下一个数据
     * 
     * @return 此数据
     */
    public Ingredient next() {
        return ingredients.get(index++);
    }

}
