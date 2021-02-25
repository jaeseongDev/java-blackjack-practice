package blackjack.view;

import blackjack.domain.participant.Player;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static List<String> inputPlayersNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String input = scanner.nextLine();
        String[] names = input.split(DELIMITER);
        printEmptyLine();
        return Arrays.asList(names)
                     .stream()
                     .map(name -> name.trim())
                     .collect(Collectors.toList());
    }

    public static String inputIfReceiveCard(Player player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        return scanner.nextLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}