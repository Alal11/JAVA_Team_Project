package kyr.dto.order;


public class OrderDTO {
    private Long orderKey;

    public Long getOrderKey() {
        return orderKey;
    }

    private String orderDate;

    public String getOrderDate() {
        return orderDate;
    }

    private int totalPrice;

    public int getTotalPrice() {
        return totalPrice;
    }

    /*private List<OrderDetailDTO> orderDetails;

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }*/
}
