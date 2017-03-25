package com.xiaomi.example.pojo;

/**
 * Created by mi on 2017/2/15.
 */
public class Order {

    private int order_id;
    private String order_no;
    private int user_id;
    private String book_isbn;
    private int count;
    private String remark;

    public Order() {
    }

    public Order(int order_id, String order_no, int user_id, String book_isbn, int count, String remark) {
        this.order_id = order_id;
        this.order_no = order_no;
        this.user_id = user_id;
        this.book_isbn = book_isbn;
        this.count = count;
        this.remark = remark;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
