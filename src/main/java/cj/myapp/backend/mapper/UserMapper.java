package cj.myapp.backend.mapper;

import cj.myapp.backend.enity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface UserMapper {
    //登录
    @Select("select * from t_user where uname=#{uname} and pwd=#{pwd}")
    User login(@Param("uname")String uname,@Param("pwd") String pwd);

    //注册
    @Update("insert into t_user values(default,#{uname},#{pwd})")
    @Transactional
    void register(User user);

    //注册时判断用户存不存在
    @Select("select* from t_user where uname=#{uname}")
    @Transactional
    User registerByName(String name);
}
