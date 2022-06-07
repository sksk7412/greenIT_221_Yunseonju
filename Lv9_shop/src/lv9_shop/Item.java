package lv9_shop;

public class Item {
	String itemName;
	String category;
	int price;
	
	public Item(String itemName,String category,int price) {
		 this.itemName = itemName;
		 this.category = category;
		 this.price = price;
	}

	//get
	public String getItemName() {
		return itemName;
	}
	public String getCategory() {
		return category;
	}
	public int getPrice() {
		return price;
	}
	
	//set
	public void setPrice(int price) {
		this.price = price;
	}
	
	void print() {
		System.out.println("[" + itemName + "]" + "[" + price + "]" + "[" + category + "]");
	}
}
