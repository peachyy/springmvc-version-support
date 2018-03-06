package com.peachyy.message;

/**
 * Created by Taoxs on 2017/10/23.
 */
public class BaseMessageResult implements java.io.Serializable {
    private static final long serialVersionUID = -763699707098454152L;

    private int code;

    private String msg;

    private String version;

    private Object data;
    public BaseMessageResult(){

    }
    public BaseMessageResult(ResponseCode code){
        this.code=code.getCode();
        this.msg=code.getMsg();
    }
    public BaseMessageResult(ResponseCode code,Object data){
        this.code=code.getCode();
        this.msg=code.getMsg();
        this.data=data;
    }
    public int getCode() {
        return code;
    }

    public BaseMessageResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BaseMessageResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public BaseMessageResult setData(Object data) {
        this.data = data;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static BaseMessageResult error(){
        return new BaseMessageResult(ResponseCode.SC_INTERNAL_SERVER_ERROR);
    }
    public static BaseMessageResult error(String msg){
        return new BaseMessageResult(ResponseCode.SC_INTERNAL_SERVER_ERROR).setMsg(msg);
    }
    public static BaseMessageResult error(ResponseCode code){
        return new BaseMessageResult(code);
    }
    public static BaseMessageResult success(){
        BaseMessageResult result=new BaseMessageResult(ResponseCode.SC_OK);
        return result;
    }
    public static BaseMessageResult success(Object data){
        BaseMessageResult result=new BaseMessageResult(ResponseCode.SC_OK,data);
        return result;
    }
}
