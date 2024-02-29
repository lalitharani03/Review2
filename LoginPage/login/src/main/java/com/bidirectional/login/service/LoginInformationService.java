package com.bidirectional.login.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bidirectional.login.model.LoginInformation;
import com.bidirectional.login.repository.LoginInformationRepo;

import jakarta.transaction.Transactional;

@Service
public class LoginInformationService {
    private LoginInformationRepo loginInformationRepo;
    public LoginInformationService(LoginInformationRepo loginInformationRepo){
        this.loginInformationRepo=loginInformationRepo;
    }
    public LoginInformation postLoginInfo(LoginInformation loginInformation){
        return loginInformationRepo.save(loginInformation);
    }
    public List<LoginInformation> getLoginInfoList(){
        return loginInformationRepo.findAll();
    }
    public LoginInformation getByLoginInfoId(int customerId){
        return loginInformationRepo.findById(customerId).orElse(null);
    }
    @Transactional
    public void putLoginInfo(int customerId,String password){
         loginInformationRepo.update(customerId,password);
    }
    public LoginInformation putLoginInformation(LoginInformation loginInformation){
        return loginInformationRepo.save(loginInformation);
    }
    public void deleteByLoginInfoId(int id){
        loginInformationRepo.deleteById(id);
    }
    public Page<LoginInformation> paginationLoginInfo(int offset,int pagesize)
    {
        return loginInformationRepo.findAll(PageRequest.of(offset,pagesize));
    }
    public Page<LoginInformation> pageSortLoginInfo(int offset,int pagesize,String field)
    {
        PageRequest pageRequest=PageRequest.of(offset, pagesize , Sort.by(field));
        return loginInformationRepo.findAll(pageRequest);
    }
}
