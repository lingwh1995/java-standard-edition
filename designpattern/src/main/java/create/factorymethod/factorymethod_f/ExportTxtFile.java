package create.factorymethod.factorymethod_f;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/3 16:45
 */
public class ExportTxtFile implements ExportFileApi{

    /**
     * 导出内容成为文件
     *
     * @param data 示意：需要保存的数据
     * @return 是否导出成功
     */
    @Override
    public boolean export(String data) {
        System.out.println("导出数据"+data+"到文本文件~");
        return true;
    }
}
