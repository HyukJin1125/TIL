package hyukjin.submit11;

public class Product {

	private String productName;
	private int productPrice;
	
	public Product(String productName, int productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}
		public Product(String productName) {
			this.productName = productName;
		}
		public Product() {
			
		}
	
		@Override
		public String toString() {
			return "Product [Name=" + productName + ", productPrice=" + productPrice + "]";
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}
	
	
	
	
	
	
}
