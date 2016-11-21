import Model.Service;
import Model.WorkItem;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

/**
 * Created by Администратор on 21.11.2016.
 */
public class WorkDetailsTest {

    @Test
    public final void testWorkDetails() {
        ArrayList<WorkItem> workItems = Dao.WorkUnits.getWorkItems(3);
        assertFalse(workItems.isEmpty());
    }
}
