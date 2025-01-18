package ua.lviv.lgs.domain;

import java.util.Objects;

public class OrderDetails {
	private Integer id;
	private Integer orderId;
	private Integer brickId;
	private Integer quantity;
	private double pricePerUnit;

	public OrderDetails(Integer id, Integer orderId, Integer brickId, Integer quantity, double pricePerUnit) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.brickId = brickId;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}

	public OrderDetails(Integer orderId, Integer brickId, Integer quantity, double pricePerUnit) {
		super();
		this.orderId = orderId;
		this.brickId = brickId;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getBrickId() {
		return brickId;
	}

	public void setBrickId(Integer brickId) {
		this.brickId = brickId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brickId, id, orderId, pricePerUnit, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		return Objects.equals(brickId, other.brickId) && Objects.equals(id, other.id)
				&& Objects.equals(orderId, other.orderId)
				&& Double.doubleToLongBits(pricePerUnit) == Double.doubleToLongBits(other.pricePerUnit)
				&& Objects.equals(quantity, other.quantity);
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderId=" + orderId + ", brickId=" + brickId + ", quantity=" + quantity
				+ ", pricePerUnit=" + pricePerUnit + "]";
	}

}
