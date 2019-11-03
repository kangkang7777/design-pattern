package kitchen.order.merchname;
import java.util.Collections;
import java.util.List;
//单品水煮鱼
public class BoiledFish implements MerchName{
    public final static List<String> names= Collections.singletonList("水煮鱼");

    // public BoiledFish(){
    //     names=new List<>();
    //     names.add("水煮鱼");
    // }

    @Override
    public List<MerchName> getMerch(){
        return null;
    }

    @Override
    public List<String> getMerchName(){
        return names;
    }
}