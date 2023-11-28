package kyr.dto.order;


public class OrderHistoryDTO {
    private Long orderKey;

    public Long getOrderKey() {
        return orderKey;
    }

    private String orderDate;

    public String getOrderDate() {
        return orderDate;
    }

    private String ingredientName;

    public String getIngredientName() {
        return ingredientName;
    }

    private int totalPrice;

    public int getTotalPrice() {
        return totalPrice;
    }

    public OrderHistoryDTO(Long orderKey, String orderDate, String ingredientName
            , int totalPrice) {
        this.orderKey = orderKey;
        this.orderDate= orderDate;
        this.ingredientName = ingredientName;
        this.totalPrice = totalPrice;

    }
}

