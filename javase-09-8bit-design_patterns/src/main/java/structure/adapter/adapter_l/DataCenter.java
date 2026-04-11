package structure.adapter.adapter_l;

public class DataCenter {

    /**
     * 返回一个数组
     * @return
     */
    public static int[] getResult(){
        int[] result = new int[10];
        for(int i=0;i<result.length;i++) {
            result[i] = i;
        }
        return result;
    }
}
