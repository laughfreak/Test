package com.prj.controller;

import com.prj.entity.Teacher;
import com.prj.server.TeacherServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    @Qualifier("TeacherServerImpl")
    private TeacherServer teacherServer;

    @ResponseBody
    @RequestMapping("/queryTeacher")
    public List<Teacher> queryTeacher(){
        return teacherServer.queryTeacherList();
    }

    public TeacherServer getTeacherServer() {
        return teacherServer;
    }

    public void setTeacherServer(TeacherServer teacherServer) {
        this.teacherServer = teacherServer;
    }
}
