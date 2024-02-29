package com.bidirectional.login.service;
import java.util.List;
import com.bidirectional.login.repository.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.bidirectional.login.model.*;

@Service
public class LoginService {
    private LoginRepo loginRepo;
    public LoginService(LoginRepo loginRepo){
        this.loginRepo=loginRepo;
    }
    public Login postLogin(Login login){
        return loginRepo.save(login);
    }
    public List<Login> getLoginList(){
        return loginRepo.findAll();
    }
    public Login getByLoginId(int customerId){
        return loginRepo.findById(customerId).orElse(null);
    }
    public Login putLogin(Login login){
        return loginRepo.save(login);
    }
    public void deleteByLoginId(int customerId){
        loginRepo.deleteById(customerId);
    }
    public Page<Login> paginationLogin(int offset,int pagesize)
    {
        return loginRepo.findAll(PageRequest.of(offset,pagesize));
    }
    public Page<Login> pageSortLogin(int offset,int pagesize,String field)
    {
        PageRequest pageRequest=PageRequest.of(offset, pagesize , Sort.by(field));
        return loginRepo.findAll(pageRequest);
    }
}
