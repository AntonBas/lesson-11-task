package ua.lviv.lgs.domain;

import java.util.Objects;

public class Bricks {
	private Integer id;
	private String type;
	private double pricePerUnit;
	private Integer stock;

	public Bricks(Integer id, String type, double pricePerUnit, Integer stock) {
		super();
		this.id = id;
		this.type = type;
		this.pricePerUnit = pricePerUnit;
		this.stock = stock;
	}

	public Bricks(String type, double pricePerUnit, Integer stock) {
		super();
		this.type = type;
		this.pricePerUnit = pricePerUnit;
		this.stock = stock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pricePerUnit, stock, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bricks other = (Bricks) obj;
		return Objects.equals(id, other.id)
				&& Double.doubleToLongBits(pricePerUnit) == Double.doubleToLongBits(other.pricePerUnit)
				&& Objects.equals(stock, other.stock) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Bricks [id=" + id + ", type=" + type + ", pricePerUnit=" + pricePerUnit + ", stock=" + stock + "]";
	}

}
