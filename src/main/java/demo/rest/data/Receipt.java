package demo.rest.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

	private Operator operator;
	private List<OrderItem> items;
	
	public Receipt() {
		this.operator = new Operator("operator1");
		this.items = new ArrayList<OrderItem>();
		
		OrderItem item = new OrderItem();
		item.setProduct(new Product("coffe", BigDecimal.valueOf(20)));
		item.setQuantity(2);
		
		this.items.add(item);
	}
	
	public List<OrderItem> getItems(){
		return items;
	}
	
	public Operator getOperator() {
		return operator;
	}
}
