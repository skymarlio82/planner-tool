
package com.nike.app.planner.boot.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nike.app.planner.boot.data.entity.BuyPlanTop2DownPlatformView;

@Repository("bpt2dpvDao")
public interface Bpt2dpvDao extends JpaRepository<BuyPlanTop2DownPlatformView, Integer> {

	@Query("from BuyPlanTop2DownPlatformView bpt2dpv order by bpt2dpv.bpTop2DownPlatformId")
	List<BuyPlanTop2DownPlatformView> findAll();

	@Query("select bpt2dpv from BuyPlanTop2DownPlatformView bpt2dpv where bpt2dpv.platform = :platform and bpt2dpv.division = :division ")
	BuyPlanTop2DownPlatformView findBuyPlanTop2DownPlatformViewByPlatformAndDivision(@Param("platform") String platform, @Param("division") String division);

	@Query("select bpt2dpv from BuyPlanTop2DownPlatformView bpt2dpv where bpt2dpv.platform = :platform order by bpt2dpv.bpTop2DownPlatformId")
	List<BuyPlanTop2DownPlatformView> findBuyPlanTop2DownPlatformViewByPlatform(@Param("platform") String platform);
	
	@Query("select bpt2dpv from BuyPlanTop2DownPlatformView bpt2dpv where bpt2dpv.division = :division order by bpt2dpv.bpTop2DownPlatformId")
	List<BuyPlanTop2DownPlatformView> findBuyPlanTop2DownPlatformViewByDivision(@Param("division") String division);
	
	@Query("select bpt2dpv from BuyPlanTop2DownPlatformView bpt2dpv where bpt2dpv.platform = :platform and bpt2dpv.division = :division order by bpt2dpv.bpTop2DownPlatformId")
	List<BuyPlanTop2DownPlatformView> findBuyPlanTop2DownPlatformViewListByPlatformAndDivision(@Param("platform") String platform, @Param("division") String division);
}