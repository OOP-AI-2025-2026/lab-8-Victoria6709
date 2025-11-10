package ua.opnu;

public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public double getRating() {
        return reviews == 0 ? 0.0 : total / reviews;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(BookData other) {
        double thisRating = this.getRating();
        double otherRating = other.getRating();

        if (thisRating > otherRating) {
            return -1;
        } else if (thisRating < otherRating) {
            return 1;
        } else {
            // Якщо рейтинги рівні — порівнюємо за назвою
            return this.title.compareTo(other.title);
        }
    }

    @Override
    public String toString() {
        return String.format("BookData[title=%s, author=%s, rating=%.2f]", title, author, getRating());
    }
}
