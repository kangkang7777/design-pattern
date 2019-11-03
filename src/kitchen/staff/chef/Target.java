package kitchen.staff.chef;

import kitchen.merch.Dish;

import java.util.ArrayList;

public interface Target {
    ArrayList<Dish> getDishes(ArrayList<String> list);
}
