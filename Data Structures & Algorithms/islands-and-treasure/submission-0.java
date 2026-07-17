class Solution {
    record Cell(int row, int col){}
    public void islandsAndTreasure(int[][] grid) {
        // assuming M x N matrix
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<Cell> q = new ArrayDeque<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new Cell(i, j));
                }
            }
        }
        if (q.size() == 0) return;
        while(!q.isEmpty()) {
            Cell cell = q.poll();
            List<Cell> nbs = getNeighbors(cell.row(), cell.col(), rows, columns);
            for(Cell nb: nbs) {
                // Not a land cell
                if (grid[nb.row()][nb.col()] != Integer.MAX_VALUE) continue;
                q.offer(nb);
                grid[nb.row()][nb.col()] = grid[cell.row()][cell.col()] + 1;
            }
        }
    }
    private List<Cell> getNeighbors(int row, int col, int maxRows, int maxColumns) {
        List<Cell> neighbors = new ArrayList<>();
        // Top
        if (row - 1 >= 0) {
            neighbors.add(new Cell(row - 1, col));
        }
        // Bottom
        if (row + 1 < maxRows) {
            neighbors.add(new Cell(row + 1, col));
        }
        // Left
        if (col - 1 >= 0) {
            neighbors.add(new Cell(row, col - 1));
        }
        // Right
        if (col + 1 < maxColumns) {
            neighbors.add(new Cell(row, col + 1));
        }
        return neighbors;
    }
}
