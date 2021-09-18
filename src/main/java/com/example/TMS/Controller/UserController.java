package com.example.TMS.Controller;

import com.example.TMS.BaseResponse.BaseResponse;
import com.example.TMS.DTO.UserDTO;
import com.example.TMS.ServiceImplements.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

   @PostMapping("/create")
    public BaseResponse create1(@RequestBody UserDTO userDTO)
   {
       return userService.create(userDTO);
   }

   @GetMapping("/getbyid")
    public BaseResponse getbyid1(@RequestParam Long id)
   {
       return userService.getbyid(id);
   }

   @DeleteMapping("/deletebyid")
    public BaseResponse deletebyid1(@RequestParam Long id)
   {
       return userService.deletebyid(id);
   }

   @PutMapping("/putupdate")
    public BaseResponse update1(@RequestBody UserDTO userDTO,@RequestParam Long id)
   {
       return userService.putupdate(userDTO,id);
   }



}
