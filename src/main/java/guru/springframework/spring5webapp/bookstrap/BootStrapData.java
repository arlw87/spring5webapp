package guru.springframework.spring5webapp.bookstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Spring will look for implements of CommandLineRunner and run them
//Component means that the class is spring managed
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author simon = new Author("Simon", "Stevens");
        Book aNiceDay = new Book("A Nice Day", "1234321");

        simon.getBooks().add(aNiceDay);
        aNiceDay.getAuthors().add(simon);

        authorRepository.save(simon);
        bookRepository.save(aNiceDay);

        Author matthew = new Author("Matt", "Paul");
        Book aTravelGuide = new Book("A Travel Guide", "73850603");

        matthew.getBooks().add(aTravelGuide);
        aTravelGuide.getAuthors().add(matthew);

        authorRepository.save(matthew);
        bookRepository.save(aTravelGuide);

        System.out.println("Run in bootstrap");
        System.out.println("Number of Books " + bookRepository.count());

    }
}
