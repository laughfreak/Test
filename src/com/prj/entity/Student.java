package com.prj.entity;


public class Student {

  private int sid;
  private String sname;
  private Teacher teacher;

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public int getSid() {
    return sid;
  }

  public void setSid(int sid) {
    this.sid = sid;
  }


  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }




}
