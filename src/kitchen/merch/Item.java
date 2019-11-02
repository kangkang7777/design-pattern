package merch;

public class Item {

    private DishBuilder ndish;
    //判断产生何种菜品
    public void setbuilder(DishBuilder dish) {
        this.ndish = dish;
    }
    //产生菜品
    public void createDish(){
        ndish.setName();
        ndish.setPack();
        ndish.setPrice();
        ndish.setCooker();
        ndish.setMaterial();
    }
    //生成菜品以后获取菜品
    public Dish getDish(){
        return ndish.getDish();
    }

}

