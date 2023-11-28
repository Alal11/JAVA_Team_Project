package kyr.dto.basket;


public class BasketAddDTO {
    private Long ingredientKey;
    private int basketQuantity;


    public BasketAddDTO(Long ingredientKey, int basketQuantity) {
        this.ingredientKey = ingredientKey;
        this.basketQuantity = basketQuantity;
    }

    public Long getIngredientKey(){return ingredientKey;}

    public int getBasketQuantity(){return basketQuantity;}

}

