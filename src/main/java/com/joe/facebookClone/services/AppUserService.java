package com.joe.facebookClone.services;

import com.joe.facebookClone.dao.AppUserDAO;
import com.joe.facebookClone.dto.AppUserDTO;
import com.joe.facebookClone.dto.LoginDTO;
import com.joe.facebookClone.models.AppUsers;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.JDBCType;


@Service
public class AppUserService {
    @Autowired
    AppUserDAO appUserDAO;

    AppUserDTO appUserDTO;

    @Autowired
    PostService postService;

    public boolean save(AppUsers appUsers, HttpSession session){
        String password = BCrypt.hashpw(appUsers.getPassword(),BCrypt.gensalt());
        appUsers.setPassword(password);
        appUserDAO.save(appUsers);
        session.setAttribute("account_status","Account has been successfully created. please login");
        return true;
    }
    public AppUsers getAppUsers(String email, String password){
        AppUsers appUsers = appUserDAO.findByEmail(email);
        return appUsers;
    }
    public boolean auth(LoginDTO loginDTO, HttpSession session){
        AppUsers appUsers= appUserDAO.findByEmail(loginDTO.getEmail());
        if(appUsers!= null) {
            if(BCrypt.checkpw(loginDTO.getPassword(),appUsers.getPassword())) {
                appUserDTO = new AppUserDTO();
                appUserDTO.setEmail(appUsers.getEmail());
                appUserDTO.setName(appUsers.getName());
                appUserDTO.setId(appUsers.getId());
                postService.fetchPost(session);
                session.setAttribute("appUserDTO", appUserDTO);
                session.setAttribute("loggedInUsers", appUserDTO);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}
