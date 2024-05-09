package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.npc.ghost.Pinky;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class MapParserTest {

    private MapParser mapParser;

    private final List<Ghost> ghosts = new ArrayList<>();

    private Ghost ghost;

    @BeforeEach
    void setUp() {
        LevelFactory lf = mock(LevelFactory.class);
        BoardFactory bf = mock(BoardFactory.class);
        Map<Direction, Sprite> map = Collections.emptyMap();

        ghost = new Pinky(map);

        Square sqr1 = new Square() {
            @Override
            public boolean isAccessibleTo(Unit unit) {
                return false;
            }

            @Override
            public Sprite getSprite() {
                return null;
            }
        };

        Mockito.when(bf.createGround()).thenReturn(sqr1);


        ghosts.add(mock(Ghost.class));


        mapParser = new MapParser(lf,bf);

    }

    @Test
    void testMakeGhostSquareWorking() {
        List<Unit> occupants = mapParser.makeGhostSquare(ghosts,ghost).getOccupants();
        assertThat(occupants).isNotNull().isNotEmpty();
        assertThat(occupants.get(0)).isEqualTo(ghost);

    }

    @Test
    void testMakeGhostSquareNullGhost() {
        assertThrows(NullPointerException.class, () -> {
            mapParser.makeGhostSquare(ghosts,null);
        });
    }

    @Test
    void testMakeGhostSquareGhostArrays() {
        List<Unit> occupants =mapParser.makeGhostSquare(new ArrayList<Ghost>(),ghost).getOccupants();
        assertThat(occupants).isNotNull().isNotEmpty();
        assertThat(occupants.get(0)).isEqualTo(ghost);

        assertThrows(NullPointerException.class, () -> {
            mapParser.makeGhostSquare(null,ghost);
        });
        assertThrows(NullPointerException.class, () -> {
            mapParser.makeGhostSquare(new ArrayList<Ghost>(null),ghost);
        });
    }

}
