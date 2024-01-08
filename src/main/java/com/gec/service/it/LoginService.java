package com.gec.service.it;

import com.gec.domain.User;

public interface LoginService {
    User login(String account,String password);
    void logout();
}
