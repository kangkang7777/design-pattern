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
             //此步可将订单进一步处理再传递给厨师，测试visitor的时候注释掉
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
    public void visit(Dish dish) {
        System.out.println("visit " + dish.getName() + ":" + dish.getPrice() + "元");
    }

    @Override
    public void visit(Order order) {
        System.out.println("visit order");
        //测试waiter时注释以下部分
        for (Dish dish: dishes) {
            this.visit(dish);
            mOrder.addBill(dish.getPrice());
        }
        mOrder.pay();
    }

    //测试时用
    /*public ArrayList<Dish> getDishes(){
        return dishes;
    }*/
}