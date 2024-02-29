package com.bidirectional.login.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bidirectional.login.model.LoginInformation;
import com.bidirectional.login.service.LoginInformationService;

@RestController
public class LoginInformationController {
    private LoginInformationService loginInformationService;
    public LoginInformationController(LoginInformationService loginInformationService){
        this.loginInformationService=loginInformationService;
    }
     @PostMapping("/loginInfo")
    public LoginInformation postLoginInfoDetails(@RequestBody LoginInformation loginInformation) {
        return loginInformationService.postLoginInfo(loginInformation);
    }
    @GetMapping("/loginInfos")
    public List<LoginInformation> getListOfLoginInfoDetails() {
        return loginInformationService.getLoginInfoList();
    }
    
    @GetMapping("/loginInfo/{Id}")
    public LoginInformation getLoginInfoById(@PathVariable("Id") int customerId) {
        return loginInformationService.getByLoginInfoId(customerId);
    }
    @PutMapping("/loginInfos/{customerId}")
    public void putLoginInfoDetails(@PathVariable("customerId") int customerId, @RequestParam String password ) {
        loginInformationService.putLoginInfo(customerId,password);
    }    
    @PutMapping("/loginInfo/{customerId}")
    public LoginInformation putLoginInfoDetail(@PathVariable("customerId") int customerId, @RequestBody LoginInformation loginInformation ) {
        return loginInformationService.putLoginInformation(loginInformation);
    }    
    @DeleteMapping("/loginIn/{id}")
    public void deleteLoginInfoById(@PathVariable("id") int id){
         loginInformationService.deleteByLoginInfoId(id);
    }
    @GetMapping("/loginInfo/{offset}/{pagesize}")
    public ResponseEntity<Page<LoginInformation>> getPaginationLoginInfo(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize) 
    {
        Page<LoginInformation> log=loginInformationService.paginationLoginInfo(offset,pagesize);
        if(log!=null)
        {
            return new ResponseEntity<>(log,HttpStatus.OK);
        }
        return new ResponseEntity<>(log,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/loginInfo/{offset}/{pagesize}/{field}")
    public ResponseEntity<Page<LoginInformation>> getPageSortLoginInfo(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize,@PathVariable("field") String field) {
        Page<LoginInformation> sort=loginInformationService.pageSortLoginInfo(offset,pagesize,field);
        if(sort!=null){
            return new ResponseEntity<>(sort,HttpStatus.OK);
        }
        return new ResponseEntity<>(sort,HttpStatus.NOT_FOUND);
    }
}
