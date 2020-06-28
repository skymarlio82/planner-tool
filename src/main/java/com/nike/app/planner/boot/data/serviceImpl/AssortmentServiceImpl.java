
package com.nike.app.planner.boot.data.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nike.app.planner.boot.data.dao.AssortmentDetailDao;
import com.nike.app.planner.boot.data.entity.AssortmentDetail;
import com.nike.app.planner.boot.data.service.AssortmentService;
import com.nike.app.planner.boot.util.log.SimpleLogger;

@CacheConfig(cacheNames="assortmentServiceCache")
@Service("assortmentService")
public class AssortmentServiceImpl implements AssortmentService {

	@Autowired
	private AssortmentDetailDao assortmentDetailDao = null;

	@Cacheable
	@Transactional(readOnly=true)
	@Override
	public List<AssortmentDetail> readAllAssortmentDetails() {
		List<AssortmentDetail> list = assortmentDetailDao.findAll();
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "readAllAssortmentDetails : result.size = " + list.size());
		return list;
	}
}