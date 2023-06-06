package com.book.store.services;
import com.book.store.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
//    @Autowired
//    private UserDAO userDAO;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> user = userDAO.findUserByEmail(email);
//        if(user.isPresent()) {
//            User _user = user.get();
//            return  new org.springframework.security.core.userdetails.User(_user.getEmail(), _user.getPassword(), getAuthority(_user));
//        }
//        return null;
//    }
    private Set<SimpleGrantedAuthority> getAuthority(UserDTO user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().toString()));
        return authorities;
    }

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	return null;
}
}
