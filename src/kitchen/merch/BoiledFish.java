package merch;

import staff.Visitor;

public class BoiledFish implements DishBuilder{
    private Dish ndish;

    public BoiledFish(){
        this.ndish = new Dish();
    }

    @Override
    public void setName(){
        ndish.setName("水煮鱼");
    }
    @Override
    public void setPack(){
        ndish.setPack("汤碗");
    }
    @Override
    public void setPrice(){
        ndish.setPrice(38.8);
    }
    @Override
    public void setMaterial(){
        ndish.setMaterial("鱼");
    }
    @Override
    public void setCooker(){
        ndish.setCooker("电饭煲");
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
        visitor.visit(this);
    }
}
