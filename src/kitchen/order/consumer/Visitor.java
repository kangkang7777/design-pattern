package order.consumer;
import merch.BoiledFish;
import merch.Dish;

import java.util.ArrayList;

public interface Visitor {
    void visit(BoiledFish boiledFish);
    void visit(Order order);
}
