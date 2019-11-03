package kitchen.merch;

import kitchen.staff.Visitor;

public interface DishBuilder {
    //创建一个抽象的菜品生成过程的Builder类
    void setName();
    void setPack();
    void setPrice();
    void setMaterial();
    void setCooker();
    void setCount();
    Dish getDish();
    void accept(Visitor visitor);
}
