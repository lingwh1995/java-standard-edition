package structure.adapter.adapter_l;

import java.util.List;

public class DealCenter {

    /**
     * 打印list
     * @param list
     */
    public static void deal(List<Integer> list){
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
