package magickitchen.merch;

public class Item {
    private DishBuilder ndish;

    public void setbuilder(DishBuilder dish) {
        this.ndish = dish;
    }
    public void createDish(){
        ndish.setName();
        ndish.setPack();
        ndish.setPrice();
        ndish.setCooker();
        ndish.setMaterial();
    }
    public Dish getDish(){
        return ndish.getDish();
    }

}
