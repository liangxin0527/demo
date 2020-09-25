package com.example.scurity.mapper;

import com.example.scurity.data.RoleDO;
import com.example.scurity.data.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liang
 * @date 2020/9/21
 */
@Mapper
public interface UserMapper {
    /**
     * queryUserLogByUserName
     *
     * @param username
     * @return
     */
    @Select("select * from user where username=#{username}")
    public UserDO queryUserLogByUserName(@Param("username") String username);

    /**
     * queryUserRoleByUserId
     * @param id
     * @return
     */
    @Select("select * from  role  r inner join user_role  rr on rr.role_id=r.id  where rr.user_id=#{id} " )
    List<RoleDO> queryUserRoleByUserId(@Param("id") String id);

    /**
     * queryUserPerm
     * @param id
     * @return
     */

    @Select("select  * from user_role ur left join role_menu rm on ur.role_id=rm.role_Id left join menu m on rm.menu_id=m.id where ur.user_id =#{id}")
    List<String> queryUserPerm(@Param("id") String id);
}
