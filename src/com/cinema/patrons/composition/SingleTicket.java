package com.cinema.patrons.composition;

<<<<<<< HEAD


public class SingleTicket {
    // TODO: ajouter attributs et méthodes

    public class SingleTicket extends TicketComponent {

        private String eventName;
        private String seatNumber;
        private double basePrice;
        private String dateTime;

        public SingleTicket(String eventName, String seatNumber,
                            double basePrice, String dateTime) {
            this.eventName = eventName;
            this.seatNumber = seatNumber;
            this.basePrice = basePrice;
            this.dateTime = dateTime;
        }

        @Override
        public double getPrice() {
            return basePrice;
        }

        @Override
        public String getDescription() {
            return "Billet simple - " + eventName +
                    " | Place: " + seatNumber +
                    " | Date: " + dateTime;
        }

        @Override
        public String getType() {
            return "SINGLE";
        }

        public String getEventName() {
            return eventName;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setBasePrice(double price) {
            this.basePrice = price;
        }
    }

}
=======
/**
 * SingleTicket
 * Membre 5
 */
public class SingleTicket {
    // TODO: ajouter attributs et méthodes
}
>>>>>>> 94980ff7fd64e952ad36023a89fb569a76ed5df2
