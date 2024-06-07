package com.somuncu.bookStore.service.abstracts;

import com.somuncu.bookStore.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public void saveBook(Book book);

    public List<Book> getAllBooks();

    public Optional<Book> getById(int id);
}
