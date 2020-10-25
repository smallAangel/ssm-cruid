package test;

import com.cx.bean.User;
import com.cx.dao.UserMapper;
import com.cx.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * @author cx
 * @create 2020-10-26 1:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class Userdaotest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Autowired
    SqlSession sqlSession;
    @Test
    public void test(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        for (int i = 0; i < 1000; i++) {
            String substring = UUID.randomUUID().toString().substring(0, 5)+i;
            mapper.insertSelective(new User(null,substring,substring));
        }
        System.out.println("success!");
    }
    @Test
    public void test2(){
        PageHelper.startPage(1,10);
        List<User> all = userService.getAll();
        PageInfo pageInfo = new PageInfo(all, 5);
        for (User user : all) {
            System.out.println(user);
        }
    }
}
