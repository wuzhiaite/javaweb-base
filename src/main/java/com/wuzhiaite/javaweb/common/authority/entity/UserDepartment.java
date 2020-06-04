package com.wuzhiaite.javaweb.common.authority.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.wuzhiaite.javaweb.base.entity.TreeEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.ToString;

/**
* <p>
* 
* </p>
*
* @author lpf
* @since 2020-06-01
*/
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserDepartment对象", description="")
public class UserDepartment extends TreeEntity<UserDepartment> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String departmentName;
    @TableField("isValidate")
    private Boolean isValidate ;

    private String bz;
    @TableField(exist = false)
    private String label;

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName ;
        this.label = departmentName ;
    }
}
