package web.security.securityDitel;
/*
 *
 *@Data 20.03.2020
 *@autor Fedorov Yuri
 *@project spring_security
 *
 */

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.config.model.User;
import web.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {

        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findModelByName(email);
        if (user.getEmail().equals(email)) {
            return user;
        }
        return null;
    }
}