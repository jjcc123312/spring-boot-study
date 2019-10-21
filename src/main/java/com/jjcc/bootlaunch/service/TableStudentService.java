package com.jjcc.bootlaunch.service;

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


    List<TableStudent> selectAll();

}
