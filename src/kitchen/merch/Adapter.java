package merch;

import staff.chef.Target;
import java.util.ArrayList;

public class Adapter implements Target {
    @Override
    public ArrayList<Dish> getDishes(ArrayList<String> list) {
        ArrayList<Dish> dishes = new ArrayList<>();
        for (String string: list){
            Item item = new Item();
            int flag = 1;
            switch (string){
                case "BoiledFish":
                    item.setbuilder(new BoiledFish());
                    break;
                case "EggSoup":
                    item.setbuilder(new EggSoup());
                    break;
                case "MaboTofu":
                    item.setbuilder(new MaboTofu());
                    break;
                case "SteamedBread":
                    item.setbuilder(new SteamedBread());
                    break;
                case "StirFriedVegetables":
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
