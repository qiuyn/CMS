package com.qiuy.service;

import com.qiuy.entity.MaintenanceForm;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 2019/12/12.
 */
public interface MaintenanceFormService {
    List<MaintenanceForm>  findAllByApplysusername(String applysusername);
    public  void  saveMaintenanceForm(MaintenanceForm maintenanceForm);
    public MaintenanceForm findByFormid(Long id);
    public  void  deleteByFormid(Long id);

}
