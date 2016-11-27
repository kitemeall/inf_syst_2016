import Model.Car;
import Model.OrderDetails;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Администратор on 27.11.2016.
 */
public class OrderDetailsTest {
    @Test
    public final void testOrderDetail() {
        OrderDetails od = Dao.Orders.getOrderDetails(34);
        assertNotNull(od);
    }
}
