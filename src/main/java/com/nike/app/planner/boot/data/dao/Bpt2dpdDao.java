
package com.nike.app.planner.boot.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nike.app.planner.boot.data.entity.BuyPlanTop2DownPlatformDetail;

@Repository("bpt2dpdDao")
public interface Bpt2dpdDao extends JpaRepository<BuyPlanTop2DownPlatformDetail, Integer> {

	@Query("from BuyPlanTop2DownPlatformDetail bpt2dpd order by bpt2dpd.bpTop2DownPlatformId")
	List<BuyPlanTop2DownPlatformDetail> findAll();

	@Query("select bpt2dpd from BuyPlanTop2DownPlatformDetail bpt2dpd where bpt2dpd.platform = :platform and bpt2dpd.division = :division and bpt2dpd.yearNum = :yearNum")
	BuyPlanTop2DownPlatformDetail findBuyPlanTop2DownPlatformDetailByPlatformAndDivisionAndYearNum(@Param("platform") String platform, @Param("division") String division, @Param("yearNum") int yearNum);
}