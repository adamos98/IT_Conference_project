package pl.sii.it_conference.constant;

public final class ErrorMessage {
    public static final String USER_NOT_FOUND_BY_ID = "Nie ma użytkownika z numerem id: ";
    public static final String USER_NOT_FOUND_BY_LOGIN = "Nie mogę znaleźć użytkownika z loginem: ";
    public static final Object LOGIN_AND_EMAIL_ALREADY_REGISTERED = "Podany login i email są już zajęte";
    public static final String LOGIN_ALREADY_REGISTERED = "Podany login jest już zajęty";
    public static final String PRELECTION_NOT_FOUND_BY_ID = "Nie istnieje prelekcja o id: ";
    public static final String PRELECTION_IS_FULL = "Ta prelekcja nie ma już miejsc!";
    public static final String RESERVATION_NOT_DELETED = "Rezerwacja nie została usunięta";
    public static final String USER_RESERVED_ON_THAT_TIME = "Na tą godzinę jesteś już zapisany na prelekcję";
    public static final String RESERVATION_NOT_FOUND_WITH_ID = "Nie znaleziono rezerwacji z id: ";
}
