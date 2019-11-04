package kitchen.staff;

import kitchen.order.orderform.Order;
import kitchen.staff.chef.Chef;

public interface WaiterInterface {
    void serve(Order order);
    void serve(Chef chef);
}
