package baseball.domain;

public enum ErrorMessage {

    COMMON_ERROR("유효한 값이 아닙니다. 다시 입력해주세요."),
    DISTINCT_ERROR("중복된 값이 존재합니다."),
    RETRY_ERROR("0과 1만 입력해주세요.")
    ;

    private static final String ERROR = "[ERROR]";
    private static final String BLANK = " ";
    private String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public void getMessage(ErrorMessage errorMessage) {
        System.out.println(ERROR + BLANK + errorMessage.description);
    }
}
