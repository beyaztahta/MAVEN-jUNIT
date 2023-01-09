package day11_fakerclass_files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Files01 {
    @Test
    public void isExistTest() {
        String userDIR = System.getProperty("user.dir");
        System.out.println("userDIR = " + userDIR);// C:\Users\hp\IdeaProjects\MavenJunit

        String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome);//C:\Users\hp

        //logo.jpeg indirip MASAUSTUNE kaydedin

        String dosyaYolu = userHome + "/Desktop/logo.jpeg";
        //String dosyaYolu = userHome +"\\Desktop\\logo.jpeg";

        System.out.println(dosyaYolu);//C:\Users\hp/Desktop/logo.jpeg

        boolean isExist = Files.exists(Paths.get(dosyaYolu));//dosyada var ise true, yok ise false
        Assert.assertTrue(isExist);

    }
}
