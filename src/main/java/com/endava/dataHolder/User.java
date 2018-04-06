package com.endava.dataHolder;

//TODO Builder
//TODO Done...

public class User {
    private int Id;
    private String nameLast;
    private String nameFirst;
    private String email;
    private int age;

    public static class Builder {
        //Required
        private final int Id;
        private final String nameLast;
        private final String nameFirst;

        //Optional
        private String email = "";
        private int age = 0;

        public Builder(int Id, String nameLast, String nameFirst) {
            this.Id = Id;
            this.nameLast = nameLast;
            this.nameFirst = nameFirst;
        }

        public Builder email(String value) {
            email = value;
            return this;
        }

        public Builder age(int value) {
            age = value;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        Id = builder.Id;
        nameLast = builder.nameLast;
        nameFirst = builder.nameFirst;
        email = builder.email;
        age = builder.age;
    }

    public int getId() {
        return Id;
    }

    public String getNameLast() {
        return nameLast;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
