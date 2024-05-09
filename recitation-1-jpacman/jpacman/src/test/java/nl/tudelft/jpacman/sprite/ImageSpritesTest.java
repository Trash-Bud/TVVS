package nl.tudelft.jpacman.sprite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ImageSpritesTest {

    private ImageSprite sprite;
    private final Graphics graphics = mock(Graphics.class);
    BufferedImage bufferedImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
    int width = 150;
    int height = 300;
    int x = 1;
    int y = 1;

    @BeforeEach
    void setUp() {
        sprite = new ImageSprite(bufferedImage);
    }

    @Test
    public void testDrawCorrect(){
        sprite.draw(graphics,x,y,width,height);
        verify(graphics).drawImage(bufferedImage, x, y, x + width, y + height, 0, 0, bufferedImage.getWidth(null), bufferedImage.getHeight(null), null);
    }

    @Test
    public void testDrawGraphics(){
         Assertions.assertThrows(NullPointerException.class, () -> {
            sprite.draw(null,1,1,2,2);
        });
    }

    @Test
    void testDrawX() {
        assertDoesNotThrow(() -> sprite.draw(graphics, -1, y, width, height));
        assertDoesNotThrow(() -> sprite.draw(graphics, 0, y, width, height));
    }

    @Test
    void testDrawY() {
        assertDoesNotThrow(() -> sprite.draw(graphics, x, -1, width, height));
        assertDoesNotThrow(() -> sprite.draw(graphics, x, 0, width, height));
    }

    @Test
    void testDrawWidth() {
        assertDoesNotThrow(() -> sprite.draw(graphics, x, y, -100, height));
        assertDoesNotThrow(() -> sprite.draw(graphics, x, y, 0, height));
    }

    @Test
    void testDrawHeight() {
        assertDoesNotThrow(() -> sprite.draw(graphics, x, y, width, -100));
        assertDoesNotThrow(() -> sprite.draw(graphics, x, y, width, 0));
    }


}
