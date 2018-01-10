package com.ssm.service;

import com.ssm.model.StudentModel;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018/1/8.
 */
public interface StudentService {
    public List<StudentModel> findAllStudnts(StudentModel studentModel);
    public List<Map<String,String>> findAllStudntsMapList(StudentModel studentModel);
    public StudentModel findStudentById(Map<String,Integer> param);
}
