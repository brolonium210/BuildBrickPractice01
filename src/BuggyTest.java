public class BuggyTest {

    Counter counter = new Counter();

    public void runTests() {
        System.out.println("Starting tests...");
//        testInfiniteLoop();
        testIncorrectVariableState();
//        testNullPointerException();
//        testUnexpectedMethodCall();
//        testArrayIndexOutOfBounds();
//        testRaceCondition();
        System.out.println("All tests completed!");
    }

    // 1. Infinite Loop
    private void testInfiniteLoop() {
        System.out.println("Testing Infinite Loop...");
        int i = 0;

        while (i < 10) { // Bug: i is never incremented
            if (i == 5) {
                System.out.println("Halfway there!"); // Students should break here
            }
//            counter.incrI();
            i++;//solution ,remove for testing later
        }
        System.out.println("Infinite Loop Test Passed!"); // Never reaches here
    }

    // 2. Incorrect Variable State
    private void testIncorrectVariableState() {
        System.out.println("Testing Incorrect Variable State...");
        int x = 10;
        for (int i = 0; i < 5; i++) {
            x -= 3; // Bug: Incorrect calculation logic
        }
        if (x != -5) { // Expected result is -5
            System.out.println("Variable state is incorrect!"); // Students should find why x != -5
        }
        System.out.println("Incorrect Variable State Test Passed!");
    }

    // 3. Null Pointer Exception
    private void testNullPointerException() {
        System.out.println("Testing Null Pointer Exception...");
        String str = null;
        if (str.equals("test")) { // Bug: NullPointerException
            System.out.println("String equals test!"); // Students should use a conditional breakpoint on str
        }
        System.out.println("Null Pointer Exception Test Passed!");
    }

    // 4. Unexpected Method Call
    private void testUnexpectedMethodCall() {
        System.out.println("Testing Unexpected Method Call...");
        String input = "unexpected";
        if (input.equals("expected")) {
            unexpectedBehavior(); // Bug: Method shouldn't be called for "unexpected"
        }
        System.out.println("Unexpected Method Call Test Passed!");
    }

    private void unexpectedBehavior() {
        System.out.println("Unexpected behavior triggered!");
    }

    // 5. Array Index Out of Bounds
    private void testArrayIndexOutOfBounds() {
        System.out.println("Testing Array Index Out of Bounds...");
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i <= arr.length; i++) { // Bug: i <= arr.length leads to out-of-bounds access
            System.out.println("Element: " + arr[i]); // Students should identify invalid index
        }
        System.out.println("Array Index Out of Bounds Test Passed!");
    }

    // 6. Race Condition in Multithreading
    private void testRaceCondition() {
        System.out.println("Testing Race Condition...");
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> resource.increment());
        Thread t2 = new Thread(() -> resource.increment());
        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (resource.getCounter() != 2) { // Bug: Race condition can cause incorrect counter value
            System.out.println("Race condition detected! Counter: " + resource.getCounter());
        }

        System.out.println("Race Condition Test Passed!");
    }

    // Shared resource for race condition test
    class SharedResource {
        private int counter = 0;

        public void increment() {
            int temp = counter; // Simulate race condition
            try {
                Thread.sleep(50); // Simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter = temp + 1; // Bug: Counter value is overwritten
        }

        public int getCounter() {
            return counter;
        }
    }
}

