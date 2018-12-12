package com.yrj.mapper;

import com.yrj.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Delete("delete from employee where id = #{id}")
    public int delEmpById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into employee(lastName,email,gender,dId) values(#{lastName},#{email},#{gender},#{dId})")
    public int insertEmpById(Employee employee);

    @Update("update employee set lastName = #{lastName},email = #{email},gender=#{gender},dId=#{dId} where id = #{id}")
    public int updateEmp(Employee employee);
}
