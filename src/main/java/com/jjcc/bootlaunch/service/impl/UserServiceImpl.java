package com.jjcc.bootlaunch.service.impl;

import com.jjcc.bootlaunch.config.exception.CustomException;
import com.jjcc.bootlaunch.config.exception.CustomExceptionType;
import com.jjcc.bootlaunch.generator.test1.UserMapper;
import com.jjcc.bootlaunch.generator.test2.User2Mapper;
import com.jjcc.bootlaunch.model.User;
import com.jjcc.bootlaunch.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jjcc
 * @version 1.0.0
 * @description
 * @className UserServiceImpl.java
 * @createTime 2019年10月09日 15:02:00
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper1;

    @Resource
    private User2Mapper user2Mapper;

//    @Autowired
//    @Qualifier("primaryTransactionManager")
//    private DataSourceTransactionManager transactionManagerMaster;
//
//    @Autowired
//    @Qualifier("secondaryTransactionManager")
//    private DataSourceTransactionManager transactionManagerSlave;

    @Autowired
    TransactionDefinition transactionDefinition;

    @Override
    public List<User> getUserAll() {
        List<User> userList = new ArrayList<>();
        try {
            userList = userMapper1.getUserAll();

//            int i = 1 / 0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "在getUserAll，出现了除数为0的代码");
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "在getUserAll方法内出现系统异常");
        }
        return userList;
    }

    @Override
    public User getUserInfo(Integer id) {
        User userInfo = userMapper1.getUserInfo(id);
        return userInfo;
    }

    @Override
    public User selectUserInfoLockTest1(Integer id) {
        User userInfo = userMapper1.getUserInfo(id);
        return userInfo;
    }

    @Override
    public int deleteUserInfo(Integer id) {
        return userMapper1.deleteUserInfo(id);
    }

    @Override
    public int deleteUserInfos(Integer args1, Integer args2) {
        int i = userMapper1.deleteUserInfo(args1);
        int i1 = user2Mapper.deleteUserInfo(args2);
        return 0;
    }

    @Override
    public List<User> getSlaveUserInfoAll() {
        return user2Mapper.getUserAll();
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = {ArithmeticException.class, Error.class})
    public int saveUseInfo(User user) {
            userMapper1.saveUserInfo(user);
            user2Mapper.saveUserInfo(user);
        int s = 5 / 0;
       return 0;
    }


    @Override
    public List<User> selectUserDispose(User user) {
        List<User> userList = new ArrayList<>();
        try {
            userList = userMapper1.selectUserDispose(user);
        } catch (CustomException e) {
            e.printStackTrace();
//            throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "方法selectUserDispose有问题");
        }
        return userList;
    }
}
