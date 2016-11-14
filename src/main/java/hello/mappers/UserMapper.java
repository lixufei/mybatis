package hello.mappers;

import org.apache.ibatis.annotations.Insert;

public interface UserMapper {

    @Insert(
            "INSERT INTO user(name, age) VALUES (#{name}, #{age})"
    )
    Integer insert(User user);

//    public void insertUser(User user);
}