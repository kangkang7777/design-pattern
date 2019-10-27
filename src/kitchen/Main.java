package magickitchen;

import java.util.ArrayList;
import java.util.Scanner;

import magickitchen.merch.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("欢迎来到魔幻厨房!\n");
        System.out.println("        菜单      \n");
        System.out.println("1.麻婆豆腐\n2.水煮鱼\n3.鸡蛋汤\n4.炒青菜\n5.馒头\n");
        System.out.println("请依次输入你想点的菜，用空格分隔\n");
        ArrayList<Integer> b=new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        b.add(a);
        preMerch(b);
    }
    private static void preMerch(ArrayList<Integer> a) {
        Item item = new Item();
        for(int i=0; i<a.size(); i++){
            if(a.get(i) == 1) item.setbuilder(new MaboTofu());
            else if(a.get(i) == 2) item.setbuilder(new BoiledFish());
            else if(a.get(i) == 3) item.setbuilder(new EggSoup());
            else if(a.get(i) == 4) item.setbuilder(new StirFriedVegetables());
            else  item.setbuilder(new SteamedBread());
            item.createDish();
            Dish dish = item.getDish();
            System.out.print("你点的是:"+dish.show()+"\n");
        }
    }
}
