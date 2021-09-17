package com.example.TMS.Controller;

import com.example.TMS.BaseResponse.BaseResponse;
import com.example.TMS.DTO.VehicleDTO;
import com.example.TMS.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/create")
    public BaseResponse create(@RequestBody VehicleDTO vehicleDTO)
    {
        return vehicleService.create(vehicleDTO);
    }

    @DeleteMapping("/deletebyid")
    public BaseResponse deletebyid(@RequestParam long id)
    {
        return vehicleService.deletebyid(id);
    }

    @GetMapping("/getbyid")
    public BaseResponse getbyid(@RequestParam long id)
    {
        return vehicleService.getbyid(id);
    }

    @PutMapping("/putupdate")
    public BaseResponse putupdate(@RequestParam long id,@RequestBody VehicleDTO vehicleDTO)
    {
        return vehicleService.putupdate(id,vehicleDTO);
    }
}
