
import Model.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class DaoTest {
    @Test
    public final void testCars() {
      ArrayList<Car> cars = Dao.Cars.getCars();
        assertFalse(cars.isEmpty());
    }
    @Test
    public final void testClients() {
        ArrayList<Client> clients = Dao.Clients.getClients();
        assertFalse(clients.isEmpty());
    }
    @Test
    public final void testModels() {
        ArrayList<String> models = Dao.Models.getModels();
        assertFalse(models.isEmpty());
    }
    @Test
    public final void testWorkers() {
        ArrayList<Worker> workers = Dao.Workers.getWorkers();
        assertFalse(workers.isEmpty());
    }

    @Test
    public final void testOrders() {
        ArrayList<Order> orders = Dao.Orders.getOrders();
        assertFalse(orders.isEmpty());
    }

    @Test
    public final void testCarInsert() {
        Car car = new Car(2,"O58sa8HE98", "asdfasdf123d");
        int carId = Dao.Cars.addCar(car);
        assertTrue(carId > 0);
        Dao.Cars.deleteCar(carId);
    }

    @Test
    public final void testClientInsert() {
        Client client = new Client("James", "600 123 12 31 23");
        int clientId = Dao.Clients.addClient(client);
        assertTrue(clientId > 0);
        Dao.Clients.deleteClient(clientId);
    }

    @Test
    public final void testServices() {
        ArrayList<Service> services = Dao.Services.getServices();
        assertFalse(services.isEmpty());
    }

    @Test
    public final void testOrderInsert() {
        int orderId = Dao.Orders.addOrder(3,2);
        assertTrue(orderId > 0);
        Dao.Orders.deleteOrder(orderId);
    }
}
