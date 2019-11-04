package kitchen.staff;
import kitchen.merch.*;
import kitchen.order.orderform.Order;

import java.util.ArrayList;

public interface Visitor {
    void visit(Dish dish);
    void visit(Order order);
}
