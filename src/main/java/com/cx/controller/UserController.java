package com.cx.controller;

import com.cx.bean.Msg;
import com.cx.bean.User;
import com.cx.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @author cx
 * @create 2020-10-26 2:37
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/users")
    public String getAll1(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,5);
        System.out.println("Controller=>"+pn);
        List<User> all = userService.getAll();
        PageInfo pageInfo = new PageInfo(all, 5);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println("---pageinfo"+pageInfo);
        return "list";
    }
                    @RequestMapping("/usersjson")
                    @ResponseBody
    public Msg getAll(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<User> all = userService.getAll();
        PageInfo pageInfo = new PageInfo(all, 5);
        return Msg.success().add("pageInfo",pageInfo);
    }

//    /**
//     * 检查用户名是否可用
//     * @param empName
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping("/checkuser")
//    public Msg checkuser(@RequestParam("empName")String empName){
//        //先判断用户名是否是合法的表达式;
//        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
//        if(!empName.matches(regx)){
//            return Msg.fail().add("va_msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
//        }
//
//        //数据库用户名重复校验
//        boolean b = employeeService.checkUser(empName);
//        if(b){
//            return Msg.success();
//        }else{
//            return Msg.fail().add("va_msg", "用户名不可用");
//        }
//    }


//    /**
//     * 员工保存
//     * 1、支持JSR303校验
//     * 2、导入Hibernate-Validator
//     *
//     *
//     * @return
//     */
//    @RequestMapping(value="/emp",method= RequestMethod.POST)
//    @ResponseBody
//    public Msg saveEmp(@Valid Employee employee, BindingResult result){
//        if(result.hasErrors()){
//            //校验失败，应该返回失败，在模态框中显示校验失败的错误信息
//            Map<String, Object> map = new HashMap<>();
//            List<FieldError> errors = result.getFieldErrors();
//            for (FieldError fieldError : errors) {
//                System.out.println("错误的字段名："+fieldError.getField());
//                System.out.println("错误信息："+fieldError.getDefaultMessage());
//                map.put(fieldError.getField(), fieldError.getDefaultMessage());
//            }
//            return Msg.fail().add("errorFields", map);
//        }else{
//            employeeService.saveEmp(employee);
//            return Msg.success();
//        }
//
//    }

}
