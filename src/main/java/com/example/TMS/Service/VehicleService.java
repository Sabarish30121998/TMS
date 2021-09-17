package com.example.TMS.Service;

import com.example.TMS.BaseResponse.BaseResponse;
import com.example.TMS.DTO.VehicleDTO;
import com.example.TMS.EntityORModel.Loaded;
import com.example.TMS.EntityORModel.User;
import com.example.TMS.EntityORModel.Vehicle;
import com.example.TMS.EntityORModel.VehicleType;
import com.example.TMS.Repository.UserRepo;
import com.example.TMS.Repository.VehicleRepo;
import com.example.TMS.Repository.VehicleTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    VehicleTypeRepo vehicleTypeRepo;

    @Autowired
    UserRepo userRepo;

    public BaseResponse create(VehicleDTO vehicleDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Vehicle vehicle= new Vehicle();

        vehicle.setVehicleName(vehicleDTO.getVehicleName());
        vehicle.setRegistrationNumber(vehicleDTO.getRegistrationNumber());
        vehicle.setIsActive(0);
        vehicle.setIsDeleted(0);

        Optional<VehicleType> vehicleType = vehicleTypeRepo.findById(vehicleDTO.getVehicleTypeDTOidmapping());
        if(vehicleType.isPresent())
        {
            vehicle.setVehicleTypeid(vehicleType.get());
        }
        else
        {
            throw  new RuntimeException("enter a valid vehicletype id");
        }

        vehicleDTO.getUserDTOidmapping().forEach(user ->{
            Optional<User> sabari = userRepo.findById(user.getOwnerId());
            if(sabari.isPresent())
            {
                vehicle.setUser(sabari.get());
                vehicleRepo.save(vehicle);
            }
            else
            {
                throw  new RuntimeException("Please enter a valid user id");
            }
        });

        baseResponse.setStatuscode("success");
        baseResponse.setStatusmessage("Successfully Data Created");
        baseResponse.setData(vehicle);
        return baseResponse;
    }

    public BaseResponse deletebyid(long id) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Vehicle> sabari = vehicleRepo.findById(id);
        if(sabari.isPresent())
        {
              sabari.get().setIsDeleted(1);
              vehicleRepo.save(sabari.get());
              baseResponse.setStatuscode("success");
              baseResponse.setStatusmessage("This ID successfully deleted");
        }
        else
        {
            throw  new RuntimeException("Please Enter the Valid Vehicle id to delete");
        }

        return baseResponse;
    }

    public BaseResponse getbyid(long id) {
        BaseResponse baseResponse= new BaseResponse();
        Optional<Vehicle> sabari = vehicleRepo.findById(id);
        if(sabari.isPresent())
        {
            if(sabari.get().getIsDeleted()==0)
            {
                baseResponse.setStatuscode("success");
                baseResponse.setStatusmessage("This Vehicle Id is successfully got");
                baseResponse.setData(sabari);
            }
            else
            {
                throw  new RuntimeException("This Vehicle Id is Deleted");
            }
        }
        else
        {
            throw  new RuntimeException(" Please enter the valid vehicle id ");
        }
        return  baseResponse;
    }

    public BaseResponse putupdate(long id, VehicleDTO vehicleDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Vehicle> sabari= vehicleRepo.findById(id);
        if(sabari.isPresent())
        {
            sabari.get().setVehicleName(vehicleDTO.getVehicleName());
            sabari.get().setRegistrationNumber(vehicleDTO.getRegistrationNumber());
            sabari.get().setIsActive(vehicleDTO.getIsActive());
            sabari.get().setIsDeleted(vehicleDTO.getIsDeleted());

            //sabari.get().setVehicleTypeid(vehicleDTO.getVehicleTypeDTOidmapping());


            vehicleRepo.save(sabari.get());
            baseResponse.setStatuscode("success");
            baseResponse.setStatusmessage("This Vehicle Id is successfully updated");
            baseResponse.setData(sabari.get());
        }
        else
        {
            throw  new RuntimeException("please enter a valid vehicle id ");
        }

        return baseResponse;
    }
}
