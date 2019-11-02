package staff;
import merch.*;

import java.util.ArrayList;

public interface Visitor {
    double visit(Dish dish);
    void visit(Order order);
}
