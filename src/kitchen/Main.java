package kitchen;

import kitchen.container.Cabinet;
import kitchen.container.Container;
import kitchen.container.Fridge;
import kitchen.ingredient.Ingredient;
import kitchen.ingredient.IngredientType;
import kitchen.merch.Adapter;
import kitchen.merch.Dish;
import kitchen.order.merchname.MerchNameFactory;
import kitchen.order.orderform.Memento;
import kitchen.order.orderform.Order;
import kitchen.staff.RealWaiter;
import kitchen.staff.Waiter;
import kitchen.staff.chef.Chef;
import kitchen.time.Time;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *部分模块的测试请写在此Main中，标注信息并注释
 */
public class Main {
//    public static void main(String[] args) throws CloneNotSupportedException {
//        /**
//         * Order模块测试
//         */
//        Scanner stdIn = new Scanner(System.in);
//        Order o;
//        Order o1 = new Order();
//        o1.setDiscount(1);
//        Order o2 = new Order();
//        o2.setDiscount(0.88);
//        //菜单打印
//        System.out.println("欢迎来到谢康大厨掌勺的健康餐厅，请问您是VIP吗？  是（Y）/不是（N）");
//        String isY = stdIn.next();
//        if(isY.equals("y")|| isY.equals("Y") || isY.equals("是") || isY.equals("shi")){
//            o = (Order)o2.clone();
//            o.adjustclone();
//
//        }
//        else{
//            o = (Order)o1.clone();
//
//        }
//        System.out.println("请问一共有几位客人？");
//        int number = stdIn.nextInt();
//        o.setTablesize(number);
//
//
//        System.out.println("----Menu----");
//        System.out.println("1. 水煮鱼  2. 鸡蛋汤  3. 麻婆豆腐 4. 炒青菜 5. 馒头");
//        System.out.println("6. 水煮鱼套餐 7. 麻婆豆腐套餐 -1. 删除菜品  -2. 回退上一步 0. 完成订单");
//        System.out.println("请点餐：");
//        String dishname = "";
//        while(true){
//            dishname = stdIn.next();
//            if(dishname.equals("0") || dishname.equals("完成订单"))
//                break;
//            else if(dishname.equals("-1") || dishname.equals("删除菜品")) {
//                System.out.println("请输入要删除的菜品名字或编号：");
//                String ddish = stdIn.next();
//                o.canceldish(ddish);
//            }
//            else if(dishname.equals("-2") || dishname.equals("回退") || dishname.equals("回退上一步")){
//                o = Memento.getInstance().getBackup(o);
//            }
//            else {
//                o.adddish(dishname);
//            }
//        }
//        System.out.println("点餐完成！");
//        o.giveorder();


//    public static void main(String[] args)
//    {
//
//        Chef chef=Chef.getInstance();//获取厨师单例
//        Ingredient ingredient;
//        Container container;
//        Fridge fridge=Fridge.getInstance();
//        fridge.put(IngredientType.FISH,100);
//        Cabinet cabinet=Cabinet.getInstance();
//        cabinet.put(IngredientType.FLOUR,100);
//        ArrayList<String> strings=new ArrayList<>();
//        strings.add("BoiledFish");
//        strings.add("SteamedBread");
//        Adapter adapter=new Adapter();
//        ArrayList<Dish>dishes=adapter.getDishes(strings);
//        chef.processMerchs(dishes);
//
//    }



    //}

//这里是container与ingredient的测试
/*
    public static void main(String[] args)
    {
        Fridge fri = Fridge.getInstance();//获取冰箱单例
        Cabinet cab = Cabinet.getInstance();//获取橱柜单例
        System.out.println(fri.getName());//名字
        System.out.println(cab.getName());//名字
        fri.put(IngredientType.FLOUR,20);//冰箱放入不可放入的原料
        cab.put(IngredientType.FLOUR,20);//橱柜放入可放入的原料
        System.out.println(cab.seek(IngredientType.FLOUR));//当前可用的面粉原料数量
        cab.get(IngredientType.FLOUR,19);//橱柜取出原料
        System.out.println(cab.seek(IngredientType.FLOUR));//当前可用的面粉原料数量
        Time.getInstance().update(15);//时间流失
    }
 */
//这里是waiter的测试
    public static void main(String[] args){
        Chef chef = Chef.getInstance();
        Waiter waiter = Waiter.getInstance();
        waiter.register(chef);
        ArrayList<String> AL = new ArrayList<>();

        AL.add("水煮鱼");
        AL.add("鸡蛋汤");
        waiter.setLists(AL);
        waiter.serve();
        waiter.visit(waiter.getmOrder());
    }
    //这里是adapter与visitor的测试
    //测试时请将waiter中的77,78注释，并将最后一个函数解注释
    /*public static void main(String[] args) throws CloneNotSupportedException {
        Waiter waiter = Waiter.getInstance();
        Order order = new Order();
        order.setDiscount(0.8);
        order.adddish("水煮鱼");
        order.adddish("鸡蛋汤");
        order.adddish("馒头");
        waiter.register(order);
        waiter.serve(order);
        System.out.println("--测试访问者模式--");
        System.out.println("----访问菜品----");
        waiter.getDishes().get(0).accept(waiter);
        System.out.println("----访问订单----");
        order.accept(waiter);
    }*/

    
    public static void TestNullObject(){
        //空对象模式测试
        //顾客点菜时点到不存在的商品就会用到空对象模式
        List<String> names= null;

        //试图点一个不存在的菜
        String order="回锅肉";
        names=MerchNameFactory.getMerchName(order);

        if(names==null){
            System.out.print("没有");
            System.out.println(order);
        }else{
            for(String s:names){
                System.out.println("点的菜包括：");
                System.out.println(s);
            }
        }
    }

    public static void TestComposite(){
        //组合模式测试
        //套餐名类中包含了若干单品名类，体现了组合模式
        List<String> names= null;

        //点套餐
        String order="水煮鱼套餐";
        names=MerchNameFactory.getMerchName(order);

        if(names==null){
            System.out.println("没有");
            System.out.println(order);
        }else{
            for(String s:names){
                System.out.println("点的菜包括：");
                System.out.println(s);
            }
        }
    }

}