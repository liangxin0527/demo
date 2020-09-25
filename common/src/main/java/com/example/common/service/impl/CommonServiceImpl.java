package com.example.common.service.impl;

import com.example.common.mapper.CommonMapper;
import com.example.common.pojo.User;
import com.example.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 34480
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonMapper commonMapper;
    @Override
    public User loginByUserNameAndPassWord(String userName) {
        return commonMapper.findUserByName(userName);
    }
}
