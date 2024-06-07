package com.somuncu.bookStore.service.concretes;

import com.somuncu.bookStore.dao.MyBookListDao;
import com.somuncu.bookStore.entities.MyBookList;
import com.somuncu.bookStore.service.abstracts.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListServiceImpl implements MyBookListService {

    private MyBookListDao myBookListDao ;

    @Autowired
    public MyBookListServiceImpl(MyBookListDao myBookListDao) {
        this.myBookListDao = myBookListDao;
    }

    @Override
    public void save(MyBookList myBookList) {
        this.myBookListDao.save(myBookList);
    }

    @Override
    public List<MyBookList> getAllMyBookList() {
        return this.myBookListDao.findAll();
    }

    @Override
    public void deleteMyBook(int id) {
        this.myBookListDao.deleteById(id);
    }
}
