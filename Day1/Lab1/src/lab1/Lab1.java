package lab1;

public class Lab1 {

    public static void main(String[] args) {
        ContactDAO testDB = new ContactDAO();

        ContactPerson p = new ContactPerson();
        p.setName("Amie Santiago");
        p.setNickName("Amie");
        p.setAddress("B99");
        p.setHomePhone("9876543210");
        p.setWorkPhone("6278287326");
        p.setCellPhone("9182872363");
        p.setEmail("amie@gmail.com");
        p.setBirthDate(new java.sql.Date(1976,2,3));
        p.setWebsite("b99.com");
        p.setProfession("Policeman");
        
        testDB.insertContactPerson(p);

        testDB.getContacts().forEach((s) -> System.out.println(s.getName()));
        System.out.println("---------------------------------------------------");
        testDB.getContactsByName("bruce").forEach((s) -> System.out.println(s.getName()));
        
        testDB.CloseConnection();
    }
}
