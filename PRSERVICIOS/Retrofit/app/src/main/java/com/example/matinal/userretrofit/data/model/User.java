package com.example.matinal.userretrofit.data.model;

/**
 * Created by matinal on 16/01/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class User {

        @SerializedName("_id")
        @Expose
        private Integer _id;
        @SerializedName("first_name")
        @Expose
        private String _firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("email")
        @Expose
        private String email;

        /**
         * No args constructor for use in serialization
         *
         */
        public User() {
        }

        /**
         *
         * @param id
         * @param lastName
         * @param email
         * @param firstName
         */
        public User(Integer id, String firstName, String lastName, String email) {
            super();
            this._id = id;
            this._firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public Integer get_id() {
            return _id;
        }

        public void set_id(Integer _id) {
            this._id = _id;
        }

        public String get_firstName() {
            return _firstName;
        }

        public void set_firstName(String _firstName) {
            this._firstName = _firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("User: ").append("-").append(_firstName).append("-")
                    .append(lastName).append("-").append(email);
            return stringBuilder.toString();
        }
    }

