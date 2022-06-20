package com.tongji.softwaretest.shikebackend.service;

import com.tongji.softwaretest.shikebackend.entity.Store;

import java.util.List;

public interface StoreService {

    List<Store> getStoreList();

    Store getStoreById(int storeId);

    boolean addStore(Store store);

    boolean modifyStore(Store store);

    boolean deleteStore(int storeId);
}
