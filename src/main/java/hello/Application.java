package hello;

import hello.mappers.MyBatisUtil;
import hello.mappers.UserMapper;
import hello.mappers.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }

    static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }
    public static void main(String[] args) {
        testAdd();
    }

    private static void testAdd() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User("lisi", new Integer(25));
            userMapper.insertUser(user);
            sqlSession.commit();// 这里一定要提交，不然数据进不去数据库中
        } finally {
            sqlSession.close();
        }
    }
}
