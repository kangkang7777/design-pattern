package kitchen.order.merchname;
import java.util.List;
//单品鸡蛋汤
public class EggSoup implements MerchName {
    public final static List<String> names=List.of("鸡蛋汤");
    // public final static List<MerchName> merchs;

    // public EggSoup() {
    //     names = new List<>();
    //     names.add("鸡蛋汤");
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