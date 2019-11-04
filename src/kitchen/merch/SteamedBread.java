package kitchen.merch;

import kitchen.staff.Visitor;

public class SteamedBread implements DishBuilder{
    private Dish ndish;

    public SteamedBread(){
        this.ndish = new Dish();
    }

    @Override
    public void setName(){
        ndish.setName("蒸馒头");
    }
    @Override
    public void setPack(){
        ndish.setPack("盘子");
    }
    @Override
    public void setPrice(){
        ndish.setPrice(1.5);
    }
    @Override
    public void setMaterial(){
        ndish.setMaterial("面粉");
    }
    @Override
    public void setCooker(){
        ndish.setCooker("蒸笼");
    }
    @Override
    public void setCount(){
        ndish.setCount(1);
    }
    @Override
    public Dish getDish(){
        return ndish;
    }
    @Override
    public void accept(Visitor visitor){
        this.getDish().accept(visitor);
    }
}
