package com.xiaomi.text;

import com.alibaba.fastjson.JSON;
import com.xiaomi.example.convert.UserConvert;
import com.xiaomi.example.dal.dao.BookDAO;
import com.xiaomi.example.dal.dao.OrderDAO;
import com.xiaomi.example.dal.dao.UserDAO;
import com.xiaomi.example.dal.dataobject.BookDO;
import com.xiaomi.example.dal.dataobject.OrderDO;
import com.xiaomi.example.dal.dataobject.UserDO;
import com.xiaomi.example.pojo.User;
import com.xiaomi.example.utils.SecurityUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mi on 2017/2/13.
 */

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class TestUser extends AbstractJUnit4SpringContextTests{

    private static Logger logger = Logger.getLogger(TestUser.class);
    @Autowired
    private BookDAO bookDao ;
    @Resource
    private OrderDAO orderDAO;
    @Resource
    private UserDAO userDAO;

    @Test
    public void testBookDao(){
        BookDO book = bookDao.selectByPrimaryKey("978-7-115-41730-5");
        if(book != null) {
            System.out.println(book.toString());
        } else {
            System.out.println("no book");
        }

        OrderDO order = orderDAO.selectByPrimaryKey(2);
        if(order != null) {
            System.out.println(JSON.toJSONString(order));
        } else {
            System.out.println("no order");
        }

        User user = UserConvert.convert(userDAO.selectByPrimaryKey(40));
        if(user != null) {
            System.out.println(JSON.toJSONString(user));
        } else {
            System.out.println("no user");
        }
    }

    @Test
    public void testUserByUserNames(){
//        List<String> list = new ArrayList<String>();
//        list.add("刘进");
//        list.add("从前");
//        List listUser = userDAO.selectByUserNames(list);
//        System.out.println(JSON.toJSONString(listUser));

        UserDO user = new UserDO();
        user.setUserName("lj2012");
        user.setEmail("liujin66666@qq.com");
        user.setGender("男");
        user.setPassword(SecurityUtils.md5AndBase64Encrypt(user.getEmail() + "sssss") );

        UserDO user1 = new UserDO();
        user1.setUserName("lj2013");
        user1.setEmail("liujin333333@qq.com");
        user1.setGender("男");
        user1.setPassword(SecurityUtils.md5AndBase64Encrypt(user.getEmail() + "aaaaa") );

        List<UserDO> list = new ArrayList<UserDO>();
        list.add(user);
        list.add(user1);

        Long num = userDAO.insertBatch(list);
        System.out.println(num);

    }

    @Test
    public void testUserLogin(){

        UserDO user = new UserDO();
        user.setUserName("lj20170322");
        user.setEmail("liujin@qq.com");
        user.setGender("男");
        user.setPassword(SecurityUtils.md5AndBase64Encrypt(user.getEmail() + "aaaaa") );
        System.out.println(JSON.toJSONString(user));
        user.setUserId(userDAO.insert(user));
        System.out.println(JSON.toJSONString(user));

    }
}
