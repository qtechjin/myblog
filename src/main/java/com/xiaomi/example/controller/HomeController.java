package com.xiaomi.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaomi.example.pojo.User;
import com.xiaomi.example.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mi on 2017/3/9.
 */

@Controller
@RequestMapping("/")
public class HomeController {
    private Logger logger = Logger.getLogger("CONTROLLER");

    @Resource
    private UserService userService;

    @RequestMapping(value = "/", method = GET)
    public String home(HttpServletRequest request, HttpServletResponse response) {
//        response.setContentType("text/html;charset=UTF-8");
        return "../index";
    }

    @RequestMapping(value = "/login",method = POST)
    @ResponseBody
    public JSONObject login(HttpSession session, @RequestBody JSONObject json){

        String username = json.getString("username");
        String password = json.getString("password");
        logger.info("[CONTROLLER]:" + username + " is login now");
        if(userService.login(username, password)){
            session.setAttribute("username", username);
            json.put("result", "OK");
            logger.info(username + " login success");
        } else {
            json.put("result", "NO");
            logger.info(username + " login failed");
        }
        return json;
    }

    @RequestMapping(value = "/register", method = GET)
    public String register(HttpServletRequest request){
        return "register";
    }

    @RequestMapping(value = "/register", method = POST)
    public String registerUser(HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        logger.info(JSON.toJSONString(request.getParameterNames()));
        user.setUserName(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setGender(request.getParameter("gender"));
        user.setPassword(request.getParameter("password"));
        logger.info("[CONTROLLER]:用户注册信息:" + JSON.toJSONString(user));
        if(userService.register(user)){
            logger.info("[CONTROLLER]:用户注册成功!");
            return "success";
        } else {
            logger.info("[CONTROLLER]:用户注册失败!");
            return "register";
        }
    }


}
