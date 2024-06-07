package com.somuncu.bookStore.dao;

import com.somuncu.bookStore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book , Integer> {
}
