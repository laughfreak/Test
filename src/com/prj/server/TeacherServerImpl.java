package com.prj.server;

import com.prj.entity.Teacher;
import com.prj.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TeacherServerImpl")
public class TeacherServerImpl implements TeacherServer{
    @Autowired
    private TeacherMapper teacherMapper;

    public TeacherMapper getTeacherMapper() {
        return teacherMapper;
    }

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<Teacher> queryTeacherList() {
        return teacherMapper.queryTeacherList();
    }
}
