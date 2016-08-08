package blog.services;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginServiceStubImpl implements LoginService {

    @Override
    public boolean authenticate(String username, String password) {
//        sample password authentication: username == password
        return Objects.equals(username, password);
    }
}
