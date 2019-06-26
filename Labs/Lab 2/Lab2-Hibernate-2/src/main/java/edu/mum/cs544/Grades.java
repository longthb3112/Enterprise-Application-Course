package edu.mum.cs544;

import java.sql.*;
import javax.persistence.*;

@Entity(name = "edu.mum.cs544.Grades")
@Table(name = "grades")
public class Grades {

  @Id
  @Column(name = "\"id\"", nullable = false)
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public Integer getCourseId() {
    return courseId;
  }

  public void setCourseId(Integer courseId) {
    this.courseId = courseId;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  @Column(name = "\"student_id\"", nullable = false)
  private Integer studentId;
  @Column(name = "\"course_id\"", nullable = false)
  private Integer courseId;
  @Column(name = "\"grade\"", nullable = true)
  private String grade;
}