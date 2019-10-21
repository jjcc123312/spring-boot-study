package com.jjcc.bootlaunch.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jjcc
 * @since 2019-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TableStudent extends Model<TableStudent> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    private Integer classIds;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
