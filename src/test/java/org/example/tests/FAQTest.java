package org.example.tests;

import org.example.pages.MainPage;
import org.example.utils.FAQConstants;
import org.example.utils.BaseTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FAQTest extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    void initPage() {
        mainPage = new MainPage(driver);
    }

    @ParameterizedTest
    @MethodSource("faqData")
    void faqAnswerShouldMatchExpectedText(int questionIndex, String expectedAnswer){
        mainPage.clickFaqQuestion(questionIndex);
        String actualAnswer = mainPage.getFaqAnswerText(questionIndex);
        assertEquals(expectedAnswer, actualAnswer, "Актуальный текст ответа не совпадает с ожидаемым");
    }

    static Stream<Arguments> faqData() {
        return Stream.of(
                Arguments.of(0, FAQConstants.ANSWER_0),
                Arguments.of(1, FAQConstants.ANSWER_1),
                Arguments.of(2, FAQConstants.ANSWER_2),
                Arguments.of(3, FAQConstants.ANSWER_3),
                Arguments.of(4, FAQConstants.ANSWER_4),
                Arguments.of(5, FAQConstants.ANSWER_5),
                Arguments.of(6, FAQConstants.ANSWER_6),
                Arguments.of(7, FAQConstants.ANSWER_7)
                );
    }


}
