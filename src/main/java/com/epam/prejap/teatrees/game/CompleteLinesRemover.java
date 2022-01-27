package com.epam.prejap.teatrees.game;

/**
 * Verifies and removes complete lines in playfield grid.
 *
 * @author Piotr Chowaniec
 */
interface CompleteLinesRemover {

    /**
     * Grid is being checked from bottom to top one by one. While complete line is found then it is being removed,
     * lines above are being moved one position down, empty line is being added on the top.
     *
     * @param grid from playfield.
     * @return modified grid.
     */
    default byte[][] removeCompleteLines(byte[][] grid) {
        for (int i = grid.length - 1; i > 0; i--) {
            if (isLineComplete(grid[i])) {
                moveLinesAboveOnePositionDown(grid, i++);
                addEmptyLineOnTop(grid);
            }
        }
        if (isLineComplete(grid[0])) {
            addEmptyLineOnTop(grid);
        }
        return grid;
    }

    /**
     * If given {@code byte[] line} sum of values is equal to its length, then return true.
     *
     * @param line single byte array from grid.
     * @return sum of values of given line.
     */
    private boolean isLineComplete(byte[] line) {
        return line.length == sumLineValues(line);
    }

    private int sumLineValues(byte[] line) {
        int counter = 0;
        for (byte b : line) {
            counter += b;
        }
        return counter;
    }

    private void moveLinesAboveOnePositionDown(byte[][] grid, int lineCounter) {
        for (int i = lineCounter; i > 0; i--) {
            grid[i] = grid[i - 1];
        }
    }

    private void addEmptyLineOnTop(byte[][] grid) {
        grid[0] = new byte[grid[0].length];
    }
}
