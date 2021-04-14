package com.week7.latihanspringboot.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessagesDto<T> {
    private Integer status;
    private String message;
    private T data;
}
