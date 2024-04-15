package Tasks.SeventhTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ClientCheck {
    public static void clientTest(){

        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1, "Иван", 25, Arrays.asList(new Client.Phone("8-916-123-45-67", Client.Phone.PhoneType.MOBILE),
                new Client.Phone("8-495-777-77-77", Client.Phone.PhoneType.LANDLINE))));
        clients.add(new Client(2, "Петр", 30, Arrays.asList(new Client.Phone("8-903-333-44-55", Client.Phone.PhoneType.MOBILE))));
        clients.add(new Client(3, "Сергей", 40, Arrays.asList(new Client.Phone("8-499-999-88-77", Client.Phone.PhoneType.LANDLINE))));

        Optional<Client> youngestMobileClient = clients.stream()
                .filter(client -> client.getPhones().stream().anyMatch(phone -> phone.getType() == Client.Phone.PhoneType.MOBILE))
                .min((c1, c2) -> Integer.compare(c1.getAge(), c2.getAge()));

        if (youngestMobileClient.isPresent()) {
            System.out.println("Самый молодой клиент с мобильным телефоном: " + youngestMobileClient.get().getName() + " (" + youngestMobileClient.get().getAge() + " лет)");
        } else {
            System.out.println("Не удалось найти клиента с мобильным телефоном");
        }
    }
}
