package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.model.PageModel;
import com.ssm.model.Student;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018/1/8.
 */
public interface StudentService {
    public List<Student> findAllStudnts(Student student);

    public PageInfo<Student> findPage(Student student, int pageSize, int pageNo);

    public List<Map<String, String>> findAllStudntsMapList(Student student);

    public Student findStudentById(Map<String, Integer> param);
}
