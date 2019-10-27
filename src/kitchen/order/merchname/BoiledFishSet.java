package kitchen.order.merchname;
import java.util.List;
//水煮鱼套餐：水煮鱼+炒青菜+馒头
public class BoiledFishSet implements MerchName {
    public final static List<String> names= List.of("水煮鱼","炒青菜","馒头");
    public final static List<MerchName> merchs=List.of(new BoiledFish(),new StirFriedVegetables(),new SteamedBread());

    // public BoiledFishSet() {
    //     names = new List<>();
    //     names.add("水煮鱼");
    //     names.add("炒青菜");
    //     names.add("馒头");
        
    //     merchs=new List<>();
    //     merchs.add(new BoiledFish());
    //     merchs.add(new SteamedBread());
    //     merchs.add(new StirFriedVegetables());
    // }

    @Override
    public List<MerchName> getMerch() {
        return merchs;
    }

    @Override
    public List<String> getMerchName() {
        return names;
    }
}