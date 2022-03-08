package study;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="groceryWeb")
public class GroceryProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	 private String productName;
	 
	@Column(name="product_des")
	private String productDesc;
	
	@Column(name="product_unit")
	private int unit;
	
	@Column(name="product_cost")
	private int productCost;
	
	@Column(name="expiry_date")
	private Date expiryDate;
	
	public GroceryProduct() {

System.out.println("Grocery Entity");
	}
	public GroceryProduct( String productName, String productDesc, int unit, int productCost,
			Date expiryDate) {
		super();
		/*this.productId = productId;*/
		this.productName = productName;
		this.productDesc = productDesc;
		this.unit = unit;
		this.productCost = productCost;
		this.expiryDate = expiryDate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		 System.out.println("set product id"); 
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		 System.out.println("set product name"); 
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		 System.out.println("set product desc"); 
		this.productDesc = productDesc;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		 System.out.println("set product unit"); 
		this.unit = unit;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		 System.out.println("set product cost"); 
		this.productCost = productCost;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		 System.out.println("set expiry date"); 
		this.expiryDate = expiryDate;
	}
	@Override
    public String toString()
    {
    	String str=" ";
    	str=str+"Product Id: "+productId+" Product Name: "+productName+" Product Desc: "+productDesc+" Quantity: "+unit+" Product Cost: "+productCost+" Product Expiry Date: "+expiryDate;
       return str;
    }
	
	
}
