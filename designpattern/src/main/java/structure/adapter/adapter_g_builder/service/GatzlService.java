package structure.adapter.adapter_g_builder.service;

import structure.adapter.adapter_g_builder.dao.GatzlDao;
import structure.adapter.adapter_g_builder.domain.Gatzl;

public class GatzlService implements IGatzlService {
    private GatzlDao gatzlDao = new GatzlDao();

    @Override
    public void save(Gatzl gatzl) {
        gatzlDao.save(gatzl);
    }

    @Override
    public boolean delete(Gatzl gatzl) {
        return gatzlDao.delete(gatzl);
    }

    @Override
    public boolean sendMsg(String phoneNumber) {
        return gatzlDao.sendMsg(phoneNumber);
    }
}
