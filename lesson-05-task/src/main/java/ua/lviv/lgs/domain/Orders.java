package ua.lviv.lgs.domain;

import java.util.Date;
import java.util.Objects;

public class Orders {
	private Integer id;
	private String customerFirstName;
	private String customerLastName;
	private Date orderDate;
	private double totalPrice;

	public Orders(Integer id, String customerFirstName, String customerLastName, Date orderDate, double totalPrice) {
		super();
		this.id = id;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}

	public Orders(String customerFirstName, String customerLastName, Date orderDate, double totalPrice) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerFirstName, customerLastName, id, orderDate, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(customerFirstName, other.customerFirstName)
				&& Objects.equals(customerLastName, other.customerLastName) && Objects.equals(id, other.id)
				&& Objects.equals(orderDate, other.orderDate)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", customerFirstName=" + customerFirstName + ", customerLastName="
				+ customerLastName + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + "]";
	}

}
