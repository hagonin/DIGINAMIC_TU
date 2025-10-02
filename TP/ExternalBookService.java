package com.mycompany.tp;

public interface ExternalBookService {
    boolean isBookAvailable(String title);
    Book fetchBookDetails(String title);
}