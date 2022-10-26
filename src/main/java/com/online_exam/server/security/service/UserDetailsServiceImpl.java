package com.online_exam.server.security.service;

import com.online_exam.server.student.Student;
import com.online_exam.server.student.StudentRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    StudentRepositary studentRepositary;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepositary.findByName(username);


        return UserDetailsImpl.build(student);
    }
}
