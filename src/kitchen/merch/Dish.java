package kitchen.merch;

import kitchen.staff.Visitor;

public class Dish {
    //商品的名字
    private String name;
    //商品的价格
    private double price;
    //商品使用的餐具
    private String pack;
    //商品的原料和需求的数量
    private String material;
    private int count;
    //商品使用的厨具
    private String cooker;
    //创建和调用的函数
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPack(){
        return pack;
    }
    public void setPack(String pack){
        this.pack = pack;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getMaterial(){
        return material;
    }
    public void setMaterial(String material){
        this.material = material;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }
    public String getCooker(){
        return cooker;
    }
    public void setCooker(String cooker) {
        this.cooker = cooker;
    }
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
