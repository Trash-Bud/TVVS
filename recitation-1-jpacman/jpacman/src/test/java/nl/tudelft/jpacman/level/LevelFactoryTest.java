package nl.tudelft.jpacman.level;
import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class LevelFactoryTest {

    /**
     * The factory under test.
     */
    private LevelFactory factory;


    private Board board = mock(Board.class);
    private List<Ghost> ghosts = Collections.singletonList(mock(Ghost.class));
    private List<Square> startPositions =Collections.singletonList(mock(Square.class));


    @BeforeEach
    void setUp() {
        PacManSprites sprites = mock(PacManSprites.class);
        GhostFactory gf = mock(GhostFactory.class);

        factory = new LevelFactory(sprites,gf);

    }

    @Test
    void testCreateLevelWorking() {
        assertThat(factory.createLevel(board,ghosts,startPositions)).isInstanceOf(Level.class).isNotNull();
    }

    @Test
    void testCreateLevelBoard() {

        AssertionError error = Assertions.assertThrows(AssertionError.class, () -> {
            factory.createLevel(null,ghosts,startPositions);
        });
    }


    @Test
    void testCreateLevelGhosts() {
        List<Ghost> ghostsNull = Collections.singletonList(null);
        List<Ghost> ghostsEmpty = new ArrayList<>();

        AssertionError error = Assertions.assertThrows(AssertionError.class, () -> {
            factory.createLevel(board,null,startPositions);
        });

        assertThat(factory.createLevel(board,ghostsNull,startPositions)).isInstanceOf(Level.class).isNotNull();

        assertThat(factory.createLevel(board,ghostsEmpty,startPositions)).isInstanceOf(Level.class).isNotNull();


    }

    @Test
    void testCreateLevelStartPos() {
        List<Square> startNull = Collections.singletonList(null);
        List<Square> startEmpty = new ArrayList<>();

        AssertionError error = Assertions.assertThrows(AssertionError.class, () -> {
            factory.createLevel(board,ghosts,null);
        });

        assertThat(factory.createLevel(board,ghosts,startNull)).isInstanceOf(Level.class).isNotNull();

        assertThat(factory.createLevel(board,ghosts,startEmpty)).isInstanceOf(Level.class).isNotNull();


    }


}
