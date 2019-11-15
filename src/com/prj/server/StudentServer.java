package com.prj.server;

import com.prj.entity.Student;

import java.util.List;

public interface StudentServer {
    //查询用户
    public List<Student> queryList(int page, int limit);
    public int count();
    public int addStudent(Student student);
    public int delStudent(int sid);
    public Student queryBySid(int sid);
    public int updateStudent(Student student);


}
