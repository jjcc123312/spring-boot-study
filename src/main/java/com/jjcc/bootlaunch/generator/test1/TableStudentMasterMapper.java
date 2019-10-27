package com.jjcc.bootlaunch.generator.test1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jjcc.bootlaunch.model.TableStudent;
import org.apache.ibatis.annotations.Param;
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
public interface TableStudentMasterMapper extends BaseMapper<TableStudent> {

    @Select("select id, name, sex, age, class_ids as classIds from table_student")
    List<TableStudent> selectAll();

    /**
     * 新增多条数据
     * @title saveStudentList
     * @author Jjcc
     * @param students
     * @return int
     * @createTime 2019/10/25 23:20
     */
    int saveStudentList(@Param("students") List<TableStudent> students);

}
