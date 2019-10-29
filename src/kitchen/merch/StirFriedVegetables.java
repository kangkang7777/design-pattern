package merch;

import order.consumer.Visitor;

public class StirFriedVegetables implements DishBuilder {
    private Dish ndish;

    public StirFriedVegetables(){
        this.ndish = new Dish();
    }

    @Override
    public void setName(){
        ndish.setName("炒青菜");
    }
    @Override
    public void setPack(){
        ndish.setPack("盘子");
    }
    @Override
    public void setPrice(){
        ndish.setPrice(12.6);
    }
    @Override
    public void setMaterial(){
        ndish.setMaterial("青菜");
    }
    @Override
    public void setCooker(){
        ndish.setCooker("炒锅");
    }
    @Override
    public Dish getDish(){
        return ndish;
    }
    @Override
    public void accept(Visitor visitor){
        ndish.accept(visitor);
    }
}
