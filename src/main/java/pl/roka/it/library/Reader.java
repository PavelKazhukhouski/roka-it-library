package pl.roka.it.library;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 2. Создать сущности пользователей, которые берут книги из библиотеки, читают и возвращают книги обратно
 * в библиотеку
 * 3. Читают книги они каждый разное количество времени
 * 4. Если желаемой книги в библиотеке нет, то они должны ждать её какое-то время и если не дождались,
 * выдавать сообщение, что не дождались и уходить (завершать работу)
 */

public class Reader extends Thread {
    Random random = new Random();
    private Library library;
    Book book;
    public Reader(Library library, Book book, String name) {
        this.library = library;
        this.book = book;
        this.setName(name);
        this.start();
    }

    @Override
    public void run() {
        try {
            if (library.getBook(book).getLock().tryLock(5, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " Читает " + book);

                    Thread.sleep(random.nextInt(10) * 1000);

                    System.out.println(Thread.currentThread().getName() + " Дочитал " + book);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    library.getBook(book).getLock().unlock();
                }

            } else {
                System.out.println("Ушел домой.");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

