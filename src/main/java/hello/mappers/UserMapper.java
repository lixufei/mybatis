package hello.mappers;

public interface UserMapper {

//    @Insert(
//            "INSERT INTO matchmaker.user VALUES (#{name}, #{age})"
//    )
//    Integer insert(User user);

    public void insertUser(User user);
}