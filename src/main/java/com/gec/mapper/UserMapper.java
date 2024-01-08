package com.gec.mapper;

import com.gec.domain.Dept;
import com.gec.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User>{
    public User getUserById(String id);
    List<User> getList(Map map);

    User getUserByAccount(String account);
    int addUser(User user);
    void updateUser(User user);
    int delUser(@Param("id")String id);

    User getLeader(@Param("deptId") String deptId,@Param("roleId") String roleId);
}
