package kitchen;

import com.sun.org.apache.xpath.internal.operations.Or;
import kitchen.container.Cabinet;
import kitchen.container.Container;
import kitchen.container.ContainerIterator;
import kitchen.container.Fridge;
import kitchen.ingredient.*;
import kitchen.merch.Adapter;
import kitchen.merch.Dish;
import kitchen.order.merchname.MerchNameFactory;
import kitchen.order.orderform.Memento;
import kitchen.order.orderform.Order;
import kitchen.staff.Waiter;
import kitchen.staff.chef.Chef;
import kitchen.time.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.List;

/**
 *部分模块的测试请写在此Main中，标注信息并注释
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        ////////////////////综合测试////////////////////




        ////////////////////综合测试////////////////////

        ////////////////////模块测试////////////////////
        //chefTest();//对chef包进行测试，包含单例，命令，抽象工厂,责任链，中介者，代理模式
        //testAVBFB();//对adapter、visitor、builder、facade、bridge的测试
        //containerTest();//对container包的测试
        //ingredientTest();//对ingredient包对测试

        ////////////////////模块测试////////////////////

        ////////////////////设计模式测试////////////////////
        commandTest();
        strategyTest();
        decoratorTest();



        ////////////////////设计模式测试////////////////////

    }



    ////////////////////模块测试////////////////////

    /**
     * 对Order进行测试：
     * 包含的设计模式：
     */
    public static void OrderTest() throws CloneNotSupportedException {

        Scanner stdIn = new Scanner(System.in);
        Order o;
        Order o1 = new Order();
        o1.setDiscount(1);
        Order o2 = new Order();
        o2.setDiscount(0.88);
        //菜单打印
        System.out.println("欢迎来到谢康大厨掌勺的健康餐厅，请问您是VIP吗？  是（Y）/不是（N）");
        String isY = stdIn.next();
        if(isY.equals("y")|| isY.equals("Y") || isY.equals("是") || isY.equals("shi")){
            o = (Order)o2.clone();
            o.adjustclone();

        }
        else{
            o = (Order)o1.clone();

        }
        System.out.println("请问一共有几位客人？");
        int number = stdIn.nextInt();
        o.setTablesize(number);


        System.out.println("----Menu----");
        System.out.println("1. 水煮鱼  2. 鸡蛋汤  3. 麻婆豆腐 4. 炒青菜 5. 馒头");
        System.out.println("6. 水煮鱼套餐 7. 麻婆豆腐套餐 -1. 删除菜品  -2. 回退上一步 0. 完成订单");
        System.out.println("请点餐：");
        String dishname = "";
        while(true){
            dishname = stdIn.next();
            if(dishname.equals("0") || dishname.equals("完成订单"))
                break;
            else if(dishname.equals("-1") || dishname.equals("删除菜品")) {
                System.out.println("请输入要删除的菜品名字或编号：");
                String ddish = stdIn.next();
                o.canceldish(ddish);
            }
            else if(dishname.equals("-2") || dishname.equals("回退") || dishname.equals("回退上一步")){
                o = Memento.getInstance().getBackup(o);
            }
            else {
                o.adddish(dishname);
            }
        }
        System.out.println("点餐完成！");
        o.giveorder();
    }

    /**
     * 对waiter进行测试：
     * 包含的设计模式：
     */
