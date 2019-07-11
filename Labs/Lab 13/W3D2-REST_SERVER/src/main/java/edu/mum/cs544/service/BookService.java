package edu.mum.cs544.service;

import edu.mum.cs544.dao.IBookDao;
import edu.mum.cs544.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private IBookDao bookDao;
    public List<Book> getALl(){
        return bookDao.findAll();
    }
    public Book get(int id){
        return bookDao.findById(id).get();
    }
    public Book update(Book book){
        return bookDao.save(book);
    }
    public void delete(int id){
         bookDao.deleteById(id);
    }
    public Book create(Book book){
        return bookDao.save(book);
    }

}
