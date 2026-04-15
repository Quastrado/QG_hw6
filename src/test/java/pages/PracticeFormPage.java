package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import pages.components.CalendarComponent;

import java.util.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    private SelenideElement banner = $("#fixedban");
    private SelenideElement practiceFormWrapper = $(".practice-form-wrapper");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderBar = $("#genterWrapper");
    private SelenideElement numberInput = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement subjectsDropdown = $("#subjectsDropdown");
    private SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private SelenideElement pictureUploader = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateSelect = $("#state");
    private SelenideElement stateContainer = $("#stateCity-wrapper");
    private SelenideElement citySelect = $("#city");
    private SelenideElement submit = $("#submit");
    private SelenideElement resultModal = $("#resultModal");
    private SelenideElement resultTable = $("#resultBody");
    private SelenideElement errorText = $("#formError");




    public PracticeFormPage openPage() {
        open("/automation-practice-form.html");

        return this;
    }

    public PracticeFormPage checkSubtitle(String subtitleText) {
        practiceFormWrapper.$(".subtitle").shouldHave(text(subtitleText));

        return this;
    }

    public PracticeFormPage typeFirstName(String value) {
        firstNameInput.click();
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeLastName(String value) {
        lastNameInput.click();
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeEmail(String value) {
        emailInput.click();
        emailInput.setValue(value);

        return this;
    }

    public PracticeFormPage selectGender(String genderTextValue) {
        genderBar.$(byText(genderTextValue)).click();

        return this;
    }

    public PracticeFormPage typeNumber(String value) {
        numberInput.click();
        numberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        CalendarComponent calendar = new CalendarComponent();
        calendar.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage selectSubject(String value) {
        subjectsInput.click();
        subjectsDropdown.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage selectHobbie(String value) {
        hobbiesWrapper.$(byValue(value)).click();

        return this;
    }

    public PracticeFormPage uploadPicture(String value) {
        pictureUploader.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage typeCurrentAddress(String value) {
        currentAddressInput.click();
        currentAddressInput.setValue(value);

        return this;
    }

    public PracticeFormPage selectState(String value) {
        stateSelect.click();
        stateContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage selectCity(String value) {
        citySelect.click();
        stateContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage submitForm() {
        submit.click();

        return this;
    }

    public PracticeFormPage checkResultModalAppearance() {
        resultModal.shouldHave(visible);

        return this;
    }

    public PracticeFormPage checkResultModalTitle(String value) {
        resultModal.$(byText(value));

        return this;
    }

    public PracticeFormPage checkResultField(String fieldName, String fieldValue) {
        resultTable.$$("tr").findBy(text(fieldName)).shouldHave(text(fieldValue));

        return this;
    }

    public PracticeFormPage checkFormErrorText(String value) {
        errorText.shouldHave(text(value));

        return this;
    }

    public PracticeFormPage bannerClose() {
        banner.$(byTagName("button")).click();

        return this;
    }
}
