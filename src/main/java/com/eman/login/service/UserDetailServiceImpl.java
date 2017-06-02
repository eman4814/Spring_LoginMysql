/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eman.login.service;

import com.eman.login.model.Role;
import com.eman.login.model.User;
import com.eman.login.repository.UserRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Computer
 */
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        User usr = userRepository.findByUsername(string);
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role r : usr.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(r.getName()));
        }
        
        return new org.springframework.security.core.userdetails.User(usr.getUsername(), usr.getPassword(), grantedAuthorities);
        
    }
    
}
