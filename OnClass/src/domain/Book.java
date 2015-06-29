package domain;

public class Book {
	
	/*
	 * 生成Getter和Setter
	 * 生成toString()
	 * 生成有参构造函数
	 * 生成无参构造函数
	 * */
	public Book() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Book(String id, String name, String anthor, String price,
			String imageName, String description, String categoryid) {
		super();
		this.id = id;
		this.name = name;
		this.anthor = anthor;
		this.price = price;
		this.imageName = imageName;
		this.description = description;
		this.categoryid = categoryid;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", anthor=" + anthor
				+ ", price=" + price + ", imageName=" + imageName
				+ ", description=" + description + ", categoryid=" + categoryid
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAnthor() {
		return anthor;
	}
	public void setAnthor(String anthor) {
		this.anthor = anthor;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	private String id;
	private String name;
	private String anthor;
	private String price;
	private String imageName;
	private String description;
	private String categoryid;
}
