package magickitchen.merch;

import order.consumer.Consumer;

public interface DishBuilder {
    //创建一个抽象的菜品生成过程的Builder类
    void setName();
    void setPack();
    void setPrice();
    void setMaterial();
    void setCooker();
    Dish getDish();
    void provide(Consumer consumer);
}
