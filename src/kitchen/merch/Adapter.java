package kitchen.merch;
import java.util.ArrayList;

import kitchen.staff.Waiter;
import kitchen.staff.chef.Target;
import java.util.ArrayList;

public class Adapter implements Target {
    private Waiter waiter = Waiter.getInstance();
    private ArrayList<String> list = waiter.getList();
    @Override
    public ArrayList<Dish> getDishes() {
        ArrayList<Dish> dishes = new ArrayList<>();
        for (String string: list){
            Item item = new Item();
            int flag = 1;
            switch (string){
                case "水煮鱼":
                    item.setbuilder(new BoiledFish());
                    break;
                case "鸡蛋汤":
                    item.setbuilder(new EggSoup());
                    break;
                case "麻婆豆腐":
                    item.setbuilder(new MaboTofu());
                    break;
                case "馒头":
                    item.setbuilder(new SteamedBread());
                    break;
                case "炒青菜":
                    item.setbuilder(new StirFriedVegetables());
                    break;
                default:flag = 0;
            }
            if (flag == 1){
                item.createDish();
                Dish dish = item.getDish();
                dishes.add(dish);
            }
            else {
                System.out.println("菜单有误，请检测");
                return null;
            }
        }
        return dishes;
    }
}
