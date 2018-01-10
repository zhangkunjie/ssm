package com.ssm.service.serviceimpl;

import com.ssm.dao.StudentDao;
import com.ssm.model.StudentModel;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018/1/8.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    @Autowired
    private StudentDao studentDao;

    public List<StudentModel> findAllStudnts(StudentModel studentModel) {
        return studentDao.findAll(studentModel);
    }

    public List<Map<String, String>> findAllStudntsMapList(StudentModel studentModel) {
        return  studentDao.findAllMapList(studentModel);
    }

    public StudentModel findStudentById(Map<String, Integer> param) {
        return studentDao.findStudentById(param);
    }

}
