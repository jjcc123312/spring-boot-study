package com.jjcc.bootlaunch.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjcc.bootlaunch.config.exception.CustomException;
import com.jjcc.bootlaunch.config.exception.CustomExceptionType;
import com.jjcc.bootlaunch.generator.mysqldao.TableStudentMasterMapper;
import com.jjcc.bootlaunch.generator.redisdao.TableStudentDAO;
import com.jjcc.bootlaunch.model.TableStudent;
import com.jjcc.bootlaunch.service.TableStudentService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
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
public class TableStudentServiceImpl extends ServiceImpl<TableStudentMasterMapper, TableStudent> implements TableStudentService {

    @Resource
    private TableStudentMasterMapper tableStudentMasterMapper;

    private TableStudentDAO tableStudentDAO;

    public TableStudentServiceImpl(TableStudentDAO tableStudentDAO) {
        this.tableStudentDAO = tableStudentDAO;
    }

    @Override
    @DS("slaveDb")
    public List<TableStudent> selectAll() {
        List<TableStudent> list;
        try {

            list = tableStudentMasterMapper.selectAll();

        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "selectAll方法出现异常");
        }
        return list;
    }

    @Override
    @DS("slaveDb")
    public List<TableStudent> selectAllTwo() {
        List<TableStudent> list;
        try {

            list = tableStudentMasterMapper.selectAll();

        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "selectAllTwo方法出现异常");
        }
        return list;
    }

    @Override
    public TableStudent selectById(Serializable id) {
        return tableStudentMasterMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Async("asyncPoolTaskExecutor")
    @Override
    public Boolean saveStudentList(List<TableStudent> list)  {
        try {
            System.out.println("name：" + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tableStudentMasterMapper.saveStudentList(list);
        return true;
    }

    @Override
    public List<Object> redisPipeLineTestMethod() {
        return tableStudentDAO.redisPipelineMethod();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveStudent(TableStudent tableStudent) {
        int insert = tableStudentMasterMapper.insertStudent(tableStudent);

//        int i =  1 / 0;

        return insert;
    }

}
