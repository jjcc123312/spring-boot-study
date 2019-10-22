package com.jjcc.bootlaunch.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jjcc.bootlaunch.model.TableStudent;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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
     * 学生分页
     * @title selectPage
     * @author Jjcc
     * @param page
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.jjcc.bootlaunch.model.TableStudent>
     * @createTime 2019/10/21 23:51
     */
    IPage<TableStudent> selectPage(Page<TableStudent> page);
}
