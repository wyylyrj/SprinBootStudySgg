package com.yrj.mapper;

import com.yrj.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int delDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDeptById(Department department);

    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    public int updateDept(Department department);
}
