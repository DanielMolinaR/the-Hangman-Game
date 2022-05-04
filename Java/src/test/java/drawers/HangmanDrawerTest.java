package drawers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HangmanDrawerTest {

    @Test
    void testDrawer(){
        Drawer hangmanDrawer = mock(HangmanDrawer.class);
        doAnswer(invocation -> {
            Object arg0 = invocation.getArgument(0);

            assertEquals(2, arg0);
            return null;
        }).when(hangmanDrawer).draw(any(Integer.class));
        hangmanDrawer.draw(2);
    }

}
