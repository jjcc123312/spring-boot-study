package com.jjcc.bootlaunch.service;

import com.jjcc.bootlaunch.config.exception.CustomException;
import com.jjcc.bootlaunch.model.User;

import java.util.List;

/**
 * @author Jjcc
 * @version 1.0.0
 * @description
 * @className IUserService.java
 * @createTime 2019年10月09日 14:43:00
 */
public interface IUserService {

    /**
     * 获取所有信息
     * @title getUserAll
     * @description
     * @author Jjcc
     * @return java.util.List<com.jjcc.bootlaunch.model.User>
     * @createTime 2019/10/9 17:26
     * @throws CustomException
     */
    List<User> getUserAll();

    /**
     * 删除指定数据
     * @title deleteUserInfo
     * @author Jjcc
     * @param id
     * @return int
     * @createTime 2019/10/9 22:23
     */
    int deleteUserInfo(Integer id);



    /**
     * 获取指定数据1
     * @title getUserInfo
     * @author Jjcc
     * @param id
     * @return com.jjcc.bootlaunch.model.User
     * @createTime 2019/10/9 21:45
     */
    User getUserInfo(Integer id);

    /**
     * 获取指定数据2
     * @title selectUserInfoLockTest1
     * @author Jjcc
     * @param id
     * @return com.jjcc.bootlaunch.model.User
     * @createTime 2019/10/11 23:48
     */
    User selectUserInfoLockTest1(Integer id);

    /**
     * 条件查询user信息
     * @title selectUserDispose
     * @author Jjcc
     * @param user
     * @return java.util.List<com.jjcc.bootlaunch.model.User>
     * @createTime 2019/10/19 21:17
     */
    List<User> selectUserDispose(User user);
}
