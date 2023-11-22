package org.example.service.impl;

import org.example.dao.OperationDao;
import org.example.dao.impl.OperationDaoImpl;
import org.example.entity.Operation;
import org.example.service.OperationService;

public class OperationServiceImpl implements OperationService {

    private final OperationDao operationDao= new OperationDaoImpl();

    @Override
    public void create(Operation operation) {
        operationDao.create(operation);
    }
}
