package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Test various aspects of board.
 *
 * @author Jeroen Roosen 
 */
class BoardTest {

    private static final int MAX_WIDTH = 2;
    private static final int MAX_HEIGHT = 3;

    private final Square[][] grid = {
        { mock(Square.class), mock(Square.class), mock(Square.class) },
        { mock(Square.class), mock(Square.class), mock(Square.class) },
    };
    private final Board board = new Board(grid);

    private final Square[][] grid2 = {
            { mock(Square.class), mock(Square.class), mock(Square.class) },
            { mock(Square.class), mock(Square.class), mock(Square.class) },
            { mock(Square.class), mock(Square.class), mock(Square.class) },
    };
    private final Board board2 = new Board(grid2);

    /**
     * Verifies the board has the correct width.
     */
    @Test
    void verifyWidth() {
        assertThat(board.getWidth()).isEqualTo(MAX_WIDTH);
    }

    /**
     * Verifies the board has the correct height.
     */
    @Test
    void verifyHeight() {
        assertThat(board.getHeight()).isEqualTo(MAX_HEIGHT);
    }

    /**
     * Verify that squares at key positions are properly set.
     * @param x Horizontal coordinate of relevant cell.
     * @param y Vertical coordinate of relevant cell.
     */
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 2",
        "0, 1"
    })
    void testSquareAt(int x, int y) {
        assertThat(board.squareAt(x, y)).isEqualTo(grid[x][y]);
    }


    /**
     * Verify different x values on squareAt function.
     */
    @Test

    void testSquareFailAtXValue() {

        int y = 1;

        AssertionError error = Assertions.assertThrows(AssertionError.class, () -> {
            board2.squareAt(-1, y);
        });

        AssertionError error1 = Assertions.assertThrows(AssertionError.class, () -> {
            board2.squareAt(3, y);
        });

        assertThat(board2.squareAt(0, y)).isInstanceOf(Square.class).isNotNull();
        assertThat(board2.squareAt(1, y)).isInstanceOf(Square.class).isNotNull();
        assertThat(board2.squareAt(2, y)).isInstanceOf(Square.class).isNotNull();

    }

    /**
     * Verify different y values on squareAt function.
     */
    @Test
    void testSquareFailAtYValue() {

        int x = 1;

        AssertionError error = Assertions.assertThrows(AssertionError.class, () -> {
            board2.squareAt(x, -1);
        });

        AssertionError error1 = Assertions.assertThrows(AssertionError.class, () -> {
            board2.squareAt(x, 3);
        });

        assertThat(board2.squareAt(x, 0)).isInstanceOf(Square.class).isNotNull();
        assertThat(board2.squareAt(x, 1)).isInstanceOf(Square.class).isNotNull();
        assertThat(board2.squareAt(x, 2)).isInstanceOf(Square.class).isNotNull();
    }

    @Test
    void withinBordersMCDCCov(){
        boolean test1 = board.withinBorders(0,0); // T T T T
        assertThat(test1).isTrue();

        boolean test2 = board.withinBorders(-1,0); // F T T T
        assertThat(test2).isFalse();

        boolean test3 = board.withinBorders(0,-1); // T T F T
        assertThat(test3).isFalse();

        boolean test4 = board.withinBorders(3,0); // T F T T
        assertThat(test4).isFalse();

        boolean test5 = board.withinBorders(0,3); // T T T F
        assertThat(test5).isFalse();

    }
}
