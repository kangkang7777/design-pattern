package merch;

import staff.Visitor;

public class Dish {
    //商品的名字
    private String name;
    //商品的价格
    private double price;
    //商品使用的餐具
    private String pack;
    //商品的原料
    private String material;
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
    public String getCooker(){
        return cooker;
    }
    public void setCooker(String cooker) {
        this.cooker = cooker;
    }
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    //可能之后给厨师使用的接口，目前测试用
    //public String show(){
    //    return "菜名:"+getName()+" 餐具:"+getPack()+" 价格:"+getPrice()+" 原料:"+getMaterial()+" 厨具:"+getCooker();
    //}
}
