package com.jjcc.bootlaunch.service.impl;

import com.jjcc.bootlaunch.config.exception.CustomException;
import com.jjcc.bootlaunch.config.exception.CustomExceptionType;
import com.jjcc.bootlaunch.generator.UserMapper;
import com.jjcc.bootlaunch.model.User;
import com.jjcc.bootlaunch.service.IUserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

    @Override
    public List<User> getUserAll() {
        List<User> userList;
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


    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    int a = 123;
//    @Async
    @Override
    public void simpleTest(String name) {
        lock.lock();
        try {
            if ("jjcc".equals(name)) {
                Thread.sleep(5000);
                System.out.println("!!!!!!!!!!!!!!!!：" + a);
            } else {
                a = 123;
                System.out.println("????????????????：" + a);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
