package com.example.TMS.Controller;

import com.example.TMS.BaseResponse.BaseResponse;
import com.example.TMS.DTO.UserDTO;
import com.example.TMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

   @PostMapping("/create")
    public BaseResponse create(@RequestBody UserDTO userDTO)
   {
       return userService.create(userDTO);
   }

   @GetMapping("/getbyid")
    public BaseResponse<Optional> getbyid(@RequestParam Long id)
   {
       return userService.getbyid(id);
   }

   @DeleteMapping("/deletebyid")
    public BaseResponse deletebyid(@RequestParam Long id)
   {
       return userService.deletebyid(id);
   }

   @PutMapping("/putupdate")
    public BaseResponse update(@RequestBody UserDTO userDTO,@RequestParam Long id)
   {
       return userService.putupdate(userDTO,id);
   }



}
