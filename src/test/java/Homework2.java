import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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
        $$(".react-datepicker__day").find(text("22")).click();

        $("[id=uploadPicture]").scrollTo();

        $("#subjectsInput").click();
        $("#subjectsInput").val("E");
        $(byText("Economics")).click();
        $(byText("Sports")).click();

        //загрузка изображения
        $("[id=uploadPicture]").uploadFromClasspath("1.jpg");

        //заполнение адресных данных
        $("[id=currentAddress]").val("Alexanderplatz, 11");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        //завершение заполнения анкеты
        $("[id=submit]").click();

        //new check
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form\n"));
        $("#example-modal-sizes-title-lg").shouldHave(text("Neznayka Pavlov\n"));
        $("#example-modal-sizes-title-lg").shouldHave(text("example@gmail.com\n"));
        $("#example-modal-sizes-title-lg").shouldHave(text("Male\n"));
        $("#example-modal-sizes-title-lg").shouldHave(text("7779992545\n"));
        $("#example-modal-sizes-title-lg").shouldHave(text("22 July,1995\n"));
        $("#example-modal-sizes-title-lg").shouldHave(text("Economics\n"));
        $("#example-modal-sizes-title-lg").shouldHave(text("Sports\n"));
        $("#example-modal-sizes-title-lg").shouldHave(text("1.jpg\n"));
        $("#example-modal-sizes-title-lg").shouldHave(text("Alexanderplatz, 11\n"));
        $("#example-modal-sizes-title-lg").shouldHave(text("NCR Delhi\n"));


        $("[id=closeLargeModal]").scrollTo().click();

    }
}
