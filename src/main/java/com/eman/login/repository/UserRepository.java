/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eman.login.repository;

import com.eman.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Computer
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String Username);
}
