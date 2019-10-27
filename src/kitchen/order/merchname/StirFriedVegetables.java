package kitchen.order.merchname;
import java.util.List;
//单品炒青菜
public class StirFriedVegetables implements MerchName {
    public final static List<String> names=List.of("炒青菜");
    // public List<MerchName> merchs;

    // public StirFriedVegetables() {
    //     names = new List<>();
    //     names.add("炒青菜");
    // }

    @Override
    public List<MerchName> getMerch() {
        return null;
    }

    @Override
    public List<String> getMerchName() {
        return names;
    }
}
