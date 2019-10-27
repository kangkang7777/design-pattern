package kitchen.order.merchname;
import java.util.List;
//单品麻婆豆腐
public class MaboTofu implements MerchName {
    public final static List<String> names=List.of("麻婆豆腐");
    // public List<MerchName> merchs;

    // public MaboTofu() {
    //     names = new List<>();
    //     names.add("麻婆豆腐");
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
