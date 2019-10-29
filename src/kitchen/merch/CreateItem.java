package merch;

import staff.chef.*;
import java.util.ArrayList;

import kitchen.staff.chef.Chef;

public class CreateItem {
    private double totalprice = 0;
    public void preMerch(ArrayList<Integer> a) {
        Item item = new Item();
        for(int i=0; i<a.size(); i++){
            //判断点的是哪一道菜
            if(a.get(i) == 1) item.setbuilder(new MaboTofu());
            else if(a.get(i) == 2) item.setbuilder(new BoiledFish());
            else if(a.get(i) == 3) item.setbuilder(new EggSoup());
            else if(a.get(i) == 4) item.setbuilder(new StirFriedVegetables());
            else  item.setbuilder(new SteamedBread());
            item.createDish();
            Dish dish = item.getDish();
            totalprice += dish.getPrice();
            ArrayList<Dish> allmerch = new ArrayList<>();
            allmerch.add(dish);
            //System.out.print("你点的是:"+dish.show()+"\n");
            //processMerch(dish);
        }
        System.out.print("总价格是:"+getprice()+"元\n");
        //调用厨师包的函数进行菜品的生成
        Chef chef = Chef.getInstance();
        chef.processMerchs(allmerch);

    }
    public double getprice(){
        return totalprice;
    }
}
