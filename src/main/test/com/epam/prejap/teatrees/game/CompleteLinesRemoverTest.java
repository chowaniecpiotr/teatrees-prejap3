package com.epam.prejap.teatrees.game;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CompleteLinesRemoverTest {

    @Test(dataProvider = "gridsWithoutCompleteLines")
    public void shouldNotChangeGrid(byte[][] initGrid, byte[][] expected) {
        // Given
        CompleteLinesRemover remover = new CompleteLinesRemover() {
            @Override
            public byte[][] removeCompleteLines(byte[][] grid) {
                return CompleteLinesRemover.super.removeCompleteLines(grid);
            }
        };
        // When
        byte[][] actual = remover.removeCompleteLines(initGrid);
        // Then
        Assert.assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test(dataProvider = "gridsWithCompleteLines")
    public void shouldRemoveCompleteLines(byte[][] initGrid, byte[][] expected) {
        // Given
        CompleteLinesRemover remover = new CompleteLinesRemover() {
            @Override
            public byte[][] removeCompleteLines(byte[][] grid) {
                return CompleteLinesRemover.super.removeCompleteLines(grid);
            }
        };
        // When
        byte[][] actual = remover.removeCompleteLines(initGrid);
        // Then
        Assert.assertTrue(Arrays.deepEquals(actual, expected));
    }

    @DataProvider
    private static Object[][] gridsWithoutCompleteLines() {
        return new Object[][] {
                new Object[] {
                        new byte[][] {
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0}
                        },
                        new byte[][] {
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0}
                        }
                },
                new Object[] {
                        new byte[][] {
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                {1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
                                {1, 1, 0, 1, 1, 0, 0, 0, 0, 0}
                        },
                        new byte[][] {
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                                {1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
                                {1, 1, 0, 1, 1, 0, 0, 0, 0, 0}
                        }
                }
        };
    }

    @DataProvider
    private static Object[][] gridsWithCompleteLines() {
        return new Object[][] {
                new Object[] {
                        new byte[][] {
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
                                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
                                {1, 1, 0, 0, 1, 1, 1, 0, 1, 1},
                                {1, 1, 0, 0, 1, 1, 1, 0, 1, 1}
                        },
                        new byte[][] {
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
                                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
                                {1, 1, 0, 0, 1, 1, 1, 0, 1, 1},
                                {1, 1, 0, 0, 1, 1, 1, 0, 1, 1}
                        }
                },
                new Object[] {
                        new byte[][] {
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
                                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                        },
                        new byte[][] {
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
                                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0}
                        }
                },
                new Object[] {
                        new byte[][] {
                                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
                                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
                                {1, 1, 0, 0, 1, 1, 1, 0, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 0, 1, 1, 1, 0, 1, 1}
                        },
                        new byte[][] {
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
                                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
                                {1, 1, 0, 0, 1, 1, 1, 0, 1, 1},
                                {1, 1, 0, 0, 1, 1, 1, 0, 1, 1}
                        }
                }
        };
    }
}