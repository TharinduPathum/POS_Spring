package org.example.posbackend.service;

import org.example.posbackend.dto.ItemDto;

import java.util.List;

public interface ItemServiceInterface {
    public String saveItem(ItemDto itemDto);

    public String updateItem(ItemDto itemDto);


    public List<ItemDto> getAll();

    public void deleteItems(String id);

    public Long getLastId();
}
