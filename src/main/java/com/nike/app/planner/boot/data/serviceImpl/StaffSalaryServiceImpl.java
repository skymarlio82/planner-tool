
package com.nike.app.planner.boot.data.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nike.app.planner.boot.data.dao.StaffDetailDao;
import com.nike.app.planner.boot.data.dao.StaffSalaryDetailDao;
import com.nike.app.planner.boot.data.entity.StaffDetail;
import com.nike.app.planner.boot.data.entity.StaffSalaryDetail;
import com.nike.app.planner.boot.data.service.StaffSalaryService;
import com.nike.app.planner.boot.data.service.StaffService;
import com.nike.app.planner.boot.util.log.SimpleLogger;
import com.nike.app.planner.boot.web.mvc.bean.form.StaffSalaryDetailForm;

@CacheConfig(cacheNames="staffSalaryServiceCache")
@Service("staffSalaryService")
public class StaffSalaryServiceImpl implements StaffSalaryService {

	@Autowired
	private StaffDetailDao staffDetailDao = null;

	@Autowired
	private StaffSalaryDetailDao staffSalaryDetailDao = null;

	@Autowired
	private StaffService staffService = null;

	@Cacheable
	@Transactional(readOnly=true)
	@Override
	public List<StaffSalaryDetail> readAllStaffSalaryDetails() {
		List<StaffSalaryDetail> list = staffSalaryDetailDao.findAll();
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "readAllStaffSalaryDetails : result.list = " + list.size());
		return list;
	}

	@Cacheable
	@Transactional(readOnly=true)
	@Override
	public StaffSalaryDetail readStaffSalaryDetail(int staffId) {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "readStaffSalaryDetail : staffId = " + staffId);
		StaffSalaryDetail ssd = staffSalaryDetailDao.findOne(staffId);
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "readStaffSalaryDetail : ssd = " + ssd);
		return ssd;
	}

	@CacheEvict(allEntries=true)
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	@Override
	public void saveStaffSalaryDetail(StaffSalaryDetail staffSalaryDetail) {
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "saveStaffSalaryDetail : staffSalaryDetail = " + staffSalaryDetail);
		staffSalaryDetailDao.saveAndFlush(staffSalaryDetail);
	}

	@CacheEvict(allEntries=true)
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	@Override
	public void synchronizeStaffSalary(int staffId, double salary) {
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "synchronizeStaffSalary : staffId = " + staffId + ", salary = " + salary);
		StaffDetail sd = staffDetailDao.findOne(staffId);
		sd.setSalary(salary);
		staffService.saveStaffDetail(sd);
		StaffSalaryDetail ssd = staffSalaryDetailDao.findOne(staffId);
		ssd.setGross(salary);
		ssd.setBase((double)(salary/2));
		ssd.setCompensation((double)(salary/4));
		ssd.setIncentive((double)(salary/4));
		staffSalaryDetailDao.saveAndFlush(ssd);
	}

	@CacheEvict(allEntries=true)
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	@Override
	public void applyStaffSalaryChange(StaffSalaryDetailForm staffSalaryDetailForm) {
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "applyStaffSalaryChange : staffSalaryDetailForm = " + staffSalaryDetailForm);
		StaffSalaryDetail ssd = staffSalaryDetailDao.findOne(staffSalaryDetailForm.getStaffId());
		ssd.setBase(staffSalaryDetailForm.getBase());
		ssd.setCompensation(staffSalaryDetailForm.getCompensation());
		ssd.setIncentive(staffSalaryDetailForm.getIncentive());
		ssd.setGross((double)(staffSalaryDetailForm.getBase() + staffSalaryDetailForm.getCompensation() + staffSalaryDetailForm.getIncentive()));
		staffSalaryDetailDao.saveAndFlush(ssd);
		StaffDetail sd = staffDetailDao.findOne(staffSalaryDetailForm.getStaffId());
		sd.setSalary(ssd.getGross());
		staffService.saveStaffDetail(sd);
	}
}