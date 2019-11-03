package kitchen.order.merchname;
import java.util.List;

public class MerchNameFactory {
    static public List<String> getMerchName(String name){
        MerchName merchName=null;
        switch(name){
            case "1":
            merchName=new BoiledFish();
            break;
            case "水煮鱼":
            merchName=new BoiledFish();
            break;
            case "2":
            merchName=new EggSoup();
            break;
            case "鸡蛋汤":
            merchName=new EggSoup();
            break;
            case "3":
            merchName=new MaboTofu();
            break;
            case "麻婆豆腐":
            merchName=new MaboTofu();
            break;
            case "4":
            merchName=new StirFriedVegetables();
            break;
            case "炒青菜":
            merchName=new StirFriedVegetables();
            break;
            case "5":
            merchName=new SteamedBread();
            break;
            case "馒头":
            merchName=new SteamedBread();
            break;
            case "6":
            merchName=new BoiledFishSet();
            break;
            case "水煮鱼套餐":
            merchName=new BoiledFishSet();
            break;
            case "7":
            merchName=new MaboTofuSet();
            break;
            case "麻婆豆腐套餐":
            merchName=new MaboTofuSet();
            break;
            default:
            merchName=new NullMerchName();
            break;
        }
        return merchName.getMerchName();
    }
}