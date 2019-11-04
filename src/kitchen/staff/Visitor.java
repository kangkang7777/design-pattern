package kitchen.staff;
import kitchen.merch.*;
import kitchen.order.orderform.Order;

import java.util.ArrayList;

public interface Visitor {
    void visit(Dish dish);
    void visit(Order order);
    /*@Override
    public void visit(Dish dish) {
        System.out.println("visit " + dish.getName() + " " + s + dish.getPrice() + "元");
    }
    @Override
    public void visit(ArrayList<String> list) {
        System.out.println("visit order");
        for (Dish dish: dishes) {
            dish.accept(this);
            mOrder.addBill(dish.getPrice());
        }
        mOrder.pay();
    }*/
    //这里测试适配器和访问者
    /*public void main(String[] args){

    }*/
}
