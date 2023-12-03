package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.order.OrderCreateDTO;
import dto.order.OrderDetailsDTO;
import dto.order.OrderinquiryDTO;

import java.util.List;

public class OrderApi {

    private static ObjectMapper mapper = new ObjectMapper();
    private static final HttpRequestManager HTTP_REQUEST_MANAGER = new HttpRequestManager();

    // 주문 생성 테스트 (성공!)
    public static void placeOrder(Long memberKey, List<OrderCreateDTO> orderList) {
        String endPoint = "/order/place?memberKey="+memberKey;
        String requestBody;
        try {
            requestBody = mapper.writeValueAsString(orderList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HTTP_REQUEST_MANAGER.postRequest(endPoint, requestBody);
    }


   // 주문 조회 테스트 (성공!)
    public static List<OrderinquiryDTO> inquiryOrder(Long MemberKey) {
        List<OrderinquiryDTO> list;
        String endPoint = "/order/inquiry?memberKey="+MemberKey;
        String response = HTTP_REQUEST_MANAGER.getRequest(endPoint);

        try {
            list = mapper.readValue(response, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return list;
    }


    // 주문 상세 조회 테스트 (성공!)
    public static OrderDetailsDTO inquiryDetailOrder(Long memberKey, Long orderKey) {
        OrderDetailsDTO orderDetailsDTO;
        String endPoint = "/order/inquiry/detail?memberKey="+memberKey+"&orderKey="+orderKey;
        String response=HTTP_REQUEST_MANAGER.getRequest(endPoint);

        try {
            orderDetailsDTO = mapper.readValue(response, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return orderDetailsDTO;
    }
}