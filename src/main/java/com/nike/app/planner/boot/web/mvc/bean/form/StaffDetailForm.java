
package com.nike.app.planner.boot.web.mvc.bean.form;

@UrlEncodedForm("STAFF_DETAIL_FORM")
public class StaffDetailForm implements UrlEncodedFormBean {

	private String actionName = null;
	private int id = 0;
	private String firstName = null;
	private String lastName = null;
	private String image = null;
	private String gender = null;
	private String position = null;
	private String email = null;
	private String office = null;
	private String extn = null;
	private String age = null;
	private String salary = null;
	private String startDateStr = null;

	public StaffDetailForm() {
		
	}

	public String toString() {
		return "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", image= " + image + ", gender=" + gender + ", position=" + position + ", email=" + email + ", office=" + office + ", extn=" + extn + ", age=" + age + ", salary=" + salary + ", startDateStr=" + startDateStr;
	}

	public int getId() {
		return id;
	}

	@UrlEncodedFormFieldMapping("id")
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	@UrlEncodedFormFieldMapping("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@UrlEncodedFormFieldMapping("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImage() {
		return image;
	}

	@UrlEncodedFormFieldMapping("image")
	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	@UrlEncodedFormFieldMapping("gender")
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	@UrlEncodedFormFieldMapping("position")
	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	@UrlEncodedFormFieldMapping("email")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getOffice() {
		return office;
	}

	@UrlEncodedFormFieldMapping("office")
	public void setOffice(String office) {
		this.office = office;
	}

	public String getExtn() {
		return extn;
	}

	@UrlEncodedFormFieldMapping("extn")
	public void setExtn(String extn) {
		this.extn = extn;
	}

	public String getAge() {
		return age;
	}

	@UrlEncodedFormFieldMapping("age")
	public void setAge(String age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}

	@UrlEncodedFormFieldMapping("salary")
	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getStartDateStr() {
		return startDateStr;
	}

	@UrlEncodedFormFieldMapping("startDateStr")
	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

	@Override
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	@Override
	public String getActionName() {
		return actionName;
	}
}