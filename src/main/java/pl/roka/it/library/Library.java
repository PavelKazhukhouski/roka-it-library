package pl.roka.it.library;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Создать класс Библиотека.
 */

public class Library {
    /**
     * Список книг (изначально пустой).
     */
    private final List<Book> books;

    public Library() {
        books = new CopyOnWriteArrayList<>();
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
            System.out.println("Книга добавлена");
        }

    }

    /**
     * Получить все книги (метод ВОЗВРАЩАЕТ список всех книг в библиотеке).
     */
    public List<Book> getAllBooks() {
        return books;
    }

    /**
     * Удалить книгу (метод принимает id книги и удаляет из списка книгу с соответствующим id). ?????
     */
    public boolean removeBook(int id) {
        ListIterator<Book> iterator = books.listIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                return books.remove(book);
            }
        }
        return false;
    }

    /**
     * Редактировать книгу (принимает объект книги и редактирует их список товаров).
     */
    public void editBook(Book editedBook) {
        if (books.contains(editedBook)) {
            books.set(books.indexOf(editedBook), editedBook);
            System.out.println("Книга с ID " + editedBook.getId() + " - " +
                    "\"" + editedBook.getTitle() + "\"" + " отредактирована.");
        } else {
            System.out.println("Книга с ID " + editedBook.getId() + " не найдена в библиотеке.");
        }

    }

    public Book getBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;

    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}


