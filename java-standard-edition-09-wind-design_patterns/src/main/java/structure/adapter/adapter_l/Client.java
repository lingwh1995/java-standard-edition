package structure.adapter.adapter_l;

public class Client {
    public static void main(String[] args) {
        //返回的的数据是int[]类型数据
        int[] result = DataCenter.getResult();
        //将int[]类型数据传入到ArrayAdapter的构造方法中
        //ArrayAdapter会重写ArrayList的部分方法
        ArrayAdapter arrayAdapter = new ArrayAdapter(result);
        DealCenter.deal(arrayAdapter);
    }
}
