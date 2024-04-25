package pl.roka.it.library;

/**
 * Создать класс Книга, поля:
 * • id (целое число).
 * • title (строка).
 * • genre (строка) (Если вы уже в себе уверены, создавайте еще один класс Genre и
 * в класс Book вместо genre включайте genreId, который будет ссылаться на жанр с
 * соответствующим id).
 */

public class Book {
    private int id;
    private String title;
    private Genre genre;

    public Book(int id, String title, Genre genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                '}';
    }
}
