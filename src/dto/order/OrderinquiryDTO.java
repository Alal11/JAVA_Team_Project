package dto.order;


public class OrderinquiryDTO {
    private Long orderKey;
    private String orderDate;
    private String ingredientName;
    private int totalPrice;

    public OrderinquiryDTO() {
    }

    public OrderinquiryDTO(Long orderKey, String orderDate, String ingredientName
            , int totalPrice) {
        this.orderKey = orderKey;
        this.orderDate= orderDate;
        this.ingredientName = ingredientName;
        this.totalPrice = totalPrice;

    }

    public Long getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(Long orderKey) {
        this.orderKey = orderKey;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}

