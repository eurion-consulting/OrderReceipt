package demo.rest.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

	private String operator;
	private List<OrderItem> items;
	
	public Receipt() {
		this.operator = "operator1";
		this.items = new ArrayList<OrderItem>();
		
		OrderItem item = new OrderItem();
		item.setProduct(new Product("coffe", BigDecimal.valueOf(20)));
		item.setQuantity(2);
		
		OrderItem item2 = new OrderItem();
		item.setProduct(new Product("cream", BigDecimal.valueOf(4)));
		item.setQuantity(20);
		
		this.items.add(item);
		this.items.add(item2);
	}
	
	public List<OrderItem> getItems(){
		return items;
	}
	
	public String getOperator() {
		return operator;
	}
}
