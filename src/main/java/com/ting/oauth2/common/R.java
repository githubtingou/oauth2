package com.ting.oauth2.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * 统一返参
 *
 * @author lishuang
 * @version 1.0
 * @date 2023/03/10 16:22
 */
@Data
@Accessors(chain = true)
@Builder
public class R<T> {

    private String code;
    private String message;
    private boolean success;
    private T data;


    public static <T> R<T> OK(T t) {
        return (R<T>) R.builder().success(ResponseCode.OK.isSuccess())
                .code(ResponseCode.OK.getCode())
                .message(ResponseCode.OK.getMessage())
                .data(t)
                .build();

    }

    public static R<Void> OK() {
        return OK(null);

    }


    public static R<Object> error() {
        return error(ResponseCode.ERROR);

    }

    public static R<Object> error(ResponseCode code) {
        return R.builder().success(code.isSuccess())
                .code(code.getCode())
                .message(code.getMessage())
                .build();

    }

    public static <T> R<T> error(ResponseCode code, T message) {
        return (R<T>) R.builder().success(code.isSuccess())
                .code(code.getCode())
                .message(code.getMessage())
                .build();

    }


    @Getter
    @AllArgsConstructor
    public enum ResponseCode {
        OK("200", "处理成功", true),
        ERROR("400", "处理失败"),
        AUTH_ERROR("401", "权限验证失败"),
        ;

        private final String code;
        private final String message;
        private boolean success;

        ResponseCode(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
