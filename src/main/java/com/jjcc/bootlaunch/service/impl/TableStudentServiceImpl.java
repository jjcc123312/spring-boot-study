package com.jjcc.bootlaunch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjcc.bootlaunch.config.exception.CustomException;
import com.jjcc.bootlaunch.config.exception.CustomExceptionType;
import com.jjcc.bootlaunch.generator.test1.TableStudentMapper;
import com.jjcc.bootlaunch.model.TableStudent;
import com.jjcc.bootlaunch.service.TableStudentService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Future;

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
        List<TableStudent> list;
        try {

            list = tableStudentMapper.selectAll();

        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "selectAll方法出现异常");
        }
        return list;
    }

    @Override
    public TableStudent selectById(Serializable id) {
        return tableStudentMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager" )
    @Async("asyncPoolTaskExecutor")
    @Override
    public Future<Boolean> saveStudentList(List<TableStudent> list) throws Exception {
        boolean b = saveBatch(list, 1000);
        return new AsyncResult<>(b);
    }
}
