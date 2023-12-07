package structure.adapter.adapter_l;

import java.util.ArrayList;

public class ArrayAdapter extends ArrayList {

    private int[] result;

    public ArrayAdapter(int[] result){
        this.result = result;
    }

    @Override
    public Object get(int index) {
        return result[index];
    }

    /**
     * 注意：这个size()方法一定要重写，不然遍历的时候调用ArrayAdapter.size()返回的值是0，无法进行遍历
     * @return
     */
    @Override
    public int size() {
        return result.length;
    }
}
