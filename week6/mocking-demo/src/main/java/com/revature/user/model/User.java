package com.revature.user.model;

import java.util.Objects;

public class User {

    private Long id;
    private String first;
    private String last;
    private String email;

    public User() {
    }

    public User(Long id, String first, String email) {
        this.id = id;
        this.first = first;
        this.email = email;
    }

    public User(String first, String last, int id, String email) {
        this.first = first;
        this.last = last;
        this.id = Long.valueOf(id);
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + first + ", email=" + email + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User user)) {
            return false;
        }
        return Objects.equals(id, user.id)
                && Objects.equals(first, user.first)
                && Objects.equals(last, user.last)
                && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first, last, email);
    }
}
