package pl.roka.it.library;

public enum Genre {
    FICTION(1),
    NON_FICTION(2),
    MYSTERY(3),
    ROMANCE(4),
    FANTASY(5),
    SCIENCE_FICTION(6),
    THRILLER(7),
    HORROR(8),
    BIOGRAPHY(9),
    HISTORY(10),
    POETRY(11),
    DRAMA(12);

    int id;

    Genre(int id) {
        this.id = id;
    }

    public static Genre genreByID(int id) {
        for (Genre genre : Genre.values()) {
            if (genre.id == id) {
                return genre;
            }
        }
        throw new IllegalArgumentException("Invalid Id");
    }

    public int getGenreId() {
        return id;
    }


}
