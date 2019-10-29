package staff;

import merch.*;
import order.*;//引入订单类
import order.consumer.Visitor;
import staff.chef.Chef;

import java.util.ArrayList;
import java.util.List;

public class Waiter{
    private Chef mChef;
    private List<Visitor> mCustomers;
    private ArrayList<String> dishes;
    private List<Order> mOrders;
    private double totalPrice = 0;

    //在厨师和客人类内部声明一个Waiter
    //登记厨师和客人
    public void register(Chef chef){
        mChef = chef;
        chef.setWaiter(this);
    }
    public void register(Visitor customer){
        mCustomers.add(customer);
        customer.setWaiter(this);
    }

    //为厨师服务的方法
    //厨师做好菜后使用
    public void serve(Chef chef){
        
    }
    //为客人服务的方法
    //客人点单完成后使用
    public void serve(Visitor visitor){
        Order order = customer.getOrder();
        mOrders.add(order);

        //此步可将订单进一步处理再传递给厨师
        informChef(order);
    }

    public void informChef(Order order){
        /*通知厨师的方法
          或是对订单进一步处理的方法 */
    }

    /**
     * 顾客点菜
     * @param dish
     */
    public void attach(String dish){
        dishes.add(dish);
    }
    public void detach(String dish){
        if (dishes.indexOf(dish) != -1){
            dishes.remove(dish);
        }
    }

    /**
     * 顾客选菜的操作可以看作Visitor模式
     * @param visitor 顾客
     */
    public void accept(Visitor visitor){
        for (String dish:dishes){
            switch (dish){
                case "BoiledFish":
                    BoiledFish boiledFish = new BoiledFish();
                    boiledFish.accept(visitor);
                    totalPrice += boiledFish.getDish().getPrice();
                    break;
                case "EggSoup":
                    EggSoup eggSoup = new EggSoup();
                    eggSoup.accept(visitor);
                    totalPrice += eggSoup.getDish().getPrice();
                    break;
                case "MaboTofu":
                    MaboTofu maboTofu = new MaboTofu();
                    maboTofu.accept(visitor);
                    totalPrice += maboTofu.getDish().getPrice();
                    break;
                case "SteamedBread":
                    SteamedBread steamedBread = new SteamedBread();
                    steamedBread.accept(visitor);
                    totalPrice += steamedBread.getDish().getPrice();
                    break;
                case "StirFriedVegetables":
                    StirFriedVegetables stirFriedVegetables = new StirFriedVegetables();
                    stirFriedVegetables.accept(visitor);
                    totalPrice += stirFriedVegetables.getDish().getPrice();
                    break;
                default:break;
            }
        }
        System.out.println("totalPrice:" + totalPrice);
    }

    /**
     * 返回点单
     * @return 一个String list
     */
    public ArrayList<String> getOrder(){
        return dishes;
    }
}