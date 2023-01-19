package com.aqms.app.rest.Controller;

import com.aqms.app.rest.Helper.jwtUtil;
import com.aqms.app.rest.Models.jwtReq;
import com.aqms.app.rest.Models.jwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.aqms.app.rest.serviceClass.customUserDetailsService;

@RestController
@CrossOrigin(origins = "*")
public class jwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private  customUserDetailsService CustomUserDetailsService;

    @Autowired
    private jwtUtil JwtUtil;

    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody jwtReq JwtReq) throws Exception {
       // System.out.println(JwtReq);
        try{
            this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken
                            (JwtReq.getUsername(),JwtReq.getPassword()));
        }
        catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw  new Exception("Bad creds");
        }catch (BadCredentialsException e){
            e.printStackTrace();
            throw  new Exception("Bad creds");
        }

        UserDetails userDetails= this.CustomUserDetailsService.loadUserByUsername(JwtReq.getUsername());
        String token = this.JwtUtil.generateToken(userDetails);
        //System.out.println("TOKEN"+token);

        //token value
        return ResponseEntity.ok(new jwtResponse(token));

    }
}
