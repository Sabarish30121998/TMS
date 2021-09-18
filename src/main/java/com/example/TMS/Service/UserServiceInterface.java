package com.example.TMS.Service;

import com.example.TMS.BaseResponse.BaseResponse;
import com.example.TMS.DTO.UserDTO;

public interface UserServiceInterface {
     BaseResponse create(UserDTO userDTO);
     BaseResponse getbyid(Long id);
     BaseResponse putupdate(UserDTO userDTO,Long id);
     BaseResponse deletebyid(Long id);

}
