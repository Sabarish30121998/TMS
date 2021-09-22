package com.example.TMS.Controller;

import com.example.TMS.BaseResponse.BaseResponse;
import com.example.TMS.BaseResponse.PaginationResponse;
import com.example.TMS.DTO.TokenDTO;
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

   @GetMapping("/pagination/{currpagenumber}/{totalnumberofrecordsinpage}/{username}")
    public PaginationResponse pagination1(@PathVariable int currpagenumber, @PathVariable int totalnumberofrecordsinpage, @PathVariable String username)
   {
       return  userService.pagination(currpagenumber,totalnumberofrecordsinpage,username);
   }

   @GetMapping("/login")
    public BaseResponse token1(@RequestBody TokenDTO tokenDTO)
   {
       return userService.login(tokenDTO);
   }

   @GetMapping("/signin")
    public BaseResponse signintoken(@RequestBody TokenDTO tokenDTO)
   {
       return  userService.signin(tokenDTO);
   }


}
