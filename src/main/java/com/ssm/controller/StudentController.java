package com.ssm.controller;

import com.ssm.common.utils.JsonCallBack;
import com.ssm.model.PageModel;
import com.ssm.model.Student;
import com.ssm.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by user on 2018/1/8.
 */
@Controller
@RequestMapping("/student/")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping(value = "/findAllStudents", method = RequestMethod.GET)
    @ResponseBody
    public JsonCallBack findAllStudents(Student studentModel) {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        try {
            Map<String, Object> pairs = jsonCallBack.getPairs();
            List<Student> list = studentService.findAllStudnts(studentModel);
            pairs.put("dat", list);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }

    @RequestMapping(value = "/findStudentById", method = RequestMethod.GET)
    @ResponseBody
    public JsonCallBack findStudentById(String id) {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        Map<String, Object> pairs = jsonCallBack.getPairs();
        try {
            Map<String, Integer> param = new HashMap<String, Integer>();
            param.put("id", Integer.valueOf(id));
            Student studentModel1 = studentService.findStudentById(param);
            pairs.put("dat", studentModel1);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }

    @RequestMapping(value = "/findAllStudntsMapList", method = RequestMethod.GET)
    @ResponseBody
    public JsonCallBack findAllStudntsMapList(Student studentModel) {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        Map<String, Object> pairs = jsonCallBack.getPairs();
        try {
            List<Map<String, String>> studentModelList = studentService.findAllStudntsMapList(studentModel);
            pairs.put("dat", studentModelList);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }

    @RequestMapping(value = "/findPage/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @ResponseBody
    public JsonCallBack findPage(@RequestBody Student student,
                                 @PathVariable int pageNo, @PathVariable int pageSize) {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        Map<String, Object> pairs = jsonCallBack.getPairs();
        try {
            PageModel<Student> studentModel = studentService.findPage(student, pageNo, pageSize);
            pairs.put("dat", studentModel);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }
}
