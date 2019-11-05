package kitchen.staff;

import kitchen.merch.*;
import kitchen.order.orderform.Order;
import kitchen.staff.chef.Chef;

import java.util.ArrayList;

public class RealWaiter implements WaiterInterface {
    //厨师实例
    private Chef mChef;

    //lists
    private ArrayList<String> lists;

    //经Adaptor转化的dishlist
    private ArrayList<Dish> dishes;

    //订单实例
    private Order mOrder;

    //测试时从Waiter拿数据
    private  Waiter mWaiter = Waiter.getInstance();

    private static RealWaiter instance = new RealWaiter();
    private RealWaiter(){
        if (instance == null) {
            instance = this;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static RealWaiter getInstance(){
        return instance;
    }


//    public void serve(){
//        lists = mWaiter.getLists();
//        if(lists != null){
//            Adapter adapter = new Adapter();
//            dishes = adapter.getDishes();
//            System.out.println("订单开始传递给厨师");
//            informChef();
//        }
//        else {
//            System.out.println("菜单错误");
//        }
//    }

    //为厨师服务的方法
    //厨师做好菜后使用
    @Override
    public void serve(Chef chef){
        System.out.println("服务员已经拿到菜了");
    }
    //为客人服务的方法
    //客人点单完成后使用
    @Override
    public void serve(Order order){
        //正常使用时启用，测试Waiter时注释这行
        lists =  order.givemenu();

        //测试Waiter时启用，正常使用时注释下三行
//        System.out.println("real success");
//        if(mWaiter==null)System.out.println("null");
//        ArrayList<String>lists = mWaiter.getLists();

        if(lists != null) {
            mWaiter.setLists(lists);
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


    public Chef getmChef() {
        return mChef;
    }

    public void setmChef(Chef mChef) {
        this.mChef = mChef;
    }

    public Order getmOrder() {
        return mOrder;
    }

    public void setmOrder(Order mOrder) {
        this.mOrder = mOrder;
    }

    public ArrayList<String> getLists() {
        return lists;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setmWaiter(Waiter mWaiter) {
        this.mWaiter = mWaiter;
    }
}
