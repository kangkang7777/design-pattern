package merch;

import order.consumer.Visitor;

public class MaboTofu implements DishBuilder{
    private Dish ndish;

    public MaboTofu(){
        this.ndish = new Dish();
    }

    @Override
    public void setName(){
        ndish.setName("麻婆豆腐");
    }
    @Override
    public void setPack(){
        ndish.setPack("盘子");
    }
    @Override
    public void setPrice(){
        ndish.setPrice(19.9);
    }
    @Override
    public void setMaterial(){
        ndish.setMaterial("豆腐");
    }
    @Override
    public void setCooker(){
        ndish.setCooker("炒锅");
    }
    @Override
    public void setCount(){
        ndish.setCount(2);
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