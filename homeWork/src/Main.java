import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Sasha", Arrays.asList(
                        new Book("Метро 2033", "Дмитрий Глуховский", 544, 2005),
                        new Book("Захар Прилепин", "Обитель", 768, 2014),
                        new Book("Harry Potter", "J.K. Rowling", 400, 1997),
                        new Book("The Da Vinci Code", "Dan Brown", 689, 2003),
                        new Book("The Hunger Games", "Suzanne Collins", 374, 2008)
                )),
                new Student("Masha", Arrays.asList(
                        new Book("Преступление и наказание", "Фёдор Достоевский", 576, 1866),
                        new Book("Евгений Онегин", "Александр Пушкин", 224, 1832),
                        new Book("Мастер и Маргарита", "Михаил Булгаков", 416, 1940),
                        new Book("Казус Кукоцкого", "Людмила Улицкая", 464, 2001),
                        new Book("Мёртвые души", "Николай Гоголь", 352, 1842)
                )),
                new Student("Dasha", Arrays.asList(
                        new Book("Война и мир", "Лев Толстой", 1225, 1869),
                        new Book("Отцы и дети", "Иван Тургенев", 256, 1862),
                        new Book("Казус Кукоцкого", "Людмила Улицкая", 464, 2001), // Дубликат
                        new Book("Доктор Живаго", "Борис Пастернак", 592, 1957),
                        new Book("Чапаев и Пустота", "Виктор Пелевин", 400, 1996)
                ))
                );
        students.stream()
                .peek(System.out::println) // 1. Выводим в консоль каждого студента
                .flatMap(s -> s.getBooks().stream()) //2. Получаем для каждого студента список книг
                .sorted() // 3. Сортируем книги по количеству страниц
                .distinct() // 4. Оставляем только уникальные книги
                .filter(book -> book.getYear() > 2000) // 5. Отфильтровываем книги, которые были выпущены после 2000 года
                .limit(3) // 6. ограничиваем 3 элементами
                .map(Book::getYear) // 7. получаем года выпуска
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Найден год выпуска: " + year),
                        () -> System.out.println("Подходящей книги не найдено")
                );
    }
};
