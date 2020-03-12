package com.qiuy.service.Impl;

import com.qiuy.dao.MaintenanceFormDao;
import com.qiuy.entity.MaintenanceForm;
import com.qiuy.service.MaintenanceFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 2019/12/12.
 */
@Service
public class MaintenanceFormServiceImpl implements MaintenanceFormService {
    @Autowired
    private MaintenanceFormDao maintenanceFormDao;
    @Override
    public List<MaintenanceForm> findAllByApplysusername(String username) {
        return maintenanceFormDao.findAllByApplysusername(username);
    }

    @Override
    public void saveMaintenanceForm(MaintenanceForm maintenanceForm) {
        maintenanceFormDao.save(maintenanceForm);
    }

    @Override
    public MaintenanceForm findByFormid(Long id) {
        return maintenanceFormDao.findById(id).orElse(null);
    }

    @Override
    public void deleteByFormid(Long id) {
        maintenanceFormDao.deleteById(id);
    }
}
