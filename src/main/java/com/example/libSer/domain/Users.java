package com.example.libSer.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String userName;
    @Column
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_books")
    private List<Books> books;

    public void addBookForUser(Books book){
        this.books.add(book);
    }
    public void removeBookFromUser(Books book){
        this.books.remove(book.getId());
    }

    public Users() {
    }
    public Users(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Users(Long id, String userName, String password, List<Books> books) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users user = (Users) o;
        return id.equals(user.id) && userName.equals(user.userName) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password);
    }

    @Override
    public String toString(){
        return "User{ " +
                "id = " + id +
                ", name = " + userName;
    }
}
