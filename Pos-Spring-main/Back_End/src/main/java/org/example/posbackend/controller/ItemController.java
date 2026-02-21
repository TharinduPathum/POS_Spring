package org.example.posbackend.controller;

import jakarta.validation.Valid;
import org.example.posbackend.Util2.APIRespons;
import org.example.posbackend.dto.ItemDto;
import org.example.posbackend.service.ItemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/Item")
public class ItemController {

    @Autowired
    private ItemServiceInterface itemServiceInterface;

    @PostMapping("saveItem")
    public ResponseEntity<APIRespons<String>> saveItem(@RequestBody @Valid ItemDto itemDto) {
        java.lang.String resp = itemServiceInterface.saveItem(itemDto);
        return new ResponseEntity<>(new APIRespons<>(201,"Saved Item Successfully",null), HttpStatus.CREATED);

    }

    @GetMapping("getAll")
    public List<ItemDto> getAllItems() {
        List<ItemDto> itemDtosList = itemServiceInterface.getAll();
        return itemDtosList;
    }

    @PutMapping("updateItem")
    public ResponseEntity<APIRespons<String>> updateItem(@RequestBody @Valid ItemDto itemDto) {
        System.out.println(itemDto.getItemId());
        System.out.println(itemDto.getItemName());
        System.out.println(itemDto.getPrice());

        itemServiceInterface.updateItem(itemDto);

        return new ResponseEntity<>(new APIRespons<>(200,"Item update Succses fully...",null), HttpStatus.CREATED);

    }

    @GetMapping("getLastId")
    public String getLastId() {
        java.lang.Long lastId = itemServiceInterface.getLastId();

        Long lastNewId = lastId + 1;
        System.out.println(lastNewId);
        String lastIdAsstring = String.valueOf(lastNewId);

        return lastIdAsstring;
    }
    @DeleteMapping("deleteItem")
    public ResponseEntity<APIRespons<String>>  deleteItem(@RequestBody  @Valid ItemDto itemDto) {
        itemServiceInterface.deleteItems(String.valueOf(itemDto.getItemId()));
        return new ResponseEntity<>(new APIRespons<>(204,"Item Deleted ",null), HttpStatus.CREATED);
    }
}
