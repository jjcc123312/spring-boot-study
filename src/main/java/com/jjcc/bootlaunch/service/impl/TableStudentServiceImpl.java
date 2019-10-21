package com.jjcc.bootlaunch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjcc.bootlaunch.generator.test1.TableStudentMapper;
import com.jjcc.bootlaunch.model.TableStudent;
import com.jjcc.bootlaunch.service.TableStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jjcc
 * @since 2019-10-20
 */
@Service
public class TableStudentServiceImpl extends ServiceImpl<TableStudentMapper, TableStudent> implements TableStudentService {

    @Resource
    private TableStudentMapper tableStudentMapper;

    @Override
    public List<TableStudent> selectAll() {
        return tableStudentMapper.selectAll();
    }
}
