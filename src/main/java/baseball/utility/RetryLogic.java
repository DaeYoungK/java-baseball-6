package baseball.utility;

public class RetryLogic {

    private static final int MAX_RETRY = 5;

    public static void retry(Retry retry) {
        for (int i = 1; i <= MAX_RETRY; i++) {
            if (isLogic(retry, i)) break;
        }

    }

    private static boolean isLogic(Retry retry, int i) {
        try {
            retry.run();
            return true;
        }catch (IllegalArgumentException e) {
            if (i == MAX_RETRY) {
                throw e;
            }
        }
        return false;
    }
}
