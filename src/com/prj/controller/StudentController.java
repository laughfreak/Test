package com.prj.controller;

import com.prj.entity.Student;
import com.prj.server.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    @Qualifier("StudentServerImpl")
    private StudentServer studentServer;

    @ResponseBody
    @RequestMapping("/delStudent/{sid}")
    public String delStudent(@PathVariable int sid){
        studentServer.delStudent(sid);
        return "删除成功";
    }

    @ResponseBody
    @RequestMapping("/queryStudent")
    public Map<String,Object> queryStudent(int page,int limit){
        Map<String,Object> jsonMap=new HashMap<String,Object>();
        page=(page-1)*limit;
        List<Student> studentList=studentServer.queryList(page,limit);

        jsonMap.put("code",0);
        jsonMap.put("msg","");
        jsonMap.put("count",studentServer.count());//总行数
        jsonMap.put("data",studentList);//数据

        return jsonMap;
    }
    @ResponseBody
    @RequestMapping("/addStudent")
    public String addStudent(Student student){

        studentServer.addStudent(student);

        return "添加成功";
    }

    /*@RequestMapping("/queryStudent")
    public String queryStudent(HttpServletRequest request){
        request.setAttribute("studentList",studentServer.queryList());
        return "index.jsp";
    }*/
    @RequestMapping("/queryBySid/{sid}")
    public String queryBySid(@PathVariable int sid, HttpServletRequest request){
        request.setAttribute("student",studentServer.queryBySid(sid));
        return "/update.jsp";
    }
    @ResponseBody
    @RequestMapping("/updateStudent")
    public String updateStudent(Student student){

        studentServer.updateStudent(student);

        return "修改成功";
    }






    public StudentServer getStudentServer() {
        return studentServer;
    }

    public void setStudentServer(StudentServer studentServer) {
        this.studentServer = studentServer;
    }
}
