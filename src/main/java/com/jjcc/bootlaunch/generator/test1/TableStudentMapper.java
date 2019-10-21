package com.jjcc.bootlaunch.generator.test1;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jjcc.bootlaunch.model.TableStudent;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jjcc
 * @since 2019-10-20
 */
public interface TableStudentMapper extends BaseMapper<TableStudent> {

    @Select("select id, name, sex, age, class_ids as classIds from table_student")
    List<TableStudent> selectAll();

//    List<TableStudent> selectList();
}
