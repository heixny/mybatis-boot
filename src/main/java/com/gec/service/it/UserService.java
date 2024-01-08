package com.gec.service.it;

import com.gec.domain.PageParam;
import com.gec.domain.User;
import com.gec.service.impl.BaseService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface UserService extends BaseService<User> {
    User doLogin(String account,String password);

    void saveUser(User user);

    void delUser(String id);

    User getUserById(String id);
}
