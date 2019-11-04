package kitchen.order.merchname;
import java.util.Collections;
import java.util.List;

/**
 * 单品鸡蛋汤，只有名称List，没有MerchName对象List
 */
public class EggSoup implements MerchName {
    public final static List<String> names= Collections.singletonList("鸡蛋汤");

    /**
     * 获取MerchName对象的List
     */
    @Override
    public List<MerchName> getMerch() {
        return null;
    }

    /**
     * 获取MerchName对象的名称List
     */
    @Override
    public List<String> getMerchName() {
        return names;
    }
}