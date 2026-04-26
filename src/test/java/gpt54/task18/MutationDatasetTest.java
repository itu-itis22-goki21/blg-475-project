package gpt54.task18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals(0, s.howManyTimes("", "x")),
                () -> assertEquals(0, s.howManyTimes("abc", "abcd")),
                () -> assertEquals(0, s.howManyTimes("abcdef", "gh")),
                () -> assertEquals(1, s.howManyTimes("john doe", "john")),
                () -> assertEquals(1, s.howManyTimes("match", "match")),
                () -> assertEquals(4, s.howManyTimes("xyxyxyx", "x")),
                () -> assertEquals(4, s.howManyTimes("cacacacac", "cac"))
        );
    }
}
