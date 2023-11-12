package christmas.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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

    @Test
    void filterMenuOrdersTest() {
        List<String> result = inputView.filterMenuOrders(List.of("타파스-1", "제로콜라-1"));
        System.out.println(result);
        assertThat(result).isEqualTo(List.of("타파스", "제로콜라"));
    }

    @Test
    void validateMenuDuplicateTest() {
        inputView.validateMenuDuplicate(List.of("타파스", "제로콜라"));
        assertThatThrownBy(() -> inputView.validateMenuDuplicate(List.of("타파스", "타파스", "제로콜라")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateMenuValueTest() {
        inputView.validateMenuName(List.of("타파스", "제로콜라"));
        assertThatThrownBy(() -> inputView.validateMenuName(List.of("코카콜라", "칠성사이다")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.validateMenuName(List.of("제로콜라")))
                .isInstanceOf(IllegalArgumentException.class);
    }


}