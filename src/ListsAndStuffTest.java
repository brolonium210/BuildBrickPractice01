import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListsAndStuffTest {


    // Method under test
    ArrayList<String> makeBasicLi(String[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    @Test
    public void testMakeBasicLiWithValidArray() {
        // Arrange
        String[] input = {"Apple", "Banana", "Cherry"};
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));

        // Act
        ArrayList<String> result = makeBasicLi(input);

        // Assert
        assertEquals(expected, result, "The list should match the input array");
    }

    @Test
    public void testMakeBasicLiWithEmptyArray() {
        // Arrange
        String[] input = {};
        ArrayList<String> expected = new ArrayList<>();

        // Act
        ArrayList<String> result = makeBasicLi(input);

        // Assert
        assertEquals(expected, result, "The list should be empty for an empty array");
    }

//    @Test
//    public void testMakeBasicLiWithNullArray() {
//        // Arrange
//        String[] input = null;
//
//        // Act and Assert
//        assertThrows(NullPointerException.class, () -> {
//            makeBasicLi(input);
//        }, "Null input should throw a NullPointerException");
//    }












}