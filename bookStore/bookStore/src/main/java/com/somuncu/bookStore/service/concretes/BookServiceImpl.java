package com.somuncu.bookStore.service.concretes;

import com.somuncu.bookStore.dao.BookDao;
import com.somuncu.bookStore.entities.Book;
import com.somuncu.bookStore.service.abstracts.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao ;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void saveBook(Book book) {
        this.bookDao.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookDao.findAll() ;
    }

    @Override
    public Optional<Book> getById(int id) {
        return this.bookDao.findById(id);
    }
}
