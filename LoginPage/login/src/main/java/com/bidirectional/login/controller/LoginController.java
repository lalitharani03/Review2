package com.bidirectional.login.controller;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.bidirectional.login.model.*;
import com.bidirectional.login.service.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class LoginController {
    private LoginService loginService;
    public LoginController(LoginService loginService){
        this.loginService=loginService;
    }
    @PostMapping("/login")
    public Login postLoginDetails(@RequestBody Login login) {
        return loginService.postLogin(login);
    }
    @GetMapping("/logins")
    public List<Login> getListOfLoginDetails() {
        return loginService.getLoginList();
    }
    @GetMapping("/login/{customerId}")
    public Login getLoginById(@PathVariable("customerId") int customerId) {
        return loginService.getByLoginId(customerId);
    }
    @PutMapping("/logins/{customerId}")
    public Login putLoginDetails(@PathVariable("customerId") int customerId, @RequestBody Login login ) {
        return loginService.putLogin(login);
    }    
    @DeleteMapping("/login/{cutomerid}")
    public void deleteLoginById(@PathVariable("customerid") int id){
        loginService.deleteByLoginId(id);
    }
    @GetMapping("/login/{offset}/{pagesize}")
    public ResponseEntity<Page<Login>> getPaginationLogin(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize) 
    {
        Page<Login> log=loginService.paginationLogin(offset,pagesize);
        if(log!=null)
        {
            return new ResponseEntity<>(log,HttpStatus.OK);
        }
        return new ResponseEntity<>(log,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/login/{offset}/{pagesize}/{field}")
    public ResponseEntity<Page<Login>> getPageSortLogin(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize,@PathVariable("field") String field) {
        Page<Login> sort=loginService.pageSortLogin(offset,pagesize,field);
        if(sort!=null){
            return new ResponseEntity<>(sort,HttpStatus.OK);
        }
        return new ResponseEntity<>(sort,HttpStatus.NOT_FOUND);
    }
}
