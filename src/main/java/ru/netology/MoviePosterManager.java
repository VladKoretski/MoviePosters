package ru.netology;

public class MoviePosterManager {

    int resultLength = 5;
    private MovieName[] posters = new MovieName[0];

    // четыре конструктора
    public MoviePosterManager() {
    }

    public MoviePosterManager(MovieName[] posters) {

        this.posters = posters;
    }

    public MoviePosterManager(int resultLength) {

        this.resultLength = resultLength;
    }

    public MoviePosterManager(MovieName[] posters, int resultLength) {
        this.posters = posters;
        this.resultLength = resultLength;
    }

    // добавление фильма
    public void addNewMovie(MovieName nameOfMovie) {

        MovieName[] tempPosters = new MovieName[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            tempPosters[i] = posters[i];
        }
        tempPosters[posters.length] = nameOfMovie;
        posters = tempPosters;
    }

    public MovieName[] getPosters() {
        return posters;
    }

    public MovieName[] findAll() {
        return posters;
    }

    public MovieName[] findLast() {

        int actualLength = resultLength;
        if (actualLength > posters.length) {
            actualLength = posters.length;
        }
        MovieName[] lastMovies = new MovieName[actualLength];

        for (int i = 0; i < actualLength; i++) {
            lastMovies[i] = posters[posters.length - 1 - i];
        }
        return lastMovies;
    }
}