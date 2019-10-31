package staff;
import merch.*;

import java.util.ArrayList;

public interface Visitor {
    double visit(BoiledFish boiledFish);
    double visit(EggSoup eggSoup);
    double visit(MaboTofu maboTofu);
    double visit(SteamedBread steamedBread);
    double visit(StirFriedVegetables stirFriedVegetables);
    void visit(Order order);
}
