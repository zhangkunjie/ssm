package com.ssm.dao;

import com.ssm.model.PageModel;
import com.ssm.model.Student;
import org.springframework.stereotype.Repository;

import javax.swing.text.Style;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018/1/8.
 */
@Repository
public interface StudentDao extends BaseDao<Student, Long> {
    public List<Student> findAll(Student studentModel);

    public List<Map<String, String>> findAllMapList(Student studentModel);

    public Student findStudentById(Map<String, Integer> param);

}
