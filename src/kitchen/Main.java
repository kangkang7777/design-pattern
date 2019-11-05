package kitchen;

import kitchen.container.Cabinet;
import kitchen.container.Container;
import kitchen.container.Fridge;
import kitchen.ingredient.Ingredient;
import kitchen.ingredient.IngredientType;
import kitchen.merch.Adapter;
import kitchen.merch.Dish;
import kitchen.order.orderform.Memento;
import kitchen.order.orderform.Order;
import kitchen.staff.RealWaiter;
import kitchen.staff.Waiter;
import kitchen.staff.chef.Chef;
import kitchen.time.Time;

import javax.swing.*;
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
    //}


    /**
     * 对chef做菜功能进行测试：
     * 包含单例，命令，抽象工厂,
     * 责任链，中介者，代理模式
     * @throws CloneNotSupportedException
     */
    private  static  void chefTest() throws CloneNotSupportedException {
        Chef chef=Chef.getInstance();
        Waiter waiter = Waiter.getInstance();
        waiter.register(chef);
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
        System.out.println("-责任链模式测试开始-");
        System.out.println("--命令模式测试开始--");
        System.out.println("抽象工厂模式测试开始");
        chef.processMerchs(waiter.getDishes());

    }

    public static void main(String[] args) throws CloneNotSupportedException {

        chefTest();//对chef包进行测试，包含单例，命令，抽象工厂,责任链，中介者，代理模式

    }

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
//这里是waiter和realWaiter的测试
//测试中介者模式与代理模式
//public static void main(String[] args){
//    testMediatorAndProxy();
//}
//    //这里是adapter与visitor的测试
//    //测试时请将waiter中的77,78注释，并将最后一个函数解注释
//    /*public static void main(String[] args) throws CloneNotSupportedException {
//        Waiter waiter = Waiter.getInstance();
//        Order order = new Order();
//        order.setDiscount(0.8);
//        order.adddish("水煮鱼");
//        order.adddish("鸡蛋汤");
//        order.adddish("馒头");
//        waiter.register(order);
//        waiter.serve(order);
//        System.out.println("--测试访问者模式--");
//        System.out.println("----访问菜品----");
//        waiter.getDishes().get(0).accept(waiter);
//        System.out.println("----访问订单----");
//        order.accept(waiter);
//    }*/
//    public static void testPrototype() throws CloneNotSupportedException {
//        Order o = new Order();
//        System.out.println("o订单的生成使用了Order类的构造器");
//        o.adddish("麻婆豆腐");
//        System.out.println("为订单o中添加菜”麻婆豆腐“。");
//        Order o_copy  = (Order)o.clone();
//        System.out.println("o_copy订单的生成使用了o的clone()方法。");
//        System.out.println("测试o和o_copy的菜单是否相同? " + (o.givemenu().equals(o_copy.givemenu())) );
//        System.out.println("测试o和o_copy是否相同? " + (o.equals(o_copy)));
//    }
//
//    public static void testMemento() throws CloneNotSupportedException {
//        Order o = new Order();
//        o.adddish("麻婆豆腐");
//        o.adddish("鸡蛋汤");
//        System.out.println("新建订单o，添加菜品麻婆豆腐，鸡蛋汤。");
//        o.canceldish("鸡蛋汤");
//        System.out.println("删除菜品鸡蛋汤，此时订单菜单有：");
//        ArrayList<String> menu = o.givemenu();
//        for (String i:menu
//             ) {
//            System.out.println(i);
//        }
//        o = Memento.getInstance().getBackup(o);
//        System.out.println("用Memento模式回到o的上一步历史订单，此时订单菜单有：");
//        menu = o.givemenu();
//        for (String i:menu
//        ) {
//            System.out.println(i);
//        }
//    }
//
//    public static void testFlyweight() throws CloneNotSupportedException {
//        Order o1 = new Order();
//        Order o2 = new Order();
//        o1.adddish("鸡蛋汤");
//        o2.adddish("鸡蛋汤");
//        System.out.println("创建o1,o2两个订单，都添加菜品”鸡蛋汤”。");
//        System.out.println("测试o1的历史是否等于o2? " + (Memento.getInstance().getBackup(o1).getOid() == Memento.getInstance().getBackup(o2).getOid()));
//        Order o3 = (Order)o1.clone();
//        o1.canceldish("鸡蛋汤");
//        System.out.println("对o1进行操作后，测试此时o1的历史是否等于原o1的历史? " + (Memento.getInstance().getBackup(o1).getOid() == o3.getOid()));
//    }
//
//    public static void testMediatorAndProxy(){
//        Chef chef = Chef.getInstance();
//        Waiter waiter = Waiter.getInstance();
//        Order order = new Order();
//        //中介者注册order与chef
//        waiter.register(order);
//        waiter.register(chef);
//
//        order.setDiscount(0.6);
//        try {
//            order.adddish("水煮鱼");
//            order.adddish("鸡蛋汤");
//            order.adddish("麻婆豆腐");
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        //订单填写完毕，将订单转交给服务员
//        order.giveorder();
//        //结账
//        order.accept(waiter);
//    }
}