/*
    public static void WaiterTest(){
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
    */
    /**
     * 对container进行测试
     * 包含的设计模式：单例、迭代器
     */
    public static void containerTest(){
        Fridge fri = Fridge.getInstance();
        if(fri!=null)
            System.out.println("--单例冰箱获取成功！--");
        System.out.println("--查看能否在冰箱里放入鸡蛋--");
        System.out.println(fri.isIngredientTypeAvailable(IngredientType.EGG));
        System.out.println("--查看能否在冰箱里放入豆腐--");
        System.out.println(fri.isIngredientTypeAvailable(IngredientType.TOFU));
        System.out.println("--尝试在冰箱里放入鸡蛋！--");
        fri.put(IngredientType.EGG,5);
        System.out.println("这时冰箱里的鸡蛋个数为：");
        fri.seek(IngredientType.EGG);
        System.out.println("--尝试在冰箱里放入5份豆腐！--");
        fri.put(IngredientType.TOFU,5);
        System.out.println("豆腐放入成功！");
        System.out.println("此时冰箱里的豆腐个数为");
        System.out.println(fri.seek(IngredientType.TOFU));
        System.out.println("--尝试在冰箱里再放入500份豆腐！--");
        fri.put(IngredientType.TOFU,500);
        System.out.println("豆腐放入成功！");
        System.out.println("此时冰箱里的豆腐个数为");
        System.out.println(fri.seek(IngredientType.TOFU));
        System.out.println("测试冰箱内豆腐的个数时用到了迭代器模式。");
    }

    /**
     * 对ingredient进行测试
     * 包含的设计模式：观察者、策略、装饰器
     */
    public static void ingredientTest(){
        Ingredient ing = new Egg();
        System.out.println("我们尝试创造一个实例鸡蛋，实例的名称为：");
        System.out.println(ing.getName());
        System.out.println("实例的状态是否新鲜：");
        System.out.println(ing.isState());
        System.out.println("过去15个时间，实例的状态是否新鲜：");
        int i = 15;
        while(i-- >0)
            ing.update();
        System.out.println(ing.isState());
        i = 100;
        while(i-- >0)
            ing.update();
        System.out.println("再过去100个时间,实例的状态是否新鲜：");
        System.out.println(ing.isState());
        System.out.println("食物状态改变，这里用到了策略模式；时间的流逝用到了观察者模式");
        System.out.println("我们创造一个实例豆腐，并用FancyCut装饰它.");
        Ingredient tofu = new Tofu();
        FancyCut fan = new FancyCut(tofu);
        fan.displayCut();
        System.out.println("豆腐处理了吗？");
        System.out.println(fan.isCut());
        System.out.println("这里用到了装饰器模式。");
    }

    /**
     * 对chef做菜功能进行测试：
     * 包含的设计模式：单例，命令，抽象工厂，责任链，中介者，代理模式
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
        waiter.serve(order);//把dishes传进Chef的成员变量
        System.out.println("--测试访问者模式--");
        System.out.println("----访问菜品----");
        System.out.println("----访问订单----");
        order.accept(waiter);
        System.out.println("-责任链模式测试开始-");
        System.out.println("--命令模式测试开始--");
        System.out.println("抽象工厂模式测试开始");
        chef.processMerchs(chef.getDishes());

    }

    ////////////////////模块测试////////////////////

    ////////////////////设计模式测试////////////////////

    /**
     *
     */
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

    /**
     *
     */
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

     /**
     * 这里是adapter、visitor、builder、facade、bridge的测试11-13,19-20
     * @throws CloneNotSupportedException
     */
    public static void testAVBFB() throws CloneNotSupportedException {
        Waiter waiter = Waiter.getInstance();
        Chef chef = Chef.getInstance();
        Order order = new Order();
        order.setDiscount(0.8);
        order.adddish("水煮鱼");
        order.adddish("鸡蛋汤");
        order.adddish("馒头");
        waiter.register(order);
        waiter.register(chef);
        waiter.serve(order);
        System.out.println("--测试访问者模式--");
        System.out.println("----访问菜品----");
        waiter.getDishes().get(0).accept(waiter);
        System.out.println("----访问订单----");
        order.accept(waiter);
    }

    /**
     *
     */
    public static void testPrototype() throws CloneNotSupportedException {
        Order o = new Order();
        System.out.println("o订单的生成使用了Order类的构造器");
        o.adddish("麻婆豆腐");
        System.out.println("为订单o中添加菜”麻婆豆腐“。");
        Order o_copy  = (Order)o.clone();
        System.out.println("o_copy订单的生成使用了o的clone()方法。");
        System.out.println("测试o和o_copy的菜单是否相同? " + (o.givemenu().equals(o_copy.givemenu())) );
        System.out.println("测试o和o_copy是否相同? " + (o.equals(o_copy)));
    }

    /**
     *
     */
    public static void testMemento() throws CloneNotSupportedException {
        Order o = new Order();
        o.adddish("麻婆豆腐");
        o.adddish("鸡蛋汤");
        System.out.println("新建订单o，添加菜品麻婆豆腐，鸡蛋汤。");
        o.canceldish("鸡蛋汤");
        System.out.println("删除菜品鸡蛋汤，此时订单菜单有：");
        ArrayList<String> menu = o.givemenu();
        for (String i:menu
        ) {
            System.out.println(i);
        }
        o = Memento.getInstance().getBackup(o);
        System.out.println("用Memento模式回到o的上一步历史订单，此时订单菜单有：");
        menu = o.givemenu();
        for (String i:menu
        ) {
            System.out.println(i);
        }
    }

    /**
     *享元模式测试
     */
    public static void testFlyweight() throws CloneNotSupportedException {
        Order o1 = new Order();
        Order o2 = new Order();
        o1.adddish("鸡蛋汤");
        o2.adddish("鸡蛋汤");
        System.out.println("创建o1,o2两个订单，都添加菜品”鸡蛋汤”。");
        System.out.println("测试o1的历史是否等于o2? " + (Memento.getInstance().getBackup(o1).getOid() == Memento.getInstance().getBackup(o2).getOid()));
        Order o3 = (Order)o1.clone();
        o1.canceldish("鸡蛋汤");
        System.out.println("对o1进行操作后，测试此时o1的历史是否等于原o1的历史? " + (Memento.getInstance().getBackup(o1).getOid() == o3.getOid()));
    }

    /**
     *中介、代理模式测试
     */
    public static void testMediatorAndProxy(){
        Chef chef = Chef.getInstance();
        Waiter waiter = Waiter.getInstance();
        Order order = new Order();
        //中介者注册order与chef
        waiter.register(order);
        waiter.register(chef);

        order.setDiscount(0.6);
        try {
            order.adddish("水煮鱼");
            order.adddish("鸡蛋汤");
            order.adddish("麻婆豆腐");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //订单填写完毕，将订单转交给服务员
        order.giveorder();
        //结账
        order.accept(waiter);
    }

    /**
     * 命令模式测试
     */
    public static void commandTest() throws CloneNotSupportedException {
        Chef chef=Chef.getInstance();
        Waiter waiter = Waiter.getInstance();
        waiter.register(chef);
        Order order = new Order();
        order.setDiscount(0.8);
        order.adddish("水煮鱼");
        order.adddish("鸡蛋汤");
        order.adddish("馒头");
        waiter.register(order);
        waiter.serve(order);//把dishes传进Chef的成员变量
        System.out.println("----访问菜品----");
        System.out.println("----访问订单----");
        order.accept(waiter);
        System.out.println("--命令模式测试开始--");
        chef.processMerchs(chef.getDishes());
    }

    /**
     * 装饰器模式测试
     */
    public static void decoratorTest() {
        System.out.println("我们创造一个实例豆腐，并用FancyCut装饰它.");
        Ingredient tofu = new Tofu();
        FancyCut fan = new FancyCut(tofu);
        fan.displayCut();
        System.out.println("豆腐处理了吗？");
        System.out.println(fan.isCut());
    }

    /**
     * 策略模式测试
     */
    public static void strategyTest() {
        Ingredient ing = new Egg();
        System.out.println("我们尝试创造一个实例鸡蛋");
        System.out.println("鸡蛋的状态是否新鲜：");
        System.out.println(ing.isState());
        System.out.println("过去15个时间，实例的状态是否新鲜：");
        int i = 15;
        while(i-- >0)
            ing.update();
        System.out.println(ing.isState());
        i = 100;
        while(i-- >0)
            ing.update();
        System.out.println("再过去100个时间,实例的状态是否新鲜：");
        System.out.println(ing.isState());
        System.out.println("食物状态改变，这里用到了策略模式");
    }


        /**
         * design pattern: Observer、Iterator、State
         * description: After 100 ticks, egg will be stale but flour will not. Firstly put these 2 ingredients into the cabinet
         * and let time tick 99 times, and see what happens. Tick one more time, see if the egg is stale.
         */
    public static void observerTest()
    {
        Cabinet.getInstance().put(IngredientType.EGG,1);
        Cabinet.getInstance().put(IngredientType.FLOUR,1);
        Time.getInstance().update(99);
        ContainerIterator it = Cabinet.getInstance().Iterator();
        while(it.hasNext())
        {
            Ingredient ingredient = it.next();
            System.out.println("冰箱中有：【"+ingredient.getName()+"】" + ingredient.getStateName());
        }
        Time.getInstance().update(1);
        it = Cabinet.getInstance().Iterator();
        while(((ContainerIterator) it).hasNext())
        {
            Ingredient ingredient = it.next();
            System.out.println("冰箱中有：【"+ingredient.getName()+"】"+ ingredient.getStateName());
        }
    }

}
////////////////////设计模式测试////////////////////
