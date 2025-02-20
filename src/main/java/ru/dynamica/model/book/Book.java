package ru.dynamica.model.book;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.dynamica.model.author.Author;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String title;
    @NonNull
    private String isbn;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "author_name", referencedColumnName = "name"),
            @JoinColumn(name = "author_last_name", referencedColumnName = "last_name")
    })
    private Author author;
}

