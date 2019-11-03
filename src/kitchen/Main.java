package kitchen;

import kitchen.container.Cabinet;
import kitchen.container.Fridge;
import kitchen.ingredient.IngredientType;
import kitchen.order.orderform.Memento;
import kitchen.order.orderform.Order;
import kitchen.time.Time;

import java.util.Scanner;

/**
 *部分模块的测试请写在此Main中，标注信息并注释
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        /**
         * Order模块测试
         */
        Scanner stdIn = new Scanner(System.in);
        Order o;
        Order o1 = new Order();
        o1.setDiscount(1);
        Order o2 = new Order();
        o2.setDiscount(0.88);
        //菜单打印
        System.out.println("欢迎来到谢康大厨掌勺的健康餐厅，请问您是VIP吗？  是（Y）/不是（N）");
        String isY = stdIn.next();
        if(isY == "y"|| isY == "Y" || isY == "是"){
            o = (Order)o2.clone();
            o.adjustclone();

        }
        else{
            o = (Order)o1.clone();

        }

        System.out.println("----Menu----");
        System.out.println("1. 麻婆豆腐  2. 水煮鱼  3. 鸡蛋汤 0. 结束点餐 -1. 取消");
        System.out.println("请点餐");
        String dishname = "";
        while(!dishname.equals("0")){
            dishname = stdIn.next();
            if(dishname.equals("0"))
                break;
            if(dishname.equals("-1")) {
                o = Memento.getInstance().getBackup(o);
            }
            else {
                o.adddish(dishname);
            }
        }




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
}