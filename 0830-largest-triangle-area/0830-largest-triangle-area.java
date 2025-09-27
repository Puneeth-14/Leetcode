class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = 0.0;

        for (int i = 0; i < n; i++) {
            int xi = points[i][0], yi = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int xj = points[j][0], yj = points[j][1];
                for (int k = j + 1; k < n; k++) {
                    int xk = points[k][0], yk = points[k][1];

                    // Twice the signed area via cross-product/shoelace
                    int twiceArea = xi * (yj - yk) + xj * (yk - yi) + xk * (yi - yj);
                    double area = Math.abs(twiceArea) / 2.0;

                    if (area > max) max = area;
                }
            }
        }
        return max;
    }
}
