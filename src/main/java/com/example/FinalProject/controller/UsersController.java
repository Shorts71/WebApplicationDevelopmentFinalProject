package com.example.FinalProject.controller;

import com.example.FinalProject.entity.User;
import com.example.FinalProject.repository.UserRepository;
import com.example.FinalProject.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(
            Model model,
            @RequestParam(name = "username", required = false, defaultValue = "") String username,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "sortField", required = false, defaultValue = "userId") String sortField,
            @RequestParam(name = "sortDir", required = false, defaultValue = "ASC") String sortDir,
            @RequestParam(name = "filterType", required = false, defaultValue = "all") String filterType
    ) {
        Sort.Direction sortedDirection = sortDir.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(sortedDirection, sortField);

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<User> userPage;

        if (username != null && !username.isEmpty()) {
            userPage = userService.findUserByName(username, pageable);
        } else {
            userPage = switch (filterType) {
                case "STAFF" -> userService.findUserByStaffRole(pageable);
                case "ADMIN" -> userService.findUserByAdminRole(pageable);
                case "MANAGER" -> userService.findUserByManagerRole(pageable);
                default -> userService.getAllUsersPageable(pageable);
            };
        }

        model.addAttribute("userPage", userPage);
        model.addAttribute("users", userPage.getContent());
        model.addAttribute("total", userPage.getTotalElements());
        model.addAttribute("size", size);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("search", username);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("filterType", filterType);
        model.addAttribute("hasPrevious", userPage.hasPrevious());
        model.addAttribute("hasNext", userPage.hasNext());
        model.addAttribute("startIndex", page * size + 1);
        model.addAttribute("endIndex", Math.min((page + 1) * size, (int) userPage.getTotalElements()));

        return "users";
    }

    @GetMapping("new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user-form";

    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "user-form";
        }

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "Username already exists");
            return "redirect:/user-form?error";
        }

        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(user.getRole());

        userRepository.save(user);
        return "redirect:/users";
    }
}
