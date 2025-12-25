package com.example.deep.level1.level2.level3.level4.level5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * 5-level deep nested test class for TeamCity UI tree testing.
 * Structure: com.example.deep.level1.level2.level3.level4.level5.DeepNestedFailingTest
 */
@DisplayName("Level1_DeepTests")
public class DeepNestedFailingTest {

    @Test
    void rootLevelTest001() {
        fail("Failure at root level");
    }

    @Test
    void rootLevelTest002() {
        fail("Failure at root level");
    }

    @Nested
    @DisplayName("Level2_NestedGroup")
    class Level2Tests {

        @Test
        void level2Test001() {
            fail("Failure at level 2");
        }

        @Test
        void level2Test002() {
            fail("Failure at level 2");
        }

        @Nested
        @DisplayName("Level3_NestedGroup")
        class Level3Tests {

            @Test
            void level3Test001() {
                fail("Failure at level 3");
            }

            @Test
            void level3Test002() {
                fail("Failure at level 3");
            }

            @Nested
            @DisplayName("Level4_NestedGroup")
            class Level4Tests {

                @Test
                void level4Test001() {
                    fail("Failure at level 4");
                }

                @Test
                void level4Test002() {
                    fail("Failure at level 4");
                }

                @Nested
                @DisplayName("Level5_NestedGroup")
                class Level5Tests {

                    @Test
                    void level5Test001() {
                        fail("Failure at level 5 - deepest");
                    }

                    @Test
                    void level5Test002() {
                        fail("Failure at level 5 - deepest");
                    }

                    @Test
                    void level5Test003() {
                        fail("Failure at level 5 - deepest");
                    }

                    @Test
                    void level5Test004() {
                        fail("Failure at level 5 - deepest");
                    }

                    @Test
                    void level5Test005() {
                        fail("Failure at level 5 - deepest");
                    }
                }
            }
        }
    }
}
