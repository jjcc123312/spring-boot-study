package com.jjcc.bootlaunch.generator.test1;

import com.jjcc.bootlaunch.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Jjcc
 * @version 1.0.0
 * @description
 * @className UserMapper.java
 * @createTime 2019年10月09日 14:58:00
 */
public interface UserMapper {

    /**
     * 获取所有信息
     * @title getUserAll
     * @description
     * @author Jjcc
     * @return java.util.List<com.jjcc.bootlaunch.model.User>
     * @createTime 2019/10/9 17:26
     * @throws
     */
     List<User> getUserAll();

    /**
     * 获取指定数据
     * @title getUserInfo
     * @author Jjcc
     * @param id
     * @return com.jjcc.bootlaunch.model.User
     * @createTime 2019/10/9 21:45
     */
     User getUserInfo(Integer id);

     /**
      * 删除指定数据
      * @title deleteUserInfo
      * @author Jjcc
      * @param id
      * @return int
      * @createTime 2019/10/9 22:23
      */
     int deleteUserInfo(Integer id);


     @Insert("insert into user values(null, #{user.username}, #{user.password})")
     int saveUserInfo(@Param("user") User user);
}
