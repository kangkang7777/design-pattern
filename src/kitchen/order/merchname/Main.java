//测试用代码

// package kitchen.order.merchname;
// import java.util.List;

// public class Main{
//     public static void main(String[] args){
//         List<String> names= null;
//         //修改菜名进行点单
//         names = makeOrder("水煮鱼套餐");
//         if(names==null){
//             System.out.println("不存在");
//         }else{
//             for(String s:names){
//                 System.out.println(s);
//             }
//         }
//     }

//     public static List<String> makeOrder(String merchName){
//         MerchNameFactory factory = new MerchNameFactory();

//         List<String> names = null;
//         names = factory.getMerchName(merchName);
//         return names;
//     }

// }