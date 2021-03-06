package com.jjcc.bootlaunch.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jjcc.bootlaunch.model.TableStudent;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Future;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jjcc
 * @since 2019-10-20
 */
public interface TableStudentService extends IService<TableStudent> {


    /**
     * 查找所有学生
     * @title selectAll
     * @author Jjcc
     * @return java.util.List<com.jjcc.bootlaunch.model.TableStudent>
     * @createTime 2019/10/21 23:50
     */
    List<TableStudent> selectAll();

    /**
     * 查找所有学生
     * @title selectAll
     * @author Jjcc
     * @return java.util.List<com.jjcc.bootlaunch.model.TableStudent>
     * @createTime 2019/10/21 23:50
     */
    List<TableStudent> selectAllTwo();

    /**
     * 根据Id查询数据
     * @title selectById
     * @author Jjcc
     * @param id
     * @return com.jjcc.bootlaunch.model.TableStudent
     * @createTime 2019/10/24 14:52
     */
    TableStudent selectById(Serializable id);

    /**
     * 添加数据
     * @title saveStudentList
     * @author Jjcc
     * @param list
     * @return boolean
     * @createTime 2019/10/24 15:22
     */
    Boolean saveStudentList(List<TableStudent> list);


    /**
     * springboot使用pipeline批量操作redis
     * @title redisPipeLineTestMethod
     * @author Jjcc
     * @return java.util.List<java.lang.Object>
     * @createTime 2019/11/13 21:55
     */
    List<Object> redisPipeLineTestMethod();

    /**
     * 添加数据
     * @title saveStudent
     * @author Jjcc
     * @param tableStudent
     * @return boolean
     * @createTime 2019/11/18 9:28
     */
    int saveStudent(TableStudent tableStudent);

}
