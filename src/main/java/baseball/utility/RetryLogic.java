package baseball.utility;

public class RetryLogic {

    private static final int MAX_RETRY = 5;

    public static void retry(Retry retry) {
        int count = 1;
        for (int i = 1; i <= MAX_RETRY; i++) {
            logic(retry, i);
        }

    }

    private static void logic(Retry retry, int i) {
        try {
            retry.run();
        }catch (IllegalArgumentException e) {
            if (i == MAX_RETRY) {
                throw e;
            }
        }
    }
}
