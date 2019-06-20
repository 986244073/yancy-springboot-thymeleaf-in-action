package com.yancy.controller;

import com.yancy.entity.User;
import com.yancy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Authur : Yancy
 * @E-mail : 986244073@qq.com
 * @Create : 2019/6/16
 * @Desc :
 */
@RestController
public class UserController {
    //自动注入
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/string")
    public String string(ModelMap map) {
        map.addAttribute("userName", "emm");
        return "string";
    }

    /**
     * 查询所有用户
     */
    @GetMapping("/users")
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.listUsers());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据Id查询用户
     */
    @GetMapping("/users/{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userRepository.getUserById(id));
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 获取 创建 表单页面
     */
    @GetMapping("/users/form")
    public ModelAndView creatForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 新增 修改用户
     */
    @PostMapping("/users")
    public ModelAndView saveOrUpdateUser(User user) {
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 删除用户
     */
    @GetMapping("/users/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
         userRepository.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }
    /**
     * 修改用户
     */
    @GetMapping("/users/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id,Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form","userModel",model);
    }

}
