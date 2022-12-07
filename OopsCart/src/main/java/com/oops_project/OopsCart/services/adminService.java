package com.oops_project.OopsCart.services;
import com.oops_project.OopsCart.models.Customer;
import com.oops_project.OopsCart.models.Item;
import com.oops_project.OopsCart.models.admin;
import com.oops_project.OopsCart.repositories.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminService {

    @Autowired
    private adminRepository admin_repo;


    //registering admin
    public admin register(admin Admin){
        if(Admin.getAdminkey().equals("007")){
            return admin_repo.save(Admin);

        }
        else{
            return null;
        }


    }

    public void removeAdmin(admin Admin){
        admin_repo.delete(Admin);
    }

    public admin login(String userid, String pass){
        admin Admin = admin_repo.findById(userid).get();
        if( pass.equals(Admin.getPassword())){

            return Admin;
        }
        else{return null;}
    }
    public admin updateAdmin(admin Admin, String password, String name, String email){
        if(Admin.getAdminkey().equals(007)){
            Admin.updateProfile(password,name,email);
            return admin_repo.save(Admin);}
        else{
            return null;
        }

    }


    //remove this later
    public List<admin> findAlladmin(){
        return admin_repo.findAll();
    }

}
