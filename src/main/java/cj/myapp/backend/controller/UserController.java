package cj.myapp.backend.controller;

import cj.myapp.backend.enity.Order;
import cj.myapp.backend.enity.User;
import cj.myapp.backend.enity.Employ;
import cj.myapp.backend.mapper.OrderMapper;
import cj.myapp.backend.mapper.UserMapper;
import cj.myapp.backend.util.Response;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/api")
public class UserController {

    @Resource
    UserMapper userMapper;
    /**
     * 登录
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Response loginUser(@RequestBody User user) {
        String uname = user.getUname();
        String pwd = user.getPwd();
        System.out.println("uname=" + uname + "pwd" + pwd);
        if (uname.equals("") || pwd.equals("")) {
            return new Response(100, "用户名或密码不能为空", "");
        } else {
            if (userMapper.login(uname, pwd) != null) {
                return new Response(200, "操作成功", "");
            } else {
                return new Response(500, "用户不存在/密码错误", "");
            }
        }
    }

    @PostMapping("/register")
    public Response register(@RequestBody User user) {
        String uname = user.getUname();
        String pwd = user.getPwd();
        if (uname.equals("") || pwd.equals("")) {
            return new Response(100, "用户名或密码不能为空", "");
        } else {
            if (userMapper.registerByName(user.getUname()) == null) {
                userMapper.register(user);

                return new Response(200, "操作成功", "");
            } else {
                return new Response(500, "注册失败", "用户已存在");
            }
        }
    }

    @PostMapping("/employList")
    public Map<String,Object> findPage(@RequestBody Employ employ) {
        Integer pageSize = employ.getPageSize();
        Integer pageNum = (employ.getPageNum() - 1)*pageSize;
        Integer id = employ.getId();
        String name = employ.getName();
        String sex = employ.getSex();
        List<Employ> data = userMapper.selectPage(id,name,sex,pageNum,pageSize);
        Integer total = userMapper.selectTotal();
        Map<String,Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        res.put("msg","查询成功");
        return res;
    }
}

