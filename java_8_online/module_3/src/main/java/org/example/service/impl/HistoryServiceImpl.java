package org.example.service.impl;

import org.example.dao.HistoryDao;
import org.example.dao.impl.HistoryDaoImpl;
import org.example.entity.History;
import org.example.service.HistoryService;

public class HistoryServiceImpl implements HistoryService {

    private final HistoryDao historyDao = new HistoryDaoImpl();

    @Override
    public void create(History history) {
        historyDao.create(history);
    }
}
