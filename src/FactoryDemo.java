//Factory Method Pattern
//Topic: Creating different types of Notification (Email, SMS, Push).
// Product interface
interface Notification {
    void send(String message);
}

// Concrete products
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL with message: " + message);
    }
}

class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending PUSH notification with message: " + message);
    }
}

// Factory
class NotificationFactory {
    public static Notification createNotification(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SmsNotification();
            case "push" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown notification type: " + type);
        };
    }
}

// Client
public class FactoryDemo {
    public static void main(String[] args) {
        Notification notification1 = NotificationFactory.createNotification("email");
        notification1.send("Factory Method Pattern - Email test!");

        Notification notification2 = NotificationFactory.createNotification("sms");
        notification2.send("Factory Method Pattern - SMS test!");

        Notification notification3 = NotificationFactory.createNotification("push");
        notification3.send("Factory Method Pattern - Push test!");
    }
}
//Here:
//Notification is the Product.
//NotificationFactory is the Factory that decides which product to create.
//The client is decoupled from the concrete implementations.