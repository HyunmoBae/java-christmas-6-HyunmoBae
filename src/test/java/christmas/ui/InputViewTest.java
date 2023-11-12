package christmas.ui;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    void validateDateTest() {
        inputView.validateDate(1);
        inputView.validateDate(25);
        inputView.validateDate(31);

        assertThatThrownBy(() -> inputView.validateDate(40))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.validateDate(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}