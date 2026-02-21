package org.example.posbackend.service;

import org.example.posbackend.dto.OderDto;
import org.example.posbackend.dto.OderDeatilesDto;

import java.util.List;

public interface PlaceOderServiceInterface {
    public String saveOder(OderDto oder, List<OderDeatilesDto> oderDeatilesDto);
    String getLastOderId();
}
