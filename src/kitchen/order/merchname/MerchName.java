package kitchen.order.merchname;

import java.util.List;

public interface MerchName {
    // 返回菜名List
    public List<String> getMerchName();

    // 返回菜List
    public List<MerchName> getMerch();
}