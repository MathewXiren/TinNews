package com.xma.tinnews.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.xma.tinnews.model.Article;

import java.util.List;

// the annotation here is pre-compiled
// is working mechanism is different from hibernate
// annotation process can create classes during compile time

// hibernate create during run-time by using reflection / slow,
// when using, server is strong, so it doesnot matter,
// but when using mobile, phone is slow, so we need room
@Dao
public interface ArticleDao {

    @Insert
    void saveArticle(Article article);

    @Query("SELECT * FROM article")
    LiveData<List<Article>> getAllArticles();

    @Delete
    void deleteArticle(Article article);
}