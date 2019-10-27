package kitchen.order.merchname;
import java.util.List;
//单品馒头
public class SteamedBread implements MerchName {
    public final static List<String> names=List.of("馒头");
    // public  List<MerchName> merchs;

    // public SteamedBread() {
    //     names = new List<>();
    //     names.add("馒头");
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
