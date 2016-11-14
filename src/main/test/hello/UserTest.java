package hello;

import hello.controller.UserController;
import hello.mappers.MyBatisUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private UserController userController = new UserController();

    @Test
    public void should_add_a_record_to_matchmaker_database () {
       userController.testAdd("hjli", new Integer(18));
    }

    @Test
    public void should_1_plus_1_equals_2 () {
        assertThat(1).isEqualTo(1);
    }


}
