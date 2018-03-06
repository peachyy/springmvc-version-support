package com.peachyy.springmvc.controller;



import com.peachyy.message.BaseMessageResult;
import com.peachyy.message.ResponseCode;
import com.peachyy.springmvc.support.Version;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Taoxs on 2017/10/23.
 */
@RestController
@RequestMapping(value = {"","{v}/"})
public class HellController {
    @RequestMapping(value = {"","/"})
    public BaseMessageResult hello3(){
        BaseMessageResult result=new BaseMessageResult();
        result.setCode(ResponseCode.SC_OK.getCode());
        result.setMsg(ResponseCode.SC_OK.getMsg());
        result.setData("hellov3");
        return result;
    }
    @RequestMapping(value = {"/4"})
    public BaseMessageResult hello4(){
        BaseMessageResult result=new BaseMessageResult();
        result.setCode(ResponseCode.SC_OK.getCode());
        result.setMsg(ResponseCode.SC_OK.getMsg());
        result.setData("hellov4");
        return result;
    }

    @RequestMapping(value = {"/2","/1"})
    @Version(version = "v1")
    public BaseMessageResult hello(){
        BaseMessageResult result=new BaseMessageResult();
        result.setCode(ResponseCode.SC_OK.getCode());
        result.setMsg(ResponseCode.SC_OK.getMsg());
        result.setData("hellov1");
        return result;
    }
    @RequestMapping(value = {"","/"})
    @Version(version = "v2")
    public BaseMessageResult hello1(){
        BaseMessageResult result=new BaseMessageResult();
        result.setCode(ResponseCode.SC_OK.getCode());
        result.setMsg(ResponseCode.SC_OK.getMsg());
        result.setData("hellov2");
        return result;
    }
}
