package kitchen.staff.chef;
import ingredient.*;

import java.util.ArrayList;

import container.*;
import container.Fridge;
import magickitchen.merch.Dish;
import kitchen.cooker.*;

public class Chef{
    /**
     * Chef的成员变量，接收厨师所要处理的
     * 商品和进行烹饪时所使用的厨具
     */
    protected ArrayList<Cooker>cooker=new ArrayList<>();
    protected ArrayList<Dish>dishs=new ArrayList<>();

    /**
     * Default constructor
     */
    public Chef() {
        if (instance == null) {
            instance = this;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * 
     */
    private static Chef instance;

    /**
     * @return instance
     */
    public static synchronized Chef getInstance() {
        if (instance == null) {
            instance = new Chef();
        }
        return instance;
    }


    /**
    * 根据商品参数material，转换成IngredientType
    * 根据商品类型进行拓展
    * @param dish
    * @return IngredientType
    */
    private IngredientType transferToIngredientType(Dish dish){
        IngredientType type;
        if(dish.getMaterial().equals("黄瓜")){
            type=IngredientType.CUCUMBER;
        }
        if(dish.getMaterial().equals("鸡蛋")){
            type=IngredientType.EGG;
        }
        return type;
    }

    /**
    * 根据商品参数material，转换成Ingredient
    * 根据商品类型进行拓展
    * @param dish
    * @return Ingredient
    */
    private Ingredient transferToIngredient(Dish dish){
        Ingredient ingredient;
        if(dish.getMaterial().equals("黄瓜")){
            ingredient=new Cucumber();            
        }
        if(dish.getMaterial().equals("鸡蛋")){
            ingredient=new Egg();     
        }
        return ingredient;
    }

    /**
     * 判断原料存在的容器类型，调用容器的
     * seek（）函数，根据原料找容器，返回
     * int类型
     * @param type 原材料类型
     * @return int 
     * 1: 原料在橱柜中
     * 2：原料在冰箱中
     * 0：原料不存在
     */
    private int hasIngredient(IngredientType type){
        if(Cabinet.getInstance().seek(type))
        {
            System.out.println(""+type.toString()+"在橱柜中");
            return 1;
        }
        if(Fridge.getInstance().seek(type))
        {
            System.out.println(""+type.toString()+"在冰箱中");
            return 2;
        }
        else{
            System.out.println(""+type.toString()+"不存在");
            return 0;
        }     
    }

    /**
    * 根据hasIngredient()返回数据生成容器单例
    * @param dish
    * @return Container
    */
    public Container seletedContainer(Dish dish){
    Chef chef=Chef.getInstance();
    IngredientType type=chef.transferToIngredientType(dish);
    if(chef.hasIngredient(type)==1){
        Container cabinet=Cabinet.getInstance();
        return cabinet;
    }
    if(chef.hasIngredient(type)==2){
        Container fridge=Fridge.getInstance();
        return fridge;
    }
    else {
        throw new IllegalStateException("厨具不存在");
    }
   }
    
   

    /**
     * 根据商品选择使用的厨具
     * @param dish
     * @return Cooker
     */
    public Cooker buildCooker(Dish dish){
    if(dish.getCooker().equals("炒锅")){
        Cooker wok=new Wok();
        return wok;   
    }
    if(dish.getCooker().equals("电饭煲")){
        Cooker ricCooker=new RiceCooker();
        return ricCooker;
    }
    if(dish.getCooker().equals("蒸笼")){
        Cooker steamer=new Steamer();
        return steamer;
    }
    else {
        throw new IllegalStateException("厨具不存在");
    }
   }
    
   

    /**
     * 对外是一个处理商品的接口，内部进行处理
     * 获取原材料，使用工具，进行烹饪
     * 此处可以作为一个命令模式的command,进行拓展
     * @param dish 商品
     */
    public void processMerch(Dish dish){
        Chef chef=Chef.getInstance();
        IngredienType type=chef.transferToIngredientType(dish);
        Ingredient ingredient=chef.transferToIngredient(dish);
        Container container=chef.seletedContainer(dish);

        /**
         * count：不清楚意义
         */
        boolean isTrue= container.get(type, count);

         /**
         * 此处可进行责任链模式编写
         */
        Cooker cooker= chef.buildCooker(dish); 
        if(isTrue)      
        cooker.cook(ingredient);

    
    }
}