package merch;

import staff.Visitor;

public class EggSoup implements DishBuilder{
    private Dish ndish;

    public EggSoup(){
        this.ndish = new Dish();
    }

    @Override
    public void setName(){
        ndish.setName("鸡蛋汤");
    }
    @Override
    public void setPack(){
        ndish.setPack("汤碗");
    }
    @Override
    public void setPrice(){
        ndish.setPrice(28.8);
    }
    @Override
    public void setMaterial(){
        ndish.setMaterial("鸡蛋");
    }
    @Override
    public void setCooker(){
        ndish.setCooker("电饭煲");
    }
    @Override
    public void setCount(){
        ndish.setCount(4);
    }
    @Override
    public Dish getDish(){
        return ndish;
    }
    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);;
    }
}
