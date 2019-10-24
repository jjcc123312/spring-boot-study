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
    Future<Boolean> saveStudentList(List<TableStudent> list) throws Exception;

}
