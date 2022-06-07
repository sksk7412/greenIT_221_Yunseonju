package lv9_shop;

class Cart {
	String userId; // 구입한 유저 id
	String itemName; // 구매한 아이템

	public Cart(String userId, String itemName) {
		this.userId = userId;
		this.itemName = itemName;
	}

	void print() {
		System.out.println("[" + userId + "]" + "아이템 : " + itemName);
	}
}
