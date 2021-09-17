package com.example.TMS.Service;

import com.example.TMS.BaseResponse.BaseResponse;
import com.example.TMS.DTO.UserDTO;
import com.example.TMS.EntityORModel.User;
import com.example.TMS.Repository.UserRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class UserService {

    @Autowired
    UserRepo userRepo;

    public BaseResponse create(UserDTO userDTO) {
        BaseResponse baseResponse=new BaseResponse();
        User user = new User();

        user.setUserName(userDTO.getUserName());
        user.setUserType(userDTO.getUserType());
        user.setPassword(userDTO.getPassword());
        user.setCity(userDTO.getCity());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setIsDeleted(0);
        user.setIsActive(0);

        userRepo.save(user);


        baseResponse.setStatuscode("200");
        baseResponse.setStatusmessage("successfully value created");
        baseResponse.setData(user);
        return baseResponse;
    }

    public BaseResponse<Optional> getbyid(Long id)
    {
        BaseResponse baseResponse = new BaseResponse();
        Optional<User> sabari = userRepo.findById(id);
        if (sabari.isPresent()) {
            if (sabari.get().getIsDeleted() == 0) {
                baseResponse.setStatuscode("success");
                baseResponse.setStatusmessage("Data found");
                baseResponse.setData(sabari);
            } else {
                throw  new RuntimeException("This Data is deleted");
            }
        }
        else
        {
            throw  new RuntimeException("Please enter a valid User ID");
        }
        return baseResponse;
    }

    public BaseResponse deletebyid(Long id) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<User> sabari = userRepo.findById(id);
        if(sabari.isPresent()) {
            sabari.get().setIsDeleted(1);
            userRepo.save(sabari.get());
            baseResponse.setStatuscode("200");
            baseResponse.setStatusmessage("successfully deleted");
        }
        else
        {
            throw  new RuntimeException("Please enter the valid user id to delete");
        }
        return baseResponse;
    }

    public BaseResponse putupdate(UserDTO userDTO,Long id) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<User> sabari = userRepo.findById(id);

        if(sabari.isPresent()) {
            sabari.get().setUserName(sabari.get().getUserName());
            sabari.get().setUserType(userDTO.getUserType());
            sabari.get().setPassword(userDTO.getPassword());
            sabari.get().setCity(userDTO.getCity());
            sabari.get().setPhoneNumber(userDTO.getPhoneNumber());
            sabari.get().setIsActive(userDTO.getIsActive());
            sabari.get().setIsDeleted(userDTO.getIsDeleted());

            userRepo.save(sabari.get());
            baseResponse.setStatuscode("200");
            baseResponse.setStatusmessage("successfully value created");
            baseResponse.setData(sabari);
        }
        else{
            throw  new RuntimeException("Enter A Valid UserId");
        }


        return baseResponse;
    }
}
