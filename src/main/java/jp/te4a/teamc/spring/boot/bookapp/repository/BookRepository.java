package jp.te4a.teamc.spring.boot.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.te4a.teamc.spring.boot.bookapp.bean.BookBean;

@Repository

    public interface BookRepository extends JpaRepository<BookBean,Integer> {

        @Query("SELECT X FROM BookBean X ORDER BY X.title")
        List<BookBean>findAllOrderByTitle();
    }