package day11_fakerclass_files;

import com.github.javafaker.Faker;
import org.junit.Test;


public class FakerClass01  {
    Faker faker;
    @Test

    public void javaFakerTest() {

        //1.ADIM:   FAKER OBJESINI OLUSTUR.
        faker = new Faker();

        //2.ADIM:   FAKER OBJESI ILE FAKE DATA OLUSTUR.
        String fName=faker.name().firstName();
        System.out.println("fName = " + fName);

        //lastName datası
        String lName=faker.name().lastName();
        System.out.println("lName = " + lName);

        //kullanıcı adı
        String userName=faker.name().username();
        System.out.println("userName = " + userName);

        //meslek isimler
        System.out.println(faker.name().title());

        //sehir isimleri
        System.out.println(faker.address().city());

        //eyalet isimleri
        System.out.println(faker.address().state());

        //full address
        System.out.println(faker.address().fullAddress());

        //country
        System.out.println(faker.address().country());

       //cep telefon numarası
        System.out.println(faker.phoneNumber().cellPhone());

        //email.
        System.out.println("emailAddress() = " + faker.internet().emailAddress());

       //posta kodu
        System.out.println("zipCode() = " + faker.address().zipCode());

        //random number mesela 15 haneli numara
        System.out.println("faker.number().digits(15) = " + faker.number().digits(15));

    }
     /*
     TEST DATA: kullanıcı adı,tel,no,sifre,kart no,kredi no....
     ----->Test Dataları kimden alırsınız?
           Farklı farklı kisilerden farklı farklı yerlerden gelebilir.Oncelikle:
           1.BA-Business analyst(Acceptance Criteria lari yazar.)
           2.Test Lead
           3.Manual Tester
           4.Tech Lead & Team Lead & Developer Lead
           5.Developer
           6.Database
           7.API call lar
           8.Documentations . Ornegin API swager documanı
           9.Java Faker da fake data almak icin kullabiliriz

          Test Dataları kimden gelmez? end user- kullanıcıdan alınmaz,scrum masterdan alınmaz
      */

}
