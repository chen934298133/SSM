package com.chen.controller;

import com.chen.pojo.Books;
import com.chen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {

    // controller 调 service 层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    // 查询全部书籍，并返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    // 跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    // 添加书籍
    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println("addBook: " + books);
        bookService.addBook(books);
        // 重定向
        return "redirect:/book/allBook";
    }

    // 跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }

    // 修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }
    // 删除书籍
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

}

//@RestController
// 此处错误会返回String内容 : allBook

//@RequestMapping("/book")
//public class BookController {
//    //controller 调 service 层
//    @Autowired
//    @Qualifier("BookServiceImpl")
//    private BookService bookService;
//
//    //查询全部的书籍，并且返回到一个书籍的展示页面
//    @RequestMapping ("/allBook")
//    public String list(Model model) {
//        List<Books> list = bookService.queryAllBook();
//        model.addAttribute("list", list);
//        return "allBook";
//    }
//}
