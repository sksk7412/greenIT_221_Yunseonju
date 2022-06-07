package lv9_shop_guide;
class Cart {
	String userId; // 구입한 유저 id
	String itemName; // 구매한 아이템

	void print() {
		System.out.println("[" + userId + "]" + "아이템 : " + itemName);
	}
}