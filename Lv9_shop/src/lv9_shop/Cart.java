package lv9_shop;

class Cart {
	private String userId; // 구입한 유저 id
	private String itemName; // 구매한 아이템

	public Cart(String userId, String itemName) {
		this.userId = userId;
		this.itemName = itemName;
	}
	
	// get
	public String getUserId() {
		return userId;
	}
	public String getItemName() {
		return itemName;
	}
	// 출력
	void print() {
		System.out.println("[" + userId + "]" + "아이템 : " + itemName);
	}
}
