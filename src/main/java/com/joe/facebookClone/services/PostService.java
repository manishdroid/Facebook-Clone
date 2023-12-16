package com.joe.facebookClone.services;


import com.joe.facebookClone.dao.AppUserDAO;
import com.joe.facebookClone.dao.PostDAO;
import com.joe.facebookClone.dto.AppUserDTO;
import com.joe.facebookClone.models.Post;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostDAO postDAO;

    @Autowired
    private AppUserDAO appUserDAO;

    private List<Post> post;

    public boolean save(Post posts, HttpSession session) {
        AppUserDTO appUserDTO = (AppUserDTO) session.getAttribute("userDTO");
        if (appUserDAO != null) {
            LocalDateTime now = LocalDateTime.now();
            posts.setDateCreated(String.valueOf(now));
            // Save the post using postDAO
            postDAO.save(posts);
            return true; // Indicate that the save operation was successful
        }
        return false; // Indicate that the save operation failed
    }

    public void fetchPost(HttpSession session) {
        // Implement fetching posts logic here
    }
}
