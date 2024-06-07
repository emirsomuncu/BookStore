package com.somuncu.bookStore.service.abstracts;

import com.somuncu.bookStore.entities.MyBookList;

import java.util.List;

public interface MyBookListService {

    public void save(MyBookList myBookList);
    public List<MyBookList> getAllMyBookList();
    public void deleteMyBook(int id);
}
