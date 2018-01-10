package com.ssm.dao;

import com.ssm.model.StudentModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018/1/8.
 */
@Repository
public interface StudentDao {
    public List<StudentModel> findAll(StudentModel studentModel);
    public List<Map<String,String>> findAllMapList(StudentModel studentModel);
    public StudentModel findStudentById(Map<String,Integer> param);

}
