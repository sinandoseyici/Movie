package restapi.demo.generic.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse<T> implements Serializable {

    private T data;

    private Date responseDate;

    private boolean isSuccess;

    private String messages;


    public RestResponse(T data, boolean isSuccess) {
        this.data = data;
        this.responseDate = new Date();
        this.isSuccess = isSuccess;
    }

    public static <T> RestResponse<T> of(T t){

        return new RestResponse<>(t, true);
    }

    public static <T> RestResponse<T> isEmpty(){

        return new RestResponse<>(null, true);
    }

}
