public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0; // pos
        int dx = 0, dy = 1; // ^
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'R') {
                int temp = dx;
                dx = dy;
                dy = -temp;                
            } else if (c == 'L') {
                int temp = dx;
                dx = -dy;
                dy = temp;
            } else { // ^
                x += dx;
                y += dy;
            } 
        }
        System.out.println("x, y = " + x + ", " + y);                               
        System.out.println("dx, dy = "+ dx + ", " + dy);

        if ((x == 0 && y == 0) || 
            (dx != 0 || dy != 1)) return true;
        else return false;
        
        
    }

    // https://leetcode.com/problems/robot-bounded-in-circle/discuss/290856/JavaC%2B%2BPython-Let-Chopper-Help-Explain
    public boolean isRobotBounded_1(String ins) {
        int x = 0, y = 0, i = 0, d[][] = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        for (int j = 0; j < ins.length(); ++j)
            if (ins.charAt(j) == 'R')
                i = (i + 1) % 4;
            else if (ins.charAt(j) == 'L')
                i = (i + 3) % 4;
            else {
                x += d[i][0]; y += d[i][1];
            }
        return x == 0 && y == 0 || i > 0;
    }
}