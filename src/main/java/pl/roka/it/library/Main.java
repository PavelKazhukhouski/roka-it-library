package pl.roka.it.library;

import com.sun.jdi.event.ThreadDeathEvent;

import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 * Клиент библиотеки это хорошо, но вот что лучше:
 * - Дополнить библиотеку так, что бы она могла работать с несколькими читателями одновременно.
 * 1. Сделать сущность библиотекаря, который умеет:
 * - выдавать книги из библиотеки.
 * - принимать книги и возвращать их в библиотеку.
 * 2. Создать сущности пользователей, которые берут книги из библиотеки, читают и возвращают книги
 * обратно в библиотеку.
 * 3. Читают книги они каждый разное количество времени.
 * 4. Если желаемой книги в библиотеке нет, то они должны ждать её какое-то время и если не дождались,
 * выдавать сообщение, что не дождались и уходить (завершать работу).
 */

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        String[] title = {"Война и мир", "Звук и ярость", "Человек невидимка", "Илиада", "Одиссея",
                "Гордость и предубеждение", "Божественная комедия"};

        Library library = new Library();

        for (int i = 0; i < 5; i++) {
            library.addBook(new Book(i, title[i], Genre.values()[i]));
        }
        System.out.println(library);
        System.out.println();


        String[] readers = {"Вася", "Валера", "Света", "Коля", "Марина", "Егор", "Зина", "Галя", "Кеша", "Лида"};

        for (int i = 0; i < 7; i++) {
            new Reader(library, library.getAllBooks().get(random.nextInt(5)), readers[i]);
        }

    }


}





