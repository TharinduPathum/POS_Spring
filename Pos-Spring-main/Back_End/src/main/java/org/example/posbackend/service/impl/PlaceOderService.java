package org.example.posbackend.service.impl;

import org.example.posbackend.dto.OderDto;
import org.example.posbackend.dto.OderDeatilesDto;
import org.example.posbackend.entity.Customer;
import org.example.posbackend.entity.Item;
import org.example.posbackend.entity.Oder;
import org.example.posbackend.entity.OderDeatiles;
import org.example.posbackend.repository.CustomerRepository;
import org.example.posbackend.repository.ItemRepository;
import org.example.posbackend.repository.OderDeatilesRepository;
import org.example.posbackend.repository.OderRepository;
import org.example.posbackend.service.PlaceOderServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceOderService implements PlaceOderServiceInterface {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    OderRepository oderRepository;

    @Autowired
    OderDeatilesRepository oderDeatilesRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    @Transactional
    public String saveOder(OderDto oder, List<OderDeatilesDto> oderDeatilesDto) {

        Oder oder2 = new Oder();
        oder2.setOderId(oder.getOderId());
        oder2.setDate(oder.getDate());

        Long id = Long.valueOf(oder.getCustormerId());
        java.util.Optional<Customer> optionalcustomer = customerRepository.findById(String.valueOf(id));
        Customer customer2 = optionalcustomer.get();

        oder2.setCustomer(customer2);

        List<OderDeatiles> oderDeatilesEntytyList = new ArrayList<>();

        for (OderDeatilesDto oderDeatilesDto1 : oderDeatilesDto) {


            OderDeatiles oderDeatiles = new OderDeatiles();
//            oderDeatiles.setOderDeatiles_id();
            oderDeatiles.setQty(oderDeatilesDto1.getQty());
            oderDeatiles.setTotlePrice(oderDeatilesDto1.getTotlePrice());

            java.util.Optional<Item> optionalItem = itemRepository.findById(oderDeatilesDto1.getItemId());
            Item item2 = optionalItem.get();

            int qty = Integer.parseInt(item2.getQty());
            int custormerQty = Integer.parseInt(oderDeatilesDto1.getQty());

            if(qty<custormerQty){
                throw new NullPointerException("not avelable this qty  in the stor "+ item2.getId());

            }
            int newItemqty = qty-custormerQty;
            item2.setQty(String.valueOf(newItemqty));

            oderDeatiles.setItem(item2);
            oderDeatiles.setOder(oder2);
            oderDeatilesEntytyList.add(oderDeatiles);
            System.out.println(oderDeatiles.getOderDeatiles_id());
        }

        oder2.setOderDeatilesLists(oderDeatilesEntytyList);
        System.out.println(oder2);
        oderRepository.save(oder2);

        return "";
    }

    @Override
    public String getLastOderId() {

     java.lang.String id =  oderRepository.findLastOderId();
if(id==null){
    int newid =0;

    newid++;
    return String.valueOf(newid);

}else {

   int x= Integer.parseInt(id);
   x++;
    return String.valueOf(x);
}
    }


}
