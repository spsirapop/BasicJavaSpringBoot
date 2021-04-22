package com.training.platform.controllers;
import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserRepository userRepository;


//    @GetMapping(value = "")
//    public String index() {
//        List<User> users = userRepository.findAll();
//        System.out.println("############### Find All User (In Console) ###############");
//        System.out.println(users);
//        return "Method GET, Function : index => SHOW data list on page";
//    }


    @GetMapping(value = "/allUser")
    public List<User> indexAllUser() {
        List<User> users = userRepository.findAll();
        System.out.println("############### Find All User (In Console) ###############");
        System.out.println(users);
        return users;
    }


    @GetMapping(value = "/{id}")
    public String showWithPath(@PathVariable String id) {
        Optional<User> user = userRepository.findById(Integer.parseInt(id));
        System.out.println("############### Find User By ID (In Console) ###############");
        System.out.println(user);

        return "Method Get, Function : show, ID : "+ id +" => SHOW data by id on page with path";
    }



    @GetMapping(value = "/findByCityAndActiveAndAge")
    public List<User> indexFindByCityAndActiveAndAge() {
        List<User> users = userRepository.findByCityAndActiveAndAge("nakornpathom", 1, 18);
        return users;
    }

//    @GetMapping(value = "")
//    public List<User> index() {
//        List<Integer> ages = new ArrayList<Integer>(Arrays.asList(18, 19, 22) );
//        List<User> users = userRepository.findByAgeIn(ages);
//
//        return users;
//    }

    // Example for findAllByQuery
    @GetMapping(value = "/test1")
    public List<User> test1() {
        return userRepository.findAllByQuery();
    }
    // Example for findAllByParamsQuery
    @GetMapping(value = "/test2")
    public List<User> test2() {
        return userRepository.findAllByParamsQuery(0, "nakornpathom");
    }

    // Example for findAllByParamsQuery localhost:8080/demo/test2?city=nakornpathom&active=0
//    @GetMapping(value = "/test2")
//    public List<User> test2(@RequestParam String active ,@RequestParam String city) {
//        return userRepository.findAllByParamsQuery(Integer.parseInt(active), city);
//    }



    // Example for findAllByJpqlQuery Bangkok 1
    @GetMapping(value = "/test3")
    public List<User> test3() {
        return userRepository.findAllByJpqlQuery();
    }

    // Example for findAllByJpqlParamsQuery
    @GetMapping(value = "/test4")
    public List<User> test4() {
        return userRepository.findAllByJpqlParamsQuery(0, "bangkok");
    }



//    การทำ Healthcheck
//    @RequestMapping(value = "/healthcheck")
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public String healthCheck() {
//        return "Hello World!";
//    }
//
//
//    @RequestMapping(value = "/healthcheck"
//    public String healthCheck(HttpServletResponse response) {
//        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//        return "Hello World!";
//    }
//
//
//    @PostMapping(value = "")
//    public String create(@RequestBody Map<String,Object> inputs) {
//        System.out.println("########### POST Param ###########");
//        System.out.println(inputs);
//
//        return "Method POST, Function : create => INSERT data to DB";
//    }
//
//    @GetMapping(value = "/{id}")
//    public String showWithPath(@PathVariable String id) {
//        return "Method Get, Function : show, ID : "+ id +" => SHOW data by id on page with path";
//    }
//
//    @PatchMapping(value = "/{id}")
//    public String update(@PathVariable String id, @RequestBody Map<String,Object> inputs) {
//        System.out.println("########### PATCH Body ###########");
//        System.out.println(inputs);
//
//        return "Method PATCH, Function : update => ID : " + id + "UPDATE data to DB";
//    }
//
//    @PatchMapping(value = "/param/{id}")
//    public String update1(@PathVariable String id, @RequestParam Map<String,String> inputs) {
//        System.out.println("########### PATCH Param ###########");
//        System.out.println(inputs);
//
//        return "Method PATCH, Function : update => ID : " + id + "UPDATE data to DB";
//    }
//
//
//
//    @DeleteMapping(value = "/{id}")
//    public String destroy(@PathVariable String id)  {
//        return "Method DELETE, Function : delete, ID : " + id + " => DELETE data to DB";
//    }









//    @Autowired
//    private UserService userService;
//
//    @GetMapping(value = "")
//    public List<User> index() {
//        return userService.findAllByJpqlParamsQuery(0, "bangkok");
//    }

//    @GetMapping(value = "/allUser")
//    public List<User> index() {
//        return userService.findAll();
//    }
//
//    @GetMapping(value = "/{id}")
//    public Optional<User> findById(@PathVariable Integer id) {
//        return userService.findById(id);
//    }
//
//    @GetMapping(value = "/page")
//    public Page<User> findAllByLimit(@RequestParam Integer start, @RequestParam Integer limit, @RequestParam String field) {
//        return userService.findAllByLimit(start,limit,field);
//    }
//
//    @GetMapping(value = "/findCAA")
//    public List<User> findByCityAndActiveAndAge(@RequestParam String city,@RequestParam Integer active,@RequestParam Integer age) {
//        return userService.findByCityAndActiveAndAge(city, active, age);
//    }
//    @GetMapping(value = "/findByAgeIn")
//    public List<User> findByAgeIn(@RequestParam List<Integer> ages) {
//        return userService.findByAgeIn(ages);
//    }
//
//    @GetMapping(value = "/findByAgeInFetch")
//    public List<User> findByAgeInFetch(@RequestParam (name = "age") List<Integer> ages) {
//        return userService.findByAgeIn(ages);
//    }
//
//
//    @GetMapping(value = "/findAllByQuery")
//    public List<User> findAllByQuery() {
//        return userService.findAllByQuery();
//    }
//
//    @GetMapping(value = "/findAllByParamsQuery")
//    public List<User> findAllByParamsQuery(@RequestParam Integer active, @RequestParam String city) {
//        return userService.findAllByParamsQuery(active, city);
//    }
//
//    @GetMapping(value = "/findAllByJpqlQuery")
//    public List<User> findAllByJpqlQuery() {
//        return userService.findAllByJpqlQuery();
//    }
//
//    @GetMapping(value = "/findAllByJpqlParamsQuery")
//    public List<User> findAllByJpqlParamsQuery(@RequestParam Integer active,@RequestParam String city) {
//        return userService.findAllByJpqlParamsQuery(active, city);
//    }

}
