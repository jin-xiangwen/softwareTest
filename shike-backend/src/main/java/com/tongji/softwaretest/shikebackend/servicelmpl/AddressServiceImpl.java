package com.tongji.softwaretest.shikebackend.servicelmpl;

import com.tongji.softwaretest.shikebackend.entity.Address;
import com.tongji.softwaretest.shikebackend.mapper.AddressMapper;
import com.tongji.softwaretest.shikebackend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Address getAddressById(int addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }

    @Override
    public List<Address> getAddressList(int userId) {
        return addressMapper.selectAll(userId);
    }

    @Override
    public boolean addAddress(Address address) {
        int effectedNum = addressMapper.insert(address);
        if (effectedNum > 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean modifyAddress(Address address) {
        int effectedNum = addressMapper.updateByPrimaryKey(address);
        if (effectedNum > 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteAddress(int addressId) {
        int effectedNum = addressMapper.deleteByPrimaryKey(addressId);
        if (effectedNum > 0){
            return true;
        } else {
            return false;
        }
    }
}
