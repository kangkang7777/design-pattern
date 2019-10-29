package magickitchen.merch;

import magickitchen.staff.chef.*;
import java.util.ArrayList;

public class CreateItem {
    public void preMerch(ArrayList<Integer> a) {
        Item item = new Item();
        for(int i=0; i<a.size(); i++){
            if(a.get(i) == 1) item.setbuilder(new MaboTofu());
            else if(a.get(i) == 2) item.setbuilder(new BoiledFish());
            else if(a.get(i) == 3) item.setbuilder(new EggSoup());
            else if(a.get(i) == 4) item.setbuilder(new StirFriedVegetables());
            else  item.setbuilder(new SteamedBread());
            item.createDish();
            Dish dish = item.getDish();
            //测试用
            //System.out.print("你点的是:"+dish.show()+"\n");
            //调用厨师包的函数进行菜品的生成
            Chef chef = new Chef();
            chef.processMerch(dish);
        }
    }
}
