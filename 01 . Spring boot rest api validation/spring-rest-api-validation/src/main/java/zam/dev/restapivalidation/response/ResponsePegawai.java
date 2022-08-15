package zam.dev.restapivalidation.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponsePegawai<T> {

    private List<String> message = new ArrayList<>();

    private boolean status;

    private T payLoad;

}
