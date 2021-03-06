package lt.akademija.jpaexam.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Library implements UniqueEntityWithAssociation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private String address;
    
    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST},
            fetch=FetchType.EAGER)
    private List<Book> bookList = new ArrayList<Book>();
    
    public Library(){
        bookList.add(new Book("Hairy Potter"));
        
    }
        
    
    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return id;
    }

    @Override
    public Collection<? extends UpdatableEntity> oneToMany() {
        // TODO Auto-generated method stub
        return bookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
