package gpt54.task16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals(0, s.countDistinctCharacters("")),
                () -> assertEquals(5, s.countDistinctCharacters("abcde")),
                () -> assertEquals(5, s.countDistinctCharacters("abcdecadeCADE")),
                () -> assertEquals(1, s.countDistinctCharacters("aaaaAAAAaaaa")),
                () -> assertEquals(5, s.countDistinctCharacters("Jerry jERRY JeRRRY")),
                () -> assertEquals(1, s.countDistinctCharacters("Aa")),
                () -> assertEquals(2, s.countDistinctCharacters("AaB")),
                () -> assertThrows(Throwable.class, () -> s.countDistinctCharacters(null))
        );
    }
}
