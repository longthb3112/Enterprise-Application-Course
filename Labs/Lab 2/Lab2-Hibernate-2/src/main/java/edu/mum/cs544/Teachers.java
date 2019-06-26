package edu.mum.cs544;

import java.sql.*;
import javax.persistence.*;


@Entity(name = "edu.mum.cs544.Teachers")
@Table(name = "teachers")
public class Teachers {

  @Id
  @Column(name = "\"id\"", nullable = false)
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "\"name\"", nullable = true)
  private String name;
}