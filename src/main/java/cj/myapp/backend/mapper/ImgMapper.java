package cj.myapp.backend.mapper;

import cj.myapp.backend.enity.Img;
import cj.myapp.backend.enity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface ImgMapper {
    //将图片地址存入数据库
    @Update("insert into t_img values(default,#{img_name},#{img_path},#{createTime}),#{userId},#{userName}")
    @Transactional
    void addImg(Img img);

    //判断图片存不存在
    @Select("select* from t_img where img_name=#{img_name}")
    @Transactional
    User addByName(String name);
}
