import java.util.HashMap;
import java.util.Map;

public class Cart {

    //儲存購物車的商品，key為商品名稱，value為數量
    private Map<String, Integer> items;
    //儲存商品價格，key為商品名稱，value為商品價格
    private Map<String, Integer> prices;

    public Map<String, Integer> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, Integer> prices) {
        this.prices = prices;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public Cart() {
        items = new HashMap<>();
        prices = new HashMap<>();

        prices.put("蘋果", 10);
        prices.put("橘子", 14);
        prices.put("香蕉", 12);
    }

    //將商品加入購物車
    public void addItem(String item, int qty) {
        if (items.containsKey(item)) {
            //如果有購買過該商品，則增加數量
            int newQty = items.get(item) + qty;
            items.put(item, newQty);
        } else {
            //如果沒買過該商品，則將商品加入購物車
            items.put(item, qty);
        }
    }

    //計算購物車中商品的總價格
    public int getTotalPrc() {
        int total = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            int price = prices.get(item);
            total += quantity * price;
        }
        return total;
    }

    //顯示購物車中所有商品的資訊
    public void showItems(Map<String, Integer> items, Map<String, Integer> prices) {
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String item = entry.getKey();
            int qty = entry.getValue();
            int price = prices.get(item);
            System.out.println(item + ":" + "1個" + price + "元" + "有" + qty + "個" + "一共是" + qty * price + "元");
        }
    }

    //顯示購物車中所有商品的總價格
    public void showTotal(int total) {
        System.out.println("全部商品一共" + total + "元");
    }

    //使用main方法測試
    public static void main(String[] args) {

        Cart cart = new Cart();
        Map items = cart.getItems();
        Map prices = cart.getPrices();
        cart.addItem("蘋果",1);
        cart.addItem("橘子",2);
        cart.addItem("香蕉",3);

        cart.showItems(items,prices);
        cart.showTotal(cart.getTotalPrc());

        cart.addItem("蘋果", 1);

        cart.showItems(items,prices);
        cart.showTotal(cart.getTotalPrc());

    }
}
