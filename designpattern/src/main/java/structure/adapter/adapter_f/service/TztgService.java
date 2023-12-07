package structure.adapter.adapter_f.service;

import structure.adapter.adapter_f.dao.TztgDao;
import structure.adapter.adapter_f.domain.Tztg;

public class TztgService implements ITztgService {
    private TztgDao tztgDao = new TztgDao();

    @Override
    public void save(Tztg tztg) {
        tztgDao.save(tztg);
    }

    @Override
    public boolean delete(Tztg tztg) {
        return tztgDao.delete(tztg);
    }

    @Override
    public boolean sendEmail(String email) {
        return  tztgDao.sendEmail(email);
    }

}
