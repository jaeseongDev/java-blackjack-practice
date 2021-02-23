package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParticipantTest {
    @ParameterizedTest(name = "{index} - {displayName}")
    @DisplayName("양쪽 끝 공백을 제거한 후, 1글자 이상의 이름을 가지지 않을 경우 예외 발생")
    @ValueSource(strings = { "", " ", "  " })
    public void validateNameLength(String name) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new Participant(name)
        );
    }
}
