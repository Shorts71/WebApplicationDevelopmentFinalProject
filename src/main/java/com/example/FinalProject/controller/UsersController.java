package com.example.FinalProject.controller;

import com.example.FinalProject.entity.User;
import com.example.FinalProject.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(
            Model model,
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "userId") String sortBy,
            @RequestParam(name = "direction", required = false, defaultValue = "ASC") String direction
    ) {
        Sort.Direction sortedDirection = direction.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(sortedDirection, sortBy);

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<User> userPage;

        if (search != null && !search.isEmpty()) {
            userPage = userService.findUserByName(search, pageable);
        } else {
            userPage = userService.getAllUsersPageable(pageable);
        }

        model.addAttribute("players", userPage.getContent());
        model.addAttribute("total", userPage.getTotalElements());
        model.addAttribute("size", size);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("search", search);
        model.addAttribute("sort", sortBy);
        model.addAttribute("direction", direction);
        model.addAttribute("hasPrevious", userPage.hasPrevious());
        model.addAttribute("hasNext", userPage.hasNext());
        model.addAttribute("startIndex", page * size + 1);
        model.addAttribute("endIndex", Math.min((page + 1) * size, (int) userPage.getTotalElements()));

        return "Users";
    }
}
