package dto.order;


public class OrderCreateDTO {

    private Long ingredientKey;
    private int orderQuantity;

    public OrderCreateDTO() {
    }

    public OrderCreateDTO(Long ingredientKey, int orderQuantity) {
        this.ingredientKey = ingredientKey;
        this.orderQuantity = orderQuantity;
    }

    public Long getIngredientKey() {
        return ingredientKey;
    }

    public void setIngredientKey(Long ingredientKey) {
        this.ingredientKey = ingredientKey;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}

