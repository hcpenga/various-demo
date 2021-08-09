package com.example.variousdemo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author vicente
 * @since 2021-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Testone extends Model<Testone> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    @TableField("deptId")
    private Integer deptId;

    private Float salary;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
