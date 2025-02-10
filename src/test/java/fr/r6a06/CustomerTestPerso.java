package fr.r6a06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CustomerTestPerso {

    @Test
    void rental_test() {
        // Arrange
        Customer test = new Customer("testadd");
        Movie film = new Movie("film", 10);
        Rental filmpret = new Rental(film, 5);

        // Act
        Movie expected = film;
        Movie actual = filmpret.getMovie();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void name_test() {
        // Arrange
        Customer test = new Customer("testgetname");

        // Act
        String expected = "testgetname";
        String actual = test.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void statement_test() {
        // Arrange
        Customer test = new Customer("testadd");
        Movie film = new Movie("film", 2);
        Rental filmpret = new Rental(film, 2);

        // Act
        String expected = "Record for " + test.getName() + "\n" + "\tfilm\t1.5" + "\n" + "Amount owed is " + 1.5 + "\n" + "You earned " + 1 +
                " frequent renter points";
        test.addRental(filmpret);
        String result = test.statement();

        // Assert
        assertEquals(expected, result);
    }
}