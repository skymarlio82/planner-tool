
package com.nike.app.planner.boot.web.mvc.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.nike.app.planner.boot.data.entity.StaffDetail;

@RunWith(SpringRunner.class)
public class RestApiControllerTests {

	@Test
	public void testForGetAllStaffDetails() throws Exception {
		List<StaffDetail> staffList = new ArrayList<StaffDetail>();
		staffList.add(new StaffDetail(1, "Tiger", "Nixon", "", "M", "System Architect", "t.nixon@datatables.net", "Edinburgh", "5421", 61, (double)320800.0, new Date(), (long)0));
		staffList.add(new StaffDetail(2, "Garrett", "Winters", "", "M", "Accountant", "g.winters@datatables.net", "Tokyo", "8422", 63, (double)170750.0, new Date(), (long)0));
		staffList.add(new StaffDetail(3, "Ashton", "Cox", "", "F", "Junior Technical Author", "a.cox@datatables.net", "San Francisco", "1562", 66, (double)86000.0, new Date(), (long)0));
		staffList.add(new StaffDetail(4, "Cedric", "Kelly", "", "F", "Senior Javascript Developer", "c.kelly@datatables.net", "Edinburgh", "6224", 22, (double)433060.0, new Date(), (long)0));
		staffList.add(new StaffDetail(5, "Airi", "Satou", "", "F", "Accountant", "a.satou@datatables.net", "Tokyo", "5407", 33, (double)100000.0, new Date(), (long)0));
	}

	@Test
	public void testForSimpleCase() throws Exception {
		StaffDetail sd = new StaffDetail(1, "Tiger", "Nixon", "", "M", "System Architect", "t.nixon@datatables.net", "Edinburgh", "5421", 61, (double)320800.0, new Date(), (long)0);
		assertThat(sd.getStaffId()).isEqualTo(1);
		assertThat(sd.getFirstName()).isEqualTo("Tiger");
		assertThat(sd.getLastName()).startsWith("Nixon");
	}
}