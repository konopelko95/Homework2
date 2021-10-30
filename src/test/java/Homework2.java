import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.swing.*;
import java.io.File;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Homework2 {

    @BeforeAll
    static void setting() {
        Configuration.browserSize = ("1920x1080");
    }


    @Test
    void workSheetFillTest() {
        // Открытие сайта
        open("https://demoqa.com/automation-practice-form");

        // заполнение ФИО, почты, пола
        $("[id=firstName]").val("Neznayka");
        $("[id=lastName]").val("Pavlov");
        $("[id=userEmail]").val("example@gmail.com");
        $(byText("Male")).click();

        //ввод номера телефона,даты рождения, предмета, хобби
        $("[id=userNumber]").val("7779992545");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOptionByValue("1995");
        $$(".react-datepicker__day").find(Condition.text("22")).click();

        $("[id=uploadPicture]").scrollTo();

        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys("E");
        $(byText("Economics")).click();
        $(byText("Sports")).click();

        //загрузка изображения
        $("[id=uploadPicture]").uploadFile(new File("file\\1.jpg"));

        //заполнение адресных данных
        $("[id=currentAddress]").val("Alexanderplatz, 11");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        //завершение заполнения анкеты
        $("[id=submit]").click();

        $(byText("Thanks for submitting the form")).shouldBe(Condition.visible);

        //проверка заполненных данных
        $(byText("Neznayka Pavlov")).shouldBe(Condition.visible);
        $(byText("example@gmail.com")).shouldBe(Condition.visible);
        $(byText("Male")).shouldBe(Condition.visible);
        $(byText("7779992545")).shouldBe(Condition.visible);
        $(byText("22 July,1995")).shouldBe(Condition.visible);
        $(byText("Economics")).shouldBe(Condition.visible);
        $(byText("Sports")).shouldBe(Condition.visible);
        $(byText("1.jpg")).shouldBe(Condition.visible);
        $(byText("Alexanderplatz, 11")).shouldBe(Condition.visible);
        $(byText("NCR Delhi")).shouldBe(Condition.visible);

        $("[id=closeLargeModal]").click();

    }
}
