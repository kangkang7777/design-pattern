package kitchen.staff.chef;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import kitchen.container.*;
import kitchen.cooker.*;
import kitchen.merch.Dish;
import kitchen.cooker.Cooker;
import kitchen.ingredient.IngredientType;
import kitchen.ingredient.Ingredient;
import kitchen.container.Fridge;
import kitchen.container.Cabinet;
import kitchen.ingredient.Flour;
import kitchen.ingredient.Fish;
import kitchen.ingredient.Tofu;
import kitchen.ingredient.Vegetables;
import kitchen.ingredient.Egg;
import kitchen.staff.Waiter;


/**
 * Chef类处理从merch包传过来的
 * 商品list,根据商品信息去取
 * container里面的原料，调用cooker
 * 里面的cook函数进行烹饪，本类不
 * 涉及Container和Cooker里面原料的添加
 * 涉及的设计模式：
 * 单例，责任链
 */
public class Chef implements ChefImp{
    
    private Waiter mWaiter;
    private ArrayList<Dish>dishes=new ArrayList<>();

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setWaiter(Waiter mWaiter) {
        this.mWaiter = mWaiter;
    }

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
        IngredientType type=IngredientType.EGG;
        
        if(dish.getMaterial().equals("鸡蛋")){
            type=IngredientType.EGG;
        }
        if(dish.getMaterial().equals("面粉")){
            type=IngredientType.FLOUR;
        }
        if(dish.getMaterial().equals("鱼")){
            type=IngredientType.FISH;
        }
        if(dish.getMaterial().equals("豆腐")){
            type=IngredientType.TOFU;
        }
        if(dish.getMaterial().equals("蔬菜")){
            type=IngredientType.VEGETABLES;
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
        Ingredient ingredient=new Egg();
        
        if(dish.getMaterial().equals("鸡蛋")){
            ingredient=new Egg();     
        }
        if(dish.getMaterial().equals("面粉")){
            ingredient=new Flour();
        }
        if(dish.getMaterial().equals("鱼")){
            ingredient=new Fish();
        }
        if(dish.getMaterial().equals("豆腐")){
           ingredient=new Tofu();
        }
        if(dish.getMaterial().equals("蔬菜")){
           ingredient=new Vegetables();
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
        if(Cabinet.getInstance().seek(type)>0)
        {

            return 1;
        }
        else if(Fridge.getInstance().seek(type)>0)
        {

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
    public Container selectedContainer(Dish dish){
    Chef chef=Chef.getInstance();
    IngredientType type=chef.transferToIngredientType(dish);
    Container cabinet=Cabinet.getInstance();
    Container fridge=Fridge.getInstance();
    if(chef.hasIngredient(type)==1){

        System.out.println(""+type.toString()+"在橱柜中");
        return cabinet;
    }
    else if(chef.hasIngredient(type)==2){

        System.out.println(""+type.toString()+"在冰箱中");
        return fridge;
    }
    else {
        if(type==IngredientType.EGG||type==IngredientType.FLOUR||
                type==IngredientType.VEGETABLES){
            cabinet.put(type,100);
            System.out.println(type+"重新进货了"+"，存放在橱柜中");
            return cabinet;
        }
        else {
            fridge.put(type,100);
            System.out.println(type+"重新进货了"+"，存放在冰箱中");
            return fridge;
        }
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
    else {
        Cooker steamer=new Steamer();
        return steamer;
    }

   }
    
    

    /**
     * 对外是一个处理商品列表的接口，内部进行处理
     * 获取原材料，使用工具，进行烹饪
     * 此处可以作为一个命令模式的command,进行拓展
     * @param dishes 商品列表
     */
    @Override
    public void processMerchs(ArrayList<Dish>dishes){
        System.out.println("厨师接到了新单");
        Chef chef=Chef.getInstance(); 
        //责任链排序
        HashMap<Integer,Dish> mDishes=new HashMap<>();

        for(Dish dish:dishes){
        IngredientType type=chef.transferToIngredientType(dish);
        Ingredient ingredient=chef.transferToIngredient(dish);
        Container container=chef.selectedContainer(dish);
        
        //取原料及其数量并进行消耗
        int count=dish.getCount();
        boolean isTrue= container.get(type, count);

        Cooker newCooker= chef.buildCooker(dish); 
        if(isTrue){
            System.out.println("厨师成功从"+container.getName()+"获得"+type) ;   
            mDishes.put(newCooker.getPriority(),dish);
        }      
        else{
            System.out.println("厨师获得"+type+"失败");
        }
       
        }

        Iterator<Map.Entry<Integer, Dish>> it = mDishes.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Dish> mEntry = it.next();
            //getKey()和getValue是接口Map.Entry<K,V>中的方法，getKey()返回对应的键，getValue()返回对应的值
            int key = mEntry.getKey();
            Dish mDish=mEntry.getValue();
            Ingredient mIngredient=chef.transferToIngredient(mDish);
            Cooker mNewCooker= chef.buildCooker(mDish);
            mNewCooker.cook(mIngredient);
        }
      //mWaiter.serve(this);
    }
    
}
