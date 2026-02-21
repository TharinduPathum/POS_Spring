package org.example.posbackend.controller;

import org.example.posbackend.Util2.APIRespons;
import org.example.posbackend.dto.OderDeatilesDto;
import org.example.posbackend.dto.OderDto;
import org.example.posbackend.dto.Util.PlaceOderDto;
import org.example.posbackend.service.PlaceOderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/placeOder")
public class PlaceOderCotroller {

    @Autowired
    private PlaceOderServiceInterface placeOderServiceInterface;

    @PostMapping("saveOder")
    public ResponseEntity<APIRespons<String>> saveOder(@RequestBody PlaceOderDto placeOderDto) {
        System.out.println(placeOderDto);

        OderDto oderDto = new OderDto();
        oderDto.setOderId(placeOderDto.getOderId());
        oderDto.setCustormerId(placeOderDto.getCustormerId());
        oderDto.setDate(placeOderDto.getDate());

        List<OderDeatilesDto> OderDeatiles = placeOderDto.getOderDeatilesList();

        placeOderServiceInterface.saveOder(oderDto, OderDeatiles);

         return new ResponseEntity<>(new APIRespons<>(201,"Order saved Successfully",null), HttpStatus.CREATED);
    }



    @GetMapping("getLastOderId")
    public String getLastOderId() {
     java.lang.String id = placeOderServiceInterface.getLastOderId();
        return id;
    }


}
