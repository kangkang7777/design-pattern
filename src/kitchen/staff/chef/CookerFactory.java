package kitchen.staff.chef;

import kitchen.cooker.Cooker;
import kitchen.cooker.RiceCooker;
import kitchen.cooker.Steamer;
import kitchen.cooker.Wok;
import kitchen.merch.Dish;

public class CookerFactory {
    /**
     * 根据商品选择使用的厨具
     * @param dish 商品
     * @return Cooker 厨具
     */
    public Cooker buildCooker(Dish dish){
        if(dish.getCooker().equals("炒锅")){
            Cooker wok=new Wok();
            return wok;
        }

        if(dish.getCooker().equals("电饭煲")){
            Cooker ricCooker=new RiceCooker();
            return ricCooker;
        }
        else {
            Cooker steamer=new Steamer();
            return steamer;
        }

    }
}
