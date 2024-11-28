import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[][] grid = {
                {0,1,1},
                {1,1,0},
                {1,1,0}
        };
        int expected = 2;
        int actual = new Solution().minimumObstacles(grid);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        int[][] grid = {
                {0, 0, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 0},
                {1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 1, 1, 1},
                {0, 1, 1, 0, 0, 1, 0}
        };

        int expected = 4;
        int actual = new Solution().minimumObstacles(grid);

        Assert.assertEquals(expected, actual);
    }
}
