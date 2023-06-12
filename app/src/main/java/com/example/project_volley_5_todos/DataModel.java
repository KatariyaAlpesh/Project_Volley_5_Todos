package com.example.project_volley_5_todos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel
{

    public DataModel(Integer userId, Integer id, String title, boolean completed)
    {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = completed;

    }
        private Integer userId;
        private Integer id;
        private String title;
        private Boolean completed;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean getCompleted() {
            return completed;
        }

        public void setCompleted(Boolean completed) {
            this.completed = completed;
        }


}
