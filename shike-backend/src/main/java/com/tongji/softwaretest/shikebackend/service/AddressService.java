package com.tongji.softwaretest.shikebackend.service;

import com.tongji.softwaretest.shikebackend.entity.Address;

import java.util.List;

public interface AddressService {

    Address getAddressById(int addressId);

    List<Address> getAddressList(int userId);

    boolean addAddress(Address address);

    boolean modifyAddress(Address address);

    boolean deleteAddress(int addressId);
}
