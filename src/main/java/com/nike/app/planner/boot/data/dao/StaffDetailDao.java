
package com.nike.app.planner.boot.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nike.app.planner.boot.data.entity.StaffDetail;

@Repository("staffDetailDao")
public interface StaffDetailDao extends JpaRepository<StaffDetail, Integer> {

	@Query("from StaffDetail sd order by sd.staffId")
	List<StaffDetail> findAll();
	StaffDetail findByTimeMillis(long timeMillis);
}