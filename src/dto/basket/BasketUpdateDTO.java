package dto.basket;

public class BasketUpdateDTO {

    private Long memberKey;
    private int[] basketQuantity;

    public BasketUpdateDTO() {
    }

    public BasketUpdateDTO(Long memberKey, int[] basketQuantity) {
        this.memberKey = memberKey;
        this.basketQuantity = basketQuantity;
    }



    public Long getMemberKey() {
        return memberKey;
    }

    public void setMemberKey(Long memberKey) {
        this.memberKey = memberKey;
    }

    public int[] getBasketQuantity() {
        return basketQuantity;
    }

    public void setBasketQuantity(int basketQuantity) {
        this.basketQuantity = new int[]{basketQuantity};
    }
}
