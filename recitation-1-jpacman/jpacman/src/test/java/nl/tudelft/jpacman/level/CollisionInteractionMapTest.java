package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CollisionInteractionMapTest {

    private final CollisionInteractionMap colMap = new CollisionInteractionMap();

    @Test
    public void testInheritanceForObject() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method inheritanceMethod = colMap.getClass().getDeclaredMethod("getInheritance", Class.class);
        inheritanceMethod.setAccessible(true);

        Class<Object> subclass = Object.class;

        List< Class<? extends Unit>> result = (List< Class<? extends Unit>>) inheritanceMethod.invoke(colMap, subclass);

        assertEquals(1, result.size());
    }


    @Test
    public void testInheritanceForUnit() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method inheritanceMethod = colMap.getClass().getDeclaredMethod("getInheritance", Class.class);
        inheritanceMethod.setAccessible(true);

        Class<? extends Unit> subclass = Unit.class;

        List< Class<? extends Unit>> result = (List< Class<? extends Unit>>) inheritanceMethod.invoke(colMap, subclass);

        assertEquals(1, result.size());
    }


    @Test
    public void testInheritanceForSubClass() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method inheritanceMethod = colMap.getClass().getDeclaredMethod("getInheritance", Class.class);
        inheritanceMethod.setAccessible(true);

        class StubUnit extends Unit {
            @Override
            public Sprite getSprite() {
                return null;
            }
        }

        Class<? extends Unit> subclass = StubUnit.class;

        List< Class<? extends Unit>> result = (List< Class<? extends Unit>>) inheritanceMethod.invoke(colMap, subclass);

        assertEquals(2, result.size());
    }

    @Test
    public void testInheritanceForSubClassWithInterface() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method inheritanceMethod = colMap.getClass().getDeclaredMethod("getInheritance", Class.class);
        inheritanceMethod.setAccessible(true);

        class StubUnit extends Unit implements CollisionMap{
            @Override
            public Sprite getSprite() {
                return null;
            }

            @Override
            public <C1 extends Unit, C2 extends Unit> void collide(C1 collider, C2 collidee) {
            }
        }

        Class<? extends Unit> subclass = StubUnit.class;

        List< Class<? extends Unit>> result = (List< Class<? extends Unit>>) inheritanceMethod.invoke(colMap, subclass);

        assertEquals(2, result.size());
    }

    @Test
    public void testInheritanceForSubClassOfSubClass() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method inheritanceMethod = colMap.getClass().getDeclaredMethod("getInheritance", Class.class);
        inheritanceMethod.setAccessible(true);

        class StubUnit extends Unit implements CollisionMap{
            @Override
            public Sprite getSprite() {
                return null;
            }

            @Override
            public <C1 extends Unit, C2 extends Unit> void collide(C1 collider, C2 collidee) {
            }
        }

        class StubSubClass extends StubUnit{

        }

        Class<? extends Unit> subclass = StubSubClass.class;

        List< Class<? extends Unit>> result = (List< Class<? extends Unit>>) inheritanceMethod.invoke(colMap, subclass);

        assertEquals(3, result.size());
    }

}
