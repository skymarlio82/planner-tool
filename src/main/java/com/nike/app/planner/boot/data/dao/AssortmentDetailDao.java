
package com.nike.app.planner.boot.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nike.app.planner.boot.data.entity.AssortmentDetail;

@Repository("assortmentDetailDao")
public interface AssortmentDetailDao extends JpaRepository<AssortmentDetail, Integer> {

	@Query("from AssortmentDetail ad order by ad.assortmentPlanId")
	List<AssortmentDetail> findAll();
}