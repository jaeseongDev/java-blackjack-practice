package blackjack.domain;

public class Participant {

    private static final int MIN_NAME_LENGTH = 1;
    private final String name;

    public Participant(String name) {
        validateParticipantNameLength(name);
        this.name = name;
    }

    private void validateParticipantNameLength(String name) {
        if (name.trim().length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("참가자 이름은 양쪽 끝 공백을 제거하고 1글자 이상이 되어야 합니다.");
        }
    }
}
