package gpt54.task29;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MutationDatasetTest {

    @Test
    void runsDatasetMutationChecks() {
        Solution s = new Solution();

        assertAll(
                () -> assertEquals(List.of(), s.filterByPrefix(List.of(), "john")),
                () -> assertEquals(List.of("alpha", "beta"), s.filterByPrefix(List.of("alpha", "beta"), "")),
                () -> assertEquals(List.of(), s.filterByPrefix(List.of("cat", "dog"), "zzz")),
                () -> assertEquals(List.of(), s.filterByPrefix(List.of("cat", "dog"), "longer-than-any-entry")),
                () -> assertEquals(
                        List.of("xxx", "xxxAAA", "xxx"),
                        s.filterByPrefix(List.of("xxx", "asd", "xxy", "john doe", "xxxAAA", "xxx"), "xxx")
                ),
                () -> assertEquals(List.of("Case"), s.filterByPrefix(List.of("Case", "case", "cases"), "Cas"))
        );
    }
}
