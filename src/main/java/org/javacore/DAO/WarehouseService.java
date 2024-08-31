package org.javacore.DAO;

import org.javacore.domain.WareHouse;

import java.util.Comparator;
import java.util.List;

public interface WarehouseService extends CRUD<WareHouse> {

    List<WareHouse> findByNameLike(String name);

    // sap xep comparator khong la amonyus
    List<WareHouse> orderByName(List<WareHouse> list) ;
}
