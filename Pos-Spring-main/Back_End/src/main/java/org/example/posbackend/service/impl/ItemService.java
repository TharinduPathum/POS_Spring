package org.example.posbackend.service.impl;

import jakarta.persistence.EntityExistsException;
import org.example.posbackend.dto.ItemDto;
import org.example.posbackend.entity.Item;
import org.example.posbackend.repository.ItemRepository;
import org.example.posbackend.service.ItemServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements ItemServiceInterface {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemDto itemDto) {

        Item item = modelMapper.map(itemDto, Item.class);

        Optional<Item> item1 = itemRepository.findById(String.valueOf(itemDto.getItemId()));

        if (item1.isPresent()) {

            throw new EntityExistsException("Item already exists!");

        } else {
            itemRepository.save(item);

        }



        return "saved";

    }

    @Override
    public String updateItem(ItemDto itemDto) {
        Item item = modelMapper.map(itemDto, Item.class);
        Optional<Item> item1 = itemRepository.findById(String.valueOf(itemDto.getItemId()));
//      Customer customer2 = customer1.get();

        if (item1.isPresent()) {
            itemRepository.save(item);
        } else {

            throw new EntityExistsException("Item not avelable  to audate..!");


        }


        return "";
    }

    @Override
    public List<ItemDto> getAll() {
        List<ItemDto> itemDtosList = new ArrayList<>();
        java.util.List<Item> itemList = itemRepository.findAll();
        for (Item item : itemList) {
            ItemDto itemDto = modelMapper.map(item, ItemDto.class);
            itemDtosList.add(itemDto);
        }
        return itemDtosList;
    }


    @Override
    public void deleteItems(String id) {

   java.util.Optional<Item>items =   itemRepository.findById(id);
        if(items.isPresent()){

            itemRepository.deleteById(id);

        }else {

            throw new NullPointerException("Item not avelable to delete ...");
        }

    }

    @Override
    public Long getLastId() {

        java.lang.Long lastId = itemRepository.findLastItemId();
        return lastId;
    }
}
