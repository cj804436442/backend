package cj.myapp.backend.mapper;
import cj.myapp.backend.enity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;


@Mapper
public interface OrderMapper {
    @Update("insert into t_order values(default,#{food},#{orderTime},#{remark},#{price})")
    @Transactional
    void orderMeal(Order order);
}
