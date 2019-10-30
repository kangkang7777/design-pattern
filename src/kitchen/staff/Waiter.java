package staff;

import merch.*;
import order.*;//引入订单类
import order.consumer.Visitor;
import staff.chef.Chef;

import java.util.ArrayList;
import java.util.List;

public class Waiter implements Visitor{
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
     * visit一个菜，显示菜名以及价格
     * @param dish 被访问的菜品
     */
    @Override
    public void visit(Dish dish) {
        System.out.println("visit" + dish.getName());
        System.out.println(dish.getName() + "的价格是" + dish.getPrice());
    }
    public void visit(Order order){

    }
}