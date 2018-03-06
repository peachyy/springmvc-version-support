package com.peachyy.message;


public enum ResponseCode {
    SC_OK(200, "OK"),
    SC_NOT_DATA(204, "没有数据"),
    SC_BAD_REQUEST(400, "Bad Request/错误请求"),
    SC_UNAUTHORIZED(401, "Unauthorized/未授权"),
    SC_FORBIDDEN(403, "Forbidden/禁止"),
    SC_NOT_FOUND(404, "Not Found/未找到"),
    SC_PRECONDITION_FAILED(412,"Precondition Failed/先决条件错误"),
    SC_INTERNAL_SERVER_ERROR(500, "Internal Server Error/内部服务器错误"),
    SC_INTERNAL_SERVER_ERROR_PRICE_NOT_EQ(50001, "价格变动"),
    SC_INTERNAL_SERVER_ERROR_COUPON_TIMEOOUT(50002, "优惠券超期"),
    SC_INTERNAL_SERVER_ERROR_COUPON_ERRSTATUS(50003, "优惠券状态异常"),
    SC_INTERNAL_SERVER_ERROR_COUPON_OPERATERR(50004, "优惠券状态操作异常"),
    SC_HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported/不支持的 HTTP 版本"),
    SC_TOO_MANY_REQUEST(429,"Too Many Requests/请求太频繁 请稍后再试");//并告诉请求方  Retry-After报头


    private int code;
    private String msg;
    private ResponseCode(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public int getCode()
    {
        return this.code;
    }

    public String getMsg()
    {
        return this.msg;
    }
}
