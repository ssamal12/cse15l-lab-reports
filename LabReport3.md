# Lab Report 3

## Part 1

1. A failure inducing input for the buggy program
```
  @Test
  public void averageWithoutLowest2() {
    double[] input = {1.0, 1.0, 3.0};
    assertEquals(3.0, ArrayExamples.averageWithoutLowest(input), 0.0001);
  }
```

2. An input that does not induce a failure
```
	@Test 
	public void averageWithoutLowest() {
    double[] input = {1.0, 2.0, 3.0};
    assertEquals(2.5, ArrayExamples.averageWithoutLowest(input), 0.0001);
  }
```

3. The symptom, as the output of running the tests
```
JUnit version 4.13.2
.E.
Time: 0.003
There was 1 failure:
1) averageWithoutLowest2(ArrayTests)
java.lang.AssertionError: expected:<3.0> but was:<1.5>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:555)
        at org.junit.Assert.assertEquals(Assert.java:685)
        at ArrayTests.averageWithoutLowest2(ArrayTests.java:15)

FAILURES!!!
Tests run: 2,  Failures: 1
```

4. The bug, as the before-and-after code change required to fix it
Buggy Code:
```
  static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { return 0.0; }
    double lowest = arr[0];
    for(double num: arr) {
      if(num < lowest) { lowest = num; }
    }
    double sum = 0;
    for(double num: arr) {
      if(num != lowest) { sum += num; }
    }
    return sum / (arr.length - 1);
  }
```

Fixed Code: 
```
  static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { return 0.0; }
    double lowest = arr[0];
    for(double num: arr) {
      if(num < lowest) { lowest = num; }
    }
    double sum = 0;
    int count = 0;
    for(double num: arr) {
      if(num != lowest) { sum += num; 
        count++;
      }
    }
    return sum / count;
  }
```

The reason the fixed code works, is that when there are two lowest values, it rmeoves both lowest values from tthe count, but divides by a count that only removes one for the removal of the two lowest values. So in the test case the sum was being divided by  2 instead of one. By making the count based on the number of figures calculated in the sum, the count to divide by for the average is the true count of the number of elements used. 

Fixed Output: 
```
JUnit version 4.13.2
..
Time: 0.002

OK (2 tests)
```

## Part 2


