package ru.dynamica.model.bookloan;

public class BookLoanMapper {
    private BookLoanMapper() {
    }

    public static BookLoanDto toDto(BookLoan bookLoan) {
        BookLoanDto dto = new BookLoanDto();
        dto.setClientId(bookLoan.getClient().getId());
        dto.setBookId(bookLoan.getBook().getId());
        return dto;
    }
}
