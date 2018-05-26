package com.ssm.service.serviceimpl;

import com.ssm.dao.StudentDao;
import com.ssm.model.PageModel;
import com.ssm.model.Student;
import com.ssm.service.StudentService;
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
    private StudentDao studentDao;

    public List<Student> findAllStudnts(Student studentModel) {
        return studentDao.findAll(studentModel);
    }

    @Override
    public PageModel<Student> findPage(Student student, int pageSize, int pageNo) {
        PageModel<Student> pageModel = new PageModel<Student>();
        pageModel.setPageSize(pageSize);
        pageModel.setPageNo(pageNo);
        pageModel.getParams().put("entity",student);
        List<Student> list = studentDao.findPage(pageModel);
        pageModel.setResults(list);
        return pageModel;
    }

    public List<Map<String, String>> findAllStudntsMapList(Student studentModel) {
        return studentDao.findAllMapList(studentModel);
    }

    public Student findStudentById(Map<String, Integer> param) {
        return studentDao.findStudentById(param);
    }

}
