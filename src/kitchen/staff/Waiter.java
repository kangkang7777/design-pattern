package kitchen.staff;

import kitchen.merch.*;
import kitchen.order.orderform.Order;
import kitchen.staff.chef.Chef;


import java.util.ArrayList;
import java.util.List;

public class Waiter implements Visitor{
    //厨师实例
    private Chef mChef;
    
    //从Order拿到的list
    private ArrayList<String> lists;

    //经Adaptor转化的dishlist
    private ArrayList<Dish> dishes;

    //订单实例
    private Order mOrder;

    private static Waiter instance = new Waiter();
    private Waiter(){
        if (instance == null) {
            instance = this;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static Waiter getInstance(){
        return instance;
    }

    //在厨师和客人类内部声明一个Waiter
    //登记厨师和订单
    public void register(Chef chef){
        mChef = chef;
        chef.setWaiter(this);
        System.out.println("厨师已登记到服务员处");
    }
    public void register(Order order){
        mOrder = order;
        order.setWaiter(this);
        System.out.println("订单已获得服务员受理");
    }

    //测试用serve函数
    public void serve(){
        if(lists != null){
            Adapter adapter = new Adapter();
            dishes = adapter.getDishes();
            System.out.println("订单开始传递给厨师");
            informChef();
        }
        else {
            System.out.println("菜单错误");
        }
    }

    //为厨师服务的方法
    //厨师做好菜后使用
    public void serve(Chef chef){
        System.out.println("服务员已经拿到菜了");
        visit(mOrder);
    }
    //为客人服务的方法
    //客人点单完成后使用
    public void serve(Order order){
         lists =  order.givemenu();
         if(lists != null) {
             Adapter adapter = new Adapter();
             dishes = adapter.getDishes();
             //此步可将订单进一步处理再传递给厨师
             System.out.println("订单开始传递给厨师");
             informChef();
         }
         else
             System.out.println("菜单有误");

    }


    public void informChef(){
        mChef.setDishes(dishes);
        System.out.println("厨师已经拿到菜单");
        /*通知厨师的方法
          或是对订单进一步处理的方法 */
    }

    /*
    * 以下两个函数为Lists的设置与获取
    * */
    public void setLists(ArrayList<String> lists) {
        this.lists = lists;
    }

    public ArrayList<String> getLists() {
        return lists;
    }

    //为了测试visit获得order
    public Order getmOrder() {
        return mOrder;
    }

    @Override
    public double visit(Dish dish) {
        System.out.println("visit " + dish.getName());
        return dish.getPrice();
    }

    @Override
    public void visit(Order order) {
        System.out.println("visit order");
        //测试waiter时注释以下部分
//        Adapter adapter = new Adapter();
//        ArrayList<Dish> dishes = adapter.getDishes();
//        for (Dish dish: dishes) {
//            mOrder.addBill(visit(dish));
//        }
//        mOrder.pay();
    }

    // @Override
    // public double visit(BoiledFish boiledFish) {
    //     System.out.println("visit " + boiledFish.getDish().getName());
    //     return boiledFish.getDish().getPrice();
    // }

    // @Override
    // public double visit(EggSoup eggSoup) {
    //     System.out.println("visit " + eggSoup.getDish().getName());
    //     return eggSoup.getDish().getPrice();
    // }

    // @Override
    // public double visit(MaboTofu maboTofu) {
    //     System.out.println("visit " + maboTofu.getDish().getName());
    //     return maboTofu.getDish().getPrice();
    // }

    // @Override
    // public double visit(SteamedBread steamedBread) {
    //     System.out.println("visit " + steamedBread.getDish().getName());
    //     return steamedBread.getDish().getPrice();
    // }

    // @Override
    // public double visit(StirFriedVegetables stirFriedVegetables) {
    //     System.out.println("visit " + stirFriedVegetables.getDish().getName());
    //     return stirFriedVegetables.getDish().getPrice();
    // }

    // /**
    //  * 服务员visit订单，获取内容并计算总价
    //  * @param order
    //  */
    // @Override
    // public void visit(Order order) {
    //     ArrayList<String> list = order.getOrderList();
    //         for (String string: list) {
    //             switch (string) {
    //                 case "BoiledFish":
    //                     totalPrice += this.visit(new BoiledFish());
    //                     break;
    //                 case "EggSoup":
    //                     totalPrice += this.visit(new EggSoup());
    //                     break;
    //                 case "MaboTofu":
    //                     totalPrice += this.visit(new MaboTofu());
    //                     break;
    //                 case "SteamedBread":
    //                     totalPrice += this.visit(new SteamedBread());
    //                     break;
    //                 case "StirFriedVegetables":
    //                     totalPrice += this.visit(new StirFriedVegetables());
    //                     break;
    //                 default:break;
    //             }
    //             double discount = order.getDiscount();
    //             System.out.println("共消费：" + totalPrice * discount + "元");
    //         }
    // }
}