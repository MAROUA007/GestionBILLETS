package com.cinema.test.observateur;

import com.cinema.modele.Reservation;
import com.cinema.patrons.observateur.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

<<<<<<< HEAD
public class ObserverTest {

    @Test
    public void testObserverNotification() {

        NotificationManager manager = new NotificationManager();

        TestObserver observer = new TestObserver();
        manager.registerObserver(observer);

=======
public class ObserverTest implements BookingObserver{

    boolean notified = false;
    @Override
    public void update(Reservation reservation, String eventType) {
        notified = true;
    }
    @Test
    public void notificationShouldNotifyAllObservers() {

        NotificationManager manager = new NotificationManager();
        TestObserver observer = new TestObserver();

        manager.registerObserver(observer);
>>>>>>> 94980ff7fd64e952ad36023a89fb569a76ed5df2
        manager.notifyObservers(new Reservation(), "CONFIRMED");

        assertTrue(observer.notified);
    }

<<<<<<< HEAD
    // Observateur fictif
    class TestObserver implements BookingObserver {
        boolean notified = false;

        @Override
        public void update(Reservation reservation, String eventType) {
            notified = true;
        }
    }
=======
>>>>>>> 94980ff7fd64e952ad36023a89fb569a76ed5df2
}
