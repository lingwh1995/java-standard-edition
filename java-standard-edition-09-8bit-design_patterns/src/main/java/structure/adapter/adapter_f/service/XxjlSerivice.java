package structure.adapter.adapter_f.service;

import structure.adapter.adapter_f.adapter.XxjlAdapter;
import structure.adapter.adapter_f.dao.XxjlDao;
import structure.adapter.adapter_f.domain.Xxjl;

public class XxjlSerivice implements IXxjlService {
    private XxjlDao xxjlDao = new XxjlDao();
    private XxjlAdapter xxjlAdapter = new XxjlAdapter();

    @Override
    public void save(Xxjl xxjl) {
        xxjlDao.save(xxjl);
        xxjlAdapter.sendMsg("123456789");
        xxjlAdapter.sendEmail("123@qq.com");
    }

    @Override
    public boolean delete(Xxjl xxjl) {
        xxjlDao.delete(xxjl);
        return false;
    }
}
