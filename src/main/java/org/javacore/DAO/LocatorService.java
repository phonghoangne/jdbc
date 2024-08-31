package org.javacore.DAO;

import org.javacore.domain.Locator;

import java.util.List;

public interface LocatorService extends CRUD<Locator> {
    List<Locator> findByName(String name);
}
