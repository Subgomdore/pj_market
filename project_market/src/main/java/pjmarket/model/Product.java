package pjmarket.model;

public class Product {

	private int product_num;
	private String product_l;
	private String product_m;
	private String product_name;
	private int product_price;
	private String product_content;
	private String product_sub;
	private String product_img;
	private int product_stock;
	
		// page
		private int startRow;
		private int endRow;
		
		// 검색
		private String search;
		private String keyword;
	
	
	
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
	public String getProduct_l() {
		return product_l;
	}
	public void setProduct_l(String product_l) {
		this.product_l = product_l;
	}
	public String getProduct_m() {
		return product_m;
	}
	public void setProduct_m(String product_m) {
		this.product_m = product_m;
	}

	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_content() {
		return product_content;
	}
	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}
	public String getProduct_sub() {
		return product_sub;
	}
	public void setProduct_sub(String product_sub) {
		this.product_sub = product_sub;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public int getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	
}
