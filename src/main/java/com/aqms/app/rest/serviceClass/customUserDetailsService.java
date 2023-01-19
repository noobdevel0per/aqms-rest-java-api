package com.aqms.app.rest.serviceClass;
import com.aqms.app.rest.Models.User;
import com.aqms.app.rest.Models.customUserDetails;
import com.aqms.app.rest.Repo.userRepo;
import com.aqms.app.rest.serviceClass.customUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class customUserDetailsService implements  UserDetailsService{

    @Autowired
    private userRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       //user from database
        User user = this.userRepo.findByUsername(username);
                if(user == null){
                    throw new UsernameNotFoundException("User Not Found");
                }else{
                    return new customUserDetails(user);
                }
    }
}
