package kitchen.order.merchname;

import java.util.Arrays;
import java.util.List;

//麻婆豆腐套餐：麻婆豆腐+鸡蛋汤+馒头
public class MaboTofuSet implements MerchName {
    public final static List<String> names = Arrays.asList("麻婆豆腐", "鸡蛋汤", "馒头");
    public final static List<MerchName> merchs = Arrays.asList(new MaboTofu(), new EggSoup(), new SteamedBread());

    // public MaboTofuSet() {
    //     names = new List<>();
    //     names.add("麻婆豆腐");
    //     names.add("鸡蛋汤");
    //     names.add("馒头");

    //     merchs = new List<>();
    //     merchs.add(new MaboTofu());
    //     merchs.add(new SteamedBread());
    //     merchs.add(new EggSoup());
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