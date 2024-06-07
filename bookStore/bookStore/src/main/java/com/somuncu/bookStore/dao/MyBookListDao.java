package com.somuncu.bookStore.dao;

import com.somuncu.bookStore.entities.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBookListDao extends JpaRepository<MyBookList ,Integer> {
}
