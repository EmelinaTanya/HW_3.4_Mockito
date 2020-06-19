package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    private MovieRepository repository = new MovieRepository();
    private MovieItem first = new MovieItem(1, 1, "Бладшот", "боевик", "http://image.com");
    private MovieItem second = new MovieItem(2, 2, "Вперёд", "мультфильм", "http://image.com");
    private MovieItem third = new MovieItem(3, 3, "Отель 'Белград'", "комедия", "http://image.com");
    private MovieItem fourth = new MovieItem(4, 4, "Джентльмены", "боевик", "http://image.com");
    private MovieItem fifth = new MovieItem(5, 5, "Человек-невидимка", "ужасы", "http://image.com");
    private MovieItem sixth = new MovieItem(6, 6, "Тролли. Мировой тур", "мультфильм", "http://image.com");
    private MovieItem seventh = new MovieItem(7, 7, "Номер один", "комедия", "http://image.com");
    private MovieItem eighth = new MovieItem(8, 8, "Домовой", "комедия", "http://image.com");
    private MovieItem ninth = new MovieItem(9, 9, "Аладин", "приключения", "http://image.com");
    private MovieItem tenth = new MovieItem(10, 10, "Дитя робота", "фантастика", "http://image.com");
    private MovieItem eleventh = new MovieItem(11, 11, "Движение вверх", "спорт", "http://image.com");


    @Test
    void shouldSave() {
        MovieItem[] expected = new MovieItem[]{first};

        repository.save(first);

        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldSaveAllMovies() {
        MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        repository.save(eleventh);

        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldFindById() {
        MovieItem expected = new MovieItem(7, 7, "Номер один", "комедия", "http://image.com");

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        repository.save(eleventh);

        MovieItem actual = repository.findById(7);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNullIfNotFindById() {
        MovieItem expected = repository.findById(14);

        assertNull(expected);
    }

    @Test
    void shouldRemoveById() {
        MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth, seventh, eighth, ninth, tenth, eleventh};

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        repository.save(eleventh);

        repository.removeById(6);


        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();

        MovieItem[] expected = new MovieItem[0];

        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldNotRemoveIfNotExistingId() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(8));
    }

}
