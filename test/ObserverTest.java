package com.cinema.test.observateur;

import com.cinema.modele.Reservation;
import com.cinema.patrons.observateur.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        manager.notifyObservers(new Reservation(), "CONFIRMED");

        assertTrue(observer.notified);
    }

}
