package com.qiuy.dao;

import com.qiuy.entity.MaintenanceForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2019/12/12.
 */
@Repository
public interface MaintenanceFormDao extends CrudRepository<MaintenanceForm,Long> {
   List<MaintenanceForm>  findAllByApplysusername(String applysusername);
}
