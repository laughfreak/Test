package com.prj.server;

import com.prj.entity.Student;
import com.prj.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudentServerImpl")
public class StudentServerImpl implements StudentServer {
    @Autowired
    private StudentMapper studentMapper;

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }


    //查询用户
    @Override
    public List<Student> queryList(int page, int limit) {
        return studentMapper.queryList(page,limit);
    }

    @Override
    public int count() {
        return studentMapper.count();
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int delStudent(int sid) {
        return studentMapper.delStudent(sid);
    }

    @Override
    public Student queryBySid(int sid) {
        return studentMapper.queryBySid(sid);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }
}

