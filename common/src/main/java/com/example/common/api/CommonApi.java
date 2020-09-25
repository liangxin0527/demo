package com.example.common.api;

import com.example.common.pojo.AjaxResult;
import com.example.common.pojo.User;
import com.example.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 34480
 */

@RestController
public class CommonApi {
    @Autowired
    private CommonService commonService;


    @GetMapping("/getMessageDemo")
    public AjaxResult getMessage(String userName){
       User user= commonService.loginByUserNameAndPassWord(userName);
       if (user==null){
           return AjaxResult.error();
       }
        return  AjaxResult.success();
    }
}
