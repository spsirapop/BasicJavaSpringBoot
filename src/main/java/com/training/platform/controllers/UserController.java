package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("api-user")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/findAll")
    public List<User> index() throws Exception {
        return userService.findAll();
    }

    @GetMapping(value = "/findById/{id}")
    public Optional<User> findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @GetMapping(value = "/findAllByLimit")
    public Page<User> findAllByLimit(@RequestParam Integer start, @RequestParam Integer limit, @RequestParam String field) throws Exception{
       return userService.findAllByLimit(start,limit,field);
    }

    @GetMapping(value = "/findByCityAndActiveAndAge")
    public List<User> findByCityAndActiveAndAge(@RequestParam String city,@RequestParam Integer active,@RequestParam Integer age) {
        return userService.findByCityAndActiveAndAge(city, active, age);
    }

    @GetMapping(value = "/findByAgeIn")
    public List<User> findByAgeIn(@RequestParam List<Integer> ages) {
        return userService.findByAgeIn(ages);
    }

    @GetMapping(value = "/findAllByQuery")
    public List<User> findAllByQuery() {
        return userService.findAllByQuery();
    }
    @GetMapping(value = "/findAllByParamsQuery")
    public List<User> findAllByParamsQuery(@RequestParam Integer active, @RequestParam String city) {
        return userService.findAllByParamsQuery(active, city);
    }

    @GetMapping(value = "/findAllByJpqlQuery")
    public List<User> findAllByJpqlQuery() {
        return userService.findAllByJpqlQuery();
    }

    @GetMapping(value = "/findAllByJpqlParamsQuery")
    public List<User> findAllByJpqlParamsQuery(@RequestParam Integer active,@RequestParam String city) {
        return userService.findAllByJpqlParamsQuery(active, city);
    }

    //เพิ่มเข้ามาใหม่
    //localhost:8080/api/user/findByActive?active=1
    @GetMapping(value = "/findByActive")
    public List<User> findByActive(@RequestParam Integer active) {
        return userService.findByActive(active);
    }
    //เพิ่มเข้ามาใหม่
    //localhost:8080/api/user/findByCityAndAge?city=bangkok&age=18
    @GetMapping(value = "/findByCityAndAge")
    public List<User> findByCityAndAge(@RequestParam String city,@RequestParam Integer age) {
        return userService.findByCityAndAge(city,age);
    }
    //เพิ่มเข้ามาใหม่
    //localhost:8080/api/user/findByAgeBetween?start=18&limit=20
    @GetMapping(value = "/findByAgeBetween")
    public List<User> findByAgeBetween(@RequestParam Integer start,@RequestParam Integer limit) {
        return userService.findByAgeBetween(start,limit);
    }
    @GetMapping(value = "/findname")
    public List<User> findByNameStartingWith(@RequestParam String name) {
        return userService.findByNameStartingWith(name);
    }

}

