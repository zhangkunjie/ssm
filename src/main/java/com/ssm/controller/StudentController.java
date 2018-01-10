package com.ssm.controller;

import com.ssm.common.JsonCallBack;
import com.ssm.model.StudentModel;
import com.ssm.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by user on 2018/1/8.
 */
@Controller
@RequestMapping("/students/")
public class StudentController {
    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/findAllStudents",method = RequestMethod.GET)
    @ResponseBody
    public JsonCallBack findAllStudents(StudentModel studentModel)
    {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        Map<String, Object> pairs = jsonCallBack.getPairs();
        try {
            List<StudentModel> list =studentService.findAllStudnts(studentModel);
            pairs.put("dat", list);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }
    @RequestMapping(value = "/findStudentById",method = RequestMethod.GET)
    @ResponseBody
    public JsonCallBack findStudentById(String id)
    {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        Map<String, Object> pairs = jsonCallBack.getPairs();
        try {
            Map<String,Integer> param=new HashMap<String, Integer>();
            param.put("id",Integer.valueOf(id));
            StudentModel studentModel1=studentService.findStudentById(param);
            pairs.put("dat", studentModel1);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }
    @RequestMapping(value = "/findAllStudntsMapList",method = RequestMethod.GET)
    @ResponseBody
    public JsonCallBack findAllStudntsMapList(StudentModel studentModel)
    {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        Map<String, Object> pairs = jsonCallBack.getPairs();
        try {
            List<Map<String,String>> studentModelList=studentService.findAllStudntsMapList(studentModel);
            pairs.put("dat", studentModelList);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }
}
