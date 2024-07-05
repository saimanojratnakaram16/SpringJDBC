package com.manoj.SpringJDBC.repository;

import com.manoj.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student) {
        String sql = "insert into student (id,name,marks) values (?,?,?);";
        int rows = jdbcTemplate.update(sql,student.getId(),student.getName(),student.getMarks());
        System.out.println(rows+" rows effected");
    }

    public List<Student> findAll() {
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setMarks(rs.getInt("marks"));
                return st;
            }
        };
        String sql = "select * from student";
        return jdbcTemplate.query(sql, mapper);

    }
}
