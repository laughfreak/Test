package com.prj.mapper;

import com.prj.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    public List<Student> queryList(@Param("page") int page, @Param("limit") int limit);
    public int count();
    public int addStudent(Student studnet);
    public int delStudent(int sid);
    public Student queryBySid(int sid);
    public int updateStudent(Student student);

}
