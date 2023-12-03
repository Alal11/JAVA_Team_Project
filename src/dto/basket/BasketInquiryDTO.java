package dto.basket;


public class BasketInquiryDTO {
    private int ingredientPrice;
    private String ingredientName;
    private int basketQuantity;
    private Long basketKey;

    public BasketInquiryDTO() {
    }

    public BasketInquiryDTO(int ingredientPrice, String ingredientName, int basketQuantity, Long basketKey) {
        this.ingredientPrice = ingredientPrice;
        this.ingredientName = ingredientName;
        this.basketQuantity = basketQuantity;
        this.basketKey = basketKey;
    }

    public int getIngredientPrice() {
        return ingredientPrice;
    }

    public void setIngredientPrice(int ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getBasketQuantity() {
        return basketQuantity;
    }

    public void setBasketQuantity(int basketQuantity) {
        this.basketQuantity = basketQuantity;
    }

    public Long getBasketKey() {
        return basketKey;
    }

    public void setBasketKey(Long basketKey) {
        this.basketKey = basketKey;
    }
}