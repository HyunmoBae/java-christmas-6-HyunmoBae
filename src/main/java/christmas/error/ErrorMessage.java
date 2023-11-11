package christmas.error;

public class ErrorMessage {
    public enum ErrorMessageType {
        INVALID_DATE_VALUE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
        INVALID_NAME("[ERROR] 유효하지 않은 이름입니다. 다시 입력해 주세요."),
        INVALID_MENU_VALUE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
        ;

        private final String message;

        ErrorMessageType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public static void printErrorMessage(ErrorMessageType errorMessageType) {
        System.out.println(errorMessageType.message);
    }
}
