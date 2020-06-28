
package com.nike.app.planner.boot.data.service;

import java.util.List;

import com.nike.app.planner.boot.data.entity.AssortmentDetail;

public interface AssortmentService {

	List<AssortmentDetail> readAllAssortmentDetails();
}