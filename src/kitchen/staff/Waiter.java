package staff;

import merch.*;
import order.orderform.Order;
import staff.chef.Chef;

import java.util.ArrayList;
import java.util.List;

public class Waiter implements Visitor{
    private Chef mChef;
    private List<Visitor> mCustomers;
    private ArrayList<String> dishes;
    private List<Order> mOrders;
    private double totalPrice;

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

    @Override
    public double visit(BoiledFish boiledFish) {
        System.out.println("visit " + boiledFish.getDish().getName());
        return boiledFish.getDish().getPrice();
    }

    @Override
    public double visit(EggSoup eggSoup) {
        System.out.println("visit " + eggSoup.getDish().getName());
        return eggSoup.getDish().getPrice();
    }

    @Override
    public double visit(MaboTofu maboTofu) {
        System.out.println("visit " + maboTofu.getDish().getName());
        return maboTofu.getDish().getPrice();
    }

    @Override
    public double visit(SteamedBread steamedBread) {
        System.out.println("visit " + steamedBread.getDish().getName());
        return steamedBread.getDish().getPrice();
    }

    @Override
    public double visit(StirFriedVegetables stirFriedVegetables) {
        System.out.println("visit " + stirFriedVegetables.getDish().getName());
        return stirFriedVegetables.getDish().getPrice();
    }

    /**
     * 服务员visit订单，获取内容并计算总价
     * @param order
     */
    @Override
    public void visit(Order order) {
        ArrayList<String> list = order.getOrderList();
            for (String string: list) {
                switch (string) {
                    case "BoiledFish":
                        totalPrice += this.visit(new BoiledFish());
                        break;
                    case "EggSoup":
                        totalPrice += this.visit(new EggSoup());
                        break;
                    case "MaboTofu":
                        totalPrice += this.visit(new MaboTofu());
                        break;
                    case "SteamedBread":
                        totalPrice += this.visit(new SteamedBread());
                        break;
                    case "StirFriedVegetables":
                        totalPrice += this.visit(new StirFriedVegetables());
                        break;
                    default:break;
                }
                double discount = order.getDiscount();
                System.out.println("共消费：" + totalPrice * discount + "元");
            }
    }
}