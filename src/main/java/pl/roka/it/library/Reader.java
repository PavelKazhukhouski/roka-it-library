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
    private Random random = new Random();
    private Library library;
    private String title;
    private Book book;

    public Reader(Library library, String title, String name) {
        this.library = library;
        this.title = title;
        this.setName(name);
        this.start();
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        book = takeBook(title, 2000);
        if (book != null) {
            try {
                System.out.println(threadName + " is reading " + book.getTitle());
                Thread.sleep(random.nextInt(5) * 1000 + 1000);
                library.addBook(book);
                System.out.println(threadName + " finished reading");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(threadName + " Got out");
        }

    }

    public Book takeBook(String title, long timeOut) {
        long endTime = System.currentTimeMillis() + timeOut;
        while (System.currentTimeMillis() < endTime) {
            book = library.getBook(title);
            if (book != null && library.removeBook(book.getId())) {
                System.out.println(Thread.currentThread().getName() + " took " + book.getTitle());
                return book;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}

