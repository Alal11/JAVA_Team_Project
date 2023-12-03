package dto.basket;


public class BasketAddDTO {
    private Long ingredientKey;
    private int basketQuantity;

    public BasketAddDTO() {
    }

    public BasketAddDTO(Long ingredientKey, int basketQuantity) {
        this.ingredientKey = ingredientKey;
        this.basketQuantity = basketQuantity;
    }

    public Long getIngredientKey() {
        return ingredientKey;
    }

    public void setIngredientKey(Long ingredientKey) {
        this.ingredientKey = ingredientKey;
    }

    public int getBasketQuantity() {
        return basketQuantity;
    }

    public void setBasketQuantity(int basketQuantity) {
        this.basketQuantity = basketQuantity;
    }
}

