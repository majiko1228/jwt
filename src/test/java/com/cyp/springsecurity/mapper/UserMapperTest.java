package com.cyp.springsecurity.mapper;

import com.cyp.springsecurity.pojo.MyUserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserMapperTest {


    @Resource
    private UserMapper userMapper;

    @Test
    void getList() {
        MyUserDetails myUserDetails = userMapper.getUserByUserName("admin");
        System.out.println(myUserDetails);

        /*
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
        System.out.println(userMapper.selectById(1));
*/
    }
}