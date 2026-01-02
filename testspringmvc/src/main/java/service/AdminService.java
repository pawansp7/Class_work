package service;

import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.AdminRepository;
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepo;

    public Admin registerAdmin(Admin admin){
        return adminRepo.save(admin);
    }

    public Admin authenticateAdmin(Admin admin){
        return adminRepo.findByEmailAndPassword(admin.getEmail(), admin.getPassword()).orElse(null);
    }
}
