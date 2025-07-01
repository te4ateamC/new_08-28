package jp.te4a.teamc.spring.boot.bookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.teamc.spring.boot.bookapp.bean.BookBean;
import jp.te4a.teamc.spring.boot.bookapp.form.BookForm;
import jp.te4a.teamc.spring.boot.bookapp.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public BookForm create(BookForm bookForm) {
        BookBean bookBean = new BookBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.save(bookBean);
        return bookForm;
    }

    public BookForm update(BookForm bookForm) {
        BookBean bookBean = new BookBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.save(bookBean);
        return bookForm;
    }

    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    public List<BookForm> findAll() {
        List<BookBean> beanList = bookRepository.findAll();
        List<BookForm> formList = new ArrayList<BookForm>();
        for (BookBean bookBean : beanList) {
            BookForm bookForm = new BookForm();
            BeanUtils.copyProperties(bookBean, bookForm);
            formList.add(bookForm);
        }
        return formList;
    }

    public BookForm findOne(Integer id) {
        BookForm bookForm = new BookForm();
        bookRepository.findById(id).ifPresent(bookBean -> {
            BeanUtils.copyProperties(bookBean, bookForm);
        });
        return bookForm;
    }

    public BookForm save(BookForm bookForm) {
        BookBean bookBean = new BookBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.save(bookBean);
        return bookForm;
    }
}
