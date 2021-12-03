package com.openlab;

import com.openlab.pojo.User;
import com.openlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manageruser")
public class UserController {
    @Autowired
    UserService userService;
//    查询所有数据
    @GetMapping("/")
    public String getUserList(Model model){
        List<User> userList = userService.getUserList();
        model.addAttribute("page",userList);
        return "user/list";
    }
    @RequestMapping("/toAdd")
    public String toAdd(User user){
        //要先跳转到添加界面
        return "user/userAdd";
    }
    @PostMapping("/add")
    public String createUser(User user){
        userService.createUser(user);
//        重定向到主界面
        return "redirect:/manageruser/";
    }
    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model, @PathVariable("id")Long id){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "user/userEdit";
    }
    @RequestMapping("edit")
    public String edit(User user){
        userService.updateUser(user.getId(),user);
        return "redirect:/manageruser/";
    }
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return "redirect:/manageruser/";
    }
}
