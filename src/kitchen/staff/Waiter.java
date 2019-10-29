package staff;

import merch.Dish;
import order.*;//引入订单类
import order.consumer.Visitor;
import staff.chef;

import java.util.ArrayList;
import java.util.List;

public class Waiter{
    private Chef mChef;
    private List<Customer> mCustomers;
    private ArrayList<Dish> dishes;
    private List<Order> mOrders;

    //在厨师和客人类内部声明一个Waiter
    //登记厨师和客人
    public void register(Chef chef){
        mChef = chef;
        chef.setWaiter(this);
    }
    public void register(Customer customer){
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

    public void attach(Object object){
        dishes.add(object);
    }
    public void detach(Dish dish){
        if (dishes.indexOf(dish) != -1){
            dishes.remove(dish);
        }
    }
    public void accept(Visitor visitor){
        for (Dish dish:dishes){
            dish.accept(visitor);

        }
    }
}