package management.dto;

public class ManagementDTO {
	
	int customerNo, nailNo;
	String name, content, phone, email, day;
	int price;
	
	
	public ManagementDTO() {	// 기본생성자
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getCustomerNo() {
		return customerNo;
	}


	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}


	public int getNailNo() {
		return nailNo;
	}


	public void setNailNo(int nailNo) {
		this.nailNo = nailNo;
	}

}
