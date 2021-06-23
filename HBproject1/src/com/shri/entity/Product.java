/**This is First program of hibernate to insert values i.e hardcoded values into db
 * 
 */
package com.shri.entity;

/**
 * @author Shriyash
 * @version 1.0
 */
public class Product {

	private Integer pid;
	private String pname;
	private Double price;
	private Double qty;
	private String status;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// toString()
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + ", status=" + status
				+ "]";
	}

}
