package kyr.dto.basket;

public class BasketUpdateDTO {

    private Long memberKey;

    public Long getMemberKey() {
        return memberKey;
    }

    private int basketQuantity;

    public int getBasketQuantity() {
        return basketQuantity;
    }

    public BasketUpdateDTO(Long memberKey, int basketQuantity) {
        this.memberKey = memberKey;
        this.basketQuantity = basketQuantity;
    }
}
