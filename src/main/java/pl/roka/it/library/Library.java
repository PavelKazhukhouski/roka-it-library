package pl.roka.it.library;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Создать класс Библиотека.
 */

public class Library {
    /**
     * Список книг (изначально пустой).
     */
    private final List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    /**
     * Добавить книгу (принимает объект книги и добавляет его в список товаров). При попытке добавить книгу с id
     * уже существующем в списке, вставка производится не должна.
     */
    public void addBook(Book book) {
        if (books.contains(book)) {
            System.out.println("Книга с таким ID уже существует в библиотеке.");
        } else {
            books.add(book);
            System.out.println("Книга добавлена в библиотеку.");
        }

    }

    /**
     * Получить все книги (метод ВОЗВРАЩАЕТ список всех книг в библиотеке).
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Удалить книгу (метод принимает id книги и удаляет из списка книгу с соответствующим id). ?????
     */
    public void removeBook(int id) {
        ListIterator<Book> iterator = books.listIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                System.out.println("Книга с ID " + book.getId() + " - " +
                        "\"" + book.getTitle() + "\"" + " удалена из библиотеки.");
                return;
            }
        }
        System.out.println("Книга с ID " + id + " не найдена в библиотеке.");
    }

    /**
     * Редактировать книгу (принимает объект книги и редактирует их список товаров).
     */
    public void editBook(Book editedBook) {
        if (books.contains(editedBook)) {
            books.set(books.indexOf(editedBook), editedBook);
            System.out.println("Книга с ID " + editedBook.getId() + " - " +
                    "\"" + editedBook.getTitle() + "\"" + " отредактирована.");
            return;
        }
        System.out.println("Книга с ID " + editedBook.getId() + " не найдена в библиотеке.");
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
