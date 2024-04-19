package pl.roka.it.library;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Алгоритм работы библиотеки:
 * • Выберите действие:
 * 1 Вывод всех книг. При выборе этого действия, было бы отлично спросить у пользователя в какой сортировке вывести:
 * ▪ по алфавиту (возрастание)
 * ▪ по алфавиту (убывание)
 * ▪ по добавлению(сначала новые, потом более старые)
 * После выбора сортировки, из библиотеки получаете список книг, сортируете их таким образом, как выбрал пользователь
 * и выводите в консоль.
 * <p>
 * 2 Добавление книги. При выборе этого действия:
 * ▪ пользователь должен ввести из консоли 3 параметра (id, название, жанр).
 * ▪ создаем объект книги (поля заполняются данными введенными пользователем)
 * ▪ добавляем книгу в библиотеку (напоминаю, если в списке книг уже существует книга с таким id, то новая книга не
 * добавляется)
 * <p>
 * 3 Удаление книги. При выборе этого действия:
 * ▪ пользователь вводит id книги которую нужно удалить
 * ▪ удаляем книгу из магазина
 * <p>
 * 4 Редактирование книги. При выборе этого действия:
 * ▪ пользователь должен ввести из консоли 3 параметра (id книги для редактирования, новое название, новую жанр).
 * ▪ создаем объект книги (поля заполняются данными введенными пользователем)
 * ▪ редактируем книгу в библиотеке
 * <p>
 * 5 Выход. При выборе этого действия, работа библиотеки завершается.
 * <p>
 * В main создаем объект вашей консольной меню (приложения, Application). И вызываем метод старт. Библиотека
 * должна работать по замкнутому циклы, до тех пор пока пользователь в меню не выберет выход. Естественно не
 * забываем про обработку всевозможных ошибок.  Успехов!
 */

public class LibraryApplication {
    private final Scanner scanner = new Scanner(System.in);
    private final Library library = new Library();

    public void start() {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Вывод всех книг");
            System.out.println("2. Добавление книги");
            System.out.println("3. Удаление книги");
            System.out.println("4. Редактирование книги");
            System.out.println("5. Выход");

            switch (intReader()) {
                case 1 -> showAllBooks();
                case 2 -> addToLibrary();
                case 3 -> {
                    System.out.println("Введите Id Книги");
                    library.removeBook(intReader());
                }
                case 4 -> editingABookInTheLibrary();
                case 5 -> System.exit(0);
            }
        }
    }

    public int intReader() {
        while (!scanner.hasNextInt()) {
            System.out.println("Пожалуйста, введите целое число:");
            scanner.next();
        }
        return scanner.nextInt();
    }
    public Genre genreReader() {
        while (true) {
            System.out.println("Выберете номер нужного жанра: ");
            for (int i = 0; i < Genre.values().length; i++) {
                System.out.println(i + ". " + Genre.values()[i]);
            }
            int numberOfMenu = intReader();
            if (numberOfMenu >= 0 && numberOfMenu < Genre.values().length) {
                return Genre.values()[numberOfMenu];
            }
            System.out.println("Не правильный номер. Попробуйте еще раз.");
        }
    }

    /**
     * Вывод всех книг. При выборе этого действия, было бы отлично спросить у пользователя в какой сортировке вывести:
     * ▪ по алфавиту (возрастание)
     * ▪ по алфавиту (убывание)
     * ▪ по добавлению(сначала новые, потом более старые)
     * После выбора сортировки, из библиотеки получаете список книг, сортируете их таким образом, как выбрал пользователь
     * и выводите в консоль.
     */
    public void showAllBooks() {
        while (true) {
            System.out.println("\nВыберите способ сортировки:");
            System.out.println("1. По алфавиту (возрастание)");
            System.out.println("2. По алфавиту (убывание)");
            System.out.println("3. По порядку добавления");
            System.out.println("4. Выход в главное меню");

            List<Book> copyOfBooks = library.getAllBooks();

            switch (intReader()) {
                case 1 -> {
                    copyOfBooks.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
                    System.out.println(copyOfBooks);
                }
                case 2 -> {
                    copyOfBooks.sort(Collections.reverseOrder((b1, b2) -> b1.getTitle().compareTo(b2.getTitle())));
                    System.out.println(copyOfBooks);
                }
                case 3 -> System.out.println(copyOfBooks.reversed());
                case 4 -> {
                    return;
                }
                default -> System.out.println("Неверный выбор.");
            }
        }
    }

    /**
     * Добавление книги. При выборе этого действия:
     * ▪ пользователь должен ввести из консоли 3 параметра (id, название, жанр).
     * ▪ создаем объект книги (поля заполняются данными введенными пользователем)
     * ▪ добавляем книгу в библиотеку (напоминаю, если в списке книг уже существует книга с таким id, то новая книга не
     * добавляется)
     */
    public void addToLibrary() {
        int id;
        String title;
        Genre genre;

        System.out.println("Введите Id книги:");
        id = intReader();

        System.out.println("Введите название книги:");
        scanner.nextLine();
        title = scanner.nextLine();

        genre = genreReader();

        library.addBook(new Book(id, title, genre));
    }

    /**
     * Редактирование книги. При выборе этого действия:
     * ▪ пользователь должен ввести из консоли 3 параметра (id книги для редактирования, новое название, новую жанр).
     * ▪ создаем объект книги (поля заполняются данными введенными пользователем)
     * ▪ редактируем книгу в библиотеке
     */
    public void editingABookInTheLibrary() {
        int id;
        String title;
        Genre genre;

        System.out.println("Введите Id книги:");
        id = intReader();

        System.out.println("Введите название книги:");
        scanner.nextLine();
        title = scanner.nextLine();

        genre = genreReader();

        library.editBook(new Book(id, title, genre));
    }


}
