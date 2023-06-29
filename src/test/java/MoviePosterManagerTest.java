import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.MovieName;
import ru.netology.MoviePosterManager;

public class MoviePosterManagerTest {

    MovieName movie1 = new MovieName("Бладшот");
    MovieName movie2 = new MovieName("Вперёд");
    MovieName movie3 = new MovieName("Отель Белград");
    MovieName movie4 = new MovieName("Джентльмены");
    MovieName movie5 = new MovieName("Человек-невидимка");
    MovieName movie6 = new MovieName("Тролли. Мировой тур");
    MovieName movie7 = new MovieName("Номер один");
    MovieName movie8 = new MovieName("Ещё один какой-то фильм");

    MoviePosterManager managerForDefaultResultLength = new MoviePosterManager();
    MoviePosterManager managerForResultLength3 = new MoviePosterManager(3);
    MoviePosterManager managerForResultLength7 = new MoviePosterManager(7);

    // Add movies testing
    @Test
    public void shouldCheckAddNoMovie() {

        MoviePosterManager manager = new MoviePosterManager();
        MovieName newMovie = new MovieName(null);

        manager.addNewMovie(newMovie);
        MovieName[] expected = {};
        MovieName[] actual = manager.getPosters();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldCheckAddSomeMovie() {

        MoviePosterManager manager = new MoviePosterManager();
        MovieName newMovie1 = new MovieName("movie 1");
        manager.addNewMovie(newMovie1);
        MovieName newMovie2 = new MovieName("movie 2");
        manager.addNewMovie(newMovie2);
        MovieName newMovie3 = new MovieName("movie 3");
        manager.addNewMovie(newMovie3);

        MovieName[] expected = {newMovie1, newMovie2, newMovie3};
        MovieName[] actual = manager.getPosters();

        Assertions.assertEquals(expected, actual);
    }

    //Constructors Testing
    @BeforeEach
    public void setup() {

        //Test data for basic constructor
        managerForDefaultResultLength.addNewMovie(movie1);
        managerForDefaultResultLength.addNewMovie(movie2);
        managerForDefaultResultLength.addNewMovie(movie3);
        managerForDefaultResultLength.addNewMovie(movie4);
        managerForDefaultResultLength.addNewMovie(movie5);
        managerForDefaultResultLength.addNewMovie(movie6);
        managerForDefaultResultLength.addNewMovie(movie7);
        managerForDefaultResultLength.addNewMovie(movie8);

        //Test data for constructor with resultLength = 3
        managerForResultLength3.addNewMovie(movie1);
        managerForResultLength3.addNewMovie(movie2);
        managerForResultLength3.addNewMovie(movie3);
        managerForResultLength3.addNewMovie(movie4);
        managerForResultLength3.addNewMovie(movie5);
        managerForResultLength3.addNewMovie(movie6);
        managerForResultLength3.addNewMovie(movie7);
        managerForResultLength3.addNewMovie(movie8);

        //Test data for constructor with resultLength = 7
        managerForResultLength7.addNewMovie(movie1);
        managerForResultLength7.addNewMovie(movie2);
        managerForResultLength7.addNewMovie(movie3);
        managerForResultLength7.addNewMovie(movie4);
        managerForResultLength7.addNewMovie(movie5);
        managerForResultLength7.addNewMovie(movie6);
        managerForResultLength7.addNewMovie(movie7);
        managerForResultLength7.addNewMovie(movie8);
    }

    // Basic constructor testing
    @Test
    public void shouldFindAllForBasicConstructor() {

        MovieName[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8};
        MovieName[] actual = managerForDefaultResultLength.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForBasicConstructor() {

        MovieName[] expected = {movie8, movie7, movie6, movie5, movie4};
        MovieName[] actual = managerForDefaultResultLength.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    // Constructor with ResultLength=3 testing
    @Test
    public void shouldFindAllForConstructorWithResultLength3() {

        MovieName[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8};
        MovieName[] actual = managerForResultLength3.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForConstructorWithResultLength3() {
        MovieName[] expected = {movie8, movie7, movie6};
        MovieName[] actual = managerForResultLength3.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    // Constructor with ResultLength=7 testing
    @Test
    public void shouldFindAllForConstructorWithResultLength7() {
        MovieName[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8};
        MovieName[] actual = managerForResultLength7.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastForConstructorWithResultLength7() {
        MovieName[] expected = {movie8, movie7, movie6, movie5, movie4, movie3, movie2};
        MovieName[] actual = managerForResultLength7.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}