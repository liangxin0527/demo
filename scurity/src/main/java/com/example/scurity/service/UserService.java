package com.example.scurity.service;

import com.example.scurity.data.RoleDO;
import com.example.scurity.data.UserDO;
import com.example.scurity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author liang
 * @date 2020/9/21
 */
public class UserService  implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

     UserDO userLog= userMapper.queryUserLogByUserName(username);
     List<RoleDO> roleDO= userMapper.queryUserRoleByUserId(userLog.getId());
        List<String> permList =userMapper.queryUserPerm(userLog.getId());
        return null;
//        return new UserDO(username,passwordEncoder.encode(userLog.getPassword()),roleDO,null);
    }

}
