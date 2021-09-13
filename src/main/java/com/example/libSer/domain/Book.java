package com.example.libSer.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String bookName;
    @Column
    private String author;
    @Column
    private Integer totalBooksCount;
    @Column
    private Integer booksCount;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usr_books",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<User> users;

    public Book(String bookName, String author, Integer totalBooksCount) {
        this.bookName = bookName;
        this.author = author;
        this.totalBooksCount = totalBooksCount;
        this.booksCount = totalBooksCount;
    }

    public void addUserForBook(User user){
        this.users.add(user);
        this.booksCount -= 1;

    }
    public void removeUserFromBook(User user){
        this.users.remove(user);
        this.booksCount += 1;
    }

    public Book() {
    }

    public Book(String bookName, String author, Integer booksCount, List<User> users) {
        this.bookName = bookName;
        this.author = author;
        this.booksCount = booksCount;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public void setBooksCount(Integer booksCount) {
        this.booksCount = booksCount;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getTotalBooksCount() {
        return totalBooksCount;
    }

    public void setTotalBooksCount(Integer totalBooksCount) {
        this.totalBooksCount = totalBooksCount;
        this.booksCount = totalBooksCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id) &&
                bookName.equals(book.bookName) &&
                author.equals(book.author) &&
                totalBooksCount.equals(book.totalBooksCount) &&
                booksCount.equals(book.booksCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, author, totalBooksCount, booksCount);
    }

    @Override
    public String toString(){
        return "Book{ " +
                "id = " + id +
                ", name = " + bookName +
                ", author = " + author +
                ", booksCount = " + booksCount;
    }
}
