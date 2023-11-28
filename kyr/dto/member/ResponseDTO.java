package kyr.dto.member;


public class ResponseDTO {
    private int status;

    public int getStatus() {
        return status;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public ResponseDTO(int status, String message){
        this.status=status;
        this.message=message;
    }
}
