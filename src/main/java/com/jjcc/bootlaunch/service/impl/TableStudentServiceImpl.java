package com.jjcc.bootlaunch.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjcc.bootlaunch.generator.test1.TableStudentMapper;
import com.jjcc.bootlaunch.model.TableStudent;
import com.jjcc.bootlaunch.service.TableStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private TableStudentMapper tableStudentMapper;

    @Override
    public List<TableStudent> selectAll() {
        return tableStudentMapper.selectList(null);
    }

    @Override
    public IPage<TableStudent> selectPage(Page<TableStudent> page) {
        return tableStudentMapper.selectPageVo(page);
    }

}
