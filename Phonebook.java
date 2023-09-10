import java.util.*;

public class Phonebook {
    private Map<String, Set<String>> contacts;

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.addContact("ContactName1", "111-1111");
        phonebook.addContact("ContactName2", "222-2222");
        phonebook.addContact("ContactName2", "333-3333");
        phonebook.addContact("ContactName3", "444-4444");
        phonebook.addContact("ContactName4", "555-5555");
        phonebook.addContact("ContactName5", "666-6666");
        phonebook.addContact("ContactName1", "777-7777");
        phonebook.addContact("ContactName1", "888-8888");
        phonebook.addContact("ContactName7", "999-9999");

        phonebook.printContacts();
    }

    public Phonebook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            contacts.get(name).add(phoneNumber);
        } else { 
            Set<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }
    }

    public void printContacts() {
        List<Map.Entry<String, Set<String>>> sortedContacts = new ArrayList<>(contacts.entrySet());
        Collections.sort(sortedContacts, new Comparator<Map.Entry<String, Set<String>>>() {
            @Override
            public int compare(Map.Entry<String, Set<String>> o1, Map.Entry<String, Set<String>> o2) {
                return Integer.compare(o2.getValue().size(), o1.getValue().size());
            }
        });

        for (Map.Entry<String, Set<String>> contact : sortedContacts) {
            System.out.print(contact.getKey() + ": ");
            System.out.println(contact.getValue());
        }
    }
}
