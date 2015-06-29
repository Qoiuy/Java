package domain;

public class Customer {
	
	public Customer() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Customer(String id, String username, String password, String sex,
			String email, String telephone, String description, String address,
			String actived, String code, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.telephone = telephone;
		this.description = description;
		this.address = address;
		this.actived = actived;
		this.code = code;
		this.role = role;
	}
	@Override
	public String toString() {
		return "customer [id=" + id + ", username=" + username + ", password="
				+ password + ", sex=" + sex + ", email=" + email
				+ ", telephone=" + telephone + ", description=" + description
				+ ", address=" + address + ", actived=" + actived + ", code="
				+ code + ", role=" + role + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getActived() {
		return actived;
	}
	public void setActived(String actived) {
		this.actived = actived;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String id;
	private String username;
	private String password;//加密
	private String sex;
	private String email;
	private String telephone;
	private String description;
	private String address;
	
	private String actived;//是否激活
	private String code;//激活码
	private String role;//代表是否为管理员
}
