package hello.controller;

import hello.mappers.MyBatisUtil;
import hello.mappers.User;
import hello.mappers.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    public void testAdd(String userName, Integer age) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(userName, age);
            userMapper.insert(user);
            sqlSession.commit();// 这里一定要提交，不然数据进不去数据库中
        } finally {
            sqlSession.close();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<User> add(@RequestBody User user) {
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/data", method = RequestMethod.GET)
    public @ResponseBody String foo() {
        return "Response!";
    }

}
