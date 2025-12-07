# GestionBILLETS
-------------------- Date limite de rendu : 31 Décembre 2025 -------------

🚀 Fonctionnalités Principales
✅ Gestion des Films et Séances
Consultation du catalogue de films

Affichage des horaires des séances

Gestion des disponibilités en temps réel

✅ Système de Réservation
Réservation de billets individuels

Création de forfaits (groupes de billets)

Calcul automatique des prix avec remises

Vérification des places disponibles

✅ Gestion des Utilisateurs
Inscription et authentification

Profils utilisateurs (normal, étudiant, groupe)

Historique des réservations

✅ Système de Paiement
Multiples modes de paiement (carte, PayPal, espèces)

Traitement sécurisé des transactions

Génération de reçus

✅ Notifications Automatiques
Confirmation de réservation
Alertes de disponibilité
Rappels avant la séance

🏗️ Architecture Technique
Modèle MVC
---------------------------------------------------------------------------
|Couche      |	Responsabilités	      |  Exemples de Classes
------------------------------------------------------------------------------------
|Modèle      |	Gestion des données	  |  Film, Seance, Utilisateur, Reservation
|Vue	       | Interface utilisateur	|  VuePrincipale, VueReservation, VuePaiement
|Contrôleur	 | Logique métier	        |  ControleurReservation, ControleurPaiement

------------------------------------------------------------------------------------------------
📁 Structure du Projet



------------------------------------------------------------------------------------------------



👥 Équipe de Développement : 
-- Membre 1 - Architecte Principal
Rôle : Singleton Principal & Coordination

Responsabilités : CinemaManager, architecture globale, diagrammes UML

Classes : CinemaManager.java, Film.java, Seance.java, MainController.java

-- Membre 2 - Gestion Utilisateurs
Rôle : Singleton Utilisateurs

Responsabilités : Système d'authentification, gestion des profils

Classes : UserManager.java, User.java, UserProfile.java, UserController.java

-- Membre 3 - Système de Paiement
Rôle : Stratégie Paiement

Responsabilités : Modes de paiement, transactions

Classes : PaymentStrategy.java, CreditCardPayment.java, PayPalPayment.java, PaymentController.java

-- Membre 4 - Système de Tarification
Rôle : Stratégie Tarification

Responsabilités : Calcul des prix, promotions, remises

Classes : PricingStrategy.java, StandardPricing.java, StudentPricing.java, PricingController.java

-- Membre 5 - Gestion Réservations
Rôle : Composition Billets

Responsabilités : Structure des billets, forfaits, réservations

Classes : TicketComponent.java, SingleTicket.java, ForfaitBillets.java, BookingController.java

-- Membre 6 - Système de Notifications
Rôle : Observateur Notifications

Responsabilités : Notifications automatiques, alertes

Classes : BookingObserver.java, NotificationManager.java, EmailNotifier.java, SMSNotifier.java




📋 Scénarios d'Utilisation
* Réservation Simple:
1. Utilisateur se connecte
2. Consulte les films disponibles
3. Sélectionne une séance et des places
4. Paiement en ligne
5. Reçoit une confirmation par email

* Réservation Groupe: 
1. Création d'un forfait "Groupe"
2. Ajout de plusieurs billets
3. Application d'une remise automatique
4. Paiement unique
5. Notifications individuelles

* Gestion Administrative:
1. Ajout de nouveaux films
2. Programmation des séances
3. Consultation des statistiques
4. Gestion des utilisateurs



📚 Documentation
Documentation Technique
Javadoc : Documentation complète des classes et méthodes

Diagrammes UML : Diagrammes de classes, séquences, cas d'utilisation

Spécifications : Besoins fonctionnels et non-fonctionnels
