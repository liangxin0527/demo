package com.example.common.mapper;

import com.example.common.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 34480
 */

@Mapper
public interface CommonMapper {
/**
 * description:
 * @param userName
 * @return com.example.common.pojo.User
 */
    @Select("select * from user where username=#{userName}")
    public User findUserByName(@Param("userName")String userName);
}
