
package com.nike.app.planner.boot.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nike.app.planner.boot.util.convert.SimpleFormater;
import com.nike.app.planner.boot.web.mvc.bean.form.StaffDetailForm;

@Entity
@Table(name="PT_STAFF_DETAIL_TEST_TAB")
public class StaffDetail implements Serializable {

	private static final long serialVersionUID = -5618337193254182133L;

	private int staffId = 0;
	private String firstName = null;
	private String lastName = null;
	private String image = null;
	private String gender = null;
	private String position = null;
	private String email = null;
	private String office = null;
	private String extn = null;
	private int age = 0;
	private double salary = (double)0;
	private Date startDate = null;
	private String startDateStr = null;
	private long timeMillis = (long)0;
	@JsonProperty("DT_RowId")
	private String dt_rowid = null;

	public StaffDetail() {
		
	}

	public StaffDetail(int staffId, String firstName, String lastName, String image, String gender, String position, String email, String office, String extn, int age, double salary, Date startDate, long timeMillis) {
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.image = image;
		this.gender = gender;
		this.position = position;
		this.email = email;
		this.office = office;
		this.extn = extn;
		this.age = age;
		this.salary = salary;
		this.startDate = startDate;
		this.timeMillis = timeMillis;
	}

	public String toString() {
		return "staffId=" + staffId + ", firstName=" + firstName + ", lastName=" + lastName + ", image= " + image + ", gender=" + gender + ", position=" + position + ", email=" + email + ", office=" + office + ", extn=" + extn + ", age=" + age + ", salary=" + salary + ", startDate=" + startDate + ", startDateStr=" + startDateStr;
	}

	public void toSyn(StaffDetail staff) {
		this.firstName = (staff.getFirstName() != null && !staff.getFirstName().equals("")) ? staff.getFirstName() : this.firstName;
		this.lastName = (staff.getLastName() != null && !staff.getLastName().equals("")) ? staff.getLastName() : this.lastName;
		this.image = (staff.getImage() != null && !staff.getImage().equals("")) ? staff.getImage() : this.image;
		this.gender = (staff.getGender() != null && !staff.getGender().equals("")) ? staff.getGender() : this.gender;
		this.position = (staff.getPosition() != null && !staff.getPosition().equals("")) ? staff.getPosition() : this.position;
		this.email = (staff.getEmail() != null && !staff.getEmail().equals("")) ? staff.getEmail() : this.email;
		this.office = (staff.getOffice() != null && !staff.getOffice().equals("")) ? staff.getOffice() : this.office;
		this.extn = (staff.getExtn() != null && !staff.getExtn().equals("")) ? staff.getExtn() : this.extn;
		this.age = (staff.getAge() != 0) ? staff.getAge() : this.age;
		this.salary = (staff.getSalary() != (double)0) ? staff.getSalary() : this.salary;
		this.startDate = (staff.getStartDate() != null) ? staff.getStartDate() : this.startDate;
	}

	public void toSynForm(StaffDetailForm staff) {
		this.staffId = (staff.getId() != 0) ? staff.getId() : this.staffId;
		this.firstName = (staff.getFirstName() != null && !staff.getFirstName().equals("")) ? staff.getFirstName() : this.firstName;
		this.lastName = (staff.getLastName() != null && !staff.getLastName().equals("")) ? staff.getLastName() : this.lastName;
		this.image = (staff.getImage() != null && !staff.getImage().equals("")) ? staff.getImage() : this.image;
		this.gender = (staff.getGender() != null && !staff.getGender().equals("")) ? staff.getGender() : this.gender;
		this.position = (staff.getPosition() != null && !staff.getPosition().equals("")) ? staff.getPosition() : this.position;
		this.email = (staff.getEmail() != null && !staff.getEmail().equals("")) ? staff.getEmail() : this.email;
		this.office = (staff.getOffice() != null && !staff.getOffice().equals("")) ? staff.getOffice() : this.office;
		this.extn = (staff.getExtn() != null && !staff.getExtn().equals("")) ? staff.getExtn() : this.extn;
		this.age = (staff.getAge() != null && !staff.getAge().equals("")) ? Integer.parseInt(staff.getAge()) : this.age;
		this.salary = (staff.getSalary() != null && !staff.getSalary().equals("")) ? Double.parseDouble(staff.getSalary()) : this.salary;
		this.startDate = (staff.getStartDateStr() != null && !staff.getStartDateStr().equals("")) ? SimpleFormater.simpleFormate(staff.getStartDateStr()) : this.startDate;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="STAFF_ID")
	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="IMAGE_B64")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name="GENDER")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name="POSITION")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="OFFICE")
	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	@Column(name="EXTN")
	public String getExtn() {
		return extn;
	}

	public void setExtn(String extn) {
		this.extn = extn;
	}

	@Column(name="AGE")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name="SALARY")
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Column(name="START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Transient
	public String getStartDateStr() {
		return SimpleFormater.simpleFormate(startDate);
	}

	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

	@Transient
	public String getDt_rowid() {
		return "row_" + staffId;
	}

	public void setDt_rowid(String dt_rowid) {
		this.dt_rowid = dt_rowid;
	}

	@Column(name="TIME_MILLIS")
	public long getTimeMillis() {
		return timeMillis;
	}

	public void setTimeMillis(long timeMillis) {
		this.timeMillis = timeMillis;
	}
}