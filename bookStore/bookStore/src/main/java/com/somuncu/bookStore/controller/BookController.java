package com.somuncu.bookStore.controller;

import com.somuncu.bookStore.entities.Book;
import com.somuncu.bookStore.entities.MyBookList;
import com.somuncu.bookStore.service.abstracts.BookService;
import com.somuncu.bookStore.service.abstracts.MyBookListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private BookService bookService;
    private MyBookListService myBookListService ;

    @Autowired
    public BookController(BookService bookService , MyBookListService myBookListService) {
        this.bookService =bookService;
        this.myBookListService =myBookListService ;
    }


    @GetMapping("/")
    public String home() {
        return "home";
   }

    @RequestMapping("/bookRegister")
    public String bookRegister(Model model) {

        Book book = new Book();
        model.addAttribute("book", book);

        return "bookRegister";
    }

    @RequestMapping("/saveBook")
    public String saveBook(@Valid @ModelAttribute("book") Book book , BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "bookRegister";
        }

        this.bookService.saveBook(book);
        return "redirect:/availableBooks";
    }

    @GetMapping("/availableBooks")
    public String getAllBook(Model model) {

        List<Book> bookList = this.bookService.getAllBooks();
        model.addAttribute("bookList" , bookList);

        return "bookList";
    }

    @RequestMapping("/saveMyBooks")
    public String myBooks(@RequestParam int id , Model model) {

        Optional<Book> book = this.bookService.getById(id);


        MyBookList myBook = new MyBookList();
        myBook.setId(book.get().getId());
        myBook.setName(book.get().getName());
        myBook.setAuthor(book.get().getAuthor());
        myBook.setPrice(book.get().getPrice());

        this.myBookListService.save(myBook);

        return "redirect:/showMyBooks" ;
    }

    @GetMapping("/showMyBooks")
    public String showMyBooks(Model model) {

        List<MyBookList> myBookLists = this.myBookListService.getAllMyBookList();
        model.addAttribute("myBookLists" ,myBookLists);

        return "myBooks";
    }

    @RequestMapping("/deleteMyBook")
    public String deleteMyBook(@RequestParam int id) {
        this.myBookListService.deleteMyBook(id);
        return "redirect:/showMyBooks";
    }


}
