package kyr.dto.basket;


public class BasketInquiryDTO {
    private int ingredientPrice;

    public int getIngredientPrice() {
        return ingredientPrice;
    }

    private String ingredientName;

    public String getIngredientName() {
        return ingredientName;
    }

    private int basketQuantity;

    public int getBasketQuantity() {
        return basketQuantity;
    }

    private Long basketKey;

    public Long getBasketKey() {
        return basketKey;
    }

    public BasketInquiryDTO(int ingredientPrice, String ingredientName, int basketQuantity, Long basketKey) {
        this.ingredientPrice = ingredientPrice;
        this.ingredientName = ingredientName;
        this.basketQuantity = basketQuantity;
        this.basketKey = basketKey;
    }



}