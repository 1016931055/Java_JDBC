package com.demo4_注解解析方式;

public class BookStore {
    @Book("Java入门") //注解的特殊作用： 把value值，赋值给当前成员变量
    private String bookName;//成员变量

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
