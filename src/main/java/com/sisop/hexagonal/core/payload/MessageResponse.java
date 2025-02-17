package com.sisop.hexagonal.core.payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class MessageResponse implements Serializable {

    private Boolean success;
    private String message;
    private Object data;
    private Object errors;

}
