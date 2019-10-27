package magickitchen.merch;

public interface DishBuilder {
    void setName();
    void setPack();
    void setPrice();
    void setMaterial();
    void setCooker();
    Dish getDish();
}
