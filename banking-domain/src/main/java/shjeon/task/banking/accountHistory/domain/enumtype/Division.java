package shjeon.task.banking.accountHistory.domain.enumtype;

public enum Division {
    Y,  // 입금
    N;  // 출금

    public static Division getDivision(String division) {
        if (Division.Y.name().equals(division)) {
            return Division.Y;
        } else {
            return Division.N;
        }
    }
}
