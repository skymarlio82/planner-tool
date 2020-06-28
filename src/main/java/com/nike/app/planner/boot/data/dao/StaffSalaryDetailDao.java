
package com.nike.app.planner.boot.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nike.app.planner.boot.data.entity.StaffSalaryDetail;

@Repository("staffSalaryDetailDao")
public interface StaffSalaryDetailDao extends JpaRepository<StaffSalaryDetail, Integer> {

	@Query("from StaffSalaryDetail ssd order by ssd.staffSalaryId")
	List<StaffSalaryDetail> findAll();
}