package com.chen.controller;

import com.chen.pojo.Books;
import com.chen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
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
