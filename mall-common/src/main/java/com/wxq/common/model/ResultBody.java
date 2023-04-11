package com.wxq.common.model;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
public class ResultBody<T> {

    private T data;

    private String message;

    private Integer code;

    private Boolean success;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    private ResultBody(){}

    private ResultBody(Integer code, Boolean success, String message, T data){
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultBody<T> success(String msg, T data){
        ResultBody<T> responseVo = new ResultBody<>();
        responseVo.setCode(ErrorCode.SUCCESS);
        responseVo.setSuccess(true);
        responseVo.setMessage(msg);
        responseVo.setData(data);
        return responseVo;
    }

    public static <T> ResultBody<T> success(T data){
        return success("", data);
    }

    public static ResultBody success(){
        return success("", null);
    }

    public static <T> ResultBody<T> fail(String msg){
        ResultBody<T> responseVo = new ResultBody<>();
        responseVo.setCode(ErrorCode.FAIL);
        responseVo.setSuccess(false);
        responseVo.setMessage(msg);
        return responseVo;
    }

    public static ResultBody fail(){
        return fail("");
    }
}
