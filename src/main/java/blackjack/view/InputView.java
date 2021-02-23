package blackjack.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static List<String> inputParticipantsNames() {
        String input = scanner.nextLine();
        String[] names = input.split(DELIMITER);
        return Arrays.asList(names)
                     .stream()
                     .map(name -> name.trim())
                     .collect(Collectors.toList());
    }
}
