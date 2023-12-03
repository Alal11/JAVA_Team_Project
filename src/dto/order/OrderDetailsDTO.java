package dto.order;

public class OrderDetailsDTO {
    private Long orderKey;
    private String[] ingredientName;
    private int[] ingredientPrice;
    private int[] orderDetailQuantity;
    private int totalPrice;
    private String orderDate;
    private String memberName;
    private String memberPhone;
    private String memberAddress;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(Long orderKey, String[] ingredientName, int[] ingredientPrice, int[] orderDetailQuantity, int totalPrice, String orderDate, String memberName, String memberPhone, String memberAddress) {
        this.orderKey = orderKey;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.orderDetailQuantity = orderDetailQuantity;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberAddress = memberAddress;
    }

    public Long getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(Long orderKey) {
        this.orderKey = orderKey;
    }

    public String[] getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String[] ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int[] getIngredientPrice() {
        return ingredientPrice;
    }

    public void setIngredientPrice(int[] ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }

    public int[] getOrderDetailQuantity() {
        return orderDetailQuantity;
    }

    public void setOrderDetailQuantity(int[] orderDetailQuantity) {
        this.orderDetailQuantity = orderDetailQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }
}