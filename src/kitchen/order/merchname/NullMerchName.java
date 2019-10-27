package kitchen.order.merchname;
import java.util.List;
//空对象
public class NullMerchName implements MerchName {
    @Override
    public List<MerchName> getMerch() {
        return null;
    }

    @Override
    public List<String> getMerchName() {
        return null;
    }
}
