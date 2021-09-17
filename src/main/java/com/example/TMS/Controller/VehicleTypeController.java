package com.example.TMS.Controller;

import com.example.TMS.BaseResponse.BaseResponse;
import com.example.TMS.DTO.VehicleTypeDTO;
import com.example.TMS.Service.UserService;
import com.example.TMS.Service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vehicletype")
public class VehicleTypeController {

    @Autowired
    VehicleTypeService vehicleTypeService;

    @PostMapping("/create")
    public BaseResponse create(@RequestBody VehicleTypeDTO vehicleTypeDTO)
    {
        return vehicleTypeService.create(vehicleTypeDTO);
    }

    @GetMapping("/getbyid")
    public BaseResponse<Optional> getbyid(@RequestParam long id)
    {
        return vehicleTypeService.getbyid(id);
    }

    @DeleteMapping("/deletebyid")
    public BaseResponse deletebyid(@RequestParam long id)
    {
        return vehicleTypeService.deletebyid(id);
    }

    @PutMapping("/putupdate")
    public BaseResponse putupdate(@RequestBody VehicleTypeDTO vehicleTypeDTO,@RequestParam Long id)
    {
        return vehicleTypeService.putupdate(vehicleTypeDTO,id);
    }
}
