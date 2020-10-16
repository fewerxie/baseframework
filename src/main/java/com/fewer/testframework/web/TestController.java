package com.fewer.testframework.web;

import com.fewer.common.config.GlobalConfig;
import com.fewer.testframework.domain.TestPOJO;
import com.fewer.testframework.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName TestController
 * @Description 测试控制层
 * @Author xiezy
 * @Date 2020/10/10 15:08
 * @Version V1.0
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/findList")
    public String findList(Model model) {
        System.out.println("Controller查询所有");
        List<TestPOJO> testPOJOList = testService.findList();
        System.out.println(GlobalConfig.getUserfilesBaseDir());
//        model.addAttribute("testPOJOList", testPOJOList);
        return "testJsp";
    }

    @RequestMapping("/addData")
    public Boolean addData(TestPOJO testPOJO) {
        System.out.println("Controller新增数据");
        return testService.save(testPOJO);
    }

    @RequestMapping("/modifyData")
    public Boolean modifyData(TestPOJO testPOJO) {
        System.out.println("Controller修改数据");
        return testService.save(testPOJO);
    }

    @RequestMapping("/deleteData")
    public Boolean deleteData(TestPOJO testPOJO) {
        System.out.println("Controller删除数据");
        return testService.delete(testPOJO);
    }

}