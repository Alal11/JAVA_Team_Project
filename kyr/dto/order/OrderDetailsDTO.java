package kyr.dto.order;

public class OrderDetailsDTO {
    private Long orderKey;

    public Long getOrderKey() {
        return orderKey;
    }

    private String[] ingredientName;

    public String[] getIngredientName() {
        return ingredientName;
    }

    private int[] ingredientPrice;

    public int[] getIngredientPrice() {
        return ingredientPrice;
    }

    private int[] orderDetailQuantity;

    public int[] getOrderDetailQuantity() {
        return orderDetailQuantity;
    }

    private int totalPrice;

    public int getTotalPrice() {
        return totalPrice;
    }

    private String orderDate;

    public String getOrderDate() {
        return orderDate;
    }

    private String memberName;

    public String getMemberName() {
        return memberName;
    }

    private String memberPhone;

    public String getMemberPhone() {
        return memberPhone;
    }

    private String memberAddress;

    public String getMemberAddress() {
        return memberAddress;
    }
}