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

## Part 2 - `find` Command

1. `find directory/ -ls`
The command finds all the file directory information and lists it. For this scenario it displays all the files and directories within the technical direcory.
```
(base) sanatsamal@Sanats-MacBook-Pro docsearch % find technical/ -ls
27157727       24 -rwxr-xr-x    1 sanatsamal       staff               12077 Feb 13 20:20 technical//plos/pmed.0020102.txt
27157577       40 -rwxr-xr-x    1 sanatsamal       staff               16489 Feb 13 20:20 technical//plos/journal.pbio.0020150.txt
27157710       24 -rwxr-xr-x    1 sanatsamal       staff               11824 Feb 13 20:20 technical//plos/pmed.0020062.txt
27157789        8 -rwxr-xr-x    1 sanatsamal       staff                3536 Feb 13 20:20 technical//plos/pmed.0020274.txt
27157594       32 -rwxr-xr-x    1 sanatsamal       staff               15436 Feb 13 20:20 technical//plos/journal.pbio.0020232.txt
27157625       32 -rwxr-xr-x    1 sanatsamal       staff               12717 Feb 13 20:20 technical//plos/journal.pbio.0030021.txt
27157592       24 -rwxr-xr-x    1 sanatsamal       staff                9827 Feb 13 20:20 technical//plos/journal.pbio.0020224.txt
27157704        8 -rwxr-xr-x    1 sanatsamal       staff                1342 Feb 13 20:20 technical//plos/pmed.0020048.txt
27157708       32 -rwxr-xr-x    1 sanatsamal       staff               12349 Feb 13 20:20 technical//plos/pmed.0020060.txt
27157716        8 -rwxr-xr-x    1 sanatsamal       staff                3033 Feb 13 20:20 technical//plos/pmed.0020074.txt
27157574       40 -rwxr-xr-x    1 sanatsamal       staff               18557 Feb 13 20:20 technical//plos/journal.pbio.0020146.txt
27157731        8 -rwxr-xr-x    1 sanatsamal       staff                3630 Feb 13 20:20 technical//plos/pmed.0020114.txt
27157652       80 -rwxr-xr-x    1 sanatsamal       staff               39355 Feb 13 20:20 technical//plos/pmed.0010028.txt
27157611       40 -rwxr-xr-x    1 sanatsamal       staff               18196 Feb 13 20:20 technical//plos/journal.pbio.0020350.txt
27157585       32 -rwxr-xr-x    1 sanatsamal       staff               14772 Feb 13 20:20 technical//plos/journal.pbio.0020190.txt
27157653        8 -rwxr-xr-x    1 sanatsamal       staff                2963 Feb 13 20:20 technical//plos/pmed.0010029.txt
27157732        8 -rwxr-xr-x    1 sanatsamal       staff                3623 Feb 13 20:20 technical//plos/pmed.0020115.txt
27157575       16 -rwxr-xr-x    1 sanatsamal       staff                7538 Feb 13 20:20 technical//plos/journal.pbio.0020147.txt
27157717       24 -rwxr-xr-x    1 sanatsamal       staff                9355 Feb 13 20:20 technical//plos/pmed.0020075.txt
27157709       48 -rwxr-xr-x    1 sanatsamal       staff               21238 Feb 13 20:20 technical//plos/pmed.0020061.txt
27157769       24 -rwxr-xr-x    1 sanatsamal       staff               10659 Feb 13 20:20 technical//plos/pmed.0020210.txt
27157778       16 -rwxr-xr-x    1 sanatsamal       staff                4455 Feb 13 20:20 technical//plos/pmed.0020238.txt
27157629       24 -rwxr-xr-x    1 sanatsamal       staff               10350 Feb 13 20:20 technical//plos/journal.pbio.0030051.txt
27157559       40 -rwxr-xr-x    1 sanatsamal       staff               16825 Feb 13 20:20 technical//plos/journal.pbio.0020068.txt
27157555       40 -rwxr-xr-x    1 sanatsamal       staff               20355 Feb 13 20:20 technical//plos/journal.pbio.0020054.txt
27157548       16 -rwxr-xr-x    1 sanatsamal       staff                7538 Feb 13 20:20 technical//plos/journal.pbio.0020040.txt
27157674       48 -rwxr-xr-x    1 sanatsamal       staff               24269 Feb 13 20:20 technical//plos/pmed.0010066.txt
27157640       24 -rwxr-xr-x    1 sanatsamal       staff               10049 Feb 13 20:20 technical//plos/journal.pbio.0030131.txt
27157607       24 -rwxr-xr-x    1 sanatsamal       staff               11804 Feb 13 20:20 technical//plos/journal.pbio.0020337.txt
27157762       16 -rwxr-xr-x    1 sanatsamal       staff                4567 Feb 13 20:20 technical//plos/pmed.0020198.txt
27157675        8 -rwxr-xr-x    1 sanatsamal       staff                2534 Feb 13 20:20 technical//plos/pmed.0010067.txt
27157568       40 -rwxr-xr-x    1 sanatsamal       staff               17333 Feb 13 20:20 technical//plos/journal.pbio.0020121.txt
27157682       24 -rwxr-xr-x    1 sanatsamal       staff               11122 Feb 13 20:20 technical//plos/pmed.0020007.txt
27157628       40 -rwxr-xr-x    1 sanatsamal       staff               16704 Feb 13 20:20 technical//plos/journal.pbio.0030050.txt
27157779       16 -rwxr-xr-x    1 sanatsamal       staff                4952 Feb 13 20:20 technical//plos/pmed.0020239.txt
27157595       32 -rwxr-xr-x    1 sanatsamal       staff               15004 Feb 13 20:20 technical//plos/journal.pbio.0020241.txt
27157681       24 -rwxr-xr-x    1 sanatsamal       staff                9559 Feb 13 20:20 technical//plos/pmed.0020005.txt
27157550       40 -rwxr-xr-x    1 sanatsamal       staff               20221 Feb 13 20:20 technical//plos/journal.pbio.0020043.txt
27157700       32 -rwxr-xr-x    1 sanatsamal       staff               13575 Feb 13 20:20 technical//plos/pmed.0020039.txt
27157679       16 -rwxr-xr-x    1 sanatsamal       staff                5496 Feb 13 20:20 technical//plos/pmed.0010071.txt
27157638       40 -rwxr-xr-x    1 sanatsamal       staff               17424 Feb 13 20:20 technical//plos/journal.pbio.0030127.txt
27157669       32 -rwxr-xr-x    1 sanatsamal       staff               16284 Feb 13 20:20 technical//plos/pmed.0010058.txt
27157678        8 -rwxr-xr-x    1 sanatsamal       staff                4041 Feb 13 20:20 technical//plos/pmed.0010070.txt
27157673       64 -rwxr-xr-x    1 sanatsamal       staff               30314 Feb 13 20:20 technical//plos/pmed.0010064.txt
27157747       16 -rwxr-xr-x    1 sanatsamal       staff                5757 Feb 13 20:20 technical//plos/pmed.0020158.txt
27157549       24 -rwxr-xr-x    1 sanatsamal       staff               10153 Feb 13 20:20 technical//plos/journal.pbio.0020042.txt
27157601       24 -rwxr-xr-x    1 sanatsamal       staff                9843 Feb 13 20:20 technical//plos/journal.pbio.0020297.txt
27157766       32 -rwxr-xr-x    1 sanatsamal       staff               15713 Feb 13 20:20 technical//plos/pmed.0020206.txt
27157770       32 -rwxr-xr-x    1 sanatsamal       staff               14906 Feb 13 20:20 technical//plos/pmed.0020212.txt
27157771       40 -rwxr-xr-x    1 sanatsamal       staff               20019 Feb 13 20:20 technical//plos/pmed.0020216.txt
27157634       32 -rwxr-xr-x    1 sanatsamal       staff               13564 Feb 13 20:20 technical//plos/journal.pbio.0030094.txt
27157551       40 -rwxr-xr-x    1 sanatsamal       staff               19069 Feb 13 20:20 technical//plos/journal.pbio.0020046.txt
27157695        8 -rwxr-xr-x    1 sanatsamal       staff                2016 Feb 13 20:20 technical//plos/pmed.0020028.txt
27157553       32 -rwxr-xr-x    1 sanatsamal       staff               15002 Feb 13 20:20 technical//plos/journal.pbio.0020052.txt
27157742        8 -rwxr-xr-x    1 sanatsamal       staff                3731 Feb 13 20:20 technical//plos/pmed.0020148.txt
27157748       56 -rwxr-xr-x    1 sanatsamal       staff               28305 Feb 13 20:20 technical//plos/pmed.0020160.txt
27157663       16 -rwxr-xr-x    1 sanatsamal       staff                4529 Feb 13 20:20 technical//plos/pmed.0010048.txt
27157670       24 -rwxr-xr-x    1 sanatsamal       staff               11952 Feb 13 20:20 technical//plos/pmed.0010060.txt
27157642       40 -rwxr-xr-x    1 sanatsamal       staff               20378 Feb 13 20:20 technical//plos/journal.pbio.0030137.txt
27157641       24 -rwxr-xr-x    1 sanatsamal       staff               10649 Feb 13 20:20 technical//plos/journal.pbio.0030136.txt
27157671       16 -rwxr-xr-x    1 sanatsamal       staff                7706 Feb 13 20:20 technical//plos/pmed.0010061.txt
27157664        8 -rwxr-xr-x    1 sanatsamal       staff                4082 Feb 13 20:20 technical//plos/pmed.0010049.txt
27157749       40 -rwxr-xr-x    1 sanatsamal       staff               20118 Feb 13 20:20 technical//plos/pmed.0020161.txt
27157570       32 -rwxr-xr-x    1 sanatsamal       staff               13106 Feb 13 20:20 technical//plos/journal.pbio.0020127.txt
27157743        8 -rwxr-xr-x    1 sanatsamal       staff                3794 Feb 13 20:20 technical//plos/pmed.0020149.txt
27157571       32 -rwxr-xr-x    1 sanatsamal       staff               14772 Feb 13 20:20 technical//plos/journal.pbio.0020133.txt
27157684       48 -rwxr-xr-x    1 sanatsamal       staff               24126 Feb 13 20:20 technical//plos/pmed.0020015.txt
27157554       48 -rwxr-xr-x    1 sanatsamal       staff               21038 Feb 13 20:20 technical//plos/journal.pbio.0020053.txt
27157552       16 -rwxr-xr-x    1 sanatsamal       staff                5847 Feb 13 20:20 technical//plos/journal.pbio.0020047.txt
27157765       16 -rwxr-xr-x    1 sanatsamal       staff                5378 Feb 13 20:20 technical//plos/pmed.0020203.txt
27157630       32 -rwxr-xr-x    1 sanatsamal       staff               15033 Feb 13 20:20 technical//plos/journal.pbio.0030056.txt
27157764        8 -rwxr-xr-x    1 sanatsamal       staff                4092 Feb 13 20:20 technical//plos/pmed.0020201.txt
27157635       24 -rwxr-xr-x    1 sanatsamal       staff               12085 Feb 13 20:20 technical//plos/journal.pbio.0030097.txt
27157686       24 -rwxr-xr-x    1 sanatsamal       staff               12116 Feb 13 20:20 technical//plos/pmed.0020017.txt
27157569       32 -rwxr-xr-x    1 sanatsamal       staff               15094 Feb 13 20:20 technical//plos/journal.pbio.0020125.txt
27157624       40 -rwxr-xr-x    1 sanatsamal       staff               20030 Feb 13 20:20 technical//plos/journal.pbio.0020440.txt
27157672       56 -rwxr-xr-x    1 sanatsamal       staff               28156 Feb 13 20:20 technical//plos/pmed.0010062.txt
27157755        8 -rwxr-xr-x    1 sanatsamal       staff                3455 Feb 13 20:20 technical//plos/pmed.0020189.txt
27157750       56 -rwxr-xr-x    1 sanatsamal       staff               26844 Feb 13 20:20 technical//plos/pmed.0020162.txt
27157685       56 -rwxr-xr-x    1 sanatsamal       staff               27076 Feb 13 20:20 technical//plos/pmed.0020016.txt
27157680       24 -rwxr-xr-x    1 sanatsamal       staff               10869 Feb 13 20:20 technical//plos/pmed.0020002.txt
27157763        8 -rwxr-xr-x    1 sanatsamal       staff                3880 Feb 13 20:20 technical//plos/pmed.0020200.txt
27157773       24 -rwxr-xr-x    1 sanatsamal       staff                8322 Feb 13 20:20 technical//plos/pmed.0020231.txt
27157597       16 -rwxr-xr-x    1 sanatsamal       staff                8027 Feb 13 20:20 technical//plos/journal.pbio.0020263.txt
27157694        8 -rwxr-xr-x    1 sanatsamal       staff                2356 Feb 13 20:20 technical//plos/pmed.0020027.txt
27157696       24 -rwxr-xr-x    1 sanatsamal       staff                8919 Feb 13 20:20 technical//plos/pmed.0020033.txt
27157563       32 -rwxr-xr-x    1 sanatsamal       staff               12821 Feb 13 20:20 technical//plos/journal.pbio.0020101.txt
27157662        8 -rwxr-xr-x    1 sanatsamal       staff                4056 Feb 13 20:20 technical//plos/pmed.0010047.txt
27157637       16 -rwxr-xr-x    1 sanatsamal       staff                6794 Feb 13 20:20 technical//plos/journal.pbio.0030105.txt
27157602       32 -rwxr-xr-x    1 sanatsamal       staff               15486 Feb 13 20:20 technical//plos/journal.pbio.0020302.txt
27157661       16 -rwxr-xr-x    1 sanatsamal       staff                6385 Feb 13 20:20 technical//plos/pmed.0010046.txt
27157667       32 -rwxr-xr-x    1 sanatsamal       staff               15953 Feb 13 20:20 technical//plos/pmed.0010052.txt
27157756        8 -rwxr-xr-x    1 sanatsamal       staff                 876 Feb 13 20:20 technical//plos/pmed.0020191.txt
27157562       16 -rwxr-xr-x    1 sanatsamal       staff                8016 Feb 13 20:20 technical//plos/journal.pbio.0020100.txt
27157741        8 -rwxr-xr-x    1 sanatsamal       staff                3817 Feb 13 20:20 technical//plos/pmed.0020146.txt
27157596       16 -rwxr-xr-x    1 sanatsamal       staff                7642 Feb 13 20:20 technical//plos/journal.pbio.0020262.txt
27157632       32 -rwxr-xr-x    1 sanatsamal       staff               14373 Feb 13 20:20 technical//plos/journal.pbio.0030065.txt
27157600       32 -rwxr-xr-x    1 sanatsamal       staff               12539 Feb 13 20:20 technical//plos/journal.pbio.0020276.txt
27157774       32 -rwxr-xr-x    1 sanatsamal       staff               16033 Feb 13 20:20 technical//plos/pmed.0020232.txt
27157772        8 -rwxr-xr-x    1 sanatsamal       staff                 920 Feb 13 20:20 technical//plos/pmed.0020226.txt
27157693        8 -rwxr-xr-x    1 sanatsamal       staff                2848 Feb 13 20:20 technical//plos/pmed.0020024.txt
27157687       80 -rwxr-xr-x    1 sanatsamal       staff               37686 Feb 13 20:20 technical//plos/pmed.0020018.txt
27157739       16 -rwxr-xr-x    1 sanatsamal       staff                5668 Feb 13 20:20 technical//plos/pmed.0020144.txt
27157744        8 -rwxr-xr-x    1 sanatsamal       staff                3741 Feb 13 20:20 technical//plos/pmed.0020150.txt
27157567       32 -rwxr-xr-x    1 sanatsamal       staff               13142 Feb 13 20:20 technical//plos/journal.pbio.0020116.txt
27157754       16 -rwxr-xr-x    1 sanatsamal       staff                4837 Feb 13 20:20 technical//plos/pmed.0020187.txt
27157665        8 -rwxr-xr-x    1 sanatsamal       staff                3467 Feb 13 20:20 technical//plos/pmed.0010050.txt
27157666       24 -rwxr-xr-x    1 sanatsamal       staff                8321 Feb 13 20:20 technical//plos/pmed.0010051.txt
27157757        8 -rwxr-xr-x    1 sanatsamal       staff                1042 Feb 13 20:20 technical//plos/pmed.0020192.txt
27157660       56 -rwxr-xr-x    1 sanatsamal       staff               24586 Feb 13 20:20 technical//plos/pmed.0010045.txt
27157740        8 -rwxr-xr-x    1 sanatsamal       staff                2891 Feb 13 20:20 technical//plos/pmed.0020145.txt
27157688        8 -rwxr-xr-x    1 sanatsamal       staff                3270 Feb 13 20:20 technical//plos/pmed.0020019.txt
27157556       16 -rwxr-xr-x    1 sanatsamal       staff                6873 Feb 13 20:20 technical//plos/journal.pbio.0020063.txt
27157633       24 -rwxr-xr-x    1 sanatsamal       staff               12215 Feb 13 20:20 technical//plos/journal.pbio.0030076.txt
27157631       40 -rwxr-xr-x    1 sanatsamal       staff               17821 Feb 13 20:20 technical//plos/journal.pbio.0030062.txt
27157777        8 -rwxr-xr-x    1 sanatsamal       staff                4013 Feb 13 20:20 technical//plos/pmed.0020237.txt
27157558       24 -rwxr-xr-x    1 sanatsamal       staff               10929 Feb 13 20:20 technical//plos/journal.pbio.0020067.txt
27157683       40 -rwxr-xr-x    1 sanatsamal       staff               17310 Feb 13 20:20 technical//plos/pmed.0020009.txt
27157561       24 -rwxr-xr-x    1 sanatsamal       staff                9467 Feb 13 20:20 technical//plos/journal.pbio.0020073.txt
27157698       16 -rwxr-xr-x    1 sanatsamal       staff                6027 Feb 13 20:20 technical//plos/pmed.0020035.txt
27157690        8 -rwxr-xr-x    1 sanatsamal       staff                2765 Feb 13 20:20 technical//plos/pmed.0020021.txt
27157566       48 -rwxr-xr-x    1 sanatsamal       staff               21467 Feb 13 20:20 technical//plos/journal.pbio.0020113.txt
27157745       16 -rwxr-xr-x    1 sanatsamal       staff                6985 Feb 13 20:20 technical//plos/pmed.0020155.txt
27157677        8 -rwxr-xr-x    1 sanatsamal       staff                3963 Feb 13 20:20 technical//plos/pmed.0010069.txt
27157658       16 -rwxr-xr-x    1 sanatsamal       staff                7641 Feb 13 20:20 technical//plos/pmed.0010041.txt
27157753       72 -rwxr-xr-x    1 sanatsamal       staff               35433 Feb 13 20:20 technical//plos/pmed.0020182.txt
27157760        8 -rwxr-xr-x    1 sanatsamal       staff                3811 Feb 13 20:20 technical//plos/pmed.0020196.txt
27157606       32 -rwxr-xr-x    1 sanatsamal       staff               13391 Feb 13 20:20 technical//plos/journal.pbio.0020311.txt
27157636       32 -rwxr-xr-x    1 sanatsamal       staff               14381 Feb 13 20:20 technical//plos/journal.pbio.0030102.txt
27157605       32 -rwxr-xr-x    1 sanatsamal       staff               14197 Feb 13 20:20 technical//plos/journal.pbio.0020310.txt
27157761       16 -rwxr-xr-x    1 sanatsamal       staff                5701 Feb 13 20:20 technical//plos/pmed.0020197.txt
27157676        8 -rwxr-xr-x    1 sanatsamal       staff                2754 Feb 13 20:20 technical//plos/pmed.0010068.txt
27157738       48 -rwxr-xr-x    1 sanatsamal       staff               20867 Feb 13 20:20 technical//plos/pmed.0020140.txt
27157565       16 -rwxr-xr-x    1 sanatsamal       staff                7411 Feb 13 20:20 technical//plos/journal.pbio.0020112.txt
27157689        8 -rwxr-xr-x    1 sanatsamal       staff                3761 Feb 13 20:20 technical//plos/pmed.0020020.txt
27157697       40 -rwxr-xr-x    1 sanatsamal       staff               20118 Feb 13 20:20 technical//plos/pmed.0020034.txt
27157776       16 -rwxr-xr-x    1 sanatsamal       staff                4766 Feb 13 20:20 technical//plos/pmed.0020236.txt
27157599       24 -rwxr-xr-x    1 sanatsamal       staff                8485 Feb 13 20:20 technical//plos/journal.pbio.0020272.txt
27157767       16 -rwxr-xr-x    1 sanatsamal       staff                6589 Feb 13 20:20 technical//plos/pmed.0020208.txt
27157557       40 -rwxr-xr-x    1 sanatsamal       staff               16977 Feb 13 20:20 technical//plos/journal.pbio.0020064.txt
27157691        8 -rwxr-xr-x    1 sanatsamal       staff                2965 Feb 13 20:20 technical//plos/pmed.0020022.txt
27157699       16 -rwxr-xr-x    1 sanatsamal       staff                6396 Feb 13 20:20 technical//plos/pmed.0020036.txt
27157668       32 -rwxr-xr-x    1 sanatsamal       staff               15680 Feb 13 20:20 technical//plos/pmed.0010056.txt
27157759        8 -rwxr-xr-x    1 sanatsamal       staff                3163 Feb 13 20:20 technical//plos/pmed.0020195.txt
27157659       24 -rwxr-xr-x    1 sanatsamal       staff               10380 Feb 13 20:20 technical//plos/pmed.0010042.txt
27157752       16 -rwxr-xr-x    1 sanatsamal       staff                6993 Feb 13 20:20 technical//plos/pmed.0020181.txt
27157603       32 -rwxr-xr-x    1 sanatsamal       staff               15057 Feb 13 20:20 technical//plos/journal.pbio.0020306.txt
27157639       16 -rwxr-xr-x    1 sanatsamal       staff                6224 Feb 13 20:20 technical//plos/journal.pbio.0030129.txt
27157604       24 -rwxr-xr-x    1 sanatsamal       staff               11321 Feb 13 20:20 technical//plos/journal.pbio.0020307.txt
27157751       16 -rwxr-xr-x    1 sanatsamal       staff                7775 Feb 13 20:20 technical//plos/pmed.0020180.txt
27157758       16 -rwxr-xr-x    1 sanatsamal       staff                5238 Feb 13 20:20 technical//plos/pmed.0020194.txt
27157746        8 -rwxr-xr-x    1 sanatsamal       staff                1408 Feb 13 20:20 technical//plos/pmed.0020157.txt
27157564       16 -rwxr-xr-x    1 sanatsamal       staff                7623 Feb 13 20:20 technical//plos/journal.pbio.0020105.txt
27157692        8 -rwxr-xr-x    1 sanatsamal       staff                3554 Feb 13 20:20 technical//plos/pmed.0020023.txt
27157560       16 -rwxr-xr-x    1 sanatsamal       staff                6924 Feb 13 20:20 technical//plos/journal.pbio.0020071.txt
27157775       16 -rwxr-xr-x    1 sanatsamal       staff                4749 Feb 13 20:20 technical//plos/pmed.0020235.txt
27157598       40 -rwxr-xr-x    1 sanatsamal       staff               20392 Feb 13 20:20 technical//plos/journal.pbio.0020267.txt
27157768       40 -rwxr-xr-x    1 sanatsamal       staff               20056 Feb 13 20:20 technical//plos/pmed.0020209.txt
27157781       80 -rwxr-xr-x    1 sanatsamal       staff               38881 Feb 13 20:20 technical//plos/pmed.0020246.txt
27157593       32 -rwxr-xr-x    1 sanatsamal       staff               12946 Feb 13 20:20 technical//plos/journal.pbio.0020228.txt
27157588       40 -rwxr-xr-x    1 sanatsamal       staff               17069 Feb 13 20:20 technical//plos/journal.pbio.0020214.txt
27157705       56 -rwxr-xr-x    1 sanatsamal       staff               28669 Feb 13 20:20 technical//plos/pmed.0020050.txt
27157735       16 -rwxr-xr-x    1 sanatsamal       staff                5747 Feb 13 20:20 technical//plos/pmed.0020118.txt
27157654        8 -rwxr-xr-x    1 sanatsamal       staff                3234 Feb 13 20:20 technical//plos/pmed.0010030.txt
27157649        8 -rwxr-xr-x    1 sanatsamal       staff                3597 Feb 13 20:20 technical//plos/pmed.0010024.txt
27157610       32 -rwxr-xr-x    1 sanatsamal       staff               15412 Feb 13 20:20 technical//plos/journal.pbio.0020348.txt
27157618       48 -rwxr-xr-x    1 sanatsamal       staff               23165 Feb 13 20:20 technical//plos/journal.pbio.0020406.txt
27157650        8 -rwxr-xr-x    1 sanatsamal       staff                2843 Feb 13 20:20 technical//plos/pmed.0010025.txt
27157720        8 -rwxr-xr-x    1 sanatsamal       staff                2115 Feb 13 20:20 technical//plos/pmed.0020086.txt
27157702       72 -rwxr-xr-x    1 sanatsamal       staff               35111 Feb 13 20:20 technical//plos/pmed.0020045.txt
27157589       24 -rwxr-xr-x    1 sanatsamal       staff               10017 Feb 13 20:20 technical//plos/journal.pbio.0020215.txt
27157782       24 -rwxr-xr-x    1 sanatsamal       staff               12133 Feb 13 20:20 technical//plos/pmed.0020247.txt
27157703        8 -rwxr-xr-x    1 sanatsamal       staff                3981 Feb 13 20:20 technical//plos/pmed.0020047.txt
27157541       40 -rwxr-xr-x    1 sanatsamal       staff               18130 Feb 13 20:20 technical//plos/journal.pbio.0020001.txt
27157722        8 -rwxr-xr-x    1 sanatsamal       staff                3431 Feb 13 20:20 technical//plos/pmed.0020090.txt
27157579       48 -rwxr-xr-x    1 sanatsamal       staff               20933 Feb 13 20:20 technical//plos/journal.pbio.0020161.txt
27157623       56 -rwxr-xr-x    1 sanatsamal       staff               26338 Feb 13 20:20 technical//plos/journal.pbio.0020439.txt
27157617       40 -rwxr-xr-x    1 sanatsamal       staff               16508 Feb 13 20:20 technical//plos/journal.pbio.0020404.txt
27157651       16 -rwxr-xr-x    1 sanatsamal       staff                6414 Feb 13 20:20 technical//plos/pmed.0010026.txt
27157576       40 -rwxr-xr-x    1 sanatsamal       staff               18804 Feb 13 20:20 technical//plos/journal.pbio.0020148.txt
27157719        8 -rwxr-xr-x    1 sanatsamal       staff                2473 Feb 13 20:20 technical//plos/pmed.0020085.txt
27157723        8 -rwxr-xr-x    1 sanatsamal       staff                3561 Feb 13 20:20 technical//plos/pmed.0020091.txt
27157546       32 -rwxr-xr-x    1 sanatsamal       staff               16239 Feb 13 20:20 technical//plos/journal.pbio.0020028.txt
27157590       24 -rwxr-xr-x    1 sanatsamal       staff               11519 Feb 13 20:20 technical//plos/journal.pbio.0020216.txt
27157791        8 -rwxr-xr-x    1 sanatsamal       staff                2738 Feb 13 20:20 technical//plos/pmed.0020278.txt
27157786       16 -rwxr-xr-x    1 sanatsamal       staff                4198 Feb 13 20:20 technical//plos/pmed.0020268.txt
27157586       40 -rwxr-xr-x    1 sanatsamal       staff               19384 Feb 13 20:20 technical//plos/journal.pbio.0020206.txt
27157542       16 -rwxr-xr-x    1 sanatsamal       staff                6894 Feb 13 20:20 technical//plos/journal.pbio.0020010.txt
27157580       40 -rwxr-xr-x    1 sanatsamal       staff               17708 Feb 13 20:20 technical//plos/journal.pbio.0020164.txt
27157647       16 -rwxr-xr-x    1 sanatsamal       staff                6073 Feb 13 20:20 technical//plos/pmed.0010022.txt
27157656       72 -rwxr-xr-x    1 sanatsamal       staff               35535 Feb 13 20:20 technical//plos/pmed.0010036.txt
27157615       32 -rwxr-xr-x    1 sanatsamal       staff               16211 Feb 13 20:20 technical//plos/journal.pbio.0020400.txt
27157616       32 -rwxr-xr-x    1 sanatsamal       staff               13918 Feb 13 20:20 technical//plos/journal.pbio.0020401.txt
27157648        8 -rwxr-xr-x    1 sanatsamal       staff                3619 Feb 13 20:20 technical//plos/pmed.0010023.txt
27157737       56 -rwxr-xr-x    1 sanatsamal       staff               25177 Feb 13 20:20 technical//plos/pmed.0020123.txt
27157724        8 -rwxr-xr-x    1 sanatsamal       staff                3163 Feb 13 20:20 technical//plos/pmed.0020094.txt
27157587       40 -rwxr-xr-x    1 sanatsamal       staff               19111 Feb 13 20:20 technical//plos/journal.pbio.0020213.txt
27157784       16 -rwxr-xr-x    1 sanatsamal       staff                4677 Feb 13 20:20 technical//plos/pmed.0020257.txt
27157544       24 -rwxr-xr-x    1 sanatsamal       staff               12045 Feb 13 20:20 technical//plos/journal.pbio.0020013.txt
27157706       16 -rwxr-xr-x    1 sanatsamal       staff                6282 Feb 13 20:20 technical//plos/pmed.0020055.txt
27157718        8 -rwxr-xr-x    1 sanatsamal       staff                1538 Feb 13 20:20 technical//plos/pmed.0020082.txt
27157646       32 -rwxr-xr-x    1 sanatsamal       staff               12576 Feb 13 20:20 technical//plos/pmed.0010021.txt
27157655       16 -rwxr-xr-x    1 sanatsamal       staff                8190 Feb 13 20:20 technical//plos/pmed.0010034.txt
27157643       56 -rwxr-xr-x    1 sanatsamal       staff               26050 Feb 13 20:20 technical//plos/pmed.0010008.txt
27157736        8 -rwxr-xr-x    1 sanatsamal       staff                1444 Feb 13 20:20 technical//plos/pmed.0020120.txt
27157582       24 -rwxr-xr-x    1 sanatsamal       staff               10733 Feb 13 20:20 technical//plos/journal.pbio.0020172.txt
27157701       40 -rwxr-xr-x    1 sanatsamal       staff               17506 Feb 13 20:20 technical//plos/pmed.0020040.txt
27157713       32 -rwxr-xr-x    1 sanatsamal       staff               16026 Feb 13 20:20 technical//plos/pmed.0020068.txt
27157543       40 -rwxr-xr-x    1 sanatsamal       staff               17471 Feb 13 20:20 technical//plos/journal.pbio.0020012.txt
27157792        8 -rwxr-xr-x    1 sanatsamal       staff                2811 Feb 13 20:20 technical//plos/pmed.0020281.txt
27157780       16 -rwxr-xr-x    1 sanatsamal       staff                5076 Feb 13 20:20 technical//plos/pmed.0020242.txt
27156410        0 drwxr-xr-x  839 sanatsamal       staff               26848 Feb 13 20:20 technical//biomed
27156903       40 -rwxr-xr-x    1 sanatsamal       staff               18059 Feb 13 20:20 technical//biomed/1472-6807-2-2.txt
27156780       64 -rwxr-xr-x    1 sanatsamal       staff               29678 Feb 13 20:20 technical//biomed/1471-2350-4-3.txt
27156540       40 -rwxr-xr-x    1 sanatsamal       staff               19344 Feb 13 20:20 technical//biomed/1471-2156-2-3.txt
27156545       48 -rwxr-xr-x    1 sanatsamal       staff               20685 Feb 13 20:20 technical//biomed/1471-2156-3-11.txt
27156478       80 -rwxr-xr-x    1 sanatsamal       staff               39412 Feb 13 20:20 technical//biomed/1471-2121-3-10.txt
27156612       88 -rwxr-xr-x    1 sanatsamal       staff               40982 Feb 13 20:20 technical//biomed/1471-2172-3-4.txt
27157211       96 -rwxr-xr-x    1 sanatsamal       staff               48746 Feb 13 20:20 technical//biomed/gb-2002-4-1-r2.txt
27157230       48 -rwxr-xr-x    1 sanatsamal       staff               22764 Feb 13 20:20 technical//biomed/gb-2003-4-6-r41.txt
27156845       48 -rwxr-xr-x    1 sanatsamal       staff               23163 Feb 13 20:20 technical//biomed/1471-2466-1-1.txt
27156646       56 -rwxr-xr-x    1 sanatsamal       staff               26466 Feb 13 20:20 technical//biomed/1471-2199-2-10.txt
27156678       80 -rwxr-xr-x    1 sanatsamal       staff               40360 Feb 13 20:20 technical//biomed/1471-2202-2-9.txt
27157121       56 -rwxr-xr-x    1 sanatsamal       staff               24929 Feb 13 20:20 technical//biomed/cc991.txt
27156786       48 -rwxr-xr-x    1 sanatsamal       staff               22370 Feb 13 20:20 technical//biomed/1471-2369-3-9.txt
27157088       72 -rwxr-xr-x    1 sanatsamal       staff               35035 Feb 13 20:20 technical//biomed/bcr620.txt
27156988      104 -rwxr-xr-x    1 sanatsamal       staff               53109 Feb 13 20:20 technical//biomed/1476-069X-2-4.txt
27156870       32 -rwxr-xr-x    1 sanatsamal       staff               15015 Feb 13 20:20 technical//biomed/1472-6750-3-11.txt
27156561       96 -rwxr-xr-x    1 sanatsamal       staff               47898 Feb 13 20:20 technical//biomed/1471-2164-2-9.txt
27156416       48 -rwxr-xr-x    1 sanatsamal       staff               24028 Feb 13 20:20 technical//biomed/1471-2091-2-10.txt
27157140       96 -rwxr-xr-x    1 sanatsamal       staff               47665 Feb 13 20:20 technical//biomed/gb-2001-2-4-research0010.txt
27157222       80 -rwxr-xr-x    1 sanatsamal       staff               38892 Feb 13 20:20 technical//biomed/gb-2003-4-4-r24.txt
27156511       88 -rwxr-xr-x    1 sanatsamal       staff               41353 Feb 13 20:20 technical//biomed/1471-213X-2-1.txt
27156929       72 -rwxr-xr-x    1 sanatsamal       staff               35409 Feb 13 20:20 technical//biomed/1472-6882-3-3.txt
27156806       56 -rwxr-xr-x    1 sanatsamal       staff               27937 Feb 13 20:20 technical//biomed/1471-2407-2-3.txt
27157046       48 -rwxr-xr-x    1 sanatsamal       staff               20970 Feb 13 20:20 technical//biomed/ar331.txt
27157043       64 -rwxr-xr-x    1 sanatsamal       staff               29069 Feb 13 20:20 technical//biomed/ar319.txt
27156552       56 -rwxr-xr-x    1 sanatsamal       staff               27525 Feb 13 20:20 technical//biomed/1471-2156-4-5.txt
27156822       64 -rwxr-xr-x    1 sanatsamal       staff               30767 Feb 13 20:20 technical//biomed/1471-2431-2-1.txt
27157002       32 -rwxr-xr-x    1 sanatsamal       staff               15699 Feb 13 20:20 technical//biomed/1476-4598-2-22.txt
27156631       56 -rwxr-xr-x    1 sanatsamal       staff               26497 Feb 13 20:20 technical//biomed/1471-2180-2-22.txt
27156770       48 -rwxr-xr-x    1 sanatsamal       staff               23741 Feb 13 20:20 technical//biomed/1471-2334-3-9.txt
27156417       72 -rwxr-xr-x    1 sanatsamal       staff               35103 Feb 13 20:20 technical//biomed/1471-2091-2-11.txt
27157141       88 -rwxr-xr-x    1 sanatsamal       staff               43999 Feb 13 20:20 technical//biomed/gb-2001-2-4-research0011.txt
27156694       48 -rwxr-xr-x    1 sanatsamal       staff               21868 Feb 13 20:20 technical//biomed/1471-2202-4-12.txt
27157246       40 -rwxr-xr-x    1 sanatsamal       staff               16843 Feb 13 20:20 technical//biomed/rr73.txt
27156560       56 -rwxr-xr-x    1 sanatsamal       staff               26490 Feb 13 20:20 technical//biomed/1471-2164-2-8.txt
27156523       64 -rwxr-xr-x    1 sanatsamal       staff               32108 Feb 13 20:20 technical//biomed/1471-2148-2-12.txt
27157090       32 -rwxr-xr-x    1 sanatsamal       staff               13481 Feb 13 20:20 technical//biomed/bcr635.txt
27156412       64 -rwxr-xr-x    1 sanatsamal       staff               29585 Feb 13 20:20 technical//biomed/1468-6708-3-10.txt
27157227      144 -rwxr-xr-x    1 sanatsamal       staff               70729 Feb 13 20:20 technical//biomed/gb-2003-4-5-r34.txt
27156677       88 -rwxr-xr-x    1 sanatsamal       staff               41564 Feb 13 20:20 technical//biomed/1471-2202-2-8.txt
27156479       64 -rwxr-xr-x    1 sanatsamal       staff               28955 Feb 13 20:20 technical//biomed/1471-2121-3-11.txt
27156544       48 -rwxr-xr-x    1 sanatsamal       staff               23096 Feb 13 20:20 technical//biomed/1471-2156-3-10.txt
27156842       48 -rwxr-xr-x    1 sanatsamal       staff               22605 Feb 13 20:20 technical//biomed/1471-2458-3-20.txt
27156779       72 -rwxr-xr-x    1 sanatsamal       staff               34416 Feb 13 20:20 technical//biomed/1471-2350-4-2.txt
27156904       96 -rwxr-xr-x    1 sanatsamal       staff               48482 Feb 13 20:20 technical//biomed/1472-6807-2-3.txt
27156902       48 -rwxr-xr-x    1 sanatsamal       staff               23376 Feb 13 20:20 technical//biomed/1472-6807-2-1.txt
27156998       56 -rwxr-xr-x    1 sanatsamal       staff               28420 Feb 13 20:20 technical//biomed/1476-4598-1-8.txt
27157016       56 -rwxr-xr-x    1 sanatsamal       staff               26223 Feb 13 20:20 technical//biomed/1477-7525-1-9.txt
27157065       72 -rwxr-xr-x    1 sanatsamal       staff               35253 Feb 13 20:20 technical//biomed/ar79.txt
27156992       64 -rwxr-xr-x    1 sanatsamal       staff               31054 Feb 13 20:20 technical//biomed/1476-0711-2-7.txt
27156947       72 -rwxr-xr-x    1 sanatsamal       staff               34254 Feb 13 20:20 technical//biomed/1472-6947-3-8.txt
27156481       88 -rwxr-xr-x    1 sanatsamal       staff               43442 Feb 13 20:20 technical//biomed/1471-2121-3-13.txt
27157210       64 -rwxr-xr-x    1 sanatsamal       staff               30292 Feb 13 20:20 technical//biomed/gb-2002-4-1-r1.txt
27156814       80 -rwxr-xr-x    1 sanatsamal       staff               37922 Feb 13 20:20 technical//biomed/1471-2407-3-18.txt
27156718       96 -rwxr-xr-x    1 sanatsamal       staff               46406 Feb 13 20:20 technical//biomed/1471-2229-2-3.txt
27156756       40 -rwxr-xr-x    1 sanatsamal       staff               19590 Feb 13 20:20 technical//biomed/1471-2334-1-9.txt
27157203      112 -rwxr-xr-x    1 sanatsamal       staff               57158 Feb 13 20:20 technical//biomed/gb-2002-3-9-research0043.txt
27156821       88 -rwxr-xr-x    1 sanatsamal       staff               44803 Feb 13 20:20 technical//biomed/1471-2415-3-5.txt
27156754       40 -rwxr-xr-x    1 sanatsamal       staff               16640 Feb 13 20:20 technical//biomed/1471-2334-1-21.txt
27157148      136 -rwxr-xr-x    1 sanatsamal       staff               69168 Feb 13 20:20 technical//biomed/gb-2001-2-7-research0025.txt
27157038       96 -rwxr-xr-x    1 sanatsamal       staff               46550 Feb 13 20:20 technical//biomed/ar130.txt
27156989       56 -rwxr-xr-x    1 sanatsamal       staff               28318 Feb 13 20:20 technical//biomed/1476-069X-2-7.txt
27156931       40 -rwxr-xr-x    1 sanatsamal       staff               19200 Feb 13 20:20 technical//biomed/1472-6890-2-5.txt
27157036       72 -rwxr-xr-x    1 sanatsamal       staff               36324 Feb 13 20:20 technical//biomed/ar118.txt
27157196       64 -rwxr-xr-x    1 sanatsamal       staff               30444 Feb 13 20:20 technical//biomed/gb-2002-3-7-research0032.txt
27156725      112 -rwxr-xr-x    1 sanatsamal       staff               53437 Feb 13 20:20 technical//biomed/1471-2253-2-5.txt
27156701       64 -rwxr-xr-x    1 sanatsamal       staff               29200 Feb 13 20:20 technical//biomed/1471-2210-1-10.txt
27156419       56 -rwxr-xr-x    1 sanatsamal       staff               27970 Feb 13 20:20 technical//biomed/1471-2091-2-13.txt
27156630       80 -rwxr-xr-x    1 sanatsamal       staff               38478 Feb 13 20:20 technical//biomed/1471-2180-2-20.txt
27156685       64 -rwxr-xr-x    1 sanatsamal       staff               30039 Feb 13 20:20 technical//biomed/1471-2202-3-19.txt
27156692       64 -rwxr-xr-x    1 sanatsamal       staff               29083 Feb 13 20:20 technical//biomed/1471-2202-4-10.txt
27156951       64 -rwxr-xr-x    1 sanatsamal       staff               29285 Feb 13 20:20 technical//biomed/1472-6963-2-10.txt
27157001       56 -rwxr-xr-x    1 sanatsamal       staff               26696 Feb 13 20:20 technical//biomed/1476-4598-2-20.txt
27156553       72 -rwxr-xr-x    1 sanatsamal       staff               35378 Feb 13 20:20 technical//biomed/1471-2156-4-6.txt
27156843       56 -rwxr-xr-x    1 sanatsamal       staff               25679 Feb 13 20:20 technical//biomed/1471-2458-3-5.txt
27156876       24 -rwxr-xr-x    1 sanatsamal       staff                9952 Feb 13 20:20 technical//biomed/1472-6769-1-4.txt
27157223      128 -rwxr-xr-x    1 sanatsamal       staff               62553 Feb 13 20:20 technical//biomed/gb-2003-4-4-r26.txt
27156928       96 -rwxr-xr-x    1 sanatsamal       staff               48170 Feb 13 20:20 technical//biomed/1472-6882-3-1.txt
27157118       88 -rwxr-xr-x    1 sanatsamal       staff               43694 Feb 13 20:20 technical//biomed/cc4.txt
27156635       96 -rwxr-xr-x    1 sanatsamal       staff               47423 Feb 13 20:20 technical//biomed/1471-2180-2-35.txt
27156693       88 -rwxr-xr-x    1 sanatsamal       staff               42348 Feb 13 20:20 technical//biomed/1471-2202-4-11.txt
27157142       72 -rwxr-xr-x    1 sanatsamal       staff               35659 Feb 13 20:20 technical//biomed/gb-2001-2-4-research0012.txt
27156418       56 -rwxr-xr-x    1 sanatsamal       staff               24851 Feb 13 20:20 technical//biomed/1471-2091-2-12.txt
27156724       40 -rwxr-xr-x    1 sanatsamal       staff               17387 Feb 13 20:20 technical//biomed/1471-2253-2-4.txt
27157147       88 -rwxr-xr-x    1 sanatsamal       staff               44121 Feb 13 20:20 technical//biomed/gb-2001-2-7-research0024.txt
27156820       48 -rwxr-xr-x    1 sanatsamal       staff               22465 Feb 13 20:20 technical//biomed/1471-2415-3-4.txt
27156647       48 -rwxr-xr-x    1 sanatsamal       staff               24301 Feb 13 20:20 technical//biomed/1471-2199-2-12.txt
27156480       88 -rwxr-xr-x    1 sanatsamal       staff               44218 Feb 13 20:20 technical//biomed/1471-2121-3-12.txt
27156522       96 -rwxr-xr-x    1 sanatsamal       staff               48738 Feb 13 20:20 technical//biomed/1471-2148-1-8.txt
27157139       72 -rwxr-xr-x    1 sanatsamal       staff               33499 Feb 13 20:20 technical//biomed/gb-2001-2-3-research0008.txt
27156536       80 -rwxr-xr-x    1 sanatsamal       staff               38628 Feb 13 20:20 technical//biomed/1471-2156-2-1.txt
27156848       32 -rwxr-xr-x    1 sanatsamal       staff               15457 Feb 13 20:20 technical//biomed/1471-2466-3-1.txt
27157079       40 -rwxr-xr-x    1 sanatsamal       staff               19743 Feb 13 20:20 technical//biomed/bcr568.txt
27157233       80 -rwxr-xr-x    1 sanatsamal       staff               37359 Feb 13 20:20 technical//biomed/gb-2003-4-7-r46.txt
27156970       80 -rwxr-xr-x    1 sanatsamal       staff               39946 Feb 13 20:20 technical//biomed/1475-2875-2-14.txt
27156733       64 -rwxr-xr-x    1 sanatsamal       staff               30077 Feb 13 20:20 technical//biomed/1471-2288-2-4.txt
27156877       48 -rwxr-xr-x    1 sanatsamal       staff               24168 Feb 13 20:20 technical//biomed/1472-6785-1-3.txt
27157069       72 -rwxr-xr-x    1 sanatsamal       staff               32793 Feb 13 20:20 technical//biomed/ar93.txt
27156913       64 -rwxr-xr-x    1 sanatsamal       staff               29057 Feb 13 20:20 technical//biomed/1472-6831-2-2.txt
27157082       40 -rwxr-xr-x    1 sanatsamal       staff               19181 Feb 13 20:20 technical//biomed/bcr583.txt
27157117       40 -rwxr-xr-x    1 sanatsamal       staff               20130 Feb 13 20:20 technical//biomed/cc367.txt
27157019       64 -rwxr-xr-x    1 sanatsamal       staff               30587 Feb 13 20:20 technical//biomed/1477-7827-1-17.txt
27157018      112 -rwxr-xr-x    1 sanatsamal       staff               55102 Feb 13 20:20 technical//biomed/1477-7827-1-13.txt
27156905       80 -rwxr-xr-x    1 sanatsamal       staff               39829 Feb 13 20:20 technical//biomed/1472-6807-2-4.txt
27156547      104 -rwxr-xr-x    1 sanatsamal       staff               49960 Feb 13 20:20 technical//biomed/1471-2156-3-17.txt
27156969       72 -rwxr-xr-x    1 sanatsamal       staff               35430 Feb 13 20:20 technical//biomed/1475-2875-2-10.txt
27157231      128 -rwxr-xr-x    1 sanatsamal       staff               64870 Feb 13 20:20 technical//biomed/gb-2003-4-7-r42.txt
27156541       48 -rwxr-xr-x    1 sanatsamal       staff               22998 Feb 13 20:20 technical//biomed/1471-2156-2-5.txt
27157060       56 -rwxr-xr-x    1 sanatsamal       staff               27018 Feb 13 20:20 technical//biomed/ar68.txt
27156611       80 -rwxr-xr-x    1 sanatsamal       staff               38202 Feb 13 20:20 technical//biomed/1471-2172-3-2.txt
27156483      104 -rwxr-xr-x    1 sanatsamal       staff               52637 Feb 13 20:20 technical//biomed/1471-2121-3-16.txt
27156861       56 -rwxr-xr-x    1 sanatsamal       staff               25046 Feb 13 20:20 technical//biomed/1472-6750-1-12.txt
27156936       88 -rwxr-xr-x    1 sanatsamal       staff               44524 Feb 13 20:20 technical//biomed/1472-6904-2-7.txt
27156925       56 -rwxr-xr-x    1 sanatsamal       staff               25465 Feb 13 20:20 technical//biomed/1472-6882-1-7.txt
27156755       48 -rwxr-xr-x    1 sanatsamal       staff               22860 Feb 13 20:20 technical//biomed/1471-2334-1-24.txt
27156790       56 -rwxr-xr-x    1 sanatsamal       staff               24779 Feb 13 20:20 technical//biomed/1471-2377-2-4.txt
27157206       72 -rwxr-xr-x    1 sanatsamal       staff               33810 Feb 13 20:20 technical//biomed/gb-2002-3-9-research0046.txt
27157247       48 -rwxr-xr-x    1 sanatsamal       staff               22290 Feb 13 20:20 technical//biomed/rr74.txt
27157199       72 -rwxr-xr-x    1 sanatsamal       staff               36803 Feb 13 20:20 technical//biomed/gb-2002-3-7-research0037.txt
27157149       64 -rwxr-xr-x    1 sanatsamal       staff               32241 Feb 13 20:20 technical//biomed/gb-2001-2-8-research0027.txt
27156987       72 -rwxr-xr-x    1 sanatsamal       staff               34475 Feb 13 20:20 technical//biomed/1476-069X-2-2.txt
27156525       56 -rwxr-xr-x    1 sanatsamal       staff               28216 Feb 13 20:20 technical//biomed/1471-2148-2-15.txt
27156918       40 -rwxr-xr-x    1 sanatsamal       staff               17569 Feb 13 20:20 technical//biomed/1472-6874-2-1.txt
27156706       40 -rwxr-xr-x    1 sanatsamal       staff               20085 Feb 13 20:20 technical//biomed/1471-2210-1-8.txt
27156435       48 -rwxr-xr-x    1 sanatsamal       staff               23491 Feb 13 20:20 technical//biomed/1471-2091-3-8.txt
27156896       80 -rwxr-xr-x    1 sanatsamal       staff               38847 Feb 13 20:20 technical//biomed/1472-6793-2-8.txt
27156512       80 -rwxr-xr-x    1 sanatsamal       staff               37751 Feb 13 20:20 technical//biomed/1471-213X-2-7.txt
27156686       72 -rwxr-xr-x    1 sanatsamal       staff               36617 Feb 13 20:20 technical//biomed/1471-2202-3-20.txt
27156420       40 -rwxr-xr-x    1 sanatsamal       staff               18716 Feb 13 20:20 technical//biomed/1471-2091-2-16.txt
27157004       72 -rwxr-xr-x    1 sanatsamal       staff               33005 Feb 13 20:20 technical//biomed/1476-4598-2-25.txt
27156745       32 -rwxr-xr-x    1 sanatsamal       staff               16226 Feb 13 20:20 technical//biomed/1471-230X-2-21.txt
27157003       88 -rwxr-xr-x    1 sanatsamal       staff               42549 Feb 13 20:20 technical//biomed/1476-4598-2-24.txt
27156773       48 -rwxr-xr-x    1 sanatsamal       staff               23483 Feb 13 20:20 technical//biomed/1471-2350-2-2.txt
27157132      120 -rwxr-xr-x    1 sanatsamal       staff               59433 Feb 13 20:20 technical//biomed/gb-2001-2-11-research0046.txt
27156873       80 -rwxr-xr-x    1 sanatsamal       staff               37906 Feb 13 20:20 technical//biomed/1472-6769-1-1.txt
27157037       64 -rwxr-xr-x    1 sanatsamal       staff               32393 Feb 13 20:20 technical//biomed/ar120.txt
27156524       40 -rwxr-xr-x    1 sanatsamal       staff               16776 Feb 13 20:20 technical//biomed/1471-2148-2-14.txt
27156795       56 -rwxr-xr-x    1 sanatsamal       staff               26498 Feb 13 20:20 technical//biomed/1471-2407-1-19.txt
27157152       56 -rwxr-xr-x    1 sanatsamal       staff               25897 Feb 13 20:20 technical//biomed/gb-2001-2-8-research0032.txt
27157198      144 -rwxr-xr-x    1 sanatsamal       staff               73428 Feb 13 20:20 technical//biomed/gb-2002-3-7-research0036.txt
27156818       48 -rwxr-xr-x    1 sanatsamal       staff               22594 Feb 13 20:20 technical//biomed/1471-2415-3-1.txt
27157226       80 -rwxr-xr-x    1 sanatsamal       staff               39796 Feb 13 20:20 technical//biomed/gb-2003-4-5-r32.txt
27156862       56 -rwxr-xr-x    1 sanatsamal       staff               25697 Feb 13 20:20 technical//biomed/1472-6750-1-13.txt
27156938       48 -rwxr-xr-x    1 sanatsamal       staff               22501 Feb 13 20:20 technical//biomed/1472-6920-1-3.txt
27156849       48 -rwxr-xr-x    1 sanatsamal       staff               20548 Feb 13 20:20 technical//biomed/1471-2474-2-1.txt
27156991       48 -rwxr-xr-x    1 sanatsamal       staff               20492 Feb 13 20:20 technical//biomed/1476-0711-2-3.txt
27157241       80 -rwxr-xr-x    1 sanatsamal       staff               38006 Feb 13 20:20 technical//biomed/rr171.txt
27156546       80 -rwxr-xr-x    1 sanatsamal       staff               39328 Feb 13 20:20 technical//biomed/1471-2156-3-16.txt
27157232      128 -rwxr-xr-x    1 sanatsamal       staff               63280 Feb 13 20:20 technical//biomed/gb-2003-4-7-r43.txt
27156906       32 -rwxr-xr-x    1 sanatsamal       staff               13059 Feb 13 20:20 technical//biomed/1472-6807-2-5.txt
27156781       32 -rwxr-xr-x    1 sanatsamal       staff               13635 Feb 13 20:20 technical//biomed/1471-2350-4-4.txt
27156602       72 -rwxr-xr-x    1 sanatsamal       staff               33407 Feb 13 20:20 technical//biomed/1471-2172-1-1.txt
27157041       40 -rwxr-xr-x    1 sanatsamal       staff               18795 Feb 13 20:20 technical//biomed/ar297.txt
27156782       80 -rwxr-xr-x    1 sanatsamal       staff               39062 Feb 13 20:20 technical//biomed/1471-2350-4-6.txt
27157240       80 -rwxr-xr-x    1 sanatsamal       staff               36971 Feb 13 20:20 technical//biomed/rr167.txt
27156851       56 -rwxr-xr-x    1 sanatsamal       staff               25964 Feb 13 20:20 technical//biomed/1471-2474-2-3.txt
27156482      128 -rwxr-xr-x    1 sanatsamal       staff               62063 Feb 13 20:20 technical//biomed/1471-2121-3-15.txt
27156607       40 -rwxr-xr-x    1 sanatsamal       staff               19007 Feb 13 20:20 technical//biomed/1471-2172-3-1.txt
27156934       80 -rwxr-xr-x    1 sanatsamal       staff               38390 Feb 13 20:20 technical//biomed/1472-6904-2-4.txt
27156860       72 -rwxr-xr-x    1 sanatsamal       staff               34610 Feb 13 20:20 technical//biomed/1472-6750-1-11.txt
27157225       72 -rwxr-xr-x    1 sanatsamal       staff               36113 Feb 13 20:20 technical//biomed/gb-2003-4-5-r30.txt
27157209       88 -rwxr-xr-x    1 sanatsamal       staff               44326 Feb 13 20:20 technical//biomed/gb-2002-3-9-research0051.txt
27156819       72 -rwxr-xr-x    1 sanatsamal       staff               33886 Feb 13 20:20 technical//biomed/1471-2415-3-3.txt
27157205      120 -rwxr-xr-x    1 sanatsamal       staff               58484 Feb 13 20:20 technical//biomed/gb-2002-3-9-research0045.txt
27157150      104 -rwxr-xr-x    1 sanatsamal       staff               49958 Feb 13 20:20 technical//biomed/gb-2001-2-8-research0030.txt
27157089       88 -rwxr-xr-x    1 sanatsamal       staff               44886 Feb 13 20:20 technical//biomed/bcr631.txt
27156875       32 -rwxr-xr-x    1 sanatsamal       staff               14626 Feb 13 20:20 technical//biomed/1472-6769-1-3.txt
27157112       48 -rwxr-xr-x    1 sanatsamal       staff               22668 Feb 13 20:20 technical//biomed/cc3.txt
27156634       48 -rwxr-xr-x    1 sanatsamal       staff               21144 Feb 13 20:20 technical//biomed/1471-2180-2-32.txt
27156695       64 -rwxr-xr-x    1 sanatsamal       staff               29125 Feb 13 20:20 technical//biomed/1471-2202-4-16.txt
27156632       56 -rwxr-xr-x    1 sanatsamal       staff               24787 Feb 13 20:20 technical//biomed/1471-2180-2-26.txt
27156825       40 -rwxr-xr-x    1 sanatsamal       staff               18045 Feb 13 20:20 technical//biomed/1471-2431-2-4.txt
27156841       64 -rwxr-xr-x    1 sanatsamal       staff               31894 Feb 13 20:20 technical//biomed/1471-2458-3-2.txt
27156985       56 -rwxr-xr-x    1 sanatsamal       staff               26713 Feb 13 20:20 technical//biomed/1475-9276-1-3.txt
27157044       56 -rwxr-xr-x    1 sanatsamal       staff               24928 Feb 13 20:20 technical//biomed/ar321.txt
27156746       40 -rwxr-xr-x    1 sanatsamal       staff               19639 Feb 13 20:20 technical//biomed/1471-230X-2-23.txt
27157042       40 -rwxr-xr-x    1 sanatsamal       staff               19157 Feb 13 20:20 technical//biomed/ar309.txt
27157143       72 -rwxr-xr-x    1 sanatsamal       staff               34260 Feb 13 20:20 technical//biomed/gb-2001-2-4-research0014.txt
27157017       24 -rwxr-xr-x    1 sanatsamal       staff               12265 Feb 13 20:20 technical//biomed/1477-7819-1-10.txt
27157131       72 -rwxr-xr-x    1 sanatsamal       staff               34018 Feb 13 20:20 technical//biomed/gb-2001-2-11-research0045.txt
27156696       64 -rwxr-xr-x    1 sanatsamal       staff               29568 Feb 13 20:20 technical//biomed/1471-2202-4-17.txt
27156874       32 -rwxr-xr-x    1 sanatsamal       staff               15688 Feb 13 20:20 technical//biomed/1472-6769-1-2.txt
27157087       56 -rwxr-xr-x    1 sanatsamal       staff               24966 Feb 13 20:20 technical//biomed/bcr618.txt
27157197       96 -rwxr-xr-x    1 sanatsamal       staff               48887 Feb 13 20:20 technical//biomed/gb-2002-3-7-research0035.txt
27157151       96 -rwxr-xr-x    1 sanatsamal       staff               47386 Feb 13 20:20 technical//biomed/gb-2001-2-8-research0031.txt
27156526       96 -rwxr-xr-x    1 sanatsamal       staff               46786 Feb 13 20:20 technical//biomed/1471-2148-2-17.txt
27156719       72 -rwxr-xr-x    1 sanatsamal       staff               33066 Feb 13 20:20 technical//biomed/1471-2229-2-4.txt
27156776       96 -rwxr-xr-x    1 sanatsamal       staff               47393 Feb 13 20:20 technical//biomed/1471-2350-3-12.txt
27157204       64 -rwxr-xr-x    1 sanatsamal       staff               32469 Feb 13 20:20 technical//biomed/gb-2002-3-9-research0044.txt
27156791       40 -rwxr-xr-x    1 sanatsamal       staff               19796 Feb 13 20:20 technical//biomed/1471-2377-2-6.txt
27156854       40 -rwxr-xr-x    1 sanatsamal       staff               19899 Feb 13 20:20 technical//biomed/1471-2474-4-4.txt
27156935      176 -rwxr-xr-x    1 sanatsamal       staff               89104 Feb 13 20:20 technical//biomed/1472-6904-2-5.txt
27156912       72 -rwxr-xr-x    1 sanatsamal       staff               34387 Feb 13 20:20 technical//biomed/1472-6823-3-1.txt
27156850       56 -rwxr-xr-x    1 sanatsamal       staff               27445 Feb 13 20:20 technical//biomed/1471-2474-2-2.txt
27157239       48 -rwxr-xr-x    1 sanatsamal       staff               22439 Feb 13 20:20 technical//biomed/rr166.txt
27157242       56 -rwxr-xr-x    1 sanatsamal       staff               24900 Feb 13 20:20 technical//biomed/rr172.txt
27156542       40 -rwxr-xr-x    1 sanatsamal       staff               17411 Feb 13 20:20 technical//biomed/1471-2156-2-7.txt
27156878       48 -rwxr-xr-x    1 sanatsamal       staff               21135 Feb 13 20:20 technical//biomed/1472-6785-1-5.txt
27157071       80 -rwxr-xr-x    1 sanatsamal       staff               40398 Feb 13 20:20 technical//biomed/bcr284.txt
27157182       80 -rwxr-xr-x    1 sanatsamal       staff               38916 Feb 13 20:20 technical//biomed/gb-2002-3-2-research0008.txt
27157163      152 -rwxr-xr-x    1 sanatsamal       staff               74234 Feb 13 20:20 technical//biomed/gb-2002-3-11-research0059.txt
27157110       40 -rwxr-xr-x    1 sanatsamal       staff               20124 Feb 13 20:20 technical//biomed/cc2190.txt
27157167      104 -rwxr-xr-x    1 sanatsamal       staff               51918 Feb 13 20:20 technical//biomed/gb-2002-3-11-research0065.txt
27156514       56 -rwxr-xr-x    1 sanatsamal       staff               26809 Feb 13 20:20 technical//biomed/1471-213X-3-2.txt
27156532       64 -rwxr-xr-x    1 sanatsamal       staff               29059 Feb 13 20:20 technical//biomed/1471-2148-3-18.txt
27156722       32 -rwxr-xr-x    1 sanatsamal       staff               15141 Feb 13 20:20 technical//biomed/1471-2229-3-3.txt
27156614       56 -rwxr-xr-x    1 sanatsamal       staff               27888 Feb 13 20:20 technical//biomed/1471-2172-4-1.txt
27157067       56 -rwxr-xr-x    1 sanatsamal       staff               27719 Feb 13 20:20 technical//biomed/ar795.txt
27156565       48 -rwxr-xr-x    1 sanatsamal       staff               22329 Feb 13 20:20 technical//biomed/1471-2164-3-15.txt
27157102       40 -rwxr-xr-x    1 sanatsamal       staff               16482 Feb 13 20:20 technical//biomed/cc1843.txt
27156574       48 -rwxr-xr-x    1 sanatsamal       staff               22442 Feb 13 20:20 technical//biomed/1471-2164-3-29.txt
27156834       56 -rwxr-xr-x    1 sanatsamal       staff               26515 Feb 13 20:20 technical//biomed/1471-2458-2-16.txt
27156978       88 -rwxr-xr-x    1 sanatsamal       staff               41765 Feb 13 20:20 technical//biomed/1475-925X-2-10.txt
27156908      144 -rwxr-xr-x    1 sanatsamal       staff               73091 Feb 13 20:20 technical//biomed/1472-6807-3-1.txt
27157237       56 -rwxr-xr-x    1 sanatsamal       staff               27080 Feb 13 20:20 technical//biomed/gb-2003-4-9-r58.txt
27156464       48 -rwxr-xr-x    1 sanatsamal       staff               23355 Feb 13 20:20 technical//biomed/1471-2105-4-27.txt
27156442       48 -rwxr-xr-x    1 sanatsamal       staff               21074 Feb 13 20:20 technical//biomed/1471-2105-3-12.txt
27157216       64 -rwxr-xr-x    1 sanatsamal       staff               32489 Feb 13 20:20 technical//biomed/gb-2003-4-2-r16.txt
27157050       56 -rwxr-xr-x    1 sanatsamal       staff               26013 Feb 13 20:20 technical//biomed/ar408.txt
27157051       56 -rwxr-xr-x    1 sanatsamal       staff               27953 Feb 13 20:20 technical//biomed/ar409.txt
27156797       64 -rwxr-xr-x    1 sanatsamal       staff               30455 Feb 13 20:20 technical//biomed/1471-2407-2-11.txt
27157129       72 -rwxr-xr-x    1 sanatsamal       staff               36125 Feb 13 20:20 technical//biomed/gb-2001-2-10-research0041.txt
27156734       80 -rwxr-xr-x    1 sanatsamal       staff               39781 Feb 13 20:20 technical//biomed/1471-2288-3-4.txt
27156463       64 -rwxr-xr-x    1 sanatsamal       staff               29786 Feb 13 20:20 technical//biomed/1471-2105-4-26.txt
27156741       48 -rwxr-xr-x    1 sanatsamal       staff               22520 Feb 13 20:20 technical//biomed/1471-230X-1-5.txt
27157202       56 -rwxr-xr-x    1 sanatsamal       staff               25182 Feb 13 20:20 technical//biomed/gb-2002-3-8-research0040.txt
27156979       40 -rwxr-xr-x    1 sanatsamal       staff               17188 Feb 13 20:20 technical//biomed/1475-925X-2-11.txt
27157153       48 -rwxr-xr-x    1 sanatsamal       staff               22853 Feb 13 20:20 technical//biomed/gb-2001-2-9-research0035.txt
27156609       72 -rwxr-xr-x    1 sanatsamal       staff               33309 Feb 13 20:20 technical//biomed/1471-2172-3-12.txt
27157228       88 -rwxr-xr-x    1 sanatsamal       staff               41587 Feb 13 20:20 technical//biomed/gb-2003-4-6-r37.txt
27156864       48 -rwxr-xr-x    1 sanatsamal       staff               24163 Feb 13 20:20 technical//biomed/1472-6750-1-8.txt
27156830       64 -rwxr-xr-x    1 sanatsamal       staff               32110 Feb 13 20:20 technical//biomed/1471-244X-2-9.txt
27157178       96 -rwxr-xr-x    1 sanatsamal       staff               48768 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0085.txt
27156500       40 -rwxr-xr-x    1 sanatsamal       staff               16722 Feb 13 20:20 technical//biomed/1471-213X-1-1.txt
27156592       80 -rwxr-xr-x    1 sanatsamal       staff               40895 Feb 13 20:20 technical//biomed/1471-2164-4-21.txt
27157104       40 -rwxr-xr-x    1 sanatsamal       staff               17889 Feb 13 20:20 technical//biomed/cc1856.txt
27156641       80 -rwxr-xr-x    1 sanatsamal       staff               39977 Feb 13 20:20 technical//biomed/1471-2180-3-15.txt
27156573       80 -rwxr-xr-x    1 sanatsamal       staff               39250 Feb 13 20:20 technical//biomed/1471-2164-3-28.txt
27157093       48 -rwxr-xr-x    1 sanatsamal       staff               21650 Feb 13 20:20 technical//biomed/cc105.txt
27156663       32 -rwxr-xr-x    1 sanatsamal       staff               16156 Feb 13 20:20 technical//biomed/1471-2202-2-10.txt
27156625       72 -rwxr-xr-x    1 sanatsamal       staff               35320 Feb 13 20:20 technical//biomed/1471-2180-1-8.txt
27156826       56 -rwxr-xr-x    1 sanatsamal       staff               25954 Feb 13 20:20 technical//biomed/1471-2431-3-3.txt
27156784       48 -rwxr-xr-x    1 sanatsamal       staff               22598 Feb 13 20:20 technical//biomed/1471-2369-3-10.txt
27156515      112 -rwxr-xr-x    1 sanatsamal       staff               55468 Feb 13 20:20 technical//biomed/1471-213X-3-3.txt
27157098       48 -rwxr-xr-x    1 sanatsamal       staff               23920 Feb 13 20:20 technical//biomed/cc1498.txt
27156789       32 -rwxr-xr-x    1 sanatsamal       staff               16023 Feb 13 20:20 technical//biomed/1471-2377-1-2.txt
27156777       40 -rwxr-xr-x    1 sanatsamal       staff               18161 Feb 13 20:20 technical//biomed/1471-2350-3-7.txt
27157183       48 -rwxr-xr-x    1 sanatsamal       staff               22813 Feb 13 20:20 technical//biomed/gb-2002-3-2-research0009.txt
27157072       72 -rwxr-xr-x    1 sanatsamal       staff               35311 Feb 13 20:20 technical//biomed/bcr285.txt
27157195       72 -rwxr-xr-x    1 sanatsamal       staff               34079 Feb 13 20:20 technical//biomed/gb-2002-3-6-software0001.txt
27156963       72 -rwxr-xr-x    1 sanatsamal       staff               34655 Feb 13 20:20 technical//biomed/1475-2867-3-12.txt
27156715       56 -rwxr-xr-x    1 sanatsamal       staff               25656 Feb 13 20:20 technical//biomed/1471-2229-1-2.txt
27156815       80 -rwxr-xr-x    1 sanatsamal       staff               39297 Feb 13 20:20 technical//biomed/1471-2407-3-3.txt
27156930       88 -rwxr-xr-x    1 sanatsamal       staff               42977 Feb 13 20:20 technical//biomed/1472-6890-1-4.txt
27156615       56 -rwxr-xr-x    1 sanatsamal       staff               28351 Feb 13 20:20 technical//biomed/1471-2172-4-2.txt
27156566       56 -rwxr-xr-x    1 sanatsamal       staff               27283 Feb 13 20:20 technical//biomed/1471-2164-3-16.txt
27156429       80 -rwxr-xr-x    1 sanatsamal       staff               40558 Feb 13 20:20 technical//biomed/1471-2091-3-18.txt
27156664       64 -rwxr-xr-x    1 sanatsamal       staff               29596 Feb 13 20:20 technical//biomed/1471-2202-2-12.txt
27156594       64 -rwxr-xr-x    1 sanatsamal       staff               31625 Feb 13 20:20 technical//biomed/1471-2164-4-23.txt
27156507       80 -rwxr-xr-x    1 sanatsamal       staff               39354 Feb 13 20:20 technical//biomed/1471-213X-1-3.txt
27157180       96 -rwxr-xr-x    1 sanatsamal       staff               46321 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0087.txt
27156432       72 -rwxr-xr-x    1 sanatsamal       staff               34168 Feb 13 20:20 technical//biomed/1471-2091-3-30.txt
27157172       72 -rwxr-xr-x    1 sanatsamal       staff               34732 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0078.txt
27156585       64 -rwxr-xr-x    1 sanatsamal       staff               29123 Feb 13 20:20 technical//biomed/1471-2164-3-9.txt
27156608       80 -rwxr-xr-x    1 sanatsamal       staff               40190 Feb 13 20:20 technical//biomed/1471-2172-3-10.txt
27156605       72 -rwxr-xr-x    1 sanatsamal       staff               35974 Feb 13 20:20 technical//biomed/1471-2172-2-4.txt
27156616       72 -rwxr-xr-x    1 sanatsamal       staff               36285 Feb 13 20:20 technical//biomed/1471-2180-1-12.txt
27157144       88 -rwxr-xr-x    1 sanatsamal       staff               42611 Feb 13 20:20 technical//biomed/gb-2001-2-6-research0018.txt
27157154       88 -rwxr-xr-x    1 sanatsamal       staff               44019 Feb 13 20:20 technical//biomed/gb-2001-2-9-research0037.txt
27156441       56 -rwxr-xr-x    1 sanatsamal       staff               25632 Feb 13 20:20 technical//biomed/1471-2105-2-9.txt
27156937      128 -rwxr-xr-x    1 sanatsamal       staff               63901 Feb 13 20:20 technical//biomed/1472-6904-3-1.txt
27156889       64 -rwxr-xr-x    1 sanatsamal       staff               29048 Feb 13 20:20 technical//biomed/1472-6793-2-16.txt
27156909       40 -rwxr-xr-x    1 sanatsamal       staff               20394 Feb 13 20:20 technical//biomed/1472-6807-3-2.txt
27156994      104 -rwxr-xr-x    1 sanatsamal       staff               51827 Feb 13 20:20 technical//biomed/1476-072X-2-4.txt
27156473       80 -rwxr-xr-x    1 sanatsamal       staff               39018 Feb 13 20:20 technical//biomed/1471-2121-2-18.txt
27156530       72 -rwxr-xr-x    1 sanatsamal       staff               34954 Feb 13 20:20 technical//biomed/1471-2148-2-8.txt
27156461       64 -rwxr-xr-x    1 sanatsamal       staff               31885 Feb 13 20:20 technical//biomed/1471-2105-4-24.txt
27156549       48 -rwxr-xr-x    1 sanatsamal       staff               21552 Feb 13 20:20 technical//biomed/1471-2156-3-3.txt
27156846       72 -rwxr-xr-x    1 sanatsamal       staff               34691 Feb 13 20:20 technical//biomed/1471-2466-2-3.txt
27156748       48 -rwxr-xr-x    1 sanatsamal       staff               21842 Feb 13 20:20 technical//biomed/1471-230X-3-5.txt
27156798       40 -rwxr-xr-x    1 sanatsamal       staff               18959 Feb 13 20:20 technical//biomed/1471-2407-2-12.txt
27157215      112 -rwxr-xr-x    1 sanatsamal       staff               55514 Feb 13 20:20 technical//biomed/gb-2003-4-2-r14.txt
27156933       64 -rwxr-xr-x    1 sanatsamal       staff               29304 Feb 13 20:20 technical//biomed/1472-6904-1-2.txt
27157100       64 -rwxr-xr-x    1 sanatsamal       staff               29974 Feb 13 20:20 technical//biomed/cc1538.txt
27156462       40 -rwxr-xr-x    1 sanatsamal       staff               20276 Feb 13 20:20 technical//biomed/1471-2105-4-25.txt
27156457       64 -rwxr-xr-x    1 sanatsamal       staff               32376 Feb 13 20:20 technical//biomed/1471-2105-3-38.txt
27157052       64 -rwxr-xr-x    1 sanatsamal       staff               31030 Feb 13 20:20 technical//biomed/ar422.txt
27157130       88 -rwxr-xr-x    1 sanatsamal       staff               44791 Feb 13 20:20 technical//biomed/gb-2001-2-10-research0042.txt
27156466       56 -rwxr-xr-x    1 sanatsamal       staff               27649 Feb 13 20:20 technical//biomed/1471-2105-4-31.txt
27156914       64 -rwxr-xr-x    1 sanatsamal       staff               30221 Feb 13 20:20 technical//biomed/1472-6831-3-1.txt
27157048       40 -rwxr-xr-x    1 sanatsamal       staff               18845 Feb 13 20:20 technical//biomed/ar387.txt
27156742       32 -rwxr-xr-x    1 sanatsamal       staff               13669 Feb 13 20:20 technical//biomed/1471-230X-1-6.txt
27156890       56 -rwxr-xr-x    1 sanatsamal       staff               25629 Feb 13 20:20 technical//biomed/1472-6793-2-17.txt
27156539       80 -rwxr-xr-x    1 sanatsamal       staff               37452 Feb 13 20:20 technical//biomed/1471-2156-2-18.txt
27156440      136 -rwxr-xr-x    1 sanatsamal       staff               68152 Feb 13 20:20 technical//biomed/1471-2105-2-8.txt
27156980       48 -rwxr-xr-x    1 sanatsamal       staff               23897 Feb 13 20:20 technical//biomed/1475-925X-2-12.txt
27157034       72 -rwxr-xr-x    1 sanatsamal       staff               33145 Feb 13 20:20 technical//biomed/1478-7954-1-3.txt
27156901       40 -rwxr-xr-x    1 sanatsamal       staff               17081 Feb 13 20:20 technical//biomed/1472-6807-1-1.txt
27157105       48 -rwxr-xr-x    1 sanatsamal       staff               23617 Feb 13 20:20 technical//biomed/cc1882.txt
27156584       72 -rwxr-xr-x    1 sanatsamal       staff               32805 Feb 13 20:20 technical//biomed/1471-2164-3-8.txt
27156644       72 -rwxr-xr-x    1 sanatsamal       staff               35916 Feb 13 20:20 technical//biomed/1471-2180-3-9.txt
27157173      120 -rwxr-xr-x    1 sanatsamal       staff               59919 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0079.txt
27156433      112 -rwxr-xr-x    1 sanatsamal       staff               56000 Feb 13 20:20 technical//biomed/1471-2091-3-31.txt
27157179      168 -rwxr-xr-x    1 sanatsamal       staff               83990 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0086.txt
27156593       72 -rwxr-xr-x    1 sanatsamal       staff               35306 Feb 13 20:20 technical//biomed/1471-2164-4-22.txt
27156506       88 -rwxr-xr-x    1 sanatsamal       staff               42612 Feb 13 20:20 technical//biomed/1471-213X-1-2.txt
27156691       56 -rwxr-xr-x    1 sanatsamal       staff               26090 Feb 13 20:20 technical//biomed/1471-2202-3-8.txt
27156839       64 -rwxr-xr-x    1 sanatsamal       staff               31785 Feb 13 20:20 technical//biomed/1471-2458-2-6.txt
27157027       56 -rwxr-xr-x    1 sanatsamal       staff               25856 Feb 13 20:20 technical//biomed/1477-7827-1-48.txt
27156716       40 -rwxr-xr-x    1 sanatsamal       staff               20162 Feb 13 20:20 technical//biomed/1471-2229-1-3.txt
27156516       96 -rwxr-xr-x    1 sanatsamal       staff               48262 Feb 13 20:20 technical//biomed/1471-213X-3-4.txt
27157113       48 -rwxr-xr-x    1 sanatsamal       staff               23472 Feb 13 20:20 technical//biomed/cc300.txt
27156986       56 -rwxr-xr-x    1 sanatsamal       staff               26286 Feb 13 20:20 technical//biomed/1476-069X-1-3.txt
27156723       40 -rwxr-xr-x    1 sanatsamal       staff               17890 Feb 13 20:20 technical//biomed/1471-2253-1-1.txt
27156827       72 -rwxr-xr-x    1 sanatsamal       staff               36152 Feb 13 20:20 technical//biomed/1471-2431-3-4.txt
27156712       48 -rwxr-xr-x    1 sanatsamal       staff               21547 Feb 13 20:20 technical//biomed/1471-2210-2-9.txt
27157176       88 -rwxr-xr-x    1 sanatsamal       staff               42932 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0082.txt
27156509       80 -rwxr-xr-x    1 sanatsamal       staff               37943 Feb 13 20:20 technical//biomed/1471-213X-1-6.txt
27156597       64 -rwxr-xr-x    1 sanatsamal       staff               31252 Feb 13 20:20 technical//biomed/1471-2164-4-26.txt
27156564       56 -rwxr-xr-x    1 sanatsamal       staff               25132 Feb 13 20:20 technical//biomed/1471-2164-3-13.txt
27156668       64 -rwxr-xr-x    1 sanatsamal       staff               29890 Feb 13 20:20 technical//biomed/1471-2202-2-17.txt
27156921       40 -rwxr-xr-x    1 sanatsamal       staff               18530 Feb 13 20:20 technical//biomed/1472-6874-3-2.txt
27157064       80 -rwxr-xr-x    1 sanatsamal       staff               39259 Feb 13 20:20 technical//biomed/ar778.txt
27157062       40 -rwxr-xr-x    1 sanatsamal       staff               18059 Feb 13 20:20 technical//biomed/ar750.txt
27156853       48 -rwxr-xr-x    1 sanatsamal       staff               20593 Feb 13 20:20 technical//biomed/1471-2474-3-3.txt
27156879       56 -rwxr-xr-x    1 sanatsamal       staff               25115 Feb 13 20:20 technical//biomed/1472-6785-2-6.txt
27156856       16 -rwxr-xr-x    1 sanatsamal       staff                6804 Feb 13 20:20 technical//biomed/1471-2490-3-2.txt
27157030       96 -rwxr-xr-x    1 sanatsamal       staff               45807 Feb 13 20:20 technical//biomed/1477-7827-1-9.txt
27157146       72 -rwxr-xr-x    1 sanatsamal       staff               36620 Feb 13 20:20 technical//biomed/gb-2001-2-6-research0021.txt
27157059       56 -rwxr-xr-x    1 sanatsamal       staff               25700 Feb 13 20:20 technical//biomed/ar624.txt
27156474       64 -rwxr-xr-x    1 sanatsamal       staff               29502 Feb 13 20:20 technical//biomed/1471-2121-2-21.txt
27156940       40 -rwxr-xr-x    1 sanatsamal       staff               19761 Feb 13 20:20 technical//biomed/1472-6920-2-3.txt
27157047       32 -rwxr-xr-x    1 sanatsamal       staff               14731 Feb 13 20:20 technical//biomed/ar383.txt
27156443      112 -rwxr-xr-x    1 sanatsamal       staff               54441 Feb 13 20:20 technical//biomed/1471-2105-3-14.txt
27156800       48 -rwxr-xr-x    1 sanatsamal       staff               23819 Feb 13 20:20 technical//biomed/1471-2407-2-16.txt
27156452       80 -rwxr-xr-x    1 sanatsamal       staff               38482 Feb 13 20:20 technical//biomed/1471-2105-3-28.txt
27157214       88 -rwxr-xr-x    1 sanatsamal       staff               42624 Feb 13 20:20 technical//biomed/gb-2003-4-2-r11.txt
27157099       56 -rwxr-xr-x    1 sanatsamal       staff               25108 Feb 13 20:20 technical//biomed/cc1529.txt
27156801       96 -rwxr-xr-x    1 sanatsamal       staff               45137 Feb 13 20:20 technical//biomed/1471-2407-2-17.txt
27156910       64 -rwxr-xr-x    1 sanatsamal       staff               32679 Feb 13 20:20 technical//biomed/1472-6815-2-3.txt
27157058       40 -rwxr-xr-x    1 sanatsamal       staff               19149 Feb 13 20:20 technical//biomed/ar619.txt
27156833       56 -rwxr-xr-x    1 sanatsamal       staff               26761 Feb 13 20:20 technical//biomed/1471-2458-2-11.txt
27157145       56 -rwxr-xr-x    1 sanatsamal       staff               27074 Feb 13 20:20 technical//biomed/gb-2001-2-6-research0020.txt
27156880       80 -rwxr-xr-x    1 sanatsamal       staff               40558 Feb 13 20:20 technical//biomed/1472-6785-2-7.txt
27156617       56 -rwxr-xr-x    1 sanatsamal       staff               27490 Feb 13 20:20 technical//biomed/1471-2180-1-16.txt
27157061       56 -rwxr-xr-x    1 sanatsamal       staff               27848 Feb 13 20:20 technical//biomed/ar745.txt
27156932       72 -rwxr-xr-x    1 sanatsamal       staff               34258 Feb 13 20:20 technical//biomed/1472-6890-3-2.txt
27157091       64 -rwxr-xr-x    1 sanatsamal       staff               30360 Feb 13 20:20 technical//biomed/cc103.txt
27156667       72 -rwxr-xr-x    1 sanatsamal       staff               32894 Feb 13 20:20 technical//biomed/1471-2202-2-16.txt
27157066       56 -rwxr-xr-x    1 sanatsamal       staff               25237 Feb 13 20:20 technical//biomed/ar792.txt
27157177      176 -rwxr-xr-x    1 sanatsamal       staff               88698 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0083.txt
27156640       64 -rwxr-xr-x    1 sanatsamal       staff               31355 Feb 13 20:20 technical//biomed/1471-2180-3-13.txt
27156711       56 -rwxr-xr-x    1 sanatsamal       staff               25317 Feb 13 20:20 technical//biomed/1471-2210-2-8.txt
27156886       88 -rwxr-xr-x    1 sanatsamal       staff               42284 Feb 13 20:20 technical//biomed/1472-6793-1-8.txt
27156838       64 -rwxr-xr-x    1 sanatsamal       staff               29911 Feb 13 20:20 technical//biomed/1471-2458-2-3.txt
27156869       64 -rwxr-xr-x    1 sanatsamal       staff               31607 Feb 13 20:20 technical//biomed/1472-6750-2-21.txt
27156828       72 -rwxr-xr-x    1 sanatsamal       staff               34936 Feb 13 20:20 technical//biomed/1471-2431-3-5.txt
27156926       48 -rwxr-xr-x    1 sanatsamal       staff               21093 Feb 13 20:20 technical//biomed/1472-6882-2-10.txt
27156775       96 -rwxr-xr-x    1 sanatsamal       staff               48211 Feb 13 20:20 technical//biomed/1471-2350-3-1.txt
27157166       88 -rwxr-xr-x    1 sanatsamal       staff               44323 Feb 13 20:20 technical//biomed/gb-2002-3-11-research0062.txt
27156927       32 -rwxr-xr-x    1 sanatsamal       staff               15301 Feb 13 20:20 technical//biomed/1472-6882-2-5.txt
27157164       56 -rwxr-xr-x    1 sanatsamal       staff               27931 Feb 13 20:20 technical//biomed/gb-2002-3-11-research0060.txt
27156517       72 -rwxr-xr-x    1 sanatsamal       staff               34190 Feb 13 20:20 technical//biomed/1471-213X-3-7.txt
27157114       64 -rwxr-xr-x    1 sanatsamal       staff               32569 Feb 13 20:20 technical//biomed/cc303.txt
27157095       48 -rwxr-xr-x    1 sanatsamal       staff               22286 Feb 13 20:20 technical//biomed/cc1477.txt
27156817       48 -rwxr-xr-x    1 sanatsamal       staff               24515 Feb 13 20:20 technical//biomed/1471-2407-3-5.txt
27156792      104 -rwxr-xr-x    1 sanatsamal       staff               50740 Feb 13 20:20 technical//biomed/1471-2377-3-4.txt
27156639       80 -rwxr-xr-x    1 sanatsamal       staff               37919 Feb 13 20:20 technical//biomed/1471-2180-3-11.txt
27157175       88 -rwxr-xr-x    1 sanatsamal       staff               41121 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0081.txt
27157103       64 -rwxr-xr-x    1 sanatsamal       staff               31319 Feb 13 20:20 technical//biomed/cc1852.txt
27156596       40 -rwxr-xr-x    1 sanatsamal       staff               20338 Feb 13 20:20 technical//biomed/1471-2164-4-25.txt
27156430       80 -rwxr-xr-x    1 sanatsamal       staff               40379 Feb 13 20:20 technical//biomed/1471-2091-3-22.txt
27156665       48 -rwxr-xr-x    1 sanatsamal       staff               23188 Feb 13 20:20 technical//biomed/1471-2202-2-14.txt
27156563       40 -rwxr-xr-x    1 sanatsamal       staff               18841 Feb 13 20:20 technical//biomed/1471-2164-3-10.txt
27156590       64 -rwxr-xr-x    1 sanatsamal       staff               31181 Feb 13 20:20 technical//biomed/1471-2164-4-19.txt
27157119       32 -rwxr-xr-x    1 sanatsamal       staff               12557 Feb 13 20:20 technical//biomed/cc713.txt
27156610       88 -rwxr-xr-x    1 sanatsamal       staff               41490 Feb 13 20:20 technical//biomed/1471-2172-3-16.txt
27156619       56 -rwxr-xr-x    1 sanatsamal       staff               26000 Feb 13 20:20 technical//biomed/1471-2180-1-28.txt
27156740       56 -rwxr-xr-x    1 sanatsamal       staff               25804 Feb 13 20:20 technical//biomed/1471-230X-1-10.txt
27156475       56 -rwxr-xr-x    1 sanatsamal       staff               26337 Feb 13 20:20 technical//biomed/1471-2121-2-22.txt
27156761       56 -rwxr-xr-x    1 sanatsamal       staff               25529 Feb 13 20:20 technical//biomed/1471-2334-2-29.txt
27156493       56 -rwxr-xr-x    1 sanatsamal       staff               25531 Feb 13 20:20 technical//biomed/1471-2121-3-8.txt
27156950       56 -rwxr-xr-x    1 sanatsamal       staff               27938 Feb 13 20:20 technical//biomed/1472-6963-1-8.txt
27156738       48 -rwxr-xr-x    1 sanatsamal       staff               23589 Feb 13 20:20 technical//biomed/1471-2296-3-19.txt
27156799       56 -rwxr-xr-x    1 sanatsamal       staff               28027 Feb 13 20:20 technical//biomed/1471-2407-2-15.txt
27156445       96 -rwxr-xr-x    1 sanatsamal       staff               47239 Feb 13 20:20 technical//biomed/1471-2105-3-17.txt
27156747       48 -rwxr-xr-x    1 sanatsamal       staff               21061 Feb 13 20:20 technical//biomed/1471-230X-3-3.txt
27157054       40 -rwxr-xr-x    1 sanatsamal       staff               17933 Feb 13 20:20 technical//biomed/ar430.txt
27156550       96 -rwxr-xr-x    1 sanatsamal       staff               46131 Feb 13 20:20 technical//biomed/1471-2156-3-4.txt
27156847       48 -rwxr-xr-x    1 sanatsamal       staff               20589 Feb 13 20:20 technical//biomed/1471-2466-2-4.txt
27156737       64 -rwxr-xr-x    1 sanatsamal       staff               31087 Feb 13 20:20 technical//biomed/1471-2296-3-18.txt
27156444       80 -rwxr-xr-x    1 sanatsamal       staff               37446 Feb 13 20:20 technical//biomed/1471-2105-3-16.txt
27156939       72 -rwxr-xr-x    1 sanatsamal       staff               32906 Feb 13 20:20 technical//biomed/1472-6920-2-1.txt
27156993       64 -rwxr-xr-x    1 sanatsamal       staff               29768 Feb 13 20:20 technical//biomed/1476-072X-2-3.txt
27157238       56 -rwxr-xr-x    1 sanatsamal       staff               27689 Feb 13 20:20 technical//biomed/gb-2003-4-9-r60.txt
27157039       80 -rwxr-xr-x    1 sanatsamal       staff               38211 Feb 13 20:20 technical//biomed/ar140.txt
27157219      104 -rwxr-xr-x    1 sanatsamal       staff               52824 Feb 13 20:20 technical//biomed/gb-2003-4-3-r17.txt
27156888       80 -rwxr-xr-x    1 sanatsamal       staff               37722 Feb 13 20:20 technical//biomed/1472-6793-2-11.txt
27156911       40 -rwxr-xr-x    1 sanatsamal       staff               19040 Feb 13 20:20 technical//biomed/1472-6823-2-2.txt
27156620       64 -rwxr-xr-x    1 sanatsamal       staff               30845 Feb 13 20:20 technical//biomed/1471-2180-1-29.txt
27156604       96 -rwxr-xr-x    1 sanatsamal       staff               46108 Feb 13 20:20 technical//biomed/1471-2172-2-3.txt
27156796       48 -rwxr-xr-x    1 sanatsamal       staff               21314 Feb 13 20:20 technical//biomed/1471-2407-1-6.txt
27156423       56 -rwxr-xr-x    1 sanatsamal       staff               25298 Feb 13 20:20 technical//biomed/1471-2091-2-9.txt
27156666       56 -rwxr-xr-x    1 sanatsamal       staff               28119 Feb 13 20:20 technical//biomed/1471-2202-2-15.txt
27156431       72 -rwxr-xr-x    1 sanatsamal       staff               33815 Feb 13 20:20 technical//biomed/1471-2091-3-23.txt
27156595       56 -rwxr-xr-x    1 sanatsamal       staff               26222 Feb 13 20:20 technical//biomed/1471-2164-4-24.txt
27156508       40 -rwxr-xr-x    1 sanatsamal       staff               18068 Feb 13 20:20 technical//biomed/1471-213X-1-4.txt
27157174       64 -rwxr-xr-x    1 sanatsamal       staff               28874 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0080.txt
27156638       64 -rwxr-xr-x    1 sanatsamal       staff               30027 Feb 13 20:20 technical//biomed/1471-2180-3-10.txt
27157094       56 -rwxr-xr-x    1 sanatsamal       staff               26600 Feb 13 20:20 technical//biomed/cc1476.txt
27156816       56 -rwxr-xr-x    1 sanatsamal       staff               25661 Feb 13 20:20 technical//biomed/1471-2407-3-4.txt
27156829       48 -rwxr-xr-x    1 sanatsamal       staff               22131 Feb 13 20:20 technical//biomed/1471-2431-3-6.txt
27157073       56 -rwxr-xr-x    1 sanatsamal       staff               25685 Feb 13 20:20 technical//biomed/bcr294.txt
27157165       56 -rwxr-xr-x    1 sanatsamal       staff               26586 Feb 13 20:20 technical//biomed/gb-2002-3-11-research0061.txt
27157025       80 -rwxr-xr-x    1 sanatsamal       staff               39369 Feb 13 20:20 technical//biomed/1477-7827-1-43.txt
27156959       56 -rwxr-xr-x    1 sanatsamal       staff               25725 Feb 13 20:20 technical//biomed/1475-2832-1-1.txt
27156655       64 -rwxr-xr-x    1 sanatsamal       staff               30440 Feb 13 20:20 technical//biomed/1471-2199-3-12.txt
27156661       48 -rwxr-xr-x    1 sanatsamal       staff               20783 Feb 13 20:20 technical//biomed/1471-2202-1-1.txt
27156866       40 -rwxr-xr-x    1 sanatsamal       staff               19066 Feb 13 20:20 technical//biomed/1472-6750-2-13.txt
27157109       48 -rwxr-xr-x    1 sanatsamal       staff               20745 Feb 13 20:20 technical//biomed/cc2172.txt
27156885       40 -rwxr-xr-x    1 sanatsamal       staff               19300 Feb 13 20:20 technical//biomed/1472-6793-1-6.txt
27156710       72 -rwxr-xr-x    1 sanatsamal       staff               35907 Feb 13 20:20 technical//biomed/1471-2210-2-6.txt
27156510       80 -rwxr-xr-x    1 sanatsamal       staff               37729 Feb 13 20:20 technical//biomed/1471-213X-1-9.txt
27156579       48 -rwxr-xr-x    1 sanatsamal       staff               20958 Feb 13 20:20 technical//biomed/1471-2164-3-34.txt
27156588       56 -rwxr-xr-x    1 sanatsamal       staff               26254 Feb 13 20:20 technical//biomed/1471-2164-4-15.txt
27156687       72 -rwxr-xr-x    1 sanatsamal       staff               35079 Feb 13 20:20 technical//biomed/1471-2202-3-3.txt
27156669       40 -rwxr-xr-x    1 sanatsamal       staff               20061 Feb 13 20:20 technical//biomed/1471-2202-2-18.txt
27157111       40 -rwxr-xr-x    1 sanatsamal       staff               18512 Feb 13 20:20 technical//biomed/cc2358.txt
27156898       56 -rwxr-xr-x    1 sanatsamal       staff               26409 Feb 13 20:20 technical//biomed/1472-6793-3-4.txt
27157169      112 -rwxr-xr-x    1 sanatsamal       staff               56348 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0072.txt
27156953       40 -rwxr-xr-x    1 sanatsamal       staff               16645 Feb 13 20:20 technical//biomed/1472-6963-3-11.txt
27156957       56 -rwxr-xr-x    1 sanatsamal       staff               27276 Feb 13 20:20 technical//biomed/1472-6963-3-6.txt
27157006       32 -rwxr-xr-x    1 sanatsamal       staff               15618 Feb 13 20:20 technical//biomed/1476-4598-2-3.txt
27157029       48 -rwxr-xr-x    1 sanatsamal       staff               20506 Feb 13 20:20 technical//biomed/1477-7827-1-6.txt
27156975      128 -rwxr-xr-x    1 sanatsamal       staff               62700 Feb 13 20:20 technical//biomed/1475-4924-1-10.txt
27156919       56 -rwxr-xr-x    1 sanatsamal       staff               27708 Feb 13 20:20 technical//biomed/1472-6874-2-13.txt
27156788       40 -rwxr-xr-x    1 sanatsamal       staff               18617 Feb 13 20:20 technical//biomed/1471-2369-4-5.txt
27156491       96 -rwxr-xr-x    1 sanatsamal       staff               48187 Feb 13 20:20 technical//biomed/1471-2121-3-4.txt
27156471       56 -rwxr-xr-x    1 sanatsamal       staff               26002 Feb 13 20:20 technical//biomed/1471-2121-2-12.txt
27156527       56 -rwxr-xr-x    1 sanatsamal       staff               24898 Feb 13 20:20 technical//biomed/1471-2148-2-2.txt
27156982       80 -rwxr-xr-x    1 sanatsamal       staff               39964 Feb 13 20:20 technical//biomed/1475-925X-2-6.txt
27156519       64 -rwxr-xr-x    1 sanatsamal       staff               29403 Feb 13 20:20 technical//biomed/1471-2148-1-14.txt
27156803       64 -rwxr-xr-x    1 sanatsamal       staff               29550 Feb 13 20:20 technical//biomed/1471-2407-2-19.txt
27156707       72 -rwxr-xr-x    1 sanatsamal       staff               35701 Feb 13 20:20 technical//biomed/1471-2210-2-14.txt
27156966       72 -rwxr-xr-x    1 sanatsamal       staff               36377 Feb 13 20:20 technical//biomed/1475-2867-3-4.txt
27157053       40 -rwxr-xr-x    1 sanatsamal       staff               18681 Feb 13 20:20 technical//biomed/ar429.txt
27156807       40 -rwxr-xr-x    1 sanatsamal       staff               19545 Feb 13 20:20 technical//biomed/1471-2407-2-31.txt
27156451       64 -rwxr-xr-x    1 sanatsamal       staff               31764 Feb 13 20:20 technical//biomed/1471-2105-3-26.txt
27157015       40 -rwxr-xr-x    1 sanatsamal       staff               17188 Feb 13 20:20 technical//biomed/1477-7525-1-12.txt
27156802       56 -rwxr-xr-x    1 sanatsamal       staff               26749 Feb 13 20:20 technical//biomed/1471-2407-2-18.txt
27156460       80 -rwxr-xr-x    1 sanatsamal       staff               37814 Feb 13 20:20 technical//biomed/1471-2105-4-13.txt
27157212       96 -rwxr-xr-x    1 sanatsamal       staff               46030 Feb 13 20:20 technical//biomed/gb-2003-4-1-r5.txt
27156758       64 -rwxr-xr-x    1 sanatsamal       staff               32166 Feb 13 20:20 technical//biomed/1471-2334-2-24.txt
27156749       72 -rwxr-xr-x    1 sanatsamal       staff               33364 Feb 13 20:20 technical//biomed/1471-2318-3-2.txt
27156537       72 -rwxr-xr-x    1 sanatsamal       staff               36043 Feb 13 20:20 technical//biomed/1471-2156-2-12.txt
27156621       64 -rwxr-xr-x    1 sanatsamal       staff               29292 Feb 13 20:20 technical//biomed/1471-2180-1-31.txt
27157000       32 -rwxr-xr-x    1 sanatsamal       staff               15818 Feb 13 20:20 technical//biomed/1476-4598-2-2.txt
27156916       56 -rwxr-xr-x    1 sanatsamal       staff               24653 Feb 13 20:20 technical//biomed/1472-684X-2-1.txt
27156859       32 -rwxr-xr-x    1 sanatsamal       staff               12826 Feb 13 20:20 technical//biomed/1471-5945-3-3.txt
27156958       80 -rwxr-xr-x    1 sanatsamal       staff               37540 Feb 13 20:20 technical//biomed/1472-6963-3-7.txt
27156974       56 -rwxr-xr-x    1 sanatsamal       staff               27864 Feb 13 20:20 technical//biomed/1475-2891-2-1.txt
27156421       96 -rwxr-xr-x    1 sanatsamal       staff               45414 Feb 13 20:20 technical//biomed/1471-2091-2-5.txt
27156899       56 -rwxr-xr-x    1 sanatsamal       staff               27647 Feb 13 20:20 technical//biomed/1472-6793-3-5.txt
27156976       64 -rwxr-xr-x    1 sanatsamal       staff               29681 Feb 13 20:20 technical//biomed/1475-4924-1-5.txt
27156670       72 -rwxr-xr-x    1 sanatsamal       staff               32908 Feb 13 20:20 technical//biomed/1471-2202-2-19.txt
27156424       64 -rwxr-xr-x    1 sanatsamal       staff               29139 Feb 13 20:20 technical//biomed/1471-2091-3-13.txt
27156587       40 -rwxr-xr-x    1 sanatsamal       staff               18940 Feb 13 20:20 technical//biomed/1471-2164-4-14.txt
27156580       72 -rwxr-xr-x    1 sanatsamal       staff               36670 Feb 13 20:20 technical//biomed/1471-2164-3-35.txt
27156598       72 -rwxr-xr-x    1 sanatsamal       staff               33886 Feb 13 20:20 technical//biomed/1471-2164-4-28.txt
27157107       72 -rwxr-xr-x    1 sanatsamal       staff               33687 Feb 13 20:20 technical//biomed/cc2167.txt
27157070       88 -rwxr-xr-x    1 sanatsamal       staff               43955 Feb 13 20:20 technical//biomed/bcr273.txt
27157028       80 -rwxr-xr-x    1 sanatsamal       staff               40046 Feb 13 20:20 technical//biomed/1477-7827-1-54.txt
27156757       48 -rwxr-xr-x    1 sanatsamal       staff               21319 Feb 13 20:20 technical//biomed/1471-2334-2-1.txt
27156654       56 -rwxr-xr-x    1 sanatsamal       staff               25396 Feb 13 20:20 technical//biomed/1471-2199-3-11.txt
27156865       48 -rwxr-xr-x    1 sanatsamal       staff               21912 Feb 13 20:20 technical//biomed/1472-6750-2-10.txt
27156709       72 -rwxr-xr-x    1 sanatsamal       staff               33152 Feb 13 20:20 technical//biomed/1471-2210-2-5.txt
27157108       64 -rwxr-xr-x    1 sanatsamal       staff               29402 Feb 13 20:20 technical//biomed/cc2171.txt
27156569       48 -rwxr-xr-x    1 sanatsamal       staff               20694 Feb 13 20:20 technical//biomed/1471-2164-3-23.txt
27156589       72 -rwxr-xr-x    1 sanatsamal       staff               33581 Feb 13 20:20 technical//biomed/1471-2164-4-16.txt
27157063       56 -rwxr-xr-x    1 sanatsamal       staff               24602 Feb 13 20:20 technical//biomed/ar774.txt
27157007      168 -rwxr-xr-x    1 sanatsamal       staff               83194 Feb 13 20:20 technical//biomed/1476-511X-1-2.txt
27156954       56 -rwxr-xr-x    1 sanatsamal       staff               25064 Feb 13 20:20 technical//biomed/1472-6963-3-12.txt
27156422       56 -rwxr-xr-x    1 sanatsamal       staff               25458 Feb 13 20:20 technical//biomed/1471-2091-2-7.txt
27157168      112 -rwxr-xr-x    1 sanatsamal       staff               57162 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0071.txt
27156622       64 -rwxr-xr-x    1 sanatsamal       staff               30646 Feb 13 20:20 technical//biomed/1471-2180-1-33.txt
27157127       56 -rwxr-xr-x    1 sanatsamal       staff               24629 Feb 13 20:20 technical//biomed/gb-2000-1-1-research002.txt
27157157       64 -rwxr-xr-x    1 sanatsamal       staff               28714 Feb 13 20:20 technical//biomed/gb-2001-3-1-research0005.txt
27157076       88 -rwxr-xr-x    1 sanatsamal       staff               44544 Feb 13 20:20 technical//biomed/bcr45.txt
27156436       64 -rwxr-xr-x    1 sanatsamal       staff               30279 Feb 13 20:20 technical//biomed/1471-2091-4-1.txt
27157213       64 -rwxr-xr-x    1 sanatsamal       staff               29546 Feb 13 20:20 technical//biomed/gb-2003-4-1-r7.txt
27156759       56 -rwxr-xr-x    1 sanatsamal       staff               27094 Feb 13 20:20 technical//biomed/1471-2334-2-26.txt
27156470       88 -rwxr-xr-x    1 sanatsamal       staff               42311 Feb 13 20:20 technical//biomed/1471-2121-2-11.txt
27156857       48 -rwxr-xr-x    1 sanatsamal       staff               22954 Feb 13 20:20 technical//biomed/1471-5945-1-3.txt
27156446      160 -rwxr-xr-x    1 sanatsamal       staff               78562 Feb 13 20:20 technical//biomed/1471-2105-3-18.txt
27156729       64 -rwxr-xr-x    1 sanatsamal       staff               28796 Feb 13 20:20 technical//biomed/1471-2261-3-5.txt
27156450       24 -rwxr-xr-x    1 sanatsamal       staff               12110 Feb 13 20:20 technical//biomed/1471-2105-3-24.txt
27157010       40 -rwxr-xr-x    1 sanatsamal       staff               19791 Feb 13 20:20 technical//biomed/1476-5918-1-2.txt
27157014       48 -rwxr-xr-x    1 sanatsamal       staff               21781 Feb 13 20:20 technical//biomed/1477-7525-1-10.txt
27157192       64 -rwxr-xr-x    1 sanatsamal       staff               31838 Feb 13 20:20 technical//biomed/gb-2002-3-5-research0024.txt
27156454       88 -rwxr-xr-x    1 sanatsamal       staff               43797 Feb 13 20:20 technical//biomed/1471-2105-3-30.txt
27156808       64 -rwxr-xr-x    1 sanatsamal       staff               31098 Feb 13 20:20 technical//biomed/1471-2407-2-33.txt
27157193      104 -rwxr-xr-x    1 sanatsamal       staff               49968 Feb 13 20:20 technical//biomed/gb-2002-3-5-research0025.txt
27156728       88 -rwxr-xr-x    1 sanatsamal       staff               43855 Feb 13 20:20 technical//biomed/1471-2261-3-4.txt
27156657       88 -rwxr-xr-x    1 sanatsamal       staff               41339 Feb 13 20:20 technical//biomed/1471-2199-3-3.txt
27156469      104 -rwxr-xr-x    1 sanatsamal       staff               51543 Feb 13 20:20 technical//biomed/1471-2121-2-10.txt
27156492       80 -rwxr-xr-x    1 sanatsamal       staff               39935 Feb 13 20:20 technical//biomed/1471-2121-3-6.txt
27156760       72 -rwxr-xr-x    1 sanatsamal       staff               35377 Feb 13 20:20 technical//biomed/1471-2334-2-27.txt
27157156       56 -rwxr-xr-x    1 sanatsamal       staff               26047 Feb 13 20:20 technical//biomed/gb-2001-3-1-research0004.txt
27156439       72 -rwxr-xr-x    1 sanatsamal       staff               34261 Feb 13 20:20 technical//biomed/1471-2105-2-1.txt
27156726       40 -rwxr-xr-x    1 sanatsamal       staff               19386 Feb 13 20:20 technical//biomed/1471-2261-1-6.txt
27157220       40 -rwxr-xr-x    1 sanatsamal       staff               18620 Feb 13 20:20 technical//biomed/gb-2003-4-3-r18.txt
27157057       72 -rwxr-xr-x    1 sanatsamal       staff               34084 Feb 13 20:20 technical//biomed/ar615.txt
27157055       40 -rwxr-xr-x    1 sanatsamal       staff               18964 Feb 13 20:20 technical//biomed/ar601.txt
27156999       48 -rwxr-xr-x    1 sanatsamal       staff               24279 Feb 13 20:20 technical//biomed/1476-4598-2-1.txt
27156917       64 -rwxr-xr-x    1 sanatsamal       staff               29525 Feb 13 20:20 technical//biomed/1472-684X-2-2.txt
27156618       96 -rwxr-xr-x    1 sanatsamal       staff               47026 Feb 13 20:20 technical//biomed/1471-2180-1-26.txt
27156836       56 -rwxr-xr-x    1 sanatsamal       staff               27043 Feb 13 20:20 technical//biomed/1471-2458-2-21.txt
27156900       64 -rwxr-xr-x    1 sanatsamal       staff               29507 Feb 13 20:20 technical//biomed/1472-6793-3-6.txt
27156955       40 -rwxr-xr-x    1 sanatsamal       staff               20388 Feb 13 20:20 technical//biomed/1472-6963-3-13.txt
27156562       64 -rwxr-xr-x    1 sanatsamal       staff               30676 Feb 13 20:20 technical//biomed/1471-2164-3-1.txt
27156679      152 -rwxr-xr-x    1 sanatsamal       staff               75711 Feb 13 20:20 technical//biomed/1471-2202-3-1.txt
27156708       48 -rwxr-xr-x    1 sanatsamal       staff               23490 Feb 13 20:20 technical//biomed/1471-2210-2-4.txt
27156653       40 -rwxr-xr-x    1 sanatsamal       staff               19877 Feb 13 20:20 technical//biomed/1471-2199-3-10.txt
27156772       32 -rwxr-xr-x    1 sanatsamal       staff               15134 Feb 13 20:20 technical//biomed/1471-2350-2-12.txt
27156778       56 -rwxr-xr-x    1 sanatsamal       staff               26118 Feb 13 20:20 technical//biomed/1471-2350-3-9.txt
27156983       88 -rwxr-xr-x    1 sanatsamal       staff               43338 Feb 13 20:20 technical//biomed/1475-9268-1-1.txt
27157137       72 -rwxr-xr-x    1 sanatsamal       staff               36028 Feb 13 20:20 technical//biomed/gb-2001-2-2-research0004.txt
27157106       40 -rwxr-xr-x    1 sanatsamal       staff               17840 Feb 13 20:20 technical//biomed/cc2160.txt
27156871       72 -rwxr-xr-x    1 sanatsamal       staff               34558 Feb 13 20:20 technical//biomed/1472-6750-3-4.txt
27156689       96 -rwxr-xr-x    1 sanatsamal       staff               47766 Feb 13 20:20 technical//biomed/1471-2202-3-5.txt
27156586       64 -rwxr-xr-x    1 sanatsamal       staff               32319 Feb 13 20:20 technical//biomed/1471-2164-4-13.txt
27156425      112 -rwxr-xr-x    1 sanatsamal       staff               54849 Feb 13 20:20 technical//biomed/1471-2091-3-14.txt
27156858       72 -rwxr-xr-x    1 sanatsamal       staff               35587 Feb 13 20:20 technical//biomed/1471-5945-2-13.txt
27156577       64 -rwxr-xr-x    1 sanatsamal       staff               29324 Feb 13 20:20 technical//biomed/1471-2164-3-32.txt
27156571       48 -rwxr-xr-x    1 sanatsamal       staff               21046 Feb 13 20:20 technical//biomed/1471-2164-3-26.txt
27156732       64 -rwxr-xr-x    1 sanatsamal       staff               30852 Feb 13 20:20 technical//biomed/1471-2288-2-11.txt
27156642       80 -rwxr-xr-x    1 sanatsamal       staff               37694 Feb 13 20:20 technical//biomed/1471-2180-3-4.txt
27156863       64 -rwxr-xr-x    1 sanatsamal       staff               31799 Feb 13 20:20 technical//biomed/1472-6750-1-6.txt
27157229      104 -rwxr-xr-x    1 sanatsamal       staff               51187 Feb 13 20:20 technical//biomed/gb-2003-4-6-r39.txt
27156837       72 -rwxr-xr-x    1 sanatsamal       staff               36580 Feb 13 20:20 technical//biomed/1471-2458-2-25.txt
27157221      104 -rwxr-xr-x    1 sanatsamal       staff               51112 Feb 13 20:20 technical//biomed/gb-2003-4-3-r20.txt
27157236       72 -rwxr-xr-x    1 sanatsamal       staff               35998 Feb 13 20:20 technical//biomed/gb-2003-4-9-r57.txt
27156486       72 -rwxr-xr-x    1 sanatsamal       staff               34129 Feb 13 20:20 technical//biomed/1471-2121-3-2.txt
27156805       40 -rwxr-xr-x    1 sanatsamal       staff               20230 Feb 13 20:20 technical//biomed/1471-2407-2-23.txt
27156465       72 -rwxr-xr-x    1 sanatsamal       staff               33821 Feb 13 20:20 technical//biomed/1471-2105-4-28.txt
27156945       88 -rwxr-xr-x    1 sanatsamal       staff               42551 Feb 13 20:20 technical//biomed/1472-6947-2-7.txt
27157189       72 -rwxr-xr-x    1 sanatsamal       staff               32848 Feb 13 20:20 technical//biomed/gb-2002-3-5-research0021.txt
27157049       56 -rwxr-xr-x    1 sanatsamal       staff               27321 Feb 13 20:20 technical//biomed/ar407.txt
27156658       64 -rwxr-xr-x    1 sanatsamal       staff               29608 Feb 13 20:20 technical//biomed/1471-2199-3-7.txt
27156964       72 -rwxr-xr-x    1 sanatsamal       staff               35654 Feb 13 20:20 technical//biomed/1475-2867-3-2.txt
27156977       48 -rwxr-xr-x    1 sanatsamal       staff               21404 Feb 13 20:20 technical//biomed/1475-925X-2-1.txt
27156965       48 -rwxr-xr-x    1 sanatsamal       staff               23790 Feb 13 20:20 technical//biomed/1475-2867-3-3.txt
27156455       72 -rwxr-xr-x    1 sanatsamal       staff               34563 Feb 13 20:20 technical//biomed/1471-2105-3-34.txt
27157188       80 -rwxr-xr-x    1 sanatsamal       staff               39368 Feb 13 20:20 technical//biomed/gb-2002-3-5-research0020.txt
27156804       48 -rwxr-xr-x    1 sanatsamal       staff               22429 Feb 13 20:20 technical//biomed/1471-2407-2-22.txt
27156472       72 -rwxr-xr-x    1 sanatsamal       staff               32852 Feb 13 20:20 technical//biomed/1471-2121-2-15.txt
27156528       32 -rwxr-xr-x    1 sanatsamal       staff               14560 Feb 13 20:20 technical//biomed/1471-2148-2-5.txt
27157092       40 -rwxr-xr-x    1 sanatsamal       staff               19035 Feb 13 20:20 technical//biomed/cc1044.txt
27156437       64 -rwxr-xr-x    1 sanatsamal       staff               28719 Feb 13 20:20 technical//biomed/1471-2091-4-5.txt
27156730       56 -rwxr-xr-x    1 sanatsamal       staff               25922 Feb 13 20:20 technical//biomed/1471-2288-1-9.txt
27157245       64 -rwxr-xr-x    1 sanatsamal       staff               32562 Feb 13 20:20 technical//biomed/rr37.txt
27157155      120 -rwxr-xr-x    1 sanatsamal       staff               60518 Feb 13 20:20 technical//biomed/gb-2001-3-1-research0001.txt
27156952       56 -rwxr-xr-x    1 sanatsamal       staff               26929 Feb 13 20:20 technical//biomed/1472-6963-3-1.txt
27156606       40 -rwxr-xr-x    1 sanatsamal       staff               19565 Feb 13 20:20 technical//biomed/1471-2172-2-9.txt
27156835       32 -rwxr-xr-x    1 sanatsamal       staff               16116 Feb 13 20:20 technical//biomed/1471-2458-2-18.txt
27156643       88 -rwxr-xr-x    1 sanatsamal       staff               43688 Feb 13 20:20 technical//biomed/1471-2180-3-5.txt
27156731       88 -rwxr-xr-x    1 sanatsamal       staff               42772 Feb 13 20:20 technical//biomed/1471-2288-2-10.txt
27156581       96 -rwxr-xr-x    1 sanatsamal       staff               45524 Feb 13 20:20 technical//biomed/1471-2164-3-4.txt
27156897       48 -rwxr-xr-x    1 sanatsamal       staff               20943 Feb 13 20:20 technical//biomed/1472-6793-3-3.txt
27157170       48 -rwxr-xr-x    1 sanatsamal       staff               22757 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0075.txt
27156572       48 -rwxr-xr-x    1 sanatsamal       staff               24329 Feb 13 20:20 technical//biomed/1471-2164-3-27.txt
27156578       64 -rwxr-xr-x    1 sanatsamal       staff               32602 Feb 13 20:20 technical//biomed/1471-2164-3-33.txt
27156426       72 -rwxr-xr-x    1 sanatsamal       staff               34209 Feb 13 20:20 technical//biomed/1471-2091-3-15.txt
27156688       64 -rwxr-xr-x    1 sanatsamal       staff               32489 Feb 13 20:20 technical//biomed/1471-2202-3-4.txt
27156867       96 -rwxr-xr-x    1 sanatsamal       staff               47947 Feb 13 20:20 technical//biomed/1472-6750-2-14.txt
27156624       80 -rwxr-xr-x    1 sanatsamal       staff               38765 Feb 13 20:20 technical//biomed/1471-2180-1-7.txt
27157097       32 -rwxr-xr-x    1 sanatsamal       staff               16242 Feb 13 20:20 technical//biomed/cc1497.txt
27156762       48 -rwxr-xr-x    1 sanatsamal       staff               22233 Feb 13 20:20 technical//biomed/1471-2334-2-5.txt
27156656       48 -rwxr-xr-x    1 sanatsamal       staff               22226 Feb 13 20:20 technical//biomed/1471-2199-3-17.txt
27156771       48 -rwxr-xr-x    1 sanatsamal       staff               23338 Feb 13 20:20 technical//biomed/1471-2350-2-11.txt
27156764       56 -rwxr-xr-x    1 sanatsamal       staff               27097 Feb 13 20:20 technical//biomed/1471-2334-2-7.txt
27157096       32 -rwxr-xr-x    1 sanatsamal       staff               16376 Feb 13 20:20 technical//biomed/cc1495.txt
27156984       48 -rwxr-xr-x    1 sanatsamal       staff               20942 Feb 13 20:20 technical//biomed/1475-9268-1-2.txt
27157026       96 -rwxr-xr-x    1 sanatsamal       staff               48259 Feb 13 20:20 technical//biomed/1477-7827-1-46.txt
27156428       64 -rwxr-xr-x    1 sanatsamal       staff               29469 Feb 13 20:20 technical//biomed/1471-2091-3-17.txt
27157068       56 -rwxr-xr-x    1 sanatsamal       staff               25350 Feb 13 20:20 technical//biomed/ar799.txt
27156568       72 -rwxr-xr-x    1 sanatsamal       staff               33671 Feb 13 20:20 technical//biomed/1471-2164-3-19.txt
27157181      104 -rwxr-xr-x    1 sanatsamal       staff               51726 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0088.txt
27156576       80 -rwxr-xr-x    1 sanatsamal       staff               40400 Feb 13 20:20 technical//biomed/1471-2164-3-31.txt
27157171       88 -rwxr-xr-x    1 sanatsamal       staff               41682 Feb 13 20:20 technical//biomed/gb-2002-3-12-research0077.txt
27156956       88 -rwxr-xr-x    1 sanatsamal       staff               41716 Feb 13 20:20 technical//biomed/1472-6963-3-14.txt
27156967       72 -rwxr-xr-x    1 sanatsamal       staff               33494 Feb 13 20:20 technical//biomed/1475-2875-1-14.txt
27156582       48 -rwxr-xr-x    1 sanatsamal       staff               21289 Feb 13 20:20 technical//biomed/1471-2164-3-6.txt
27157235       48 -rwxr-xr-x    1 sanatsamal       staff               20637 Feb 13 20:20 technical//biomed/gb-2003-4-8-r51.txt
27156971       64 -rwxr-xr-x    1 sanatsamal       staff               29607 Feb 13 20:20 technical//biomed/1475-2875-2-4.txt
27156949       48 -rwxr-xr-x    1 sanatsamal       staff               21711 Feb 13 20:20 technical//biomed/1472-6963-1-11.txt
27157056       56 -rwxr-xr-x    1 sanatsamal       staff               28204 Feb 13 20:20 technical//biomed/ar612.txt
27156892       64 -rwxr-xr-x    1 sanatsamal       staff               28870 Feb 13 20:20 technical//biomed/1472-6793-2-19.txt
27156743       40 -rwxr-xr-x    1 sanatsamal       staff               17629 Feb 13 20:20 technical//biomed/1471-230X-1-8.txt
27156529       40 -rwxr-xr-x    1 sanatsamal       staff               19427 Feb 13 20:20 technical//biomed/1471-2148-2-7.txt
27157190       80 -rwxr-xr-x    1 sanatsamal       staff               38544 Feb 13 20:20 technical//biomed/gb-2002-3-5-research0022.txt
27156736       96 -rwxr-xr-x    1 sanatsamal       staff               46390 Feb 13 20:20 technical//biomed/1471-2288-3-9.txt
27156448       64 -rwxr-xr-x    1 sanatsamal       staff               29117 Feb 13 20:20 technical//biomed/1471-2105-3-22.txt
27156944       72 -rwxr-xr-x    1 sanatsamal       staff               33905 Feb 13 20:20 technical//biomed/1472-6947-2-4.txt
27157075       48 -rwxr-xr-x    1 sanatsamal       staff               23358 Feb 13 20:20 technical//biomed/bcr317.txt
27156981       40 -rwxr-xr-x    1 sanatsamal       staff               17695 Feb 13 20:20 technical//biomed/1475-925X-2-3.txt
27157074       64 -rwxr-xr-x    1 sanatsamal       staff               30804 Feb 13 20:20 technical//biomed/bcr303.txt
27156449       64 -rwxr-xr-x    1 sanatsamal       staff               30792 Feb 13 20:20 technical//biomed/1471-2105-3-23.txt
27156735       48 -rwxr-xr-x    1 sanatsamal       staff               23191 Feb 13 20:20 technical//biomed/1471-2288-3-8.txt
27157077       48 -rwxr-xr-x    1 sanatsamal       staff               22904 Feb 13 20:20 technical//biomed/bcr458.txt
27156456       64 -rwxr-xr-x    1 sanatsamal       staff               29508 Feb 13 20:20 technical//biomed/1471-2105-3-37.txt
27157191       40 -rwxr-xr-x    1 sanatsamal       staff               19700 Feb 13 20:20 technical//biomed/gb-2002-3-5-research0023.txt
27156891       96 -rwxr-xr-x    1 sanatsamal       staff               45713 Feb 13 20:20 technical//biomed/1472-6793-2-18.txt
27156538       56 -rwxr-xr-x    1 sanatsamal       staff               27688 Feb 13 20:20 technical//biomed/1471-2156-2-17.txt
27156787       48 -rwxr-xr-x    1 sanatsamal       staff               21464 Feb 13 20:20 technical//biomed/1471-2369-4-1.txt
27157040       56 -rwxr-xr-x    1 sanatsamal       staff               25253 Feb 13 20:20 technical//biomed/ar149.txt
27157194       56 -rwxr-xr-x    1 sanatsamal       staff               26711 Feb 13 20:20 technical//biomed/gb-2002-3-6-research0029.txt
27156467       64 -rwxr-xr-x    1 sanatsamal       staff               29793 Feb 13 20:20 technical//biomed/1471-2121-1-2.txt
27156623       72 -rwxr-xr-x    1 sanatsamal       staff               34076 Feb 13 20:20 technical//biomed/1471-2180-1-34.txt
27157234       64 -rwxr-xr-x    1 sanatsamal       staff               29369 Feb 13 20:20 technical//biomed/gb-2003-4-8-r50.txt
27156583       80 -rwxr-xr-x    1 sanatsamal       staff               40413 Feb 13 20:20 technical//biomed/1471-2164-3-7.txt
27156575       40 -rwxr-xr-x    1 sanatsamal       staff               18364 Feb 13 20:20 technical//biomed/1471-2164-3-30.txt
27156672       88 -rwxr-xr-x    1 sanatsamal       staff               41831 Feb 13 20:20 technical//biomed/1471-2202-2-20.txt
27156570       72 -rwxr-xr-x    1 sanatsamal       staff               35306 Feb 13 20:20 technical//biomed/1471-2164-3-24.txt
27156690       64 -rwxr-xr-x    1 sanatsamal       staff               28821 Feb 13 20:20 technical//biomed/1471-2202-3-7.txt
27156427       72 -rwxr-xr-x    1 sanatsamal       staff               35953 Feb 13 20:20 technical//biomed/1471-2091-3-16.txt
27156567       96 -rwxr-xr-x    1 sanatsamal       staff               47848 Feb 13 20:20 technical//biomed/1471-2164-3-18.txt
27156872       80 -rwxr-xr-x    1 sanatsamal       staff               36952 Feb 13 20:20 technical//biomed/1472-6750-3-6.txt
27156884       64 -rwxr-xr-x    1 sanatsamal       staff               32160 Feb 13 20:20 technical//biomed/1472-6793-1-2.txt
27156763       72 -rwxr-xr-x    1 sanatsamal       staff               33504 Feb 13 20:20 technical//biomed/1471-2334-2-6.txt
27156505       96 -rwxr-xr-x    1 sanatsamal       staff               46555 Feb 13 20:20 technical//biomed/1471-213X-1-15.txt
27157116       32 -rwxr-xr-x    1 sanatsamal       staff               16150 Feb 13 20:20 technical//biomed/cc350.txt
27156531       40 -rwxr-xr-x    1 sanatsamal       staff               19888 Feb 13 20:20 technical//biomed/1471-2148-3-1.txt
27157083       48 -rwxr-xr-x    1 sanatsamal       staff               22429 Feb 13 20:20 technical//biomed/bcr588.txt
27156648       48 -rwxr-xr-x    1 sanatsamal       staff               23248 Feb 13 20:20 technical//biomed/1471-2199-2-2.txt
27156962       48 -rwxr-xr-x    1 sanatsamal       staff               21894 Feb 13 20:20 technical//biomed/1475-2867-2-7.txt
27156414       64 -rwxr-xr-x    1 sanatsamal       staff               31378 Feb 13 20:20 technical//biomed/1468-6708-3-4.txt
27156489      104 -rwxr-xr-x    1 sanatsamal       staff               51597 Feb 13 20:20 technical//biomed/1471-2121-3-25.txt
27156767       40 -rwxr-xr-x    1 sanatsamal       staff               17234 Feb 13 20:20 technical//biomed/1471-2334-3-12.txt
27156700       56 -rwxr-xr-x    1 sanatsamal       staff               27415 Feb 13 20:20 technical//biomed/1471-2202-4-6.txt
27156922      160 -rwxr-xr-x    1 sanatsamal       staff               78507 Feb 13 20:20 technical//biomed/1472-6882-1-10.txt
27156485       96 -rwxr-xr-x    1 sanatsamal       staff               46803 Feb 13 20:20 technical//biomed/1471-2121-3-19.txt
27156601       64 -rwxr-xr-x    1 sanatsamal       staff               32085 Feb 13 20:20 technical//biomed/1471-2164-4-6.txt
27156721       72 -rwxr-xr-x    1 sanatsamal       staff               34915 Feb 13 20:20 technical//biomed/1471-2229-2-9.txt
27157208       64 -rwxr-xr-x    1 sanatsamal       staff               29598 Feb 13 20:20 technical//biomed/gb-2002-3-9-research0049.txt
27156753       48 -rwxr-xr-x    1 sanatsamal       staff               24239 Feb 13 20:20 technical//biomed/1471-2334-1-17.txt
27156626       72 -rwxr-xr-x    1 sanatsamal       staff               32867 Feb 13 20:20 technical//biomed/1471-2180-2-1.txt
27157120       24 -rwxr-xr-x    1 sanatsamal       staff               11287 Feb 13 20:20 technical//biomed/cc973.txt
27156705      104 -rwxr-xr-x    1 sanatsamal       staff               53072 Feb 13 20:20 technical//biomed/1471-2210-1-7.txt
27156750       48 -rwxr-xr-x    1 sanatsamal       staff               24415 Feb 13 20:20 technical//biomed/1471-2326-2-4.txt
27156628       72 -rwxr-xr-x    1 sanatsamal       staff               35235 Feb 13 20:20 technical//biomed/1471-2180-2-16.txt
27156494       40 -rwxr-xr-x    1 sanatsamal       staff               17621 Feb 13 20:20 technical//biomed/1471-2121-4-1.txt
27156513       32 -rwxr-xr-x    1 sanatsamal       staff               13689 Feb 13 20:20 technical//biomed/1471-213X-2-8.txt
27156882       56 -rwxr-xr-x    1 sanatsamal       staff               25055 Feb 13 20:20 technical//biomed/1472-6793-1-12.txt
27156659       64 -rwxr-xr-x    1 sanatsamal       staff               30658 Feb 13 20:20 technical//biomed/1471-2199-4-4.txt
27156660       56 -rwxr-xr-x    1 sanatsamal       staff               25184 Feb 13 20:20 technical//biomed/1471-2199-4-5.txt
27156783       56 -rwxr-xr-x    1 sanatsamal       staff               25926 Feb 13 20:20 technical//biomed/1471-2369-3-1.txt
27156555       80 -rwxr-xr-x    1 sanatsamal       staff               39804 Feb 13 20:20 technical//biomed/1471-2164-2-1.txt
27156662       80 -rwxr-xr-x    1 sanatsamal       staff               38924 Feb 13 20:20 technical//biomed/1471-2202-2-1.txt
27157207       96 -rwxr-xr-x    1 sanatsamal       staff               45928 Feb 13 20:20 technical//biomed/gb-2002-3-9-research0048.txt
27156720       48 -rwxr-xr-x    1 sanatsamal       staff               23226 Feb 13 20:20 technical//biomed/1471-2229-2-8.txt
27156855       56 -rwxr-xr-x    1 sanatsamal       staff               25832 Feb 13 20:20 technical//biomed/1471-2474-4-8.txt
27156484       72 -rwxr-xr-x    1 sanatsamal       staff               35704 Feb 13 20:20 technical//biomed/1471-2121-3-18.txt
27156923       64 -rwxr-xr-x    1 sanatsamal       staff               31620 Feb 13 20:20 technical//biomed/1472-6882-1-11.txt
27156768       16 -rwxr-xr-x    1 sanatsamal       staff                6297 Feb 13 20:20 technical//biomed/1471-2334-3-13.txt
27157122       48 -rwxr-xr-x    1 sanatsamal       staff               21676 Feb 13 20:20 technical//biomed/cvm-2-1-038.txt
27156490      112 -rwxr-xr-x    1 sanatsamal       staff               56063 Feb 13 20:20 technical//biomed/1471-2121-3-30.txt
27156551       72 -rwxr-xr-x    1 sanatsamal       staff               33991 Feb 13 20:20 technical//biomed/1471-2156-4-10.txt
27156649       40 -rwxr-xr-x    1 sanatsamal       staff               20447 Feb 13 20:20 technical//biomed/1471-2199-2-3.txt
27156995       48 -rwxr-xr-x    1 sanatsamal       staff               21898 Feb 13 20:20 technical//biomed/1476-4598-1-3.txt
27156603       80 -rwxr-xr-x    1 sanatsamal       staff               38772 Feb 13 20:20 technical//biomed/1471-2172-2-10.txt
27156477       64 -rwxr-xr-x    1 sanatsamal       staff               31043 Feb 13 20:20 technical//biomed/1471-2121-2-6.txt
27157020       48 -rwxr-xr-x    1 sanatsamal       staff               23010 Feb 13 20:20 technical//biomed/1477-7827-1-21.txt
27157021       72 -rwxr-xr-x    1 sanatsamal       staff               35797 Feb 13 20:20 technical//biomed/1477-7827-1-23.txt
27156973       56 -rwxr-xr-x    1 sanatsamal       staff               25430 Feb 13 20:20 technical//biomed/1475-2891-1-2.txt
27156415       40 -rwxr-xr-x    1 sanatsamal       staff               18114 Feb 13 20:20 technical//biomed/1468-6708-3-7.txt
27156645       64 -rwxr-xr-x    1 sanatsamal       staff               32069 Feb 13 20:20 technical//biomed/1471-2199-2-1.txt
27156438       72 -rwxr-xr-x    1 sanatsamal       staff               36588 Feb 13 20:20 technical//biomed/1471-2105-1-1.txt
27157158      112 -rwxr-xr-x    1 sanatsamal       staff               55347 Feb 13 20:20 technical//biomed/gb-2002-3-10-research0052.txt
27156699       56 -rwxr-xr-x    1 sanatsamal       staff               26021 Feb 13 20:20 technical//biomed/1471-2202-4-5.txt
27156766       48 -rwxr-xr-x    1 sanatsamal       staff               24252 Feb 13 20:20 technical//biomed/1471-2334-3-11.txt
27156600       56 -rwxr-xr-x    1 sanatsamal       staff               24850 Feb 13 20:20 technical//biomed/1471-2164-4-5.txt
27157125       56 -rwxr-xr-x    1 sanatsamal       staff               25831 Feb 13 20:20 technical//biomed/cvm-2-6-278.txt
27157123       40 -rwxr-xr-x    1 sanatsamal       staff               19679 Feb 13 20:20 technical//biomed/cvm-2-4-180.txt
27156453       96 -rwxr-xr-x    1 sanatsamal       staff               47668 Feb 13 20:20 technical//biomed/1471-2105-3-3.txt
27157218      112 -rwxr-xr-x    1 sanatsamal       staff               55181 Feb 13 20:20 technical//biomed/gb-2003-4-2-r9.txt
27156972       56 -rwxr-xr-x    1 sanatsamal       staff               24661 Feb 13 20:20 technical//biomed/1475-2883-2-11.txt
27156960       48 -rwxr-xr-x    1 sanatsamal       staff               22387 Feb 13 20:20 technical//biomed/1475-2867-2-10.txt
27156673       64 -rwxr-xr-x    1 sanatsamal       staff               30961 Feb 13 20:20 technical//biomed/1471-2202-2-3.txt
27157084       40 -rwxr-xr-x    1 sanatsamal       staff               19094 Feb 13 20:20 technical//biomed/bcr602.txt
27156629       48 -rwxr-xr-x    1 sanatsamal       staff               20538 Feb 13 20:20 technical//biomed/1471-2180-2-2.txt
27157136       96 -rwxr-xr-x    1 sanatsamal       staff               48870 Feb 13 20:20 technical//biomed/gb-2001-2-12-research0055.txt
27157033       72 -rwxr-xr-x    1 sanatsamal       staff               35659 Feb 13 20:20 technical//biomed/1478-1336-1-4.txt
27156894       64 -rwxr-xr-x    1 sanatsamal       staff               31160 Feb 13 20:20 technical//biomed/1472-6793-2-4.txt
27156704       72 -rwxr-xr-x    1 sanatsamal       staff               33669 Feb 13 20:20 technical//biomed/1471-2210-1-4.txt
27156434      104 -rwxr-xr-x    1 sanatsamal       staff               52697 Feb 13 20:20 technical//biomed/1471-2091-3-4.txt
27156495       72 -rwxr-xr-x    1 sanatsamal       staff               34571 Feb 13 20:20 technical//biomed/1471-2121-4-2.txt
27157187       72 -rwxr-xr-x    1 sanatsamal       staff               34914 Feb 13 20:20 technical//biomed/gb-2002-3-4-research0019.txt
27156680       48 -rwxr-xr-x    1 sanatsamal       staff               23827 Feb 13 20:20 technical//biomed/1471-2202-3-10.txt
27156633       32 -rwxr-xr-x    1 sanatsamal       staff               13909 Feb 13 20:20 technical//biomed/1471-2180-2-29.txt
27156868       48 -rwxr-xr-x    1 sanatsamal       staff               22140 Feb 13 20:20 technical//biomed/1472-6750-2-2.txt
27157009       48 -rwxr-xr-x    1 sanatsamal       staff               23183 Feb 13 20:20 technical//biomed/1476-511X-2-3.txt
27157101       32 -rwxr-xr-x    1 sanatsamal       staff               15211 Feb 13 20:20 technical//biomed/cc1547.txt
27156881       64 -rwxr-xr-x    1 sanatsamal       staff               28809 Feb 13 20:20 technical//biomed/1472-6793-1-11.txt
27156810       32 -rwxr-xr-x    1 sanatsamal       staff               14795 Feb 13 20:20 technical//biomed/1471-2407-2-9.txt
27156809       40 -rwxr-xr-x    1 sanatsamal       staff               18174 Feb 13 20:20 technical//biomed/1471-2407-2-8.txt
27157005       72 -rwxr-xr-x    1 sanatsamal       staff               35675 Feb 13 20:20 technical//biomed/1476-4598-2-28.txt
27157008       56 -rwxr-xr-x    1 sanatsamal       staff               28467 Feb 13 20:20 technical//biomed/1476-511X-2-2.txt
27156681       64 -rwxr-xr-x    1 sanatsamal       staff               31287 Feb 13 20:20 technical//biomed/1471-2202-3-11.txt
27156496       80 -rwxr-xr-x    1 sanatsamal       staff               37156 Feb 13 20:20 technical//biomed/1471-2121-4-3.txt
27157186       64 -rwxr-xr-x    1 sanatsamal       staff               29148 Feb 13 20:20 technical//biomed/gb-2002-3-4-research0018.txt
27156727       56 -rwxr-xr-x    1 sanatsamal       staff               25902 Feb 13 20:20 technical//biomed/1471-2261-2-11.txt
27156895       72 -rwxr-xr-x    1 sanatsamal       staff               33228 Feb 13 20:20 technical//biomed/1472-6793-2-5.txt
27156556       80 -rwxr-xr-x    1 sanatsamal       staff               37800 Feb 13 20:20 technical//biomed/1471-2164-2-2.txt
27157135       80 -rwxr-xr-x    1 sanatsamal       staff               40003 Feb 13 20:20 technical//biomed/gb-2001-2-12-research0054.txt
27157035       80 -rwxr-xr-x    1 sanatsamal       staff               37212 Feb 13 20:20 technical//biomed/ar104.txt
27156794       80 -rwxr-xr-x    1 sanatsamal       staff               37667 Feb 13 20:20 technical//biomed/1471-2407-1-15.txt
27156671       40 -rwxr-xr-x    1 sanatsamal       staff               18827 Feb 13 20:20 technical//biomed/1471-2202-2-2.txt
27157217       88 -rwxr-xr-x    1 sanatsamal       staff               43710 Feb 13 20:20 technical//biomed/gb-2003-4-2-r8.txt
27156941       40 -rwxr-xr-x    1 sanatsamal       staff               16536 Feb 13 20:20 technical//biomed/1472-6947-1-2.txt
27156447      272 -rwxr-xr-x    1 sanatsamal       staff              136424 Feb 13 20:20 technical//biomed/1471-2105-3-2.txt
27156717       80 -rwxr-xr-x    1 sanatsamal       staff               37128 Feb 13 20:20 technical//biomed/1471-2229-2-11.txt
27156599      112 -rwxr-xr-x    1 sanatsamal       staff               54077 Feb 13 20:20 technical//biomed/1471-2164-4-4.txt
27157126       40 -rwxr-xr-x    1 sanatsamal       staff               19340 Feb 13 20:20 technical//biomed/cvm-2-6-286.txt
27156518       48 -rwxr-xr-x    1 sanatsamal       staff               23842 Feb 13 20:20 technical//biomed/1471-2148-1-1.txt
27156765       64 -rwxr-xr-x    1 sanatsamal       staff               30506 Feb 13 20:20 technical//biomed/1471-2334-3-10.txt
27156924       64 -rwxr-xr-x    1 sanatsamal       staff               31937 Feb 13 20:20 technical//biomed/1472-6882-1-12.txt
27157159       64 -rwxr-xr-x    1 sanatsamal       staff               31808 Feb 13 20:20 technical//biomed/gb-2002-3-10-research0053.txt
27156543       24 -rwxr-xr-x    1 sanatsamal       staff               10530 Feb 13 20:20 technical//biomed/1471-2156-2-8.txt
27157244       80 -rwxr-xr-x    1 sanatsamal       staff               37082 Feb 13 20:20 technical//biomed/rr196.txt
27156533       88 -rwxr-xr-x    1 sanatsamal       staff               45044 Feb 13 20:20 technical//biomed/1471-2148-3-3.txt
27156907       40 -rwxr-xr-x    1 sanatsamal       staff               19498 Feb 13 20:20 technical//biomed/1472-6807-2-9.txt
27157024      112 -rwxr-xr-x    1 sanatsamal       staff               53800 Feb 13 20:20 technical//biomed/1477-7827-1-36.txt
27156535       80 -rwxr-xr-x    1 sanatsamal       staff               40153 Feb 13 20:20 technical//biomed/1471-2148-3-7.txt
27156504       72 -rwxr-xr-x    1 sanatsamal       staff               36535 Feb 13 20:20 technical//biomed/1471-213X-1-13.txt
27156468       56 -rwxr-xr-x    1 sanatsamal       staff               26820 Feb 13 20:20 technical//biomed/1471-2121-2-1.txt
27157185       64 -rwxr-xr-x    1 sanatsamal       staff               31929 Feb 13 20:20 technical//biomed/gb-2002-3-3-research0012.txt
27156548       32 -rwxr-xr-x    1 sanatsamal       staff               13363 Feb 13 20:20 technical//biomed/1471-2156-3-22.txt
27157081       48 -rwxr-xr-x    1 sanatsamal       staff               21426 Feb 13 20:20 technical//biomed/bcr571.txt
27156650      112 -rwxr-xr-x    1 sanatsamal       staff               54313 Feb 13 20:20 technical//biomed/1471-2199-2-4.txt
27157128       56 -rwxr-xr-x    1 sanatsamal       staff               28019 Feb 13 20:20 technical//biomed/gb-2000-1-2-research0003.txt
27156948       48 -rwxr-xr-x    1 sanatsamal       staff               22981 Feb 13 20:20 technical//biomed/1472-6955-2-1.txt
27156459       72 -rwxr-xr-x    1 sanatsamal       staff               34496 Feb 13 20:20 technical//biomed/1471-2105-3-6.txt
27156852       56 -rwxr-xr-x    1 sanatsamal       staff               24615 Feb 13 20:20 technical//biomed/1471-2474-3-23.txt
27156943       72 -rwxr-xr-x    1 sanatsamal       staff               33487 Feb 13 20:20 technical//biomed/1472-6947-1-6.txt
27156811       56 -rwxr-xr-x    1 sanatsamal       staff               26367 Feb 13 20:20 technical//biomed/1471-2407-3-14.txt
27156675       48 -rwxr-xr-x    1 sanatsamal       staff               23922 Feb 13 20:20 technical//biomed/1471-2202-2-6.txt
27156961       56 -rwxr-xr-x    1 sanatsamal       staff               25953 Feb 13 20:20 technical//biomed/1475-2867-2-15.txt
27156887       64 -rwxr-xr-x    1 sanatsamal       staff               30811 Feb 13 20:20 technical//biomed/1472-6793-2-1.txt
27157201       48 -rwxr-xr-x    1 sanatsamal       staff               20507 Feb 13 20:20 technical//biomed/gb-2002-3-8-research0039.txt
27156785       40 -rwxr-xr-x    1 sanatsamal       staff               18646 Feb 13 20:20 technical//biomed/1471-2369-3-6.txt
27157086       48 -rwxr-xr-x    1 sanatsamal       staff               20662 Feb 13 20:20 technical//biomed/bcr607.txt
27156920       40 -rwxr-xr-x    1 sanatsamal       staff               18987 Feb 13 20:20 technical//biomed/1472-6874-2-8.txt
27156637       48 -rwxr-xr-x    1 sanatsamal       staff               24381 Feb 13 20:20 technical//biomed/1471-2180-2-7.txt
27156558       48 -rwxr-xr-x    1 sanatsamal       staff               20730 Feb 13 20:20 technical//biomed/1471-2164-2-6.txt
27156636       48 -rwxr-xr-x    1 sanatsamal       staff               21154 Feb 13 20:20 technical//biomed/1471-2180-2-38.txt
27156714       32 -rwxr-xr-x    1 sanatsamal       staff               16141 Feb 13 20:20 technical//biomed/1471-2210-3-3.txt
27156823       48 -rwxr-xr-x    1 sanatsamal       staff               21527 Feb 13 20:20 technical//biomed/1471-2431-2-11.txt
27156883       72 -rwxr-xr-x    1 sanatsamal       staff               33137 Feb 13 20:20 technical//biomed/1472-6793-1-15.txt
27156844       48 -rwxr-xr-x    1 sanatsamal       staff               22386 Feb 13 20:20 technical//biomed/1471-2458-3-9.txt
27156499       56 -rwxr-xr-x    1 sanatsamal       staff               26467 Feb 13 20:20 technical//biomed/1471-2121-4-6.txt
27156682       72 -rwxr-xr-x    1 sanatsamal       staff               33896 Feb 13 20:20 technical//biomed/1471-2202-3-14.txt
27156559       64 -rwxr-xr-x    1 sanatsamal       staff               32543 Feb 13 20:20 technical//biomed/1471-2164-2-7.txt
27157133       80 -rwxr-xr-x    1 sanatsamal       staff               37186 Feb 13 20:20 technical//biomed/gb-2001-2-12-research0051.txt
27157200       96 -rwxr-xr-x    1 sanatsamal       staff               45876 Feb 13 20:20 technical//biomed/gb-2002-3-8-research0038.txt
27156831       48 -rwxr-xr-x    1 sanatsamal       staff               20900 Feb 13 20:20 technical//biomed/1471-244X-3-5.txt
27156676       56 -rwxr-xr-x    1 sanatsamal       staff               27117 Feb 13 20:20 technical//biomed/1471-2202-2-7.txt
27156751       40 -rwxr-xr-x    1 sanatsamal       staff               16775 Feb 13 20:20 technical//biomed/1471-2334-1-10.txt
27156812       56 -rwxr-xr-x    1 sanatsamal       staff               25312 Feb 13 20:20 technical//biomed/1471-2407-3-15.txt
27156488       72 -rwxr-xr-x    1 sanatsamal       staff               33441 Feb 13 20:20 technical//biomed/1471-2121-3-22.txt
27156769       72 -rwxr-xr-x    1 sanatsamal       staff               35377 Feb 13 20:20 technical//biomed/1471-2334-3-15.txt
27156520       64 -rwxr-xr-x    1 sanatsamal       staff               29837 Feb 13 20:20 technical//biomed/1471-2148-1-4.txt
27156651       72 -rwxr-xr-x    1 sanatsamal       staff               34740 Feb 13 20:20 technical//biomed/1471-2199-2-5.txt
27156413       40 -rwxr-xr-x    1 sanatsamal       staff               16882 Feb 13 20:20 technical//biomed/1468-6708-3-3.txt
27157080       40 -rwxr-xr-x    1 sanatsamal       staff               20468 Feb 13 20:20 technical//biomed/bcr570.txt
27157162       96 -rwxr-xr-x    1 sanatsamal       staff               45288 Feb 13 20:20 technical//biomed/gb-2002-3-10-research0056.txt
27156946       64 -rwxr-xr-x    1 sanatsamal       staff               30395 Feb 13 20:20 technical//biomed/1472-6947-3-5.txt
27157115       48 -rwxr-xr-x    1 sanatsamal       staff               23825 Feb 13 20:20 technical//biomed/cc343.txt
27156503       64 -rwxr-xr-x    1 sanatsamal       staff               29734 Feb 13 20:20 technical//biomed/1471-213X-1-12.txt
27156739       56 -rwxr-xr-x    1 sanatsamal       staff               28483 Feb 13 20:20 technical//biomed/1471-2296-3-3.txt
27157022       56 -rwxr-xr-x    1 sanatsamal       staff               25530 Feb 13 20:20 technical//biomed/1477-7827-1-27.txt
27156996       32 -rwxr-xr-x    1 sanatsamal       staff               15245 Feb 13 20:20 technical//biomed/1476-4598-1-5.txt
27157243       64 -rwxr-xr-x    1 sanatsamal       staff               30791 Feb 13 20:20 technical//biomed/rr191.txt
27156534       72 -rwxr-xr-x    1 sanatsamal       staff               33162 Feb 13 20:20 technical//biomed/1471-2148-3-4.txt
27156840       72 -rwxr-xr-x    1 sanatsamal       staff               35574 Feb 13 20:20 technical//biomed/1471-2458-3-11.txt
27156968       64 -rwxr-xr-x    1 sanatsamal       staff               31562 Feb 13 20:20 technical//biomed/1475-2875-1-5.txt
27157023       88 -rwxr-xr-x    1 sanatsamal       staff               41600 Feb 13 20:20 technical//biomed/1477-7827-1-31.txt
27156501       56 -rwxr-xr-x    1 sanatsamal       staff               26832 Feb 13 20:20 technical//biomed/1471-213X-1-10.txt
27157184       96 -rwxr-xr-x    1 sanatsamal       staff               46710 Feb 13 20:20 technical//biomed/gb-2002-3-3-research0011.txt
27157160       72 -rwxr-xr-x    1 sanatsamal       staff               32878 Feb 13 20:20 technical//biomed/gb-2002-3-10-research0054.txt
27156411       48 -rwxr-xr-x    1 sanatsamal       staff               24112 Feb 13 20:20 technical//biomed/1468-6708-3-1.txt
27156521       32 -rwxr-xr-x    1 sanatsamal       staff               12833 Feb 13 20:20 technical//biomed/1471-2148-1-6.txt
27156698       72 -rwxr-xr-x    1 sanatsamal       staff               32938 Feb 13 20:20 technical//biomed/1471-2202-4-3.txt
27156942       40 -rwxr-xr-x    1 sanatsamal       staff               18158 Feb 13 20:20 technical//biomed/1472-6947-1-5.txt
27156674       72 -rwxr-xr-x    1 sanatsamal       staff               32780 Feb 13 20:20 technical//biomed/1471-2202-2-5.txt
27157011       80 -rwxr-xr-x    1 sanatsamal       staff               37006 Feb 13 20:20 technical//biomed/1476-9433-1-2.txt
27156702       32 -rwxr-xr-x    1 sanatsamal       staff               14603 Feb 13 20:20 technical//biomed/1471-2210-1-2.txt
27156832       64 -rwxr-xr-x    1 sanatsamal       staff               32387 Feb 13 20:20 technical//biomed/1471-2458-1-9.txt
27156893       72 -rwxr-xr-x    1 sanatsamal       staff               35125 Feb 13 20:20 technical//biomed/1472-6793-2-2.txt
27157134       56 -rwxr-xr-x    1 sanatsamal       staff               25094 Feb 13 20:20 technical//biomed/gb-2001-2-12-research0053.txt
27157031       48 -rwxr-xr-x    1 sanatsamal       staff               22678 Feb 13 20:20 technical//biomed/1478-1336-1-2.txt
27156683       88 -rwxr-xr-x    1 sanatsamal       staff               42803 Feb 13 20:20 technical//biomed/1471-2202-3-16.txt
27156627       56 -rwxr-xr-x    1 sanatsamal       staff               28049 Feb 13 20:20 technical//biomed/1471-2180-2-13.txt
27156497       56 -rwxr-xr-x    1 sanatsamal       staff               25444 Feb 13 20:20 technical//biomed/1471-2121-4-4.txt
27157224       64 -rwxr-xr-x    1 sanatsamal       staff               28895 Feb 13 20:20 technical//biomed/gb-2003-4-4-r28.txt
27156744       24 -rwxr-xr-x    1 sanatsamal       staff               11200 Feb 13 20:20 technical//biomed/1471-230X-2-17.txt
27157013       48 -rwxr-xr-x    1 sanatsamal       staff               21459 Feb 13 20:20 technical//biomed/1477-5956-1-1.txt
27156554       88 -rwxr-xr-x    1 sanatsamal       staff               43248 Feb 13 20:20 technical//biomed/1471-2156-4-9.txt
27156824       56 -rwxr-xr-x    1 sanatsamal       staff               26239 Feb 13 20:20 technical//biomed/1471-2431-2-12.txt
27157045       32 -rwxr-xr-x    1 sanatsamal       staff               15903 Feb 13 20:20 technical//biomed/ar328.txt
27156713       56 -rwxr-xr-x    1 sanatsamal       staff               28562 Feb 13 20:20 technical//biomed/1471-2210-3-1.txt
27156498       56 -rwxr-xr-x    1 sanatsamal       staff               27586 Feb 13 20:20 technical//biomed/1471-2121-4-5.txt
27156774       24 -rwxr-xr-x    1 sanatsamal       staff               11237 Feb 13 20:20 technical//biomed/1471-2350-2-8.txt
27156684       64 -rwxr-xr-x    1 sanatsamal       staff               29638 Feb 13 20:20 technical//biomed/1471-2202-3-17.txt
27156793       48 -rwxr-xr-x    1 sanatsamal       staff               23484 Feb 13 20:20 technical//biomed/1471-2407-1-13.txt
27157085       96 -rwxr-xr-x    1 sanatsamal       staff               46272 Feb 13 20:20 technical//biomed/bcr605.txt
27156990      152 -rwxr-xr-x    1 sanatsamal       staff               74965 Feb 13 20:20 technical//biomed/1476-069X-2-9.txt
27157032       48 -rwxr-xr-x    1 sanatsamal       staff               23526 Feb 13 20:20 technical//biomed/1478-1336-1-3.txt
27156557       56 -rwxr-xr-x    1 sanatsamal       staff               27684 Feb 13 20:20 technical//biomed/1471-2164-2-4.txt
27156703       56 -rwxr-xr-x    1 sanatsamal       staff               28252 Feb 13 20:20 technical//biomed/1471-2210-1-3.txt
27157012       48 -rwxr-xr-x    1 sanatsamal       staff               21318 Feb 13 20:20 technical//biomed/1476-9433-1-3.txt
27156752       48 -rwxr-xr-x    1 sanatsamal       staff               21797 Feb 13 20:20 technical//biomed/1471-2334-1-13.txt
27156813       48 -rwxr-xr-x    1 sanatsamal       staff               22447 Feb 13 20:20 technical//biomed/1471-2407-3-16.txt
27156591       56 -rwxr-xr-x    1 sanatsamal       staff               28119 Feb 13 20:20 technical//biomed/1471-2164-4-2.txt
27157124       56 -rwxr-xr-x    1 sanatsamal       staff               25609 Feb 13 20:20 technical//biomed/cvm-2-4-187.txt
27156458       72 -rwxr-xr-x    1 sanatsamal       staff               34817 Feb 13 20:20 technical//biomed/1471-2105-3-4.txt
27156487       64 -rwxr-xr-x    1 sanatsamal       staff               32262 Feb 13 20:20 technical//biomed/1471-2121-3-21.txt
27156697       72 -rwxr-xr-x    1 sanatsamal       staff               33888 Feb 13 20:20 technical//biomed/1471-2202-4-2.txt
27156613       48 -rwxr-xr-x    1 sanatsamal       staff               21927 Feb 13 20:20 technical//biomed/1471-2172-3-9.txt
27157138       48 -rwxr-xr-x    1 sanatsamal       staff               23524 Feb 13 20:20 technical//biomed/gb-2001-2-3-research0007.txt
27156652       56 -rwxr-xr-x    1 sanatsamal       staff               26704 Feb 13 20:20 technical//biomed/1471-2199-2-6.txt
27157078       32 -rwxr-xr-x    1 sanatsamal       staff               16229 Feb 13 20:20 technical//biomed/bcr567.txt
27157161       96 -rwxr-xr-x    1 sanatsamal       staff               47650 Feb 13 20:20 technical//biomed/gb-2002-3-10-research0055.txt
27156476       32 -rwxr-xr-x    1 sanatsamal       staff               14165 Feb 13 20:20 technical//biomed/1471-2121-2-3.txt
27156502       64 -rwxr-xr-x    1 sanatsamal       staff               29630 Feb 13 20:20 technical//biomed/1471-213X-1-11.txt
27156915      104 -rwxr-xr-x    1 sanatsamal       staff               49884 Feb 13 20:20 technical//biomed/1472-684X-1-5.txt
27156997       72 -rwxr-xr-x    1 sanatsamal       staff               33139 Feb 13 20:20 technical//biomed/1476-4598-1-6.txt
27156392        0 drwxr-xr-x   19 sanatsamal       staff                 608 Feb 13 20:20 technical//911report
27156400      520 -rwxr-xr-x    1 sanatsamal       staff              265912 Feb 13 20:20 technical//911report/chapter-13.4.txt
27156401      576 -rwxr-xr-x    1 sanatsamal       staff              290993 Feb 13 20:20 technical//911report/chapter-13.5.txt
27156397      176 -rwxr-xr-x    1 sanatsamal       staff               89854 Feb 13 20:20 technical//911report/chapter-13.1.txt
27156398      216 -rwxr-xr-x    1 sanatsamal       staff              110568 Feb 13 20:20 technical//911report/chapter-13.2.txt
27156399      296 -rwxr-xr-x    1 sanatsamal       staff              150467 Feb 13 20:20 technical//911report/chapter-13.3.txt
27156403      520 -rwxr-xr-x    1 sanatsamal       staff              264360 Feb 13 20:20 technical//911report/chapter-3.txt
27156402      160 -rwxr-xr-x    1 sanatsamal       staff               79803 Feb 13 20:20 technical//911report/chapter-2.txt
27156393      232 -rwxr-xr-x    1 sanatsamal       staff              118656 Feb 13 20:20 technical//911report/chapter-1.txt
27156404      200 -rwxr-xr-x    1 sanatsamal       staff               99008 Feb 13 20:20 technical//911report/chapter-5.txt
27156405      296 -rwxr-xr-x    1 sanatsamal       staff              149063 Feb 13 20:20 technical//911report/chapter-6.txt
27156406      256 -rwxr-xr-x    1 sanatsamal       staff              128370 Feb 13 20:20 technical//911report/chapter-7.txt
27156408      296 -rwxr-xr-x    1 sanatsamal       staff              149644 Feb 13 20:20 technical//911report/chapter-9.txt
27156407      168 -rwxr-xr-x    1 sanatsamal       staff               84835 Feb 13 20:20 technical//911report/chapter-8.txt
27156409       24 -rwxr-xr-x    1 sanatsamal       staff                9332 Feb 13 20:20 technical//911report/preface.txt
27156396      256 -rwxr-xr-x    1 sanatsamal       staff              127587 Feb 13 20:20 technical//911report/chapter-12.txt
27156394       96 -rwxr-xr-x    1 sanatsamal       staff               47307 Feb 13 20:20 technical//911report/chapter-10.txt
27156395      144 -rwxr-xr-x    1 sanatsamal       staff               71151 Feb 13 20:20 technical//911report/chapter-11.txt
```

This command finds all the file directory information and lists it. For this scenario it displays all the files and directories within the biomed direcory.
```
(base) sanatsamal@Sanats-MacBook-Pro technical % find biomed/ -ls
27156410        0 drwxr-xr-x  839 sanatsamal       staff               26848 Feb 13 20:20 biomed/
27156903       40 -rwxr-xr-x    1 sanatsamal       staff               18059 Feb 13 20:20 biomed//1472-6807-2-2.txt
27156780       64 -rwxr-xr-x    1 sanatsamal       staff               29678 Feb 13 20:20 biomed//1471-2350-4-3.txt
27156540       40 -rwxr-xr-x    1 sanatsamal       staff               19344 Feb 13 20:20 biomed//1471-2156-2-3.txt
27156545       48 -rwxr-xr-x    1 sanatsamal       staff               20685 Feb 13 20:20 biomed//1471-2156-3-11.txt
27156478       80 -rwxr-xr-x    1 sanatsamal       staff               39412 Feb 13 20:20 biomed//1471-2121-3-10.txt
27156612       88 -rwxr-xr-x    1 sanatsamal       staff               40982 Feb 13 20:20 biomed//1471-2172-3-4.txt
27157211       96 -rwxr-xr-x    1 sanatsamal       staff               48746 Feb 13 20:20 biomed//gb-2002-4-1-r2.txt
27157230       48 -rwxr-xr-x    1 sanatsamal       staff               22764 Feb 13 20:20 biomed//gb-2003-4-6-r41.txt
27156845       48 -rwxr-xr-x    1 sanatsamal       staff               23163 Feb 13 20:20 biomed//1471-2466-1-1.txt
27156646       56 -rwxr-xr-x    1 sanatsamal       staff               26466 Feb 13 20:20 biomed//1471-2199-2-10.txt
27156678       80 -rwxr-xr-x    1 sanatsamal       staff               40360 Feb 13 20:20 biomed//1471-2202-2-9.txt
27157121       56 -rwxr-xr-x    1 sanatsamal       staff               24929 Feb 13 20:20 biomed//cc991.txt
27156786       48 -rwxr-xr-x    1 sanatsamal       staff               22370 Feb 13 20:20 biomed//1471-2369-3-9.txt
27157088       72 -rwxr-xr-x    1 sanatsamal       staff               35035 Feb 13 20:20 biomed//bcr620.txt
27156988      104 -rwxr-xr-x    1 sanatsamal       staff               53109 Feb 13 20:20 biomed//1476-069X-2-4.txt
27156870       32 -rwxr-xr-x    1 sanatsamal       staff               15015 Feb 13 20:20 biomed//1472-6750-3-11.txt
27156561       96 -rwxr-xr-x    1 sanatsamal       staff               47898 Feb 13 20:20 biomed//1471-2164-2-9.txt
27156416       48 -rwxr-xr-x    1 sanatsamal       staff               24028 Feb 13 20:20 biomed//1471-2091-2-10.txt
27157140       96 -rwxr-xr-x    1 sanatsamal       staff               47665 Feb 13 20:20 biomed//gb-2001-2-4-research0010.txt
27157222       80 -rwxr-xr-x    1 sanatsamal       staff               38892 Feb 13 20:20 biomed//gb-2003-4-4-r24.txt
27156511       88 -rwxr-xr-x    1 sanatsamal       staff               41353 Feb 13 20:20 biomed//1471-213X-2-1.txt
27156929       72 -rwxr-xr-x    1 sanatsamal       staff               35409 Feb 13 20:20 biomed//1472-6882-3-3.txt
27156806       56 -rwxr-xr-x    1 sanatsamal       staff               27937 Feb 13 20:20 biomed//1471-2407-2-3.txt
27157046       48 -rwxr-xr-x    1 sanatsamal       staff               20970 Feb 13 20:20 biomed//ar331.txt
27157043       64 -rwxr-xr-x    1 sanatsamal       staff               29069 Feb 13 20:20 biomed//ar319.txt
27156552       56 -rwxr-xr-x    1 sanatsamal       staff               27525 Feb 13 20:20 biomed//1471-2156-4-5.txt
27156822       64 -rwxr-xr-x    1 sanatsamal       staff               30767 Feb 13 20:20 biomed//1471-2431-2-1.txt
27157002       32 -rwxr-xr-x    1 sanatsamal       staff               15699 Feb 13 20:20 biomed//1476-4598-2-22.txt
27156631       56 -rwxr-xr-x    1 sanatsamal       staff               26497 Feb 13 20:20 biomed//1471-2180-2-22.txt
27156770       48 -rwxr-xr-x    1 sanatsamal       staff               23741 Feb 13 20:20 biomed//1471-2334-3-9.txt
27156417       72 -rwxr-xr-x    1 sanatsamal       staff               35103 Feb 13 20:20 biomed//1471-2091-2-11.txt
27157141       88 -rwxr-xr-x    1 sanatsamal       staff               43999 Feb 13 20:20 biomed//gb-2001-2-4-research0011.txt
27156694       48 -rwxr-xr-x    1 sanatsamal       staff               21868 Feb 13 20:20 biomed//1471-2202-4-12.txt
27157246       40 -rwxr-xr-x    1 sanatsamal       staff               16843 Feb 13 20:20 biomed//rr73.txt
27156560       56 -rwxr-xr-x    1 sanatsamal       staff               26490 Feb 13 20:20 biomed//1471-2164-2-8.txt
27156523       64 -rwxr-xr-x    1 sanatsamal       staff               32108 Feb 13 20:20 biomed//1471-2148-2-12.txt
27157090       32 -rwxr-xr-x    1 sanatsamal       staff               13481 Feb 13 20:20 biomed//bcr635.txt
27156412       64 -rwxr-xr-x    1 sanatsamal       staff               29585 Feb 13 20:20 biomed//1468-6708-3-10.txt
27157227      144 -rwxr-xr-x    1 sanatsamal       staff               70729 Feb 13 20:20 biomed//gb-2003-4-5-r34.txt
27156677       88 -rwxr-xr-x    1 sanatsamal       staff               41564 Feb 13 20:20 biomed//1471-2202-2-8.txt
27156479       64 -rwxr-xr-x    1 sanatsamal       staff               28955 Feb 13 20:20 biomed//1471-2121-3-11.txt
27156544       48 -rwxr-xr-x    1 sanatsamal       staff               23096 Feb 13 20:20 biomed//1471-2156-3-10.txt
27156842       48 -rwxr-xr-x    1 sanatsamal       staff               22605 Feb 13 20:20 biomed//1471-2458-3-20.txt
27156779       72 -rwxr-xr-x    1 sanatsamal       staff               34416 Feb 13 20:20 biomed//1471-2350-4-2.txt
27156904       96 -rwxr-xr-x    1 sanatsamal       staff               48482 Feb 13 20:20 biomed//1472-6807-2-3.txt
27156902       48 -rwxr-xr-x    1 sanatsamal       staff               23376 Feb 13 20:20 biomed//1472-6807-2-1.txt
27156998       56 -rwxr-xr-x    1 sanatsamal       staff               28420 Feb 13 20:20 biomed//1476-4598-1-8.txt
27157016       56 -rwxr-xr-x    1 sanatsamal       staff               26223 Feb 13 20:20 biomed//1477-7525-1-9.txt
27157065       72 -rwxr-xr-x    1 sanatsamal       staff               35253 Feb 13 20:20 biomed//ar79.txt
27156992       64 -rwxr-xr-x    1 sanatsamal       staff               31054 Feb 13 20:20 biomed//1476-0711-2-7.txt
27156947       72 -rwxr-xr-x    1 sanatsamal       staff               34254 Feb 13 20:20 biomed//1472-6947-3-8.txt
27156481       88 -rwxr-xr-x    1 sanatsamal       staff               43442 Feb 13 20:20 biomed//1471-2121-3-13.txt
27157210       64 -rwxr-xr-x    1 sanatsamal       staff               30292 Feb 13 20:20 biomed//gb-2002-4-1-r1.txt
27156814       80 -rwxr-xr-x    1 sanatsamal       staff               37922 Feb 13 20:20 biomed//1471-2407-3-18.txt
27156718       96 -rwxr-xr-x    1 sanatsamal       staff               46406 Feb 13 20:20 biomed//1471-2229-2-3.txt
27156756       40 -rwxr-xr-x    1 sanatsamal       staff               19590 Feb 13 20:20 biomed//1471-2334-1-9.txt
27157203      112 -rwxr-xr-x    1 sanatsamal       staff               57158 Feb 13 20:20 biomed//gb-2002-3-9-research0043.txt
27156821       88 -rwxr-xr-x    1 sanatsamal       staff               44803 Feb 13 20:20 biomed//1471-2415-3-5.txt
27156754       40 -rwxr-xr-x    1 sanatsamal       staff               16640 Feb 13 20:20 biomed//1471-2334-1-21.txt
27157148      136 -rwxr-xr-x    1 sanatsamal       staff               69168 Feb 13 20:20 biomed//gb-2001-2-7-research0025.txt
27157038       96 -rwxr-xr-x    1 sanatsamal       staff               46550 Feb 13 20:20 biomed//ar130.txt
27156989       56 -rwxr-xr-x    1 sanatsamal       staff               28318 Feb 13 20:20 biomed//1476-069X-2-7.txt
27156931       40 -rwxr-xr-x    1 sanatsamal       staff               19200 Feb 13 20:20 biomed//1472-6890-2-5.txt
27157036       72 -rwxr-xr-x    1 sanatsamal       staff               36324 Feb 13 20:20 biomed//ar118.txt
27157196       64 -rwxr-xr-x    1 sanatsamal       staff               30444 Feb 13 20:20 biomed//gb-2002-3-7-research0032.txt
27156725      112 -rwxr-xr-x    1 sanatsamal       staff               53437 Feb 13 20:20 biomed//1471-2253-2-5.txt
27156701       64 -rwxr-xr-x    1 sanatsamal       staff               29200 Feb 13 20:20 biomed//1471-2210-1-10.txt
27156419       56 -rwxr-xr-x    1 sanatsamal       staff               27970 Feb 13 20:20 biomed//1471-2091-2-13.txt
27156630       80 -rwxr-xr-x    1 sanatsamal       staff               38478 Feb 13 20:20 biomed//1471-2180-2-20.txt
27156685       64 -rwxr-xr-x    1 sanatsamal       staff               30039 Feb 13 20:20 biomed//1471-2202-3-19.txt
27156692       64 -rwxr-xr-x    1 sanatsamal       staff               29083 Feb 13 20:20 biomed//1471-2202-4-10.txt
27156951       64 -rwxr-xr-x    1 sanatsamal       staff               29285 Feb 13 20:20 biomed//1472-6963-2-10.txt
27157001       56 -rwxr-xr-x    1 sanatsamal       staff               26696 Feb 13 20:20 biomed//1476-4598-2-20.txt
27156553       72 -rwxr-xr-x    1 sanatsamal       staff               35378 Feb 13 20:20 biomed//1471-2156-4-6.txt
27156843       56 -rwxr-xr-x    1 sanatsamal       staff               25679 Feb 13 20:20 biomed//1471-2458-3-5.txt
27156876       24 -rwxr-xr-x    1 sanatsamal       staff                9952 Feb 13 20:20 biomed//1472-6769-1-4.txt
27157223      128 -rwxr-xr-x    1 sanatsamal       staff               62553 Feb 13 20:20 biomed//gb-2003-4-4-r26.txt
27156928       96 -rwxr-xr-x    1 sanatsamal       staff               48170 Feb 13 20:20 biomed//1472-6882-3-1.txt
27157118       88 -rwxr-xr-x    1 sanatsamal       staff               43694 Feb 13 20:20 biomed//cc4.txt
27156635       96 -rwxr-xr-x    1 sanatsamal       staff               47423 Feb 13 20:20 biomed//1471-2180-2-35.txt
27156693       88 -rwxr-xr-x    1 sanatsamal       staff               42348 Feb 13 20:20 biomed//1471-2202-4-11.txt
27157142       72 -rwxr-xr-x    1 sanatsamal       staff               35659 Feb 13 20:20 biomed//gb-2001-2-4-research0012.txt
27156418       56 -rwxr-xr-x    1 sanatsamal       staff               24851 Feb 13 20:20 biomed//1471-2091-2-12.txt
27156724       40 -rwxr-xr-x    1 sanatsamal       staff               17387 Feb 13 20:20 biomed//1471-2253-2-4.txt
27157147       88 -rwxr-xr-x    1 sanatsamal       staff               44121 Feb 13 20:20 biomed//gb-2001-2-7-research0024.txt
27156820       48 -rwxr-xr-x    1 sanatsamal       staff               22465 Feb 13 20:20 biomed//1471-2415-3-4.txt
27156647       48 -rwxr-xr-x    1 sanatsamal       staff               24301 Feb 13 20:20 biomed//1471-2199-2-12.txt
27156480       88 -rwxr-xr-x    1 sanatsamal       staff               44218 Feb 13 20:20 biomed//1471-2121-3-12.txt
27156522       96 -rwxr-xr-x    1 sanatsamal       staff               48738 Feb 13 20:20 biomed//1471-2148-1-8.txt
27157139       72 -rwxr-xr-x    1 sanatsamal       staff               33499 Feb 13 20:20 biomed//gb-2001-2-3-research0008.txt
27156536       80 -rwxr-xr-x    1 sanatsamal       staff               38628 Feb 13 20:20 biomed//1471-2156-2-1.txt
27156848       32 -rwxr-xr-x    1 sanatsamal       staff               15457 Feb 13 20:20 biomed//1471-2466-3-1.txt
27157079       40 -rwxr-xr-x    1 sanatsamal       staff               19743 Feb 13 20:20 biomed//bcr568.txt
27157233       80 -rwxr-xr-x    1 sanatsamal       staff               37359 Feb 13 20:20 biomed//gb-2003-4-7-r46.txt
27156970       80 -rwxr-xr-x    1 sanatsamal       staff               39946 Feb 13 20:20 biomed//1475-2875-2-14.txt
27156733       64 -rwxr-xr-x    1 sanatsamal       staff               30077 Feb 13 20:20 biomed//1471-2288-2-4.txt
27156877       48 -rwxr-xr-x    1 sanatsamal       staff               24168 Feb 13 20:20 biomed//1472-6785-1-3.txt
27157069       72 -rwxr-xr-x    1 sanatsamal       staff               32793 Feb 13 20:20 biomed//ar93.txt
27156913       64 -rwxr-xr-x    1 sanatsamal       staff               29057 Feb 13 20:20 biomed//1472-6831-2-2.txt
27157082       40 -rwxr-xr-x    1 sanatsamal       staff               19181 Feb 13 20:20 biomed//bcr583.txt
27157117       40 -rwxr-xr-x    1 sanatsamal       staff               20130 Feb 13 20:20 biomed//cc367.txt
27157019       64 -rwxr-xr-x    1 sanatsamal       staff               30587 Feb 13 20:20 biomed//1477-7827-1-17.txt
27157018      112 -rwxr-xr-x    1 sanatsamal       staff               55102 Feb 13 20:20 biomed//1477-7827-1-13.txt
27156905       80 -rwxr-xr-x    1 sanatsamal       staff               39829 Feb 13 20:20 biomed//1472-6807-2-4.txt
27156547      104 -rwxr-xr-x    1 sanatsamal       staff               49960 Feb 13 20:20 biomed//1471-2156-3-17.txt
27156969       72 -rwxr-xr-x    1 sanatsamal       staff               35430 Feb 13 20:20 biomed//1475-2875-2-10.txt
27157231      128 -rwxr-xr-x    1 sanatsamal       staff               64870 Feb 13 20:20 biomed//gb-2003-4-7-r42.txt
27156541       48 -rwxr-xr-x    1 sanatsamal       staff               22998 Feb 13 20:20 biomed//1471-2156-2-5.txt
27157060       56 -rwxr-xr-x    1 sanatsamal       staff               27018 Feb 13 20:20 biomed//ar68.txt
27156611       80 -rwxr-xr-x    1 sanatsamal       staff               38202 Feb 13 20:20 biomed//1471-2172-3-2.txt
27156483      104 -rwxr-xr-x    1 sanatsamal       staff               52637 Feb 13 20:20 biomed//1471-2121-3-16.txt
27156861       56 -rwxr-xr-x    1 sanatsamal       staff               25046 Feb 13 20:20 biomed//1472-6750-1-12.txt
27156936       88 -rwxr-xr-x    1 sanatsamal       staff               44524 Feb 13 20:20 biomed//1472-6904-2-7.txt
27156925       56 -rwxr-xr-x    1 sanatsamal       staff               25465 Feb 13 20:20 biomed//1472-6882-1-7.txt
27156755       48 -rwxr-xr-x    1 sanatsamal       staff               22860 Feb 13 20:20 biomed//1471-2334-1-24.txt
27156790       56 -rwxr-xr-x    1 sanatsamal       staff               24779 Feb 13 20:20 biomed//1471-2377-2-4.txt
27157206       72 -rwxr-xr-x    1 sanatsamal       staff               33810 Feb 13 20:20 biomed//gb-2002-3-9-research0046.txt
27157247       48 -rwxr-xr-x    1 sanatsamal       staff               22290 Feb 13 20:20 biomed//rr74.txt
27157199       72 -rwxr-xr-x    1 sanatsamal       staff               36803 Feb 13 20:20 biomed//gb-2002-3-7-research0037.txt
27157149       64 -rwxr-xr-x    1 sanatsamal       staff               32241 Feb 13 20:20 biomed//gb-2001-2-8-research0027.txt
27156987       72 -rwxr-xr-x    1 sanatsamal       staff               34475 Feb 13 20:20 biomed//1476-069X-2-2.txt
27156525       56 -rwxr-xr-x    1 sanatsamal       staff               28216 Feb 13 20:20 biomed//1471-2148-2-15.txt
27156918       40 -rwxr-xr-x    1 sanatsamal       staff               17569 Feb 13 20:20 biomed//1472-6874-2-1.txt
27156706       40 -rwxr-xr-x    1 sanatsamal       staff               20085 Feb 13 20:20 biomed//1471-2210-1-8.txt
27156435       48 -rwxr-xr-x    1 sanatsamal       staff               23491 Feb 13 20:20 biomed//1471-2091-3-8.txt
27156896       80 -rwxr-xr-x    1 sanatsamal       staff               38847 Feb 13 20:20 biomed//1472-6793-2-8.txt
27156512       80 -rwxr-xr-x    1 sanatsamal       staff               37751 Feb 13 20:20 biomed//1471-213X-2-7.txt
27156686       72 -rwxr-xr-x    1 sanatsamal       staff               36617 Feb 13 20:20 biomed//1471-2202-3-20.txt
27156420       40 -rwxr-xr-x    1 sanatsamal       staff               18716 Feb 13 20:20 biomed//1471-2091-2-16.txt
27157004       72 -rwxr-xr-x    1 sanatsamal       staff               33005 Feb 13 20:20 biomed//1476-4598-2-25.txt
27156745       32 -rwxr-xr-x    1 sanatsamal       staff               16226 Feb 13 20:20 biomed//1471-230X-2-21.txt
27157003       88 -rwxr-xr-x    1 sanatsamal       staff               42549 Feb 13 20:20 biomed//1476-4598-2-24.txt
27156773       48 -rwxr-xr-x    1 sanatsamal       staff               23483 Feb 13 20:20 biomed//1471-2350-2-2.txt
27157132      120 -rwxr-xr-x    1 sanatsamal       staff               59433 Feb 13 20:20 biomed//gb-2001-2-11-research0046.txt
27156873       80 -rwxr-xr-x    1 sanatsamal       staff               37906 Feb 13 20:20 biomed//1472-6769-1-1.txt
27157037       64 -rwxr-xr-x    1 sanatsamal       staff               32393 Feb 13 20:20 biomed//ar120.txt
27156524       40 -rwxr-xr-x    1 sanatsamal       staff               16776 Feb 13 20:20 biomed//1471-2148-2-14.txt
27156795       56 -rwxr-xr-x    1 sanatsamal       staff               26498 Feb 13 20:20 biomed//1471-2407-1-19.txt
27157152       56 -rwxr-xr-x    1 sanatsamal       staff               25897 Feb 13 20:20 biomed//gb-2001-2-8-research0032.txt
27157198      144 -rwxr-xr-x    1 sanatsamal       staff               73428 Feb 13 20:20 biomed//gb-2002-3-7-research0036.txt
27156818       48 -rwxr-xr-x    1 sanatsamal       staff               22594 Feb 13 20:20 biomed//1471-2415-3-1.txt
27157226       80 -rwxr-xr-x    1 sanatsamal       staff               39796 Feb 13 20:20 biomed//gb-2003-4-5-r32.txt
27156862       56 -rwxr-xr-x    1 sanatsamal       staff               25697 Feb 13 20:20 biomed//1472-6750-1-13.txt
27156938       48 -rwxr-xr-x    1 sanatsamal       staff               22501 Feb 13 20:20 biomed//1472-6920-1-3.txt
27156849       48 -rwxr-xr-x    1 sanatsamal       staff               20548 Feb 13 20:20 biomed//1471-2474-2-1.txt
27156991       48 -rwxr-xr-x    1 sanatsamal       staff               20492 Feb 13 20:20 biomed//1476-0711-2-3.txt
27157241       80 -rwxr-xr-x    1 sanatsamal       staff               38006 Feb 13 20:20 biomed//rr171.txt
27156546       80 -rwxr-xr-x    1 sanatsamal       staff               39328 Feb 13 20:20 biomed//1471-2156-3-16.txt
27157232      128 -rwxr-xr-x    1 sanatsamal       staff               63280 Feb 13 20:20 biomed//gb-2003-4-7-r43.txt
27156906       32 -rwxr-xr-x    1 sanatsamal       staff               13059 Feb 13 20:20 biomed//1472-6807-2-5.txt
27156781       32 -rwxr-xr-x    1 sanatsamal       staff               13635 Feb 13 20:20 biomed//1471-2350-4-4.txt
27156602       72 -rwxr-xr-x    1 sanatsamal       staff               33407 Feb 13 20:20 biomed//1471-2172-1-1.txt
27157041       40 -rwxr-xr-x    1 sanatsamal       staff               18795 Feb 13 20:20 biomed//ar297.txt
27156782       80 -rwxr-xr-x    1 sanatsamal       staff               39062 Feb 13 20:20 biomed//1471-2350-4-6.txt
27157240       80 -rwxr-xr-x    1 sanatsamal       staff               36971 Feb 13 20:20 biomed//rr167.txt
27156851       56 -rwxr-xr-x    1 sanatsamal       staff               25964 Feb 13 20:20 biomed//1471-2474-2-3.txt
27156482      128 -rwxr-xr-x    1 sanatsamal       staff               62063 Feb 13 20:20 biomed//1471-2121-3-15.txt
27156607       40 -rwxr-xr-x    1 sanatsamal       staff               19007 Feb 13 20:20 biomed//1471-2172-3-1.txt
27156934       80 -rwxr-xr-x    1 sanatsamal       staff               38390 Feb 13 20:20 biomed//1472-6904-2-4.txt
27156860       72 -rwxr-xr-x    1 sanatsamal       staff               34610 Feb 13 20:20 biomed//1472-6750-1-11.txt
27157225       72 -rwxr-xr-x    1 sanatsamal       staff               36113 Feb 13 20:20 biomed//gb-2003-4-5-r30.txt
27157209       88 -rwxr-xr-x    1 sanatsamal       staff               44326 Feb 13 20:20 biomed//gb-2002-3-9-research0051.txt
27156819       72 -rwxr-xr-x    1 sanatsamal       staff               33886 Feb 13 20:20 biomed//1471-2415-3-3.txt
27157205      120 -rwxr-xr-x    1 sanatsamal       staff               58484 Feb 13 20:20 biomed//gb-2002-3-9-research0045.txt
27157150      104 -rwxr-xr-x    1 sanatsamal       staff               49958 Feb 13 20:20 biomed//gb-2001-2-8-research0030.txt
27157089       88 -rwxr-xr-x    1 sanatsamal       staff               44886 Feb 13 20:20 biomed//bcr631.txt
27156875       32 -rwxr-xr-x    1 sanatsamal       staff               14626 Feb 13 20:20 biomed//1472-6769-1-3.txt
27157112       48 -rwxr-xr-x    1 sanatsamal       staff               22668 Feb 13 20:20 biomed//cc3.txt
27156634       48 -rwxr-xr-x    1 sanatsamal       staff               21144 Feb 13 20:20 biomed//1471-2180-2-32.txt
27156695       64 -rwxr-xr-x    1 sanatsamal       staff               29125 Feb 13 20:20 biomed//1471-2202-4-16.txt
27156632       56 -rwxr-xr-x    1 sanatsamal       staff               24787 Feb 13 20:20 biomed//1471-2180-2-26.txt
27156825       40 -rwxr-xr-x    1 sanatsamal       staff               18045 Feb 13 20:20 biomed//1471-2431-2-4.txt
27156841       64 -rwxr-xr-x    1 sanatsamal       staff               31894 Feb 13 20:20 biomed//1471-2458-3-2.txt
27156985       56 -rwxr-xr-x    1 sanatsamal       staff               26713 Feb 13 20:20 biomed//1475-9276-1-3.txt
27157044       56 -rwxr-xr-x    1 sanatsamal       staff               24928 Feb 13 20:20 biomed//ar321.txt
27156746       40 -rwxr-xr-x    1 sanatsamal       staff               19639 Feb 13 20:20 biomed//1471-230X-2-23.txt
27157042       40 -rwxr-xr-x    1 sanatsamal       staff               19157 Feb 13 20:20 biomed//ar309.txt
27157143       72 -rwxr-xr-x    1 sanatsamal       staff               34260 Feb 13 20:20 biomed//gb-2001-2-4-research0014.txt
27157017       24 -rwxr-xr-x    1 sanatsamal       staff               12265 Feb 13 20:20 biomed//1477-7819-1-10.txt
27157131       72 -rwxr-xr-x    1 sanatsamal       staff               34018 Feb 13 20:20 biomed//gb-2001-2-11-research0045.txt
27156696       64 -rwxr-xr-x    1 sanatsamal       staff               29568 Feb 13 20:20 biomed//1471-2202-4-17.txt
27156874       32 -rwxr-xr-x    1 sanatsamal       staff               15688 Feb 13 20:20 biomed//1472-6769-1-2.txt
27157087       56 -rwxr-xr-x    1 sanatsamal       staff               24966 Feb 13 20:20 biomed//bcr618.txt
27157197       96 -rwxr-xr-x    1 sanatsamal       staff               48887 Feb 13 20:20 biomed//gb-2002-3-7-research0035.txt
27157151       96 -rwxr-xr-x    1 sanatsamal       staff               47386 Feb 13 20:20 biomed//gb-2001-2-8-research0031.txt
27156526       96 -rwxr-xr-x    1 sanatsamal       staff               46786 Feb 13 20:20 biomed//1471-2148-2-17.txt
27156719       72 -rwxr-xr-x    1 sanatsamal       staff               33066 Feb 13 20:20 biomed//1471-2229-2-4.txt
27156776       96 -rwxr-xr-x    1 sanatsamal       staff               47393 Feb 13 20:20 biomed//1471-2350-3-12.txt
27157204       64 -rwxr-xr-x    1 sanatsamal       staff               32469 Feb 13 20:20 biomed//gb-2002-3-9-research0044.txt
27156791       40 -rwxr-xr-x    1 sanatsamal       staff               19796 Feb 13 20:20 biomed//1471-2377-2-6.txt
27156854       40 -rwxr-xr-x    1 sanatsamal       staff               19899 Feb 13 20:20 biomed//1471-2474-4-4.txt
27156935      176 -rwxr-xr-x    1 sanatsamal       staff               89104 Feb 13 20:20 biomed//1472-6904-2-5.txt
27156912       72 -rwxr-xr-x    1 sanatsamal       staff               34387 Feb 13 20:20 biomed//1472-6823-3-1.txt
27156850       56 -rwxr-xr-x    1 sanatsamal       staff               27445 Feb 13 20:20 biomed//1471-2474-2-2.txt
27157239       48 -rwxr-xr-x    1 sanatsamal       staff               22439 Feb 13 20:20 biomed//rr166.txt
27157242       56 -rwxr-xr-x    1 sanatsamal       staff               24900 Feb 13 20:20 biomed//rr172.txt
27156542       40 -rwxr-xr-x    1 sanatsamal       staff               17411 Feb 13 20:20 biomed//1471-2156-2-7.txt
27156878       48 -rwxr-xr-x    1 sanatsamal       staff               21135 Feb 13 20:20 biomed//1472-6785-1-5.txt
27157071       80 -rwxr-xr-x    1 sanatsamal       staff               40398 Feb 13 20:20 biomed//bcr284.txt
27157182       80 -rwxr-xr-x    1 sanatsamal       staff               38916 Feb 13 20:20 biomed//gb-2002-3-2-research0008.txt
27157163      152 -rwxr-xr-x    1 sanatsamal       staff               74234 Feb 13 20:20 biomed//gb-2002-3-11-research0059.txt
27157110       40 -rwxr-xr-x    1 sanatsamal       staff               20124 Feb 13 20:20 biomed//cc2190.txt
27157167      104 -rwxr-xr-x    1 sanatsamal       staff               51918 Feb 13 20:20 biomed//gb-2002-3-11-research0065.txt
27156514       56 -rwxr-xr-x    1 sanatsamal       staff               26809 Feb 13 20:20 biomed//1471-213X-3-2.txt
27156532       64 -rwxr-xr-x    1 sanatsamal       staff               29059 Feb 13 20:20 biomed//1471-2148-3-18.txt
27156722       32 -rwxr-xr-x    1 sanatsamal       staff               15141 Feb 13 20:20 biomed//1471-2229-3-3.txt
27156614       56 -rwxr-xr-x    1 sanatsamal       staff               27888 Feb 13 20:20 biomed//1471-2172-4-1.txt
27157067       56 -rwxr-xr-x    1 sanatsamal       staff               27719 Feb 13 20:20 biomed//ar795.txt
27156565       48 -rwxr-xr-x    1 sanatsamal       staff               22329 Feb 13 20:20 biomed//1471-2164-3-15.txt
27157102       40 -rwxr-xr-x    1 sanatsamal       staff               16482 Feb 13 20:20 biomed//cc1843.txt
27156574       48 -rwxr-xr-x    1 sanatsamal       staff               22442 Feb 13 20:20 biomed//1471-2164-3-29.txt
27156834       56 -rwxr-xr-x    1 sanatsamal       staff               26515 Feb 13 20:20 biomed//1471-2458-2-16.txt
27156978       88 -rwxr-xr-x    1 sanatsamal       staff               41765 Feb 13 20:20 biomed//1475-925X-2-10.txt
27156908      144 -rwxr-xr-x    1 sanatsamal       staff               73091 Feb 13 20:20 biomed//1472-6807-3-1.txt
27157237       56 -rwxr-xr-x    1 sanatsamal       staff               27080 Feb 13 20:20 biomed//gb-2003-4-9-r58.txt
27156464       48 -rwxr-xr-x    1 sanatsamal       staff               23355 Feb 13 20:20 biomed//1471-2105-4-27.txt
27156442       48 -rwxr-xr-x    1 sanatsamal       staff               21074 Feb 13 20:20 biomed//1471-2105-3-12.txt
27157216       64 -rwxr-xr-x    1 sanatsamal       staff               32489 Feb 13 20:20 biomed//gb-2003-4-2-r16.txt
27157050       56 -rwxr-xr-x    1 sanatsamal       staff               26013 Feb 13 20:20 biomed//ar408.txt
27157051       56 -rwxr-xr-x    1 sanatsamal       staff               27953 Feb 13 20:20 biomed//ar409.txt
27156797       64 -rwxr-xr-x    1 sanatsamal       staff               30455 Feb 13 20:20 biomed//1471-2407-2-11.txt
27157129       72 -rwxr-xr-x    1 sanatsamal       staff               36125 Feb 13 20:20 biomed//gb-2001-2-10-research0041.txt
27156734       80 -rwxr-xr-x    1 sanatsamal       staff               39781 Feb 13 20:20 biomed//1471-2288-3-4.txt
27156463       64 -rwxr-xr-x    1 sanatsamal       staff               29786 Feb 13 20:20 biomed//1471-2105-4-26.txt
27156741       48 -rwxr-xr-x    1 sanatsamal       staff               22520 Feb 13 20:20 biomed//1471-230X-1-5.txt
27157202       56 -rwxr-xr-x    1 sanatsamal       staff               25182 Feb 13 20:20 biomed//gb-2002-3-8-research0040.txt
27156979       40 -rwxr-xr-x    1 sanatsamal       staff               17188 Feb 13 20:20 biomed//1475-925X-2-11.txt
27157153       48 -rwxr-xr-x    1 sanatsamal       staff               22853 Feb 13 20:20 biomed//gb-2001-2-9-research0035.txt
27156609       72 -rwxr-xr-x    1 sanatsamal       staff               33309 Feb 13 20:20 biomed//1471-2172-3-12.txt
27157228       88 -rwxr-xr-x    1 sanatsamal       staff               41587 Feb 13 20:20 biomed//gb-2003-4-6-r37.txt
27156864       48 -rwxr-xr-x    1 sanatsamal       staff               24163 Feb 13 20:20 biomed//1472-6750-1-8.txt
27156830       64 -rwxr-xr-x    1 sanatsamal       staff               32110 Feb 13 20:20 biomed//1471-244X-2-9.txt
27157178       96 -rwxr-xr-x    1 sanatsamal       staff               48768 Feb 13 20:20 biomed//gb-2002-3-12-research0085.txt
27156500       40 -rwxr-xr-x    1 sanatsamal       staff               16722 Feb 13 20:20 biomed//1471-213X-1-1.txt
27156592       80 -rwxr-xr-x    1 sanatsamal       staff               40895 Feb 13 20:20 biomed//1471-2164-4-21.txt
27157104       40 -rwxr-xr-x    1 sanatsamal       staff               17889 Feb 13 20:20 biomed//cc1856.txt
27156641       80 -rwxr-xr-x    1 sanatsamal       staff               39977 Feb 13 20:20 biomed//1471-2180-3-15.txt
27156573       80 -rwxr-xr-x    1 sanatsamal       staff               39250 Feb 13 20:20 biomed//1471-2164-3-28.txt
27157093       48 -rwxr-xr-x    1 sanatsamal       staff               21650 Feb 13 20:20 biomed//cc105.txt
27156663       32 -rwxr-xr-x    1 sanatsamal       staff               16156 Feb 13 20:20 biomed//1471-2202-2-10.txt
27156625       72 -rwxr-xr-x    1 sanatsamal       staff               35320 Feb 13 20:20 biomed//1471-2180-1-8.txt
27156826       56 -rwxr-xr-x    1 sanatsamal       staff               25954 Feb 13 20:20 biomed//1471-2431-3-3.txt
27156784       48 -rwxr-xr-x    1 sanatsamal       staff               22598 Feb 13 20:20 biomed//1471-2369-3-10.txt
27156515      112 -rwxr-xr-x    1 sanatsamal       staff               55468 Feb 13 20:20 biomed//1471-213X-3-3.txt
27157098       48 -rwxr-xr-x    1 sanatsamal       staff               23920 Feb 13 20:20 biomed//cc1498.txt
27156789       32 -rwxr-xr-x    1 sanatsamal       staff               16023 Feb 13 20:20 biomed//1471-2377-1-2.txt
27156777       40 -rwxr-xr-x    1 sanatsamal       staff               18161 Feb 13 20:20 biomed//1471-2350-3-7.txt
27157183       48 -rwxr-xr-x    1 sanatsamal       staff               22813 Feb 13 20:20 biomed//gb-2002-3-2-research0009.txt
27157072       72 -rwxr-xr-x    1 sanatsamal       staff               35311 Feb 13 20:20 biomed//bcr285.txt
27157195       72 -rwxr-xr-x    1 sanatsamal       staff               34079 Feb 13 20:20 biomed//gb-2002-3-6-software0001.txt
27156963       72 -rwxr-xr-x    1 sanatsamal       staff               34655 Feb 13 20:20 biomed//1475-2867-3-12.txt
27156715       56 -rwxr-xr-x    1 sanatsamal       staff               25656 Feb 13 20:20 biomed//1471-2229-1-2.txt
27156815       80 -rwxr-xr-x    1 sanatsamal       staff               39297 Feb 13 20:20 biomed//1471-2407-3-3.txt
27156930       88 -rwxr-xr-x    1 sanatsamal       staff               42977 Feb 13 20:20 biomed//1472-6890-1-4.txt
27156615       56 -rwxr-xr-x    1 sanatsamal       staff               28351 Feb 13 20:20 biomed//1471-2172-4-2.txt
27156566       56 -rwxr-xr-x    1 sanatsamal       staff               27283 Feb 13 20:20 biomed//1471-2164-3-16.txt
27156429       80 -rwxr-xr-x    1 sanatsamal       staff               40558 Feb 13 20:20 biomed//1471-2091-3-18.txt
27156664       64 -rwxr-xr-x    1 sanatsamal       staff               29596 Feb 13 20:20 biomed//1471-2202-2-12.txt
27156594       64 -rwxr-xr-x    1 sanatsamal       staff               31625 Feb 13 20:20 biomed//1471-2164-4-23.txt
27156507       80 -rwxr-xr-x    1 sanatsamal       staff               39354 Feb 13 20:20 biomed//1471-213X-1-3.txt
27157180       96 -rwxr-xr-x    1 sanatsamal       staff               46321 Feb 13 20:20 biomed//gb-2002-3-12-research0087.txt
27156432       72 -rwxr-xr-x    1 sanatsamal       staff               34168 Feb 13 20:20 biomed//1471-2091-3-30.txt
27157172       72 -rwxr-xr-x    1 sanatsamal       staff               34732 Feb 13 20:20 biomed//gb-2002-3-12-research0078.txt
27156585       64 -rwxr-xr-x    1 sanatsamal       staff               29123 Feb 13 20:20 biomed//1471-2164-3-9.txt
27156608       80 -rwxr-xr-x    1 sanatsamal       staff               40190 Feb 13 20:20 biomed//1471-2172-3-10.txt
27156605       72 -rwxr-xr-x    1 sanatsamal       staff               35974 Feb 13 20:20 biomed//1471-2172-2-4.txt
27156616       72 -rwxr-xr-x    1 sanatsamal       staff               36285 Feb 13 20:20 biomed//1471-2180-1-12.txt
27157144       88 -rwxr-xr-x    1 sanatsamal       staff               42611 Feb 13 20:20 biomed//gb-2001-2-6-research0018.txt
27157154       88 -rwxr-xr-x    1 sanatsamal       staff               44019 Feb 13 20:20 biomed//gb-2001-2-9-research0037.txt
27156441       56 -rwxr-xr-x    1 sanatsamal       staff               25632 Feb 13 20:20 biomed//1471-2105-2-9.txt
27156937      128 -rwxr-xr-x    1 sanatsamal       staff               63901 Feb 13 20:20 biomed//1472-6904-3-1.txt
27156889       64 -rwxr-xr-x    1 sanatsamal       staff               29048 Feb 13 20:20 biomed//1472-6793-2-16.txt
27156909       40 -rwxr-xr-x    1 sanatsamal       staff               20394 Feb 13 20:20 biomed//1472-6807-3-2.txt
27156994      104 -rwxr-xr-x    1 sanatsamal       staff               51827 Feb 13 20:20 biomed//1476-072X-2-4.txt
27156473       80 -rwxr-xr-x    1 sanatsamal       staff               39018 Feb 13 20:20 biomed//1471-2121-2-18.txt
27156530       72 -rwxr-xr-x    1 sanatsamal       staff               34954 Feb 13 20:20 biomed//1471-2148-2-8.txt
27156461       64 -rwxr-xr-x    1 sanatsamal       staff               31885 Feb 13 20:20 biomed//1471-2105-4-24.txt
27156549       48 -rwxr-xr-x    1 sanatsamal       staff               21552 Feb 13 20:20 biomed//1471-2156-3-3.txt
27156846       72 -rwxr-xr-x    1 sanatsamal       staff               34691 Feb 13 20:20 biomed//1471-2466-2-3.txt
27156748       48 -rwxr-xr-x    1 sanatsamal       staff               21842 Feb 13 20:20 biomed//1471-230X-3-5.txt
27156798       40 -rwxr-xr-x    1 sanatsamal       staff               18959 Feb 13 20:20 biomed//1471-2407-2-12.txt
27157215      112 -rwxr-xr-x    1 sanatsamal       staff               55514 Feb 13 20:20 biomed//gb-2003-4-2-r14.txt
27156933       64 -rwxr-xr-x    1 sanatsamal       staff               29304 Feb 13 20:20 biomed//1472-6904-1-2.txt
27157100       64 -rwxr-xr-x    1 sanatsamal       staff               29974 Feb 13 20:20 biomed//cc1538.txt
27156462       40 -rwxr-xr-x    1 sanatsamal       staff               20276 Feb 13 20:20 biomed//1471-2105-4-25.txt
27156457       64 -rwxr-xr-x    1 sanatsamal       staff               32376 Feb 13 20:20 biomed//1471-2105-3-38.txt
27157052       64 -rwxr-xr-x    1 sanatsamal       staff               31030 Feb 13 20:20 biomed//ar422.txt
27157130       88 -rwxr-xr-x    1 sanatsamal       staff               44791 Feb 13 20:20 biomed//gb-2001-2-10-research0042.txt
27156466       56 -rwxr-xr-x    1 sanatsamal       staff               27649 Feb 13 20:20 biomed//1471-2105-4-31.txt
27156914       64 -rwxr-xr-x    1 sanatsamal       staff               30221 Feb 13 20:20 biomed//1472-6831-3-1.txt
27157048       40 -rwxr-xr-x    1 sanatsamal       staff               18845 Feb 13 20:20 biomed//ar387.txt
27156742       32 -rwxr-xr-x    1 sanatsamal       staff               13669 Feb 13 20:20 biomed//1471-230X-1-6.txt
27156890       56 -rwxr-xr-x    1 sanatsamal       staff               25629 Feb 13 20:20 biomed//1472-6793-2-17.txt
27156539       80 -rwxr-xr-x    1 sanatsamal       staff               37452 Feb 13 20:20 biomed//1471-2156-2-18.txt
27156440      136 -rwxr-xr-x    1 sanatsamal       staff               68152 Feb 13 20:20 biomed//1471-2105-2-8.txt
27156980       48 -rwxr-xr-x    1 sanatsamal       staff               23897 Feb 13 20:20 biomed//1475-925X-2-12.txt
27157034       72 -rwxr-xr-x    1 sanatsamal       staff               33145 Feb 13 20:20 biomed//1478-7954-1-3.txt
27156901       40 -rwxr-xr-x    1 sanatsamal       staff               17081 Feb 13 20:20 biomed//1472-6807-1-1.txt
27157105       48 -rwxr-xr-x    1 sanatsamal       staff               23617 Feb 13 20:20 biomed//cc1882.txt
27156584       72 -rwxr-xr-x    1 sanatsamal       staff               32805 Feb 13 20:20 biomed//1471-2164-3-8.txt
27156644       72 -rwxr-xr-x    1 sanatsamal       staff               35916 Feb 13 20:20 biomed//1471-2180-3-9.txt
27157173      120 -rwxr-xr-x    1 sanatsamal       staff               59919 Feb 13 20:20 biomed//gb-2002-3-12-research0079.txt
27156433      112 -rwxr-xr-x    1 sanatsamal       staff               56000 Feb 13 20:20 biomed//1471-2091-3-31.txt
27157179      168 -rwxr-xr-x    1 sanatsamal       staff               83990 Feb 13 20:20 biomed//gb-2002-3-12-research0086.txt
27156593       72 -rwxr-xr-x    1 sanatsamal       staff               35306 Feb 13 20:20 biomed//1471-2164-4-22.txt
27156506       88 -rwxr-xr-x    1 sanatsamal       staff               42612 Feb 13 20:20 biomed//1471-213X-1-2.txt
27156691       56 -rwxr-xr-x    1 sanatsamal       staff               26090 Feb 13 20:20 biomed//1471-2202-3-8.txt
27156839       64 -rwxr-xr-x    1 sanatsamal       staff               31785 Feb 13 20:20 biomed//1471-2458-2-6.txt
27157027       56 -rwxr-xr-x    1 sanatsamal       staff               25856 Feb 13 20:20 biomed//1477-7827-1-48.txt
27156716       40 -rwxr-xr-x    1 sanatsamal       staff               20162 Feb 13 20:20 biomed//1471-2229-1-3.txt
27156516       96 -rwxr-xr-x    1 sanatsamal       staff               48262 Feb 13 20:20 biomed//1471-213X-3-4.txt
27157113       48 -rwxr-xr-x    1 sanatsamal       staff               23472 Feb 13 20:20 biomed//cc300.txt
27156986       56 -rwxr-xr-x    1 sanatsamal       staff               26286 Feb 13 20:20 biomed//1476-069X-1-3.txt
27156723       40 -rwxr-xr-x    1 sanatsamal       staff               17890 Feb 13 20:20 biomed//1471-2253-1-1.txt
27156827       72 -rwxr-xr-x    1 sanatsamal       staff               36152 Feb 13 20:20 biomed//1471-2431-3-4.txt
27156712       48 -rwxr-xr-x    1 sanatsamal       staff               21547 Feb 13 20:20 biomed//1471-2210-2-9.txt
27157176       88 -rwxr-xr-x    1 sanatsamal       staff               42932 Feb 13 20:20 biomed//gb-2002-3-12-research0082.txt
27156509       80 -rwxr-xr-x    1 sanatsamal       staff               37943 Feb 13 20:20 biomed//1471-213X-1-6.txt
27156597       64 -rwxr-xr-x    1 sanatsamal       staff               31252 Feb 13 20:20 biomed//1471-2164-4-26.txt
27156564       56 -rwxr-xr-x    1 sanatsamal       staff               25132 Feb 13 20:20 biomed//1471-2164-3-13.txt
27156668       64 -rwxr-xr-x    1 sanatsamal       staff               29890 Feb 13 20:20 biomed//1471-2202-2-17.txt
27156921       40 -rwxr-xr-x    1 sanatsamal       staff               18530 Feb 13 20:20 biomed//1472-6874-3-2.txt
27157064       80 -rwxr-xr-x    1 sanatsamal       staff               39259 Feb 13 20:20 biomed//ar778.txt
27157062       40 -rwxr-xr-x    1 sanatsamal       staff               18059 Feb 13 20:20 biomed//ar750.txt
27156853       48 -rwxr-xr-x    1 sanatsamal       staff               20593 Feb 13 20:20 biomed//1471-2474-3-3.txt
27156879       56 -rwxr-xr-x    1 sanatsamal       staff               25115 Feb 13 20:20 biomed//1472-6785-2-6.txt
27156856       16 -rwxr-xr-x    1 sanatsamal       staff                6804 Feb 13 20:20 biomed//1471-2490-3-2.txt
27157030       96 -rwxr-xr-x    1 sanatsamal       staff               45807 Feb 13 20:20 biomed//1477-7827-1-9.txt
27157146       72 -rwxr-xr-x    1 sanatsamal       staff               36620 Feb 13 20:20 biomed//gb-2001-2-6-research0021.txt
27157059       56 -rwxr-xr-x    1 sanatsamal       staff               25700 Feb 13 20:20 biomed//ar624.txt
27156474       64 -rwxr-xr-x    1 sanatsamal       staff               29502 Feb 13 20:20 biomed//1471-2121-2-21.txt
27156940       40 -rwxr-xr-x    1 sanatsamal       staff               19761 Feb 13 20:20 biomed//1472-6920-2-3.txt
27157047       32 -rwxr-xr-x    1 sanatsamal       staff               14731 Feb 13 20:20 biomed//ar383.txt
27156443      112 -rwxr-xr-x    1 sanatsamal       staff               54441 Feb 13 20:20 biomed//1471-2105-3-14.txt
27156800       48 -rwxr-xr-x    1 sanatsamal       staff               23819 Feb 13 20:20 biomed//1471-2407-2-16.txt
27156452       80 -rwxr-xr-x    1 sanatsamal       staff               38482 Feb 13 20:20 biomed//1471-2105-3-28.txt
27157214       88 -rwxr-xr-x    1 sanatsamal       staff               42624 Feb 13 20:20 biomed//gb-2003-4-2-r11.txt
27157099       56 -rwxr-xr-x    1 sanatsamal       staff               25108 Feb 13 20:20 biomed//cc1529.txt
27156801       96 -rwxr-xr-x    1 sanatsamal       staff               45137 Feb 13 20:20 biomed//1471-2407-2-17.txt
27156910       64 -rwxr-xr-x    1 sanatsamal       staff               32679 Feb 13 20:20 biomed//1472-6815-2-3.txt
27157058       40 -rwxr-xr-x    1 sanatsamal       staff               19149 Feb 13 20:20 biomed//ar619.txt
27156833       56 -rwxr-xr-x    1 sanatsamal       staff               26761 Feb 13 20:20 biomed//1471-2458-2-11.txt
27157145       56 -rwxr-xr-x    1 sanatsamal       staff               27074 Feb 13 20:20 biomed//gb-2001-2-6-research0020.txt
27156880       80 -rwxr-xr-x    1 sanatsamal       staff               40558 Feb 13 20:20 biomed//1472-6785-2-7.txt
27156617       56 -rwxr-xr-x    1 sanatsamal       staff               27490 Feb 13 20:20 biomed//1471-2180-1-16.txt
27157061       56 -rwxr-xr-x    1 sanatsamal       staff               27848 Feb 13 20:20 biomed//ar745.txt
27156932       72 -rwxr-xr-x    1 sanatsamal       staff               34258 Feb 13 20:20 biomed//1472-6890-3-2.txt
27157091       64 -rwxr-xr-x    1 sanatsamal       staff               30360 Feb 13 20:20 biomed//cc103.txt
27156667       72 -rwxr-xr-x    1 sanatsamal       staff               32894 Feb 13 20:20 biomed//1471-2202-2-16.txt
27157066       56 -rwxr-xr-x    1 sanatsamal       staff               25237 Feb 13 20:20 biomed//ar792.txt
27157177      176 -rwxr-xr-x    1 sanatsamal       staff               88698 Feb 13 20:20 biomed//gb-2002-3-12-research0083.txt
27156640       64 -rwxr-xr-x    1 sanatsamal       staff               31355 Feb 13 20:20 biomed//1471-2180-3-13.txt
27156711       56 -rwxr-xr-x    1 sanatsamal       staff               25317 Feb 13 20:20 biomed//1471-2210-2-8.txt
27156886       88 -rwxr-xr-x    1 sanatsamal       staff               42284 Feb 13 20:20 biomed//1472-6793-1-8.txt
27156838       64 -rwxr-xr-x    1 sanatsamal       staff               29911 Feb 13 20:20 biomed//1471-2458-2-3.txt
27156869       64 -rwxr-xr-x    1 sanatsamal       staff               31607 Feb 13 20:20 biomed//1472-6750-2-21.txt
27156828       72 -rwxr-xr-x    1 sanatsamal       staff               34936 Feb 13 20:20 biomed//1471-2431-3-5.txt
27156926       48 -rwxr-xr-x    1 sanatsamal       staff               21093 Feb 13 20:20 biomed//1472-6882-2-10.txt
27156775       96 -rwxr-xr-x    1 sanatsamal       staff               48211 Feb 13 20:20 biomed//1471-2350-3-1.txt
27157166       88 -rwxr-xr-x    1 sanatsamal       staff               44323 Feb 13 20:20 biomed//gb-2002-3-11-research0062.txt
27156927       32 -rwxr-xr-x    1 sanatsamal       staff               15301 Feb 13 20:20 biomed//1472-6882-2-5.txt
27157164       56 -rwxr-xr-x    1 sanatsamal       staff               27931 Feb 13 20:20 biomed//gb-2002-3-11-research0060.txt
27156517       72 -rwxr-xr-x    1 sanatsamal       staff               34190 Feb 13 20:20 biomed//1471-213X-3-7.txt
27157114       64 -rwxr-xr-x    1 sanatsamal       staff               32569 Feb 13 20:20 biomed//cc303.txt
27157095       48 -rwxr-xr-x    1 sanatsamal       staff               22286 Feb 13 20:20 biomed//cc1477.txt
27156817       48 -rwxr-xr-x    1 sanatsamal       staff               24515 Feb 13 20:20 biomed//1471-2407-3-5.txt
27156792      104 -rwxr-xr-x    1 sanatsamal       staff               50740 Feb 13 20:20 biomed//1471-2377-3-4.txt
27156639       80 -rwxr-xr-x    1 sanatsamal       staff               37919 Feb 13 20:20 biomed//1471-2180-3-11.txt
27157175       88 -rwxr-xr-x    1 sanatsamal       staff               41121 Feb 13 20:20 biomed//gb-2002-3-12-research0081.txt
27157103       64 -rwxr-xr-x    1 sanatsamal       staff               31319 Feb 13 20:20 biomed//cc1852.txt
27156596       40 -rwxr-xr-x    1 sanatsamal       staff               20338 Feb 13 20:20 biomed//1471-2164-4-25.txt
27156430       80 -rwxr-xr-x    1 sanatsamal       staff               40379 Feb 13 20:20 biomed//1471-2091-3-22.txt
27156665       48 -rwxr-xr-x    1 sanatsamal       staff               23188 Feb 13 20:20 biomed//1471-2202-2-14.txt
27156563       40 -rwxr-xr-x    1 sanatsamal       staff               18841 Feb 13 20:20 biomed//1471-2164-3-10.txt
27156590       64 -rwxr-xr-x    1 sanatsamal       staff               31181 Feb 13 20:20 biomed//1471-2164-4-19.txt
27157119       32 -rwxr-xr-x    1 sanatsamal       staff               12557 Feb 13 20:20 biomed//cc713.txt
27156610       88 -rwxr-xr-x    1 sanatsamal       staff               41490 Feb 13 20:20 biomed//1471-2172-3-16.txt
27156619       56 -rwxr-xr-x    1 sanatsamal       staff               26000 Feb 13 20:20 biomed//1471-2180-1-28.txt
27156740       56 -rwxr-xr-x    1 sanatsamal       staff               25804 Feb 13 20:20 biomed//1471-230X-1-10.txt
27156475       56 -rwxr-xr-x    1 sanatsamal       staff               26337 Feb 13 20:20 biomed//1471-2121-2-22.txt
27156761       56 -rwxr-xr-x    1 sanatsamal       staff               25529 Feb 13 20:20 biomed//1471-2334-2-29.txt
27156493       56 -rwxr-xr-x    1 sanatsamal       staff               25531 Feb 13 20:20 biomed//1471-2121-3-8.txt
27156950       56 -rwxr-xr-x    1 sanatsamal       staff               27938 Feb 13 20:20 biomed//1472-6963-1-8.txt
27156738       48 -rwxr-xr-x    1 sanatsamal       staff               23589 Feb 13 20:20 biomed//1471-2296-3-19.txt
27156799       56 -rwxr-xr-x    1 sanatsamal       staff               28027 Feb 13 20:20 biomed//1471-2407-2-15.txt
27156445       96 -rwxr-xr-x    1 sanatsamal       staff               47239 Feb 13 20:20 biomed//1471-2105-3-17.txt
27156747       48 -rwxr-xr-x    1 sanatsamal       staff               21061 Feb 13 20:20 biomed//1471-230X-3-3.txt
27157054       40 -rwxr-xr-x    1 sanatsamal       staff               17933 Feb 13 20:20 biomed//ar430.txt
27156550       96 -rwxr-xr-x    1 sanatsamal       staff               46131 Feb 13 20:20 biomed//1471-2156-3-4.txt
27156847       48 -rwxr-xr-x    1 sanatsamal       staff               20589 Feb 13 20:20 biomed//1471-2466-2-4.txt
27156737       64 -rwxr-xr-x    1 sanatsamal       staff               31087 Feb 13 20:20 biomed//1471-2296-3-18.txt
27156444       80 -rwxr-xr-x    1 sanatsamal       staff               37446 Feb 13 20:20 biomed//1471-2105-3-16.txt
27156939       72 -rwxr-xr-x    1 sanatsamal       staff               32906 Feb 13 20:20 biomed//1472-6920-2-1.txt
27156993       64 -rwxr-xr-x    1 sanatsamal       staff               29768 Feb 13 20:20 biomed//1476-072X-2-3.txt
27157238       56 -rwxr-xr-x    1 sanatsamal       staff               27689 Feb 13 20:20 biomed//gb-2003-4-9-r60.txt
27157039       80 -rwxr-xr-x    1 sanatsamal       staff               38211 Feb 13 20:20 biomed//ar140.txt
27157219      104 -rwxr-xr-x    1 sanatsamal       staff               52824 Feb 13 20:20 biomed//gb-2003-4-3-r17.txt
27156888       80 -rwxr-xr-x    1 sanatsamal       staff               37722 Feb 13 20:20 biomed//1472-6793-2-11.txt
27156911       40 -rwxr-xr-x    1 sanatsamal       staff               19040 Feb 13 20:20 biomed//1472-6823-2-2.txt
27156620       64 -rwxr-xr-x    1 sanatsamal       staff               30845 Feb 13 20:20 biomed//1471-2180-1-29.txt
27156604       96 -rwxr-xr-x    1 sanatsamal       staff               46108 Feb 13 20:20 biomed//1471-2172-2-3.txt
27156796       48 -rwxr-xr-x    1 sanatsamal       staff               21314 Feb 13 20:20 biomed//1471-2407-1-6.txt
27156423       56 -rwxr-xr-x    1 sanatsamal       staff               25298 Feb 13 20:20 biomed//1471-2091-2-9.txt
27156666       56 -rwxr-xr-x    1 sanatsamal       staff               28119 Feb 13 20:20 biomed//1471-2202-2-15.txt
27156431       72 -rwxr-xr-x    1 sanatsamal       staff               33815 Feb 13 20:20 biomed//1471-2091-3-23.txt
27156595       56 -rwxr-xr-x    1 sanatsamal       staff               26222 Feb 13 20:20 biomed//1471-2164-4-24.txt
27156508       40 -rwxr-xr-x    1 sanatsamal       staff               18068 Feb 13 20:20 biomed//1471-213X-1-4.txt
27157174       64 -rwxr-xr-x    1 sanatsamal       staff               28874 Feb 13 20:20 biomed//gb-2002-3-12-research0080.txt
27156638       64 -rwxr-xr-x    1 sanatsamal       staff               30027 Feb 13 20:20 biomed//1471-2180-3-10.txt
27157094       56 -rwxr-xr-x    1 sanatsamal       staff               26600 Feb 13 20:20 biomed//cc1476.txt
27156816       56 -rwxr-xr-x    1 sanatsamal       staff               25661 Feb 13 20:20 biomed//1471-2407-3-4.txt
27156829       48 -rwxr-xr-x    1 sanatsamal       staff               22131 Feb 13 20:20 biomed//1471-2431-3-6.txt
27157073       56 -rwxr-xr-x    1 sanatsamal       staff               25685 Feb 13 20:20 biomed//bcr294.txt
27157165       56 -rwxr-xr-x    1 sanatsamal       staff               26586 Feb 13 20:20 biomed//gb-2002-3-11-research0061.txt
27157025       80 -rwxr-xr-x    1 sanatsamal       staff               39369 Feb 13 20:20 biomed//1477-7827-1-43.txt
27156959       56 -rwxr-xr-x    1 sanatsamal       staff               25725 Feb 13 20:20 biomed//1475-2832-1-1.txt
27156655       64 -rwxr-xr-x    1 sanatsamal       staff               30440 Feb 13 20:20 biomed//1471-2199-3-12.txt
27156661       48 -rwxr-xr-x    1 sanatsamal       staff               20783 Feb 13 20:20 biomed//1471-2202-1-1.txt
27156866       40 -rwxr-xr-x    1 sanatsamal       staff               19066 Feb 13 20:20 biomed//1472-6750-2-13.txt
27157109       48 -rwxr-xr-x    1 sanatsamal       staff               20745 Feb 13 20:20 biomed//cc2172.txt
27156885       40 -rwxr-xr-x    1 sanatsamal       staff               19300 Feb 13 20:20 biomed//1472-6793-1-6.txt
27156710       72 -rwxr-xr-x    1 sanatsamal       staff               35907 Feb 13 20:20 biomed//1471-2210-2-6.txt
27156510       80 -rwxr-xr-x    1 sanatsamal       staff               37729 Feb 13 20:20 biomed//1471-213X-1-9.txt
27156579       48 -rwxr-xr-x    1 sanatsamal       staff               20958 Feb 13 20:20 biomed//1471-2164-3-34.txt
27156588       56 -rwxr-xr-x    1 sanatsamal       staff               26254 Feb 13 20:20 biomed//1471-2164-4-15.txt
27156687       72 -rwxr-xr-x    1 sanatsamal       staff               35079 Feb 13 20:20 biomed//1471-2202-3-3.txt
27156669       40 -rwxr-xr-x    1 sanatsamal       staff               20061 Feb 13 20:20 biomed//1471-2202-2-18.txt
27157111       40 -rwxr-xr-x    1 sanatsamal       staff               18512 Feb 13 20:20 biomed//cc2358.txt
27156898       56 -rwxr-xr-x    1 sanatsamal       staff               26409 Feb 13 20:20 biomed//1472-6793-3-4.txt
27157169      112 -rwxr-xr-x    1 sanatsamal       staff               56348 Feb 13 20:20 biomed//gb-2002-3-12-research0072.txt
27156953       40 -rwxr-xr-x    1 sanatsamal       staff               16645 Feb 13 20:20 biomed//1472-6963-3-11.txt
27156957       56 -rwxr-xr-x    1 sanatsamal       staff               27276 Feb 13 20:20 biomed//1472-6963-3-6.txt
27157006       32 -rwxr-xr-x    1 sanatsamal       staff               15618 Feb 13 20:20 biomed//1476-4598-2-3.txt
27157029       48 -rwxr-xr-x    1 sanatsamal       staff               20506 Feb 13 20:20 biomed//1477-7827-1-6.txt
27156975      128 -rwxr-xr-x    1 sanatsamal       staff               62700 Feb 13 20:20 biomed//1475-4924-1-10.txt
27156919       56 -rwxr-xr-x    1 sanatsamal       staff               27708 Feb 13 20:20 biomed//1472-6874-2-13.txt
27156788       40 -rwxr-xr-x    1 sanatsamal       staff               18617 Feb 13 20:20 biomed//1471-2369-4-5.txt
27156491       96 -rwxr-xr-x    1 sanatsamal       staff               48187 Feb 13 20:20 biomed//1471-2121-3-4.txt
27156471       56 -rwxr-xr-x    1 sanatsamal       staff               26002 Feb 13 20:20 biomed//1471-2121-2-12.txt
27156527       56 -rwxr-xr-x    1 sanatsamal       staff               24898 Feb 13 20:20 biomed//1471-2148-2-2.txt
27156982       80 -rwxr-xr-x    1 sanatsamal       staff               39964 Feb 13 20:20 biomed//1475-925X-2-6.txt
27156519       64 -rwxr-xr-x    1 sanatsamal       staff               29403 Feb 13 20:20 biomed//1471-2148-1-14.txt
27156803       64 -rwxr-xr-x    1 sanatsamal       staff               29550 Feb 13 20:20 biomed//1471-2407-2-19.txt
27156707       72 -rwxr-xr-x    1 sanatsamal       staff               35701 Feb 13 20:20 biomed//1471-2210-2-14.txt
27156966       72 -rwxr-xr-x    1 sanatsamal       staff               36377 Feb 13 20:20 biomed//1475-2867-3-4.txt
27157053       40 -rwxr-xr-x    1 sanatsamal       staff               18681 Feb 13 20:20 biomed//ar429.txt
27156807       40 -rwxr-xr-x    1 sanatsamal       staff               19545 Feb 13 20:20 biomed//1471-2407-2-31.txt
27156451       64 -rwxr-xr-x    1 sanatsamal       staff               31764 Feb 13 20:20 biomed//1471-2105-3-26.txt
27157015       40 -rwxr-xr-x    1 sanatsamal       staff               17188 Feb 13 20:20 biomed//1477-7525-1-12.txt
27156802       56 -rwxr-xr-x    1 sanatsamal       staff               26749 Feb 13 20:20 biomed//1471-2407-2-18.txt
27156460       80 -rwxr-xr-x    1 sanatsamal       staff               37814 Feb 13 20:20 biomed//1471-2105-4-13.txt
27157212       96 -rwxr-xr-x    1 sanatsamal       staff               46030 Feb 13 20:20 biomed//gb-2003-4-1-r5.txt
27156758       64 -rwxr-xr-x    1 sanatsamal       staff               32166 Feb 13 20:20 biomed//1471-2334-2-24.txt
27156749       72 -rwxr-xr-x    1 sanatsamal       staff               33364 Feb 13 20:20 biomed//1471-2318-3-2.txt
27156537       72 -rwxr-xr-x    1 sanatsamal       staff               36043 Feb 13 20:20 biomed//1471-2156-2-12.txt
27156621       64 -rwxr-xr-x    1 sanatsamal       staff               29292 Feb 13 20:20 biomed//1471-2180-1-31.txt
27157000       32 -rwxr-xr-x    1 sanatsamal       staff               15818 Feb 13 20:20 biomed//1476-4598-2-2.txt
27156916       56 -rwxr-xr-x    1 sanatsamal       staff               24653 Feb 13 20:20 biomed//1472-684X-2-1.txt
27156859       32 -rwxr-xr-x    1 sanatsamal       staff               12826 Feb 13 20:20 biomed//1471-5945-3-3.txt
27156958       80 -rwxr-xr-x    1 sanatsamal       staff               37540 Feb 13 20:20 biomed//1472-6963-3-7.txt
27156974       56 -rwxr-xr-x    1 sanatsamal       staff               27864 Feb 13 20:20 biomed//1475-2891-2-1.txt
27156421       96 -rwxr-xr-x    1 sanatsamal       staff               45414 Feb 13 20:20 biomed//1471-2091-2-5.txt
27156899       56 -rwxr-xr-x    1 sanatsamal       staff               27647 Feb 13 20:20 biomed//1472-6793-3-5.txt
27156976       64 -rwxr-xr-x    1 sanatsamal       staff               29681 Feb 13 20:20 biomed//1475-4924-1-5.txt
27156670       72 -rwxr-xr-x    1 sanatsamal       staff               32908 Feb 13 20:20 biomed//1471-2202-2-19.txt
27156424       64 -rwxr-xr-x    1 sanatsamal       staff               29139 Feb 13 20:20 biomed//1471-2091-3-13.txt
27156587       40 -rwxr-xr-x    1 sanatsamal       staff               18940 Feb 13 20:20 biomed//1471-2164-4-14.txt
27156580       72 -rwxr-xr-x    1 sanatsamal       staff               36670 Feb 13 20:20 biomed//1471-2164-3-35.txt
27156598       72 -rwxr-xr-x    1 sanatsamal       staff               33886 Feb 13 20:20 biomed//1471-2164-4-28.txt
27157107       72 -rwxr-xr-x    1 sanatsamal       staff               33687 Feb 13 20:20 biomed//cc2167.txt
27157070       88 -rwxr-xr-x    1 sanatsamal       staff               43955 Feb 13 20:20 biomed//bcr273.txt
27157028       80 -rwxr-xr-x    1 sanatsamal       staff               40046 Feb 13 20:20 biomed//1477-7827-1-54.txt
27156757       48 -rwxr-xr-x    1 sanatsamal       staff               21319 Feb 13 20:20 biomed//1471-2334-2-1.txt
27156654       56 -rwxr-xr-x    1 sanatsamal       staff               25396 Feb 13 20:20 biomed//1471-2199-3-11.txt
27156865       48 -rwxr-xr-x    1 sanatsamal       staff               21912 Feb 13 20:20 biomed//1472-6750-2-10.txt
27156709       72 -rwxr-xr-x    1 sanatsamal       staff               33152 Feb 13 20:20 biomed//1471-2210-2-5.txt
27157108       64 -rwxr-xr-x    1 sanatsamal       staff               29402 Feb 13 20:20 biomed//cc2171.txt
27156569       48 -rwxr-xr-x    1 sanatsamal       staff               20694 Feb 13 20:20 biomed//1471-2164-3-23.txt
27156589       72 -rwxr-xr-x    1 sanatsamal       staff               33581 Feb 13 20:20 biomed//1471-2164-4-16.txt
27157063       56 -rwxr-xr-x    1 sanatsamal       staff               24602 Feb 13 20:20 biomed//ar774.txt
27157007      168 -rwxr-xr-x    1 sanatsamal       staff               83194 Feb 13 20:20 biomed//1476-511X-1-2.txt
27156954       56 -rwxr-xr-x    1 sanatsamal       staff               25064 Feb 13 20:20 biomed//1472-6963-3-12.txt
27156422       56 -rwxr-xr-x    1 sanatsamal       staff               25458 Feb 13 20:20 biomed//1471-2091-2-7.txt
27157168      112 -rwxr-xr-x    1 sanatsamal       staff               57162 Feb 13 20:20 biomed//gb-2002-3-12-research0071.txt
27156622       64 -rwxr-xr-x    1 sanatsamal       staff               30646 Feb 13 20:20 biomed//1471-2180-1-33.txt
27157127       56 -rwxr-xr-x    1 sanatsamal       staff               24629 Feb 13 20:20 biomed//gb-2000-1-1-research002.txt
27157157       64 -rwxr-xr-x    1 sanatsamal       staff               28714 Feb 13 20:20 biomed//gb-2001-3-1-research0005.txt
27157076       88 -rwxr-xr-x    1 sanatsamal       staff               44544 Feb 13 20:20 biomed//bcr45.txt
27156436       64 -rwxr-xr-x    1 sanatsamal       staff               30279 Feb 13 20:20 biomed//1471-2091-4-1.txt
27157213       64 -rwxr-xr-x    1 sanatsamal       staff               29546 Feb 13 20:20 biomed//gb-2003-4-1-r7.txt
27156759       56 -rwxr-xr-x    1 sanatsamal       staff               27094 Feb 13 20:20 biomed//1471-2334-2-26.txt
27156470       88 -rwxr-xr-x    1 sanatsamal       staff               42311 Feb 13 20:20 biomed//1471-2121-2-11.txt
27156857       48 -rwxr-xr-x    1 sanatsamal       staff               22954 Feb 13 20:20 biomed//1471-5945-1-3.txt
27156446      160 -rwxr-xr-x    1 sanatsamal       staff               78562 Feb 13 20:20 biomed//1471-2105-3-18.txt
27156729       64 -rwxr-xr-x    1 sanatsamal       staff               28796 Feb 13 20:20 biomed//1471-2261-3-5.txt
27156450       24 -rwxr-xr-x    1 sanatsamal       staff               12110 Feb 13 20:20 biomed//1471-2105-3-24.txt
27157010       40 -rwxr-xr-x    1 sanatsamal       staff               19791 Feb 13 20:20 biomed//1476-5918-1-2.txt
27157014       48 -rwxr-xr-x    1 sanatsamal       staff               21781 Feb 13 20:20 biomed//1477-7525-1-10.txt
27157192       64 -rwxr-xr-x    1 sanatsamal       staff               31838 Feb 13 20:20 biomed//gb-2002-3-5-research0024.txt
27156454       88 -rwxr-xr-x    1 sanatsamal       staff               43797 Feb 13 20:20 biomed//1471-2105-3-30.txt
27156808       64 -rwxr-xr-x    1 sanatsamal       staff               31098 Feb 13 20:20 biomed//1471-2407-2-33.txt
27157193      104 -rwxr-xr-x    1 sanatsamal       staff               49968 Feb 13 20:20 biomed//gb-2002-3-5-research0025.txt
27156728       88 -rwxr-xr-x    1 sanatsamal       staff               43855 Feb 13 20:20 biomed//1471-2261-3-4.txt
27156657       88 -rwxr-xr-x    1 sanatsamal       staff               41339 Feb 13 20:20 biomed//1471-2199-3-3.txt
27156469      104 -rwxr-xr-x    1 sanatsamal       staff               51543 Feb 13 20:20 biomed//1471-2121-2-10.txt
27156492       80 -rwxr-xr-x    1 sanatsamal       staff               39935 Feb 13 20:20 biomed//1471-2121-3-6.txt
27156760       72 -rwxr-xr-x    1 sanatsamal       staff               35377 Feb 13 20:20 biomed//1471-2334-2-27.txt
27157156       56 -rwxr-xr-x    1 sanatsamal       staff               26047 Feb 13 20:20 biomed//gb-2001-3-1-research0004.txt
27156439       72 -rwxr-xr-x    1 sanatsamal       staff               34261 Feb 13 20:20 biomed//1471-2105-2-1.txt
27156726       40 -rwxr-xr-x    1 sanatsamal       staff               19386 Feb 13 20:20 biomed//1471-2261-1-6.txt
27157220       40 -rwxr-xr-x    1 sanatsamal       staff               18620 Feb 13 20:20 biomed//gb-2003-4-3-r18.txt
27157057       72 -rwxr-xr-x    1 sanatsamal       staff               34084 Feb 13 20:20 biomed//ar615.txt
27157055       40 -rwxr-xr-x    1 sanatsamal       staff               18964 Feb 13 20:20 biomed//ar601.txt
27156999       48 -rwxr-xr-x    1 sanatsamal       staff               24279 Feb 13 20:20 biomed//1476-4598-2-1.txt
27156917       64 -rwxr-xr-x    1 sanatsamal       staff               29525 Feb 13 20:20 biomed//1472-684X-2-2.txt
27156618       96 -rwxr-xr-x    1 sanatsamal       staff               47026 Feb 13 20:20 biomed//1471-2180-1-26.txt
27156836       56 -rwxr-xr-x    1 sanatsamal       staff               27043 Feb 13 20:20 biomed//1471-2458-2-21.txt
27156900       64 -rwxr-xr-x    1 sanatsamal       staff               29507 Feb 13 20:20 biomed//1472-6793-3-6.txt
27156955       40 -rwxr-xr-x    1 sanatsamal       staff               20388 Feb 13 20:20 biomed//1472-6963-3-13.txt
27156562       64 -rwxr-xr-x    1 sanatsamal       staff               30676 Feb 13 20:20 biomed//1471-2164-3-1.txt
27156679      152 -rwxr-xr-x    1 sanatsamal       staff               75711 Feb 13 20:20 biomed//1471-2202-3-1.txt
27156708       48 -rwxr-xr-x    1 sanatsamal       staff               23490 Feb 13 20:20 biomed//1471-2210-2-4.txt
27156653       40 -rwxr-xr-x    1 sanatsamal       staff               19877 Feb 13 20:20 biomed//1471-2199-3-10.txt
27156772       32 -rwxr-xr-x    1 sanatsamal       staff               15134 Feb 13 20:20 biomed//1471-2350-2-12.txt
27156778       56 -rwxr-xr-x    1 sanatsamal       staff               26118 Feb 13 20:20 biomed//1471-2350-3-9.txt
27156983       88 -rwxr-xr-x    1 sanatsamal       staff               43338 Feb 13 20:20 biomed//1475-9268-1-1.txt
27157137       72 -rwxr-xr-x    1 sanatsamal       staff               36028 Feb 13 20:20 biomed//gb-2001-2-2-research0004.txt
27157106       40 -rwxr-xr-x    1 sanatsamal       staff               17840 Feb 13 20:20 biomed//cc2160.txt
27156871       72 -rwxr-xr-x    1 sanatsamal       staff               34558 Feb 13 20:20 biomed//1472-6750-3-4.txt
27156689       96 -rwxr-xr-x    1 sanatsamal       staff               47766 Feb 13 20:20 biomed//1471-2202-3-5.txt
27156586       64 -rwxr-xr-x    1 sanatsamal       staff               32319 Feb 13 20:20 biomed//1471-2164-4-13.txt
27156425      112 -rwxr-xr-x    1 sanatsamal       staff               54849 Feb 13 20:20 biomed//1471-2091-3-14.txt
27156858       72 -rwxr-xr-x    1 sanatsamal       staff               35587 Feb 13 20:20 biomed//1471-5945-2-13.txt
27156577       64 -rwxr-xr-x    1 sanatsamal       staff               29324 Feb 13 20:20 biomed//1471-2164-3-32.txt
27156571       48 -rwxr-xr-x    1 sanatsamal       staff               21046 Feb 13 20:20 biomed//1471-2164-3-26.txt
27156732       64 -rwxr-xr-x    1 sanatsamal       staff               30852 Feb 13 20:20 biomed//1471-2288-2-11.txt
27156642       80 -rwxr-xr-x    1 sanatsamal       staff               37694 Feb 13 20:20 biomed//1471-2180-3-4.txt
27156863       64 -rwxr-xr-x    1 sanatsamal       staff               31799 Feb 13 20:20 biomed//1472-6750-1-6.txt
27157229      104 -rwxr-xr-x    1 sanatsamal       staff               51187 Feb 13 20:20 biomed//gb-2003-4-6-r39.txt
27156837       72 -rwxr-xr-x    1 sanatsamal       staff               36580 Feb 13 20:20 biomed//1471-2458-2-25.txt
27157221      104 -rwxr-xr-x    1 sanatsamal       staff               51112 Feb 13 20:20 biomed//gb-2003-4-3-r20.txt
27157236       72 -rwxr-xr-x    1 sanatsamal       staff               35998 Feb 13 20:20 biomed//gb-2003-4-9-r57.txt
27156486       72 -rwxr-xr-x    1 sanatsamal       staff               34129 Feb 13 20:20 biomed//1471-2121-3-2.txt
27156805       40 -rwxr-xr-x    1 sanatsamal       staff               20230 Feb 13 20:20 biomed//1471-2407-2-23.txt
27156465       72 -rwxr-xr-x    1 sanatsamal       staff               33821 Feb 13 20:20 biomed//1471-2105-4-28.txt
27156945       88 -rwxr-xr-x    1 sanatsamal       staff               42551 Feb 13 20:20 biomed//1472-6947-2-7.txt
27157189       72 -rwxr-xr-x    1 sanatsamal       staff               32848 Feb 13 20:20 biomed//gb-2002-3-5-research0021.txt
27157049       56 -rwxr-xr-x    1 sanatsamal       staff               27321 Feb 13 20:20 biomed//ar407.txt
27156658       64 -rwxr-xr-x    1 sanatsamal       staff               29608 Feb 13 20:20 biomed//1471-2199-3-7.txt
27156964       72 -rwxr-xr-x    1 sanatsamal       staff               35654 Feb 13 20:20 biomed//1475-2867-3-2.txt
27156977       48 -rwxr-xr-x    1 sanatsamal       staff               21404 Feb 13 20:20 biomed//1475-925X-2-1.txt
27156965       48 -rwxr-xr-x    1 sanatsamal       staff               23790 Feb 13 20:20 biomed//1475-2867-3-3.txt
27156455       72 -rwxr-xr-x    1 sanatsamal       staff               34563 Feb 13 20:20 biomed//1471-2105-3-34.txt
27157188       80 -rwxr-xr-x    1 sanatsamal       staff               39368 Feb 13 20:20 biomed//gb-2002-3-5-research0020.txt
27156804       48 -rwxr-xr-x    1 sanatsamal       staff               22429 Feb 13 20:20 biomed//1471-2407-2-22.txt
27156472       72 -rwxr-xr-x    1 sanatsamal       staff               32852 Feb 13 20:20 biomed//1471-2121-2-15.txt
27156528       32 -rwxr-xr-x    1 sanatsamal       staff               14560 Feb 13 20:20 biomed//1471-2148-2-5.txt
27157092       40 -rwxr-xr-x    1 sanatsamal       staff               19035 Feb 13 20:20 biomed//cc1044.txt
27156437       64 -rwxr-xr-x    1 sanatsamal       staff               28719 Feb 13 20:20 biomed//1471-2091-4-5.txt
27156730       56 -rwxr-xr-x    1 sanatsamal       staff               25922 Feb 13 20:20 biomed//1471-2288-1-9.txt
27157245       64 -rwxr-xr-x    1 sanatsamal       staff               32562 Feb 13 20:20 biomed//rr37.txt
27157155      120 -rwxr-xr-x    1 sanatsamal       staff               60518 Feb 13 20:20 biomed//gb-2001-3-1-research0001.txt
27156952       56 -rwxr-xr-x    1 sanatsamal       staff               26929 Feb 13 20:20 biomed//1472-6963-3-1.txt
27156606       40 -rwxr-xr-x    1 sanatsamal       staff               19565 Feb 13 20:20 biomed//1471-2172-2-9.txt
27156835       32 -rwxr-xr-x    1 sanatsamal       staff               16116 Feb 13 20:20 biomed//1471-2458-2-18.txt
27156643       88 -rwxr-xr-x    1 sanatsamal       staff               43688 Feb 13 20:20 biomed//1471-2180-3-5.txt
27156731       88 -rwxr-xr-x    1 sanatsamal       staff               42772 Feb 13 20:20 biomed//1471-2288-2-10.txt
27156581       96 -rwxr-xr-x    1 sanatsamal       staff               45524 Feb 13 20:20 biomed//1471-2164-3-4.txt
27156897       48 -rwxr-xr-x    1 sanatsamal       staff               20943 Feb 13 20:20 biomed//1472-6793-3-3.txt
27157170       48 -rwxr-xr-x    1 sanatsamal       staff               22757 Feb 13 20:20 biomed//gb-2002-3-12-research0075.txt
27156572       48 -rwxr-xr-x    1 sanatsamal       staff               24329 Feb 13 20:20 biomed//1471-2164-3-27.txt
27156578       64 -rwxr-xr-x    1 sanatsamal       staff               32602 Feb 13 20:20 biomed//1471-2164-3-33.txt
27156426       72 -rwxr-xr-x    1 sanatsamal       staff               34209 Feb 13 20:20 biomed//1471-2091-3-15.txt
27156688       64 -rwxr-xr-x    1 sanatsamal       staff               32489 Feb 13 20:20 biomed//1471-2202-3-4.txt
27156867       96 -rwxr-xr-x    1 sanatsamal       staff               47947 Feb 13 20:20 biomed//1472-6750-2-14.txt
27156624       80 -rwxr-xr-x    1 sanatsamal       staff               38765 Feb 13 20:20 biomed//1471-2180-1-7.txt
27157097       32 -rwxr-xr-x    1 sanatsamal       staff               16242 Feb 13 20:20 biomed//cc1497.txt
27156762       48 -rwxr-xr-x    1 sanatsamal       staff               22233 Feb 13 20:20 biomed//1471-2334-2-5.txt
27156656       48 -rwxr-xr-x    1 sanatsamal       staff               22226 Feb 13 20:20 biomed//1471-2199-3-17.txt
27156771       48 -rwxr-xr-x    1 sanatsamal       staff               23338 Feb 13 20:20 biomed//1471-2350-2-11.txt
27156764       56 -rwxr-xr-x    1 sanatsamal       staff               27097 Feb 13 20:20 biomed//1471-2334-2-7.txt
27157096       32 -rwxr-xr-x    1 sanatsamal       staff               16376 Feb 13 20:20 biomed//cc1495.txt
27156984       48 -rwxr-xr-x    1 sanatsamal       staff               20942 Feb 13 20:20 biomed//1475-9268-1-2.txt
27157026       96 -rwxr-xr-x    1 sanatsamal       staff               48259 Feb 13 20:20 biomed//1477-7827-1-46.txt
27156428       64 -rwxr-xr-x    1 sanatsamal       staff               29469 Feb 13 20:20 biomed//1471-2091-3-17.txt
27157068       56 -rwxr-xr-x    1 sanatsamal       staff               25350 Feb 13 20:20 biomed//ar799.txt
27156568       72 -rwxr-xr-x    1 sanatsamal       staff               33671 Feb 13 20:20 biomed//1471-2164-3-19.txt
27157181      104 -rwxr-xr-x    1 sanatsamal       staff               51726 Feb 13 20:20 biomed//gb-2002-3-12-research0088.txt
27156576       80 -rwxr-xr-x    1 sanatsamal       staff               40400 Feb 13 20:20 biomed//1471-2164-3-31.txt
27157171       88 -rwxr-xr-x    1 sanatsamal       staff               41682 Feb 13 20:20 biomed//gb-2002-3-12-research0077.txt
27156956       88 -rwxr-xr-x    1 sanatsamal       staff               41716 Feb 13 20:20 biomed//1472-6963-3-14.txt
27156967       72 -rwxr-xr-x    1 sanatsamal       staff               33494 Feb 13 20:20 biomed//1475-2875-1-14.txt
27156582       48 -rwxr-xr-x    1 sanatsamal       staff               21289 Feb 13 20:20 biomed//1471-2164-3-6.txt
27157235       48 -rwxr-xr-x    1 sanatsamal       staff               20637 Feb 13 20:20 biomed//gb-2003-4-8-r51.txt
27156971       64 -rwxr-xr-x    1 sanatsamal       staff               29607 Feb 13 20:20 biomed//1475-2875-2-4.txt
27156949       48 -rwxr-xr-x    1 sanatsamal       staff               21711 Feb 13 20:20 biomed//1472-6963-1-11.txt
27157056       56 -rwxr-xr-x    1 sanatsamal       staff               28204 Feb 13 20:20 biomed//ar612.txt
27156892       64 -rwxr-xr-x    1 sanatsamal       staff               28870 Feb 13 20:20 biomed//1472-6793-2-19.txt
27156743       40 -rwxr-xr-x    1 sanatsamal       staff               17629 Feb 13 20:20 biomed//1471-230X-1-8.txt
27156529       40 -rwxr-xr-x    1 sanatsamal       staff               19427 Feb 13 20:20 biomed//1471-2148-2-7.txt
27157190       80 -rwxr-xr-x    1 sanatsamal       staff               38544 Feb 13 20:20 biomed//gb-2002-3-5-research0022.txt
27156736       96 -rwxr-xr-x    1 sanatsamal       staff               46390 Feb 13 20:20 biomed//1471-2288-3-9.txt
27156448       64 -rwxr-xr-x    1 sanatsamal       staff               29117 Feb 13 20:20 biomed//1471-2105-3-22.txt
27156944       72 -rwxr-xr-x    1 sanatsamal       staff               33905 Feb 13 20:20 biomed//1472-6947-2-4.txt
27157075       48 -rwxr-xr-x    1 sanatsamal       staff               23358 Feb 13 20:20 biomed//bcr317.txt
27156981       40 -rwxr-xr-x    1 sanatsamal       staff               17695 Feb 13 20:20 biomed//1475-925X-2-3.txt
27157074       64 -rwxr-xr-x    1 sanatsamal       staff               30804 Feb 13 20:20 biomed//bcr303.txt
27156449       64 -rwxr-xr-x    1 sanatsamal       staff               30792 Feb 13 20:20 biomed//1471-2105-3-23.txt
27156735       48 -rwxr-xr-x    1 sanatsamal       staff               23191 Feb 13 20:20 biomed//1471-2288-3-8.txt
27157077       48 -rwxr-xr-x    1 sanatsamal       staff               22904 Feb 13 20:20 biomed//bcr458.txt
27156456       64 -rwxr-xr-x    1 sanatsamal       staff               29508 Feb 13 20:20 biomed//1471-2105-3-37.txt
27157191       40 -rwxr-xr-x    1 sanatsamal       staff               19700 Feb 13 20:20 biomed//gb-2002-3-5-research0023.txt
27156891       96 -rwxr-xr-x    1 sanatsamal       staff               45713 Feb 13 20:20 biomed//1472-6793-2-18.txt
27156538       56 -rwxr-xr-x    1 sanatsamal       staff               27688 Feb 13 20:20 biomed//1471-2156-2-17.txt
27156787       48 -rwxr-xr-x    1 sanatsamal       staff               21464 Feb 13 20:20 biomed//1471-2369-4-1.txt
27157040       56 -rwxr-xr-x    1 sanatsamal       staff               25253 Feb 13 20:20 biomed//ar149.txt
27157194       56 -rwxr-xr-x    1 sanatsamal       staff               26711 Feb 13 20:20 biomed//gb-2002-3-6-research0029.txt
27156467       64 -rwxr-xr-x    1 sanatsamal       staff               29793 Feb 13 20:20 biomed//1471-2121-1-2.txt
27156623       72 -rwxr-xr-x    1 sanatsamal       staff               34076 Feb 13 20:20 biomed//1471-2180-1-34.txt
27157234       64 -rwxr-xr-x    1 sanatsamal       staff               29369 Feb 13 20:20 biomed//gb-2003-4-8-r50.txt
27156583       80 -rwxr-xr-x    1 sanatsamal       staff               40413 Feb 13 20:20 biomed//1471-2164-3-7.txt
27156575       40 -rwxr-xr-x    1 sanatsamal       staff               18364 Feb 13 20:20 biomed//1471-2164-3-30.txt
27156672       88 -rwxr-xr-x    1 sanatsamal       staff               41831 Feb 13 20:20 biomed//1471-2202-2-20.txt
27156570       72 -rwxr-xr-x    1 sanatsamal       staff               35306 Feb 13 20:20 biomed//1471-2164-3-24.txt
27156690       64 -rwxr-xr-x    1 sanatsamal       staff               28821 Feb 13 20:20 biomed//1471-2202-3-7.txt
27156427       72 -rwxr-xr-x    1 sanatsamal       staff               35953 Feb 13 20:20 biomed//1471-2091-3-16.txt
27156567       96 -rwxr-xr-x    1 sanatsamal       staff               47848 Feb 13 20:20 biomed//1471-2164-3-18.txt
27156872       80 -rwxr-xr-x    1 sanatsamal       staff               36952 Feb 13 20:20 biomed//1472-6750-3-6.txt
27156884       64 -rwxr-xr-x    1 sanatsamal       staff               32160 Feb 13 20:20 biomed//1472-6793-1-2.txt
27156763       72 -rwxr-xr-x    1 sanatsamal       staff               33504 Feb 13 20:20 biomed//1471-2334-2-6.txt
27156505       96 -rwxr-xr-x    1 sanatsamal       staff               46555 Feb 13 20:20 biomed//1471-213X-1-15.txt
27157116       32 -rwxr-xr-x    1 sanatsamal       staff               16150 Feb 13 20:20 biomed//cc350.txt
27156531       40 -rwxr-xr-x    1 sanatsamal       staff               19888 Feb 13 20:20 biomed//1471-2148-3-1.txt
27157083       48 -rwxr-xr-x    1 sanatsamal       staff               22429 Feb 13 20:20 biomed//bcr588.txt
27156648       48 -rwxr-xr-x    1 sanatsamal       staff               23248 Feb 13 20:20 biomed//1471-2199-2-2.txt
27156962       48 -rwxr-xr-x    1 sanatsamal       staff               21894 Feb 13 20:20 biomed//1475-2867-2-7.txt
27156414       64 -rwxr-xr-x    1 sanatsamal       staff               31378 Feb 13 20:20 biomed//1468-6708-3-4.txt
27156489      104 -rwxr-xr-x    1 sanatsamal       staff               51597 Feb 13 20:20 biomed//1471-2121-3-25.txt
27156767       40 -rwxr-xr-x    1 sanatsamal       staff               17234 Feb 13 20:20 biomed//1471-2334-3-12.txt
27156700       56 -rwxr-xr-x    1 sanatsamal       staff               27415 Feb 13 20:20 biomed//1471-2202-4-6.txt
27156922      160 -rwxr-xr-x    1 sanatsamal       staff               78507 Feb 13 20:20 biomed//1472-6882-1-10.txt
27156485       96 -rwxr-xr-x    1 sanatsamal       staff               46803 Feb 13 20:20 biomed//1471-2121-3-19.txt
27156601       64 -rwxr-xr-x    1 sanatsamal       staff               32085 Feb 13 20:20 biomed//1471-2164-4-6.txt
27156721       72 -rwxr-xr-x    1 sanatsamal       staff               34915 Feb 13 20:20 biomed//1471-2229-2-9.txt
27157208       64 -rwxr-xr-x    1 sanatsamal       staff               29598 Feb 13 20:20 biomed//gb-2002-3-9-research0049.txt
27156753       48 -rwxr-xr-x    1 sanatsamal       staff               24239 Feb 13 20:20 biomed//1471-2334-1-17.txt
27156626       72 -rwxr-xr-x    1 sanatsamal       staff               32867 Feb 13 20:20 biomed//1471-2180-2-1.txt
27157120       24 -rwxr-xr-x    1 sanatsamal       staff               11287 Feb 13 20:20 biomed//cc973.txt
27156705      104 -rwxr-xr-x    1 sanatsamal       staff               53072 Feb 13 20:20 biomed//1471-2210-1-7.txt
27156750       48 -rwxr-xr-x    1 sanatsamal       staff               24415 Feb 13 20:20 biomed//1471-2326-2-4.txt
27156628       72 -rwxr-xr-x    1 sanatsamal       staff               35235 Feb 13 20:20 biomed//1471-2180-2-16.txt
27156494       40 -rwxr-xr-x    1 sanatsamal       staff               17621 Feb 13 20:20 biomed//1471-2121-4-1.txt
27156513       32 -rwxr-xr-x    1 sanatsamal       staff               13689 Feb 13 20:20 biomed//1471-213X-2-8.txt
27156882       56 -rwxr-xr-x    1 sanatsamal       staff               25055 Feb 13 20:20 biomed//1472-6793-1-12.txt
27156659       64 -rwxr-xr-x    1 sanatsamal       staff               30658 Feb 13 20:20 biomed//1471-2199-4-4.txt
27156660       56 -rwxr-xr-x    1 sanatsamal       staff               25184 Feb 13 20:20 biomed//1471-2199-4-5.txt
27156783       56 -rwxr-xr-x    1 sanatsamal       staff               25926 Feb 13 20:20 biomed//1471-2369-3-1.txt
27156555       80 -rwxr-xr-x    1 sanatsamal       staff               39804 Feb 13 20:20 biomed//1471-2164-2-1.txt
27156662       80 -rwxr-xr-x    1 sanatsamal       staff               38924 Feb 13 20:20 biomed//1471-2202-2-1.txt
27157207       96 -rwxr-xr-x    1 sanatsamal       staff               45928 Feb 13 20:20 biomed//gb-2002-3-9-research0048.txt
27156720       48 -rwxr-xr-x    1 sanatsamal       staff               23226 Feb 13 20:20 biomed//1471-2229-2-8.txt
27156855       56 -rwxr-xr-x    1 sanatsamal       staff               25832 Feb 13 20:20 biomed//1471-2474-4-8.txt
27156484       72 -rwxr-xr-x    1 sanatsamal       staff               35704 Feb 13 20:20 biomed//1471-2121-3-18.txt
27156923       64 -rwxr-xr-x    1 sanatsamal       staff               31620 Feb 13 20:20 biomed//1472-6882-1-11.txt
27156768       16 -rwxr-xr-x    1 sanatsamal       staff                6297 Feb 13 20:20 biomed//1471-2334-3-13.txt
27157122       48 -rwxr-xr-x    1 sanatsamal       staff               21676 Feb 13 20:20 biomed//cvm-2-1-038.txt
27156490      112 -rwxr-xr-x    1 sanatsamal       staff               56063 Feb 13 20:20 biomed//1471-2121-3-30.txt
27156551       72 -rwxr-xr-x    1 sanatsamal       staff               33991 Feb 13 20:20 biomed//1471-2156-4-10.txt
27156649       40 -rwxr-xr-x    1 sanatsamal       staff               20447 Feb 13 20:20 biomed//1471-2199-2-3.txt
27156995       48 -rwxr-xr-x    1 sanatsamal       staff               21898 Feb 13 20:20 biomed//1476-4598-1-3.txt
27156603       80 -rwxr-xr-x    1 sanatsamal       staff               38772 Feb 13 20:20 biomed//1471-2172-2-10.txt
27156477       64 -rwxr-xr-x    1 sanatsamal       staff               31043 Feb 13 20:20 biomed//1471-2121-2-6.txt
27157020       48 -rwxr-xr-x    1 sanatsamal       staff               23010 Feb 13 20:20 biomed//1477-7827-1-21.txt
27157021       72 -rwxr-xr-x    1 sanatsamal       staff               35797 Feb 13 20:20 biomed//1477-7827-1-23.txt
27156973       56 -rwxr-xr-x    1 sanatsamal       staff               25430 Feb 13 20:20 biomed//1475-2891-1-2.txt
27156415       40 -rwxr-xr-x    1 sanatsamal       staff               18114 Feb 13 20:20 biomed//1468-6708-3-7.txt
27156645       64 -rwxr-xr-x    1 sanatsamal       staff               32069 Feb 13 20:20 biomed//1471-2199-2-1.txt
27156438       72 -rwxr-xr-x    1 sanatsamal       staff               36588 Feb 13 20:20 biomed//1471-2105-1-1.txt
27157158      112 -rwxr-xr-x    1 sanatsamal       staff               55347 Feb 13 20:20 biomed//gb-2002-3-10-research0052.txt
27156699       56 -rwxr-xr-x    1 sanatsamal       staff               26021 Feb 13 20:20 biomed//1471-2202-4-5.txt
27156766       48 -rwxr-xr-x    1 sanatsamal       staff               24252 Feb 13 20:20 biomed//1471-2334-3-11.txt
27156600       56 -rwxr-xr-x    1 sanatsamal       staff               24850 Feb 13 20:20 biomed//1471-2164-4-5.txt
27157125       56 -rwxr-xr-x    1 sanatsamal       staff               25831 Feb 13 20:20 biomed//cvm-2-6-278.txt
27157123       40 -rwxr-xr-x    1 sanatsamal       staff               19679 Feb 13 20:20 biomed//cvm-2-4-180.txt
27156453       96 -rwxr-xr-x    1 sanatsamal       staff               47668 Feb 13 20:20 biomed//1471-2105-3-3.txt
27157218      112 -rwxr-xr-x    1 sanatsamal       staff               55181 Feb 13 20:20 biomed//gb-2003-4-2-r9.txt
27156972       56 -rwxr-xr-x    1 sanatsamal       staff               24661 Feb 13 20:20 biomed//1475-2883-2-11.txt
27156960       48 -rwxr-xr-x    1 sanatsamal       staff               22387 Feb 13 20:20 biomed//1475-2867-2-10.txt
27156673       64 -rwxr-xr-x    1 sanatsamal       staff               30961 Feb 13 20:20 biomed//1471-2202-2-3.txt
27157084       40 -rwxr-xr-x    1 sanatsamal       staff               19094 Feb 13 20:20 biomed//bcr602.txt
27156629       48 -rwxr-xr-x    1 sanatsamal       staff               20538 Feb 13 20:20 biomed//1471-2180-2-2.txt
27157136       96 -rwxr-xr-x    1 sanatsamal       staff               48870 Feb 13 20:20 biomed//gb-2001-2-12-research0055.txt
27157033       72 -rwxr-xr-x    1 sanatsamal       staff               35659 Feb 13 20:20 biomed//1478-1336-1-4.txt
27156894       64 -rwxr-xr-x    1 sanatsamal       staff               31160 Feb 13 20:20 biomed//1472-6793-2-4.txt
27156704       72 -rwxr-xr-x    1 sanatsamal       staff               33669 Feb 13 20:20 biomed//1471-2210-1-4.txt
27156434      104 -rwxr-xr-x    1 sanatsamal       staff               52697 Feb 13 20:20 biomed//1471-2091-3-4.txt
27156495       72 -rwxr-xr-x    1 sanatsamal       staff               34571 Feb 13 20:20 biomed//1471-2121-4-2.txt
27157187       72 -rwxr-xr-x    1 sanatsamal       staff               34914 Feb 13 20:20 biomed//gb-2002-3-4-research0019.txt
27156680       48 -rwxr-xr-x    1 sanatsamal       staff               23827 Feb 13 20:20 biomed//1471-2202-3-10.txt
27156633       32 -rwxr-xr-x    1 sanatsamal       staff               13909 Feb 13 20:20 biomed//1471-2180-2-29.txt
27156868       48 -rwxr-xr-x    1 sanatsamal       staff               22140 Feb 13 20:20 biomed//1472-6750-2-2.txt
27157009       48 -rwxr-xr-x    1 sanatsamal       staff               23183 Feb 13 20:20 biomed//1476-511X-2-3.txt
27157101       32 -rwxr-xr-x    1 sanatsamal       staff               15211 Feb 13 20:20 biomed//cc1547.txt
27156881       64 -rwxr-xr-x    1 sanatsamal       staff               28809 Feb 13 20:20 biomed//1472-6793-1-11.txt
27156810       32 -rwxr-xr-x    1 sanatsamal       staff               14795 Feb 13 20:20 biomed//1471-2407-2-9.txt
27156809       40 -rwxr-xr-x    1 sanatsamal       staff               18174 Feb 13 20:20 biomed//1471-2407-2-8.txt
27157005       72 -rwxr-xr-x    1 sanatsamal       staff               35675 Feb 13 20:20 biomed//1476-4598-2-28.txt
27157008       56 -rwxr-xr-x    1 sanatsamal       staff               28467 Feb 13 20:20 biomed//1476-511X-2-2.txt
27156681       64 -rwxr-xr-x    1 sanatsamal       staff               31287 Feb 13 20:20 biomed//1471-2202-3-11.txt
27156496       80 -rwxr-xr-x    1 sanatsamal       staff               37156 Feb 13 20:20 biomed//1471-2121-4-3.txt
27157186       64 -rwxr-xr-x    1 sanatsamal       staff               29148 Feb 13 20:20 biomed//gb-2002-3-4-research0018.txt
27156727       56 -rwxr-xr-x    1 sanatsamal       staff               25902 Feb 13 20:20 biomed//1471-2261-2-11.txt
27156895       72 -rwxr-xr-x    1 sanatsamal       staff               33228 Feb 13 20:20 biomed//1472-6793-2-5.txt
27156556       80 -rwxr-xr-x    1 sanatsamal       staff               37800 Feb 13 20:20 biomed//1471-2164-2-2.txt
27157135       80 -rwxr-xr-x    1 sanatsamal       staff               40003 Feb 13 20:20 biomed//gb-2001-2-12-research0054.txt
27157035       80 -rwxr-xr-x    1 sanatsamal       staff               37212 Feb 13 20:20 biomed//ar104.txt
27156794       80 -rwxr-xr-x    1 sanatsamal       staff               37667 Feb 13 20:20 biomed//1471-2407-1-15.txt
27156671       40 -rwxr-xr-x    1 sanatsamal       staff               18827 Feb 13 20:20 biomed//1471-2202-2-2.txt
27157217       88 -rwxr-xr-x    1 sanatsamal       staff               43710 Feb 13 20:20 biomed//gb-2003-4-2-r8.txt
27156941       40 -rwxr-xr-x    1 sanatsamal       staff               16536 Feb 13 20:20 biomed//1472-6947-1-2.txt
27156447      272 -rwxr-xr-x    1 sanatsamal       staff              136424 Feb 13 20:20 biomed//1471-2105-3-2.txt
27156717       80 -rwxr-xr-x    1 sanatsamal       staff               37128 Feb 13 20:20 biomed//1471-2229-2-11.txt
27156599      112 -rwxr-xr-x    1 sanatsamal       staff               54077 Feb 13 20:20 biomed//1471-2164-4-4.txt
27157126       40 -rwxr-xr-x    1 sanatsamal       staff               19340 Feb 13 20:20 biomed//cvm-2-6-286.txt
27156518       48 -rwxr-xr-x    1 sanatsamal       staff               23842 Feb 13 20:20 biomed//1471-2148-1-1.txt
27156765       64 -rwxr-xr-x    1 sanatsamal       staff               30506 Feb 13 20:20 biomed//1471-2334-3-10.txt
27156924       64 -rwxr-xr-x    1 sanatsamal       staff               31937 Feb 13 20:20 biomed//1472-6882-1-12.txt
27157159       64 -rwxr-xr-x    1 sanatsamal       staff               31808 Feb 13 20:20 biomed//gb-2002-3-10-research0053.txt
27156543       24 -rwxr-xr-x    1 sanatsamal       staff               10530 Feb 13 20:20 biomed//1471-2156-2-8.txt
27157244       80 -rwxr-xr-x    1 sanatsamal       staff               37082 Feb 13 20:20 biomed//rr196.txt
27156533       88 -rwxr-xr-x    1 sanatsamal       staff               45044 Feb 13 20:20 biomed//1471-2148-3-3.txt
27156907       40 -rwxr-xr-x    1 sanatsamal       staff               19498 Feb 13 20:20 biomed//1472-6807-2-9.txt
27157024      112 -rwxr-xr-x    1 sanatsamal       staff               53800 Feb 13 20:20 biomed//1477-7827-1-36.txt
27156535       80 -rwxr-xr-x    1 sanatsamal       staff               40153 Feb 13 20:20 biomed//1471-2148-3-7.txt
27156504       72 -rwxr-xr-x    1 sanatsamal       staff               36535 Feb 13 20:20 biomed//1471-213X-1-13.txt
27156468       56 -rwxr-xr-x    1 sanatsamal       staff               26820 Feb 13 20:20 biomed//1471-2121-2-1.txt
27157185       64 -rwxr-xr-x    1 sanatsamal       staff               31929 Feb 13 20:20 biomed//gb-2002-3-3-research0012.txt
27156548       32 -rwxr-xr-x    1 sanatsamal       staff               13363 Feb 13 20:20 biomed//1471-2156-3-22.txt
27157081       48 -rwxr-xr-x    1 sanatsamal       staff               21426 Feb 13 20:20 biomed//bcr571.txt
27156650      112 -rwxr-xr-x    1 sanatsamal       staff               54313 Feb 13 20:20 biomed//1471-2199-2-4.txt
27157128       56 -rwxr-xr-x    1 sanatsamal       staff               28019 Feb 13 20:20 biomed//gb-2000-1-2-research0003.txt
27156948       48 -rwxr-xr-x    1 sanatsamal       staff               22981 Feb 13 20:20 biomed//1472-6955-2-1.txt
27156459       72 -rwxr-xr-x    1 sanatsamal       staff               34496 Feb 13 20:20 biomed//1471-2105-3-6.txt
27156852       56 -rwxr-xr-x    1 sanatsamal       staff               24615 Feb 13 20:20 biomed//1471-2474-3-23.txt
27156943       72 -rwxr-xr-x    1 sanatsamal       staff               33487 Feb 13 20:20 biomed//1472-6947-1-6.txt
27156811       56 -rwxr-xr-x    1 sanatsamal       staff               26367 Feb 13 20:20 biomed//1471-2407-3-14.txt
27156675       48 -rwxr-xr-x    1 sanatsamal       staff               23922 Feb 13 20:20 biomed//1471-2202-2-6.txt
27156961       56 -rwxr-xr-x    1 sanatsamal       staff               25953 Feb 13 20:20 biomed//1475-2867-2-15.txt
27156887       64 -rwxr-xr-x    1 sanatsamal       staff               30811 Feb 13 20:20 biomed//1472-6793-2-1.txt
27157201       48 -rwxr-xr-x    1 sanatsamal       staff               20507 Feb 13 20:20 biomed//gb-2002-3-8-research0039.txt
27156785       40 -rwxr-xr-x    1 sanatsamal       staff               18646 Feb 13 20:20 biomed//1471-2369-3-6.txt
27157086       48 -rwxr-xr-x    1 sanatsamal       staff               20662 Feb 13 20:20 biomed//bcr607.txt
27156920       40 -rwxr-xr-x    1 sanatsamal       staff               18987 Feb 13 20:20 biomed//1472-6874-2-8.txt
27156637       48 -rwxr-xr-x    1 sanatsamal       staff               24381 Feb 13 20:20 biomed//1471-2180-2-7.txt
27156558       48 -rwxr-xr-x    1 sanatsamal       staff               20730 Feb 13 20:20 biomed//1471-2164-2-6.txt
27156636       48 -rwxr-xr-x    1 sanatsamal       staff               21154 Feb 13 20:20 biomed//1471-2180-2-38.txt
27156714       32 -rwxr-xr-x    1 sanatsamal       staff               16141 Feb 13 20:20 biomed//1471-2210-3-3.txt
27156823       48 -rwxr-xr-x    1 sanatsamal       staff               21527 Feb 13 20:20 biomed//1471-2431-2-11.txt
27156883       72 -rwxr-xr-x    1 sanatsamal       staff               33137 Feb 13 20:20 biomed//1472-6793-1-15.txt
27156844       48 -rwxr-xr-x    1 sanatsamal       staff               22386 Feb 13 20:20 biomed//1471-2458-3-9.txt
27156499       56 -rwxr-xr-x    1 sanatsamal       staff               26467 Feb 13 20:20 biomed//1471-2121-4-6.txt
27156682       72 -rwxr-xr-x    1 sanatsamal       staff               33896 Feb 13 20:20 biomed//1471-2202-3-14.txt
27156559       64 -rwxr-xr-x    1 sanatsamal       staff               32543 Feb 13 20:20 biomed//1471-2164-2-7.txt
27157133       80 -rwxr-xr-x    1 sanatsamal       staff               37186 Feb 13 20:20 biomed//gb-2001-2-12-research0051.txt
27157200       96 -rwxr-xr-x    1 sanatsamal       staff               45876 Feb 13 20:20 biomed//gb-2002-3-8-research0038.txt
27156831       48 -rwxr-xr-x    1 sanatsamal       staff               20900 Feb 13 20:20 biomed//1471-244X-3-5.txt
27156676       56 -rwxr-xr-x    1 sanatsamal       staff               27117 Feb 13 20:20 biomed//1471-2202-2-7.txt
27156751       40 -rwxr-xr-x    1 sanatsamal       staff               16775 Feb 13 20:20 biomed//1471-2334-1-10.txt
27156812       56 -rwxr-xr-x    1 sanatsamal       staff               25312 Feb 13 20:20 biomed//1471-2407-3-15.txt
27156488       72 -rwxr-xr-x    1 sanatsamal       staff               33441 Feb 13 20:20 biomed//1471-2121-3-22.txt
27156769       72 -rwxr-xr-x    1 sanatsamal       staff               35377 Feb 13 20:20 biomed//1471-2334-3-15.txt
27156520       64 -rwxr-xr-x    1 sanatsamal       staff               29837 Feb 13 20:20 biomed//1471-2148-1-4.txt
27156651       72 -rwxr-xr-x    1 sanatsamal       staff               34740 Feb 13 20:20 biomed//1471-2199-2-5.txt
27156413       40 -rwxr-xr-x    1 sanatsamal       staff               16882 Feb 13 20:20 biomed//1468-6708-3-3.txt
27157080       40 -rwxr-xr-x    1 sanatsamal       staff               20468 Feb 13 20:20 biomed//bcr570.txt
27157162       96 -rwxr-xr-x    1 sanatsamal       staff               45288 Feb 13 20:20 biomed//gb-2002-3-10-research0056.txt
27156946       64 -rwxr-xr-x    1 sanatsamal       staff               30395 Feb 13 20:20 biomed//1472-6947-3-5.txt
27157115       48 -rwxr-xr-x    1 sanatsamal       staff               23825 Feb 13 20:20 biomed//cc343.txt
27156503       64 -rwxr-xr-x    1 sanatsamal       staff               29734 Feb 13 20:20 biomed//1471-213X-1-12.txt
27156739       56 -rwxr-xr-x    1 sanatsamal       staff               28483 Feb 13 20:20 biomed//1471-2296-3-3.txt
27157022       56 -rwxr-xr-x    1 sanatsamal       staff               25530 Feb 13 20:20 biomed//1477-7827-1-27.txt
27156996       32 -rwxr-xr-x    1 sanatsamal       staff               15245 Feb 13 20:20 biomed//1476-4598-1-5.txt
27157243       64 -rwxr-xr-x    1 sanatsamal       staff               30791 Feb 13 20:20 biomed//rr191.txt
27156534       72 -rwxr-xr-x    1 sanatsamal       staff               33162 Feb 13 20:20 biomed//1471-2148-3-4.txt
27156840       72 -rwxr-xr-x    1 sanatsamal       staff               35574 Feb 13 20:20 biomed//1471-2458-3-11.txt
27156968       64 -rwxr-xr-x    1 sanatsamal       staff               31562 Feb 13 20:20 biomed//1475-2875-1-5.txt
27157023       88 -rwxr-xr-x    1 sanatsamal       staff               41600 Feb 13 20:20 biomed//1477-7827-1-31.txt
27156501       56 -rwxr-xr-x    1 sanatsamal       staff               26832 Feb 13 20:20 biomed//1471-213X-1-10.txt
27157184       96 -rwxr-xr-x    1 sanatsamal       staff               46710 Feb 13 20:20 biomed//gb-2002-3-3-research0011.txt
27157160       72 -rwxr-xr-x    1 sanatsamal       staff               32878 Feb 13 20:20 biomed//gb-2002-3-10-research0054.txt
27156411       48 -rwxr-xr-x    1 sanatsamal       staff               24112 Feb 13 20:20 biomed//1468-6708-3-1.txt
27156521       32 -rwxr-xr-x    1 sanatsamal       staff               12833 Feb 13 20:20 biomed//1471-2148-1-6.txt
27156698       72 -rwxr-xr-x    1 sanatsamal       staff               32938 Feb 13 20:20 biomed//1471-2202-4-3.txt
27156942       40 -rwxr-xr-x    1 sanatsamal       staff               18158 Feb 13 20:20 biomed//1472-6947-1-5.txt
27156674       72 -rwxr-xr-x    1 sanatsamal       staff               32780 Feb 13 20:20 biomed//1471-2202-2-5.txt
27157011       80 -rwxr-xr-x    1 sanatsamal       staff               37006 Feb 13 20:20 biomed//1476-9433-1-2.txt
27156702       32 -rwxr-xr-x    1 sanatsamal       staff               14603 Feb 13 20:20 biomed//1471-2210-1-2.txt
27156832       64 -rwxr-xr-x    1 sanatsamal       staff               32387 Feb 13 20:20 biomed//1471-2458-1-9.txt
27156893       72 -rwxr-xr-x    1 sanatsamal       staff               35125 Feb 13 20:20 biomed//1472-6793-2-2.txt
27157134       56 -rwxr-xr-x    1 sanatsamal       staff               25094 Feb 13 20:20 biomed//gb-2001-2-12-research0053.txt
27157031       48 -rwxr-xr-x    1 sanatsamal       staff               22678 Feb 13 20:20 biomed//1478-1336-1-2.txt
27156683       88 -rwxr-xr-x    1 sanatsamal       staff               42803 Feb 13 20:20 biomed//1471-2202-3-16.txt
27156627       56 -rwxr-xr-x    1 sanatsamal       staff               28049 Feb 13 20:20 biomed//1471-2180-2-13.txt
27156497       56 -rwxr-xr-x    1 sanatsamal       staff               25444 Feb 13 20:20 biomed//1471-2121-4-4.txt
27157224       64 -rwxr-xr-x    1 sanatsamal       staff               28895 Feb 13 20:20 biomed//gb-2003-4-4-r28.txt
27156744       24 -rwxr-xr-x    1 sanatsamal       staff               11200 Feb 13 20:20 biomed//1471-230X-2-17.txt
27157013       48 -rwxr-xr-x    1 sanatsamal       staff               21459 Feb 13 20:20 biomed//1477-5956-1-1.txt
27156554       88 -rwxr-xr-x    1 sanatsamal       staff               43248 Feb 13 20:20 biomed//1471-2156-4-9.txt
27156824       56 -rwxr-xr-x    1 sanatsamal       staff               26239 Feb 13 20:20 biomed//1471-2431-2-12.txt
27157045       32 -rwxr-xr-x    1 sanatsamal       staff               15903 Feb 13 20:20 biomed//ar328.txt
27156713       56 -rwxr-xr-x    1 sanatsamal       staff               28562 Feb 13 20:20 biomed//1471-2210-3-1.txt
27156498       56 -rwxr-xr-x    1 sanatsamal       staff               27586 Feb 13 20:20 biomed//1471-2121-4-5.txt
27156774       24 -rwxr-xr-x    1 sanatsamal       staff               11237 Feb 13 20:20 biomed//1471-2350-2-8.txt
27156684       64 -rwxr-xr-x    1 sanatsamal       staff               29638 Feb 13 20:20 biomed//1471-2202-3-17.txt
27156793       48 -rwxr-xr-x    1 sanatsamal       staff               23484 Feb 13 20:20 biomed//1471-2407-1-13.txt
27157085       96 -rwxr-xr-x    1 sanatsamal       staff               46272 Feb 13 20:20 biomed//bcr605.txt
27156990      152 -rwxr-xr-x    1 sanatsamal       staff               74965 Feb 13 20:20 biomed//1476-069X-2-9.txt
27157032       48 -rwxr-xr-x    1 sanatsamal       staff               23526 Feb 13 20:20 biomed//1478-1336-1-3.txt
27156557       56 -rwxr-xr-x    1 sanatsamal       staff               27684 Feb 13 20:20 biomed//1471-2164-2-4.txt
27156703       56 -rwxr-xr-x    1 sanatsamal       staff               28252 Feb 13 20:20 biomed//1471-2210-1-3.txt
27157012       48 -rwxr-xr-x    1 sanatsamal       staff               21318 Feb 13 20:20 biomed//1476-9433-1-3.txt
27156752       48 -rwxr-xr-x    1 sanatsamal       staff               21797 Feb 13 20:20 biomed//1471-2334-1-13.txt
27156813       48 -rwxr-xr-x    1 sanatsamal       staff               22447 Feb 13 20:20 biomed//1471-2407-3-16.txt
27156591       56 -rwxr-xr-x    1 sanatsamal       staff               28119 Feb 13 20:20 biomed//1471-2164-4-2.txt
27157124       56 -rwxr-xr-x    1 sanatsamal       staff               25609 Feb 13 20:20 biomed//cvm-2-4-187.txt
27156458       72 -rwxr-xr-x    1 sanatsamal       staff               34817 Feb 13 20:20 biomed//1471-2105-3-4.txt
27156487       64 -rwxr-xr-x    1 sanatsamal       staff               32262 Feb 13 20:20 biomed//1471-2121-3-21.txt
27156697       72 -rwxr-xr-x    1 sanatsamal       staff               33888 Feb 13 20:20 biomed//1471-2202-4-2.txt
27156613       48 -rwxr-xr-x    1 sanatsamal       staff               21927 Feb 13 20:20 biomed//1471-2172-3-9.txt
27157138       48 -rwxr-xr-x    1 sanatsamal       staff               23524 Feb 13 20:20 biomed//gb-2001-2-3-research0007.txt
27156652       56 -rwxr-xr-x    1 sanatsamal       staff               26704 Feb 13 20:20 biomed//1471-2199-2-6.txt
27157078       32 -rwxr-xr-x    1 sanatsamal       staff               16229 Feb 13 20:20 biomed//bcr567.txt
27157161       96 -rwxr-xr-x    1 sanatsamal       staff               47650 Feb 13 20:20 biomed//gb-2002-3-10-research0055.txt
27156476       32 -rwxr-xr-x    1 sanatsamal       staff               14165 Feb 13 20:20 biomed//1471-2121-2-3.txt
27156502       64 -rwxr-xr-x    1 sanatsamal       staff               29630 Feb 13 20:20 biomed//1471-213X-1-11.txt
27156915      104 -rwxr-xr-x    1 sanatsamal       staff               49884 Feb 13 20:20 biomed//1472-684X-1-5.txt
27156997       72 -rwxr-xr-x    1 sanatsamal       staff               33139 Feb 13 20:20 biomed//1476-4598-1-6.txt
```

Citation: https://man7.org/linux/man-pages/man1/find.1.html



2. `find technical/ -type f -size +/-`
The command finds all files in a file directory that is greater than or larget than a certain size. The "+" means greater than, and the "-" means less than. For this scenario it displays all the files and directories within the technical direcory greater than 50k megabytes.

```
(base) sanatsamal@Sanats-MacBook-Pro docsearch % find technical/ -type f -size +50k
technical//government/About_LSC/Strategic_report.txt
technical//government/About_LSC/commission_report.txt
technical//government/About_LSC/State_Planning_Report.txt
technical//government/Env_Prot_Agen/multi102902.txt
technical//government/Env_Prot_Agen/section-by-section_summary.txt
technical//government/Env_Prot_Agen/jeffordslieberm.txt
technical//government/Env_Prot_Agen/ctf7-10.txt
technical//government/Env_Prot_Agen/ctf1-6.txt
technical//government/Env_Prot_Agen/ctm4-10.txt
technical//government/Env_Prot_Agen/atx1-6.txt
technical//government/Env_Prot_Agen/bill.txt
technical//government/Env_Prot_Agen/tech_adden.txt
technical//government/Alcohol_Problems/Session3-PDF.txt
technical//government/Alcohol_Problems/Session4-PDF.txt
technical//government/Gen_Account_Office/d0269g.txt
technical//government/Gen_Account_Office/Testimony_cg00010t.txt
technical//government/Gen_Account_Office/GovernmentAuditingStandards_yb2002ed.txt
technical//government/Gen_Account_Office/Sept27-2002_d02966.txt
technical//government/Gen_Account_Office/d01376g.txt
technical//government/Gen_Account_Office/Statements_Feb28-1997_volume.txt
technical//government/Gen_Account_Office/pe1019.txt
technical//government/Gen_Account_Office/gg96118.txt
technical//government/Gen_Account_Office/July11-2001_gg00172r.txt
technical//government/Gen_Account_Office/d03419sp.txt
technical//government/Gen_Account_Office/Sept14-2002_d011070.txt
technical//government/Gen_Account_Office/d03232sp.txt
technical//government/Gen_Account_Office/June30-2000_gg00135r.txt
technical//government/Gen_Account_Office/d01591sp.txt
technical//government/Gen_Account_Office/Oct15-2001_d0224.txt
technical//government/Gen_Account_Office/im814.txt
technical//government/Gen_Account_Office/ai00134.txt
technical//government/Gen_Account_Office/Testimony_Jul17-2002_d02957t.txt
technical//government/Gen_Account_Office/ai9868.txt
technical//government/Gen_Account_Office/May1998_ai98068.txt
technical//government/Gen_Account_Office/d02701.txt
technical//government/Gen_Account_Office/ai2132.txt
technical//government/Post_Rate_Comm/Mitchell_6-17-Mit.txt
technical//biomed/1476-069X-2-4.txt
technical//biomed/gb-2003-4-5-r34.txt
technical//biomed/gb-2002-3-9-research0043.txt
technical//biomed/gb-2001-2-7-research0025.txt
technical//biomed/1471-2253-2-5.txt
technical//biomed/gb-2003-4-4-r26.txt
technical//biomed/1477-7827-1-13.txt
technical//biomed/gb-2003-4-7-r42.txt
technical//biomed/1471-2121-3-16.txt
technical//biomed/gb-2001-2-11-research0046.txt
technical//biomed/gb-2002-3-7-research0036.txt
technical//biomed/gb-2003-4-7-r43.txt
technical//biomed/1471-2121-3-15.txt
technical//biomed/gb-2002-3-9-research0045.txt
technical//biomed/1472-6904-2-5.txt
technical//biomed/gb-2002-3-11-research0059.txt
technical//biomed/gb-2002-3-11-research0065.txt
technical//biomed/1472-6807-3-1.txt
technical//biomed/1471-213X-3-3.txt
technical//biomed/1472-6904-3-1.txt
technical//biomed/1476-072X-2-4.txt
technical//biomed/gb-2003-4-2-r14.txt
technical//biomed/1471-2105-2-8.txt
technical//biomed/gb-2002-3-12-research0079.txt
technical//biomed/1471-2091-3-31.txt
technical//biomed/gb-2002-3-12-research0086.txt
technical//biomed/1471-2105-3-14.txt
technical//biomed/gb-2002-3-12-research0083.txt
technical//biomed/gb-2003-4-3-r17.txt
technical//biomed/gb-2002-3-12-research0072.txt
technical//biomed/1475-4924-1-10.txt
technical//biomed/1476-511X-1-2.txt
technical//biomed/gb-2002-3-12-research0071.txt
technical//biomed/1471-2105-3-18.txt
technical//biomed/1471-2121-2-10.txt
technical//biomed/1471-2202-3-1.txt
technical//biomed/1471-2091-3-14.txt
technical//biomed/gb-2001-3-1-research0001.txt
technical//biomed/gb-2002-3-12-research0088.txt
technical//biomed/1471-2121-3-25.txt
technical//biomed/1472-6882-1-10.txt
technical//biomed/1471-2210-1-7.txt
technical//biomed/1471-2121-3-30.txt
technical//biomed/gb-2002-3-10-research0052.txt
technical//biomed/gb-2003-4-2-r9.txt
technical//biomed/1471-2091-3-4.txt
technical//biomed/1471-2105-3-2.txt
technical//biomed/1471-2164-4-4.txt
technical//biomed/1477-7827-1-36.txt
technical//biomed/1471-2199-2-4.txt
technical//biomed/1476-069X-2-9.txt
technical//911report/chapter-13.4.txt
technical//911report/chapter-13.5.txt
technical//911report/chapter-13.1.txt
technical//911report/chapter-13.2.txt
technical//911report/chapter-13.3.txt
technical//911report/chapter-3.txt
technical//911report/chapter-2.txt
technical//911report/chapter-1.txt
technical//911report/chapter-5.txt
technical//911report/chapter-6.txt
technical//911report/chapter-7.txt
technical//911report/chapter-9.txt
technical//911report/chapter-8.txt
technical//911report/chapter-12.txt
technical//911report/chapter-11.txt
```

The command finds all files in a file directory that is greater than or larget than a certain size. The "+" means greater than, and the "-" means less than. For this scenario it displays all the files and directories within the biomed direcory less than 50k megabytes.

```
(base) sanatsamal@Sanats-MacBook-Pro technical % find biomed/ -type f -size -50k
biomed//1472-6807-2-2.txt
biomed//1471-2350-4-3.txt
biomed//1471-2156-2-3.txt
biomed//1471-2156-3-11.txt
biomed//1471-2121-3-10.txt
biomed//1471-2172-3-4.txt
biomed//gb-2002-4-1-r2.txt
biomed//gb-2003-4-6-r41.txt
biomed//1471-2466-1-1.txt
biomed//1471-2199-2-10.txt
biomed//1471-2202-2-9.txt
biomed//cc991.txt
biomed//1471-2369-3-9.txt
biomed//bcr620.txt
biomed//1472-6750-3-11.txt
biomed//1471-2164-2-9.txt
biomed//1471-2091-2-10.txt
biomed//gb-2001-2-4-research0010.txt
biomed//gb-2003-4-4-r24.txt
biomed//1471-213X-2-1.txt
biomed//1472-6882-3-3.txt
biomed//1471-2407-2-3.txt
biomed//ar331.txt
biomed//ar319.txt
biomed//1471-2156-4-5.txt
biomed//1471-2431-2-1.txt
biomed//1476-4598-2-22.txt
biomed//1471-2180-2-22.txt
biomed//1471-2334-3-9.txt
biomed//1471-2091-2-11.txt
biomed//gb-2001-2-4-research0011.txt
biomed//1471-2202-4-12.txt
biomed//rr73.txt
biomed//1471-2164-2-8.txt
biomed//1471-2148-2-12.txt
biomed//bcr635.txt
biomed//1468-6708-3-10.txt
biomed//1471-2202-2-8.txt
biomed//1471-2121-3-11.txt
biomed//1471-2156-3-10.txt
biomed//1471-2458-3-20.txt
biomed//1471-2350-4-2.txt
biomed//1472-6807-2-3.txt
biomed//1472-6807-2-1.txt
biomed//1476-4598-1-8.txt
biomed//1477-7525-1-9.txt
biomed//ar79.txt
biomed//1476-0711-2-7.txt
biomed//1472-6947-3-8.txt
biomed//1471-2121-3-13.txt
biomed//gb-2002-4-1-r1.txt
biomed//1471-2407-3-18.txt
biomed//1471-2229-2-3.txt
biomed//1471-2334-1-9.txt
biomed//1471-2415-3-5.txt
biomed//1471-2334-1-21.txt
biomed//ar130.txt
biomed//1476-069X-2-7.txt
biomed//1472-6890-2-5.txt
biomed//ar118.txt
biomed//gb-2002-3-7-research0032.txt
biomed//1471-2210-1-10.txt
biomed//1471-2091-2-13.txt
biomed//1471-2180-2-20.txt
biomed//1471-2202-3-19.txt
biomed//1471-2202-4-10.txt
biomed//1472-6963-2-10.txt
biomed//1476-4598-2-20.txt
biomed//1471-2156-4-6.txt
biomed//1471-2458-3-5.txt
biomed//1472-6769-1-4.txt
biomed//1472-6882-3-1.txt
biomed//cc4.txt
biomed//1471-2180-2-35.txt
biomed//1471-2202-4-11.txt
biomed//gb-2001-2-4-research0012.txt
biomed//1471-2091-2-12.txt
biomed//1471-2253-2-4.txt
biomed//gb-2001-2-7-research0024.txt
biomed//1471-2415-3-4.txt
biomed//1471-2199-2-12.txt
biomed//1471-2121-3-12.txt
biomed//1471-2148-1-8.txt
biomed//gb-2001-2-3-research0008.txt
biomed//1471-2156-2-1.txt
biomed//1471-2466-3-1.txt
biomed//bcr568.txt
biomed//gb-2003-4-7-r46.txt
biomed//1475-2875-2-14.txt
biomed//1471-2288-2-4.txt
biomed//1472-6785-1-3.txt
biomed//ar93.txt
biomed//1472-6831-2-2.txt
biomed//bcr583.txt
biomed//cc367.txt
biomed//1477-7827-1-17.txt
biomed//1472-6807-2-4.txt
biomed//1471-2156-3-17.txt
biomed//1475-2875-2-10.txt
biomed//1471-2156-2-5.txt
biomed//ar68.txt
biomed//1471-2172-3-2.txt
biomed//1472-6750-1-12.txt
biomed//1472-6904-2-7.txt
biomed//1472-6882-1-7.txt
biomed//1471-2334-1-24.txt
biomed//1471-2377-2-4.txt
biomed//gb-2002-3-9-research0046.txt
biomed//rr74.txt
biomed//gb-2002-3-7-research0037.txt
biomed//gb-2001-2-8-research0027.txt
biomed//1476-069X-2-2.txt
biomed//1471-2148-2-15.txt
biomed//1472-6874-2-1.txt
biomed//1471-2210-1-8.txt
biomed//1471-2091-3-8.txt
biomed//1472-6793-2-8.txt
biomed//1471-213X-2-7.txt
biomed//1471-2202-3-20.txt
biomed//1471-2091-2-16.txt
biomed//1476-4598-2-25.txt
biomed//1471-230X-2-21.txt
biomed//1476-4598-2-24.txt
biomed//1471-2350-2-2.txt
biomed//1472-6769-1-1.txt
biomed//ar120.txt
biomed//1471-2148-2-14.txt
biomed//1471-2407-1-19.txt
biomed//gb-2001-2-8-research0032.txt
biomed//1471-2415-3-1.txt
biomed//gb-2003-4-5-r32.txt
biomed//1472-6750-1-13.txt
biomed//1472-6920-1-3.txt
biomed//1471-2474-2-1.txt
biomed//1476-0711-2-3.txt
biomed//rr171.txt
biomed//1471-2156-3-16.txt
biomed//1472-6807-2-5.txt
biomed//1471-2350-4-4.txt
biomed//1471-2172-1-1.txt
biomed//ar297.txt
biomed//1471-2350-4-6.txt
biomed//rr167.txt
biomed//1471-2474-2-3.txt
biomed//1471-2172-3-1.txt
biomed//1472-6904-2-4.txt
biomed//1472-6750-1-11.txt
biomed//gb-2003-4-5-r30.txt
biomed//gb-2002-3-9-research0051.txt
biomed//1471-2415-3-3.txt
biomed//gb-2001-2-8-research0030.txt
biomed//bcr631.txt
biomed//1472-6769-1-3.txt
biomed//cc3.txt
biomed//1471-2180-2-32.txt
biomed//1471-2202-4-16.txt
biomed//1471-2180-2-26.txt
biomed//1471-2431-2-4.txt
biomed//1471-2458-3-2.txt
biomed//1475-9276-1-3.txt
biomed//ar321.txt
biomed//1471-230X-2-23.txt
biomed//ar309.txt
biomed//gb-2001-2-4-research0014.txt
biomed//1477-7819-1-10.txt
biomed//gb-2001-2-11-research0045.txt
biomed//1471-2202-4-17.txt
biomed//1472-6769-1-2.txt
biomed//bcr618.txt
biomed//gb-2002-3-7-research0035.txt
biomed//gb-2001-2-8-research0031.txt
biomed//1471-2148-2-17.txt
biomed//1471-2229-2-4.txt
biomed//1471-2350-3-12.txt
biomed//gb-2002-3-9-research0044.txt
biomed//1471-2377-2-6.txt
biomed//1471-2474-4-4.txt
biomed//1472-6823-3-1.txt
biomed//1471-2474-2-2.txt
biomed//rr166.txt
biomed//rr172.txt
biomed//1471-2156-2-7.txt
biomed//1472-6785-1-5.txt
biomed//bcr284.txt
biomed//gb-2002-3-2-research0008.txt
biomed//cc2190.txt
biomed//1471-213X-3-2.txt
biomed//1471-2148-3-18.txt
biomed//1471-2229-3-3.txt
biomed//1471-2172-4-1.txt
biomed//ar795.txt
biomed//1471-2164-3-15.txt
biomed//cc1843.txt
biomed//1471-2164-3-29.txt
biomed//1471-2458-2-16.txt
biomed//1475-925X-2-10.txt
biomed//gb-2003-4-9-r58.txt
biomed//1471-2105-4-27.txt
biomed//1471-2105-3-12.txt
biomed//gb-2003-4-2-r16.txt
biomed//ar408.txt
biomed//ar409.txt
biomed//1471-2407-2-11.txt
biomed//gb-2001-2-10-research0041.txt
biomed//1471-2288-3-4.txt
biomed//1471-2105-4-26.txt
biomed//1471-230X-1-5.txt
biomed//gb-2002-3-8-research0040.txt
biomed//1475-925X-2-11.txt
biomed//gb-2001-2-9-research0035.txt
biomed//1471-2172-3-12.txt
biomed//gb-2003-4-6-r37.txt
biomed//1472-6750-1-8.txt
biomed//1471-244X-2-9.txt
biomed//gb-2002-3-12-research0085.txt
biomed//1471-213X-1-1.txt
biomed//1471-2164-4-21.txt
biomed//cc1856.txt
biomed//1471-2180-3-15.txt
biomed//1471-2164-3-28.txt
biomed//cc105.txt
biomed//1471-2202-2-10.txt
biomed//1471-2180-1-8.txt
biomed//1471-2431-3-3.txt
biomed//1471-2369-3-10.txt
biomed//cc1498.txt
biomed//1471-2377-1-2.txt
biomed//1471-2350-3-7.txt
biomed//gb-2002-3-2-research0009.txt
biomed//bcr285.txt
biomed//gb-2002-3-6-software0001.txt
biomed//1475-2867-3-12.txt
biomed//1471-2229-1-2.txt
biomed//1471-2407-3-3.txt
biomed//1472-6890-1-4.txt
biomed//1471-2172-4-2.txt
biomed//1471-2164-3-16.txt
biomed//1471-2091-3-18.txt
biomed//1471-2202-2-12.txt
biomed//1471-2164-4-23.txt
biomed//1471-213X-1-3.txt
biomed//gb-2002-3-12-research0087.txt
biomed//1471-2091-3-30.txt
biomed//gb-2002-3-12-research0078.txt
biomed//1471-2164-3-9.txt
biomed//1471-2172-3-10.txt
biomed//1471-2172-2-4.txt
biomed//1471-2180-1-12.txt
biomed//gb-2001-2-6-research0018.txt
biomed//gb-2001-2-9-research0037.txt
biomed//1471-2105-2-9.txt
biomed//1472-6793-2-16.txt
biomed//1472-6807-3-2.txt
biomed//1471-2121-2-18.txt
biomed//1471-2148-2-8.txt
biomed//1471-2105-4-24.txt
biomed//1471-2156-3-3.txt
biomed//1471-2466-2-3.txt
biomed//1471-230X-3-5.txt
biomed//1471-2407-2-12.txt
biomed//1472-6904-1-2.txt
biomed//cc1538.txt
biomed//1471-2105-4-25.txt
biomed//1471-2105-3-38.txt
biomed//ar422.txt
biomed//gb-2001-2-10-research0042.txt
biomed//1471-2105-4-31.txt
biomed//1472-6831-3-1.txt
biomed//ar387.txt
biomed//1471-230X-1-6.txt
biomed//1472-6793-2-17.txt
biomed//1471-2156-2-18.txt
biomed//1475-925X-2-12.txt
biomed//1478-7954-1-3.txt
biomed//1472-6807-1-1.txt
biomed//cc1882.txt
biomed//1471-2164-3-8.txt
biomed//1471-2180-3-9.txt
biomed//1471-2164-4-22.txt
biomed//1471-213X-1-2.txt
biomed//1471-2202-3-8.txt
biomed//1471-2458-2-6.txt
biomed//1477-7827-1-48.txt
biomed//1471-2229-1-3.txt
biomed//1471-213X-3-4.txt
biomed//cc300.txt
biomed//1476-069X-1-3.txt
biomed//1471-2253-1-1.txt
biomed//1471-2431-3-4.txt
biomed//1471-2210-2-9.txt
biomed//gb-2002-3-12-research0082.txt
biomed//1471-213X-1-6.txt
biomed//1471-2164-4-26.txt
biomed//1471-2164-3-13.txt
biomed//1471-2202-2-17.txt
biomed//1472-6874-3-2.txt
biomed//ar778.txt
biomed//ar750.txt
biomed//1471-2474-3-3.txt
biomed//1472-6785-2-6.txt
biomed//1471-2490-3-2.txt
biomed//1477-7827-1-9.txt
biomed//gb-2001-2-6-research0021.txt
biomed//ar624.txt
biomed//1471-2121-2-21.txt
biomed//1472-6920-2-3.txt
biomed//ar383.txt
biomed//1471-2407-2-16.txt
biomed//1471-2105-3-28.txt
biomed//gb-2003-4-2-r11.txt
biomed//cc1529.txt
biomed//1471-2407-2-17.txt
biomed//1472-6815-2-3.txt
biomed//ar619.txt
biomed//1471-2458-2-11.txt
biomed//gb-2001-2-6-research0020.txt
biomed//1472-6785-2-7.txt
biomed//1471-2180-1-16.txt
biomed//ar745.txt
biomed//1472-6890-3-2.txt
biomed//cc103.txt
biomed//1471-2202-2-16.txt
biomed//ar792.txt
biomed//1471-2180-3-13.txt
biomed//1471-2210-2-8.txt
biomed//1472-6793-1-8.txt
biomed//1471-2458-2-3.txt
biomed//1472-6750-2-21.txt
biomed//1471-2431-3-5.txt
biomed//1472-6882-2-10.txt
biomed//1471-2350-3-1.txt
biomed//gb-2002-3-11-research0062.txt
biomed//1472-6882-2-5.txt
biomed//gb-2002-3-11-research0060.txt
biomed//1471-213X-3-7.txt
biomed//cc303.txt
biomed//cc1477.txt
biomed//1471-2407-3-5.txt
biomed//1471-2377-3-4.txt
biomed//1471-2180-3-11.txt
biomed//gb-2002-3-12-research0081.txt
biomed//cc1852.txt
biomed//1471-2164-4-25.txt
biomed//1471-2091-3-22.txt
biomed//1471-2202-2-14.txt
biomed//1471-2164-3-10.txt
biomed//1471-2164-4-19.txt
biomed//cc713.txt
biomed//1471-2172-3-16.txt
biomed//1471-2180-1-28.txt
biomed//1471-230X-1-10.txt
biomed//1471-2121-2-22.txt
biomed//1471-2334-2-29.txt
biomed//1471-2121-3-8.txt
biomed//1472-6963-1-8.txt
biomed//1471-2296-3-19.txt
biomed//1471-2407-2-15.txt
biomed//1471-2105-3-17.txt
biomed//1471-230X-3-3.txt
biomed//ar430.txt
biomed//1471-2156-3-4.txt
biomed//1471-2466-2-4.txt
biomed//1471-2296-3-18.txt
biomed//1471-2105-3-16.txt
biomed//1472-6920-2-1.txt
biomed//1476-072X-2-3.txt
biomed//gb-2003-4-9-r60.txt
biomed//ar140.txt
biomed//1472-6793-2-11.txt
biomed//1472-6823-2-2.txt
biomed//1471-2180-1-29.txt
biomed//1471-2172-2-3.txt
biomed//1471-2407-1-6.txt
biomed//1471-2091-2-9.txt
biomed//1471-2202-2-15.txt
biomed//1471-2091-3-23.txt
biomed//1471-2164-4-24.txt
biomed//1471-213X-1-4.txt
biomed//gb-2002-3-12-research0080.txt
biomed//1471-2180-3-10.txt
biomed//cc1476.txt
biomed//1471-2407-3-4.txt
biomed//1471-2431-3-6.txt
biomed//bcr294.txt
biomed//gb-2002-3-11-research0061.txt
biomed//1477-7827-1-43.txt
biomed//1475-2832-1-1.txt
biomed//1471-2199-3-12.txt
biomed//1471-2202-1-1.txt
biomed//1472-6750-2-13.txt
biomed//cc2172.txt
biomed//1472-6793-1-6.txt
biomed//1471-2210-2-6.txt
biomed//1471-213X-1-9.txt
biomed//1471-2164-3-34.txt
biomed//1471-2164-4-15.txt
biomed//1471-2202-3-3.txt
biomed//1471-2202-2-18.txt
biomed//cc2358.txt
biomed//1472-6793-3-4.txt
biomed//1472-6963-3-11.txt
biomed//1472-6963-3-6.txt
biomed//1476-4598-2-3.txt
biomed//1477-7827-1-6.txt
biomed//1472-6874-2-13.txt
biomed//1471-2369-4-5.txt
biomed//1471-2121-3-4.txt
biomed//1471-2121-2-12.txt
biomed//1471-2148-2-2.txt
biomed//1475-925X-2-6.txt
biomed//1471-2148-1-14.txt
biomed//1471-2407-2-19.txt
biomed//1471-2210-2-14.txt
biomed//1475-2867-3-4.txt
biomed//ar429.txt
biomed//1471-2407-2-31.txt
biomed//1471-2105-3-26.txt
biomed//1477-7525-1-12.txt
biomed//1471-2407-2-18.txt
biomed//1471-2105-4-13.txt
biomed//gb-2003-4-1-r5.txt
biomed//1471-2334-2-24.txt
biomed//1471-2318-3-2.txt
biomed//1471-2156-2-12.txt
biomed//1471-2180-1-31.txt
biomed//1476-4598-2-2.txt
biomed//1472-684X-2-1.txt
biomed//1471-5945-3-3.txt
biomed//1472-6963-3-7.txt
biomed//1475-2891-2-1.txt
biomed//1471-2091-2-5.txt
biomed//1472-6793-3-5.txt
biomed//1475-4924-1-5.txt
biomed//1471-2202-2-19.txt
biomed//1471-2091-3-13.txt
biomed//1471-2164-4-14.txt
biomed//1471-2164-3-35.txt
biomed//1471-2164-4-28.txt
biomed//cc2167.txt
biomed//bcr273.txt
biomed//1477-7827-1-54.txt
biomed//1471-2334-2-1.txt
biomed//1471-2199-3-11.txt
biomed//1472-6750-2-10.txt
biomed//1471-2210-2-5.txt
biomed//cc2171.txt
biomed//1471-2164-3-23.txt
biomed//1471-2164-4-16.txt
biomed//ar774.txt
biomed//1472-6963-3-12.txt
biomed//1471-2091-2-7.txt
biomed//1471-2180-1-33.txt
biomed//gb-2000-1-1-research002.txt
biomed//gb-2001-3-1-research0005.txt
biomed//bcr45.txt
biomed//1471-2091-4-1.txt
biomed//gb-2003-4-1-r7.txt
biomed//1471-2334-2-26.txt
biomed//1471-2121-2-11.txt
biomed//1471-5945-1-3.txt
biomed//1471-2261-3-5.txt
biomed//1471-2105-3-24.txt
biomed//1476-5918-1-2.txt
biomed//1477-7525-1-10.txt
biomed//gb-2002-3-5-research0024.txt
biomed//1471-2105-3-30.txt
biomed//1471-2407-2-33.txt
biomed//gb-2002-3-5-research0025.txt
biomed//1471-2261-3-4.txt
biomed//1471-2199-3-3.txt
biomed//1471-2121-3-6.txt
biomed//1471-2334-2-27.txt
biomed//gb-2001-3-1-research0004.txt
biomed//1471-2105-2-1.txt
biomed//1471-2261-1-6.txt
biomed//gb-2003-4-3-r18.txt
biomed//ar615.txt
biomed//ar601.txt
biomed//1476-4598-2-1.txt
biomed//1472-684X-2-2.txt
biomed//1471-2180-1-26.txt
biomed//1471-2458-2-21.txt
biomed//1472-6793-3-6.txt
biomed//1472-6963-3-13.txt
biomed//1471-2164-3-1.txt
biomed//1471-2210-2-4.txt
biomed//1471-2199-3-10.txt
biomed//1471-2350-2-12.txt
biomed//1471-2350-3-9.txt
biomed//1475-9268-1-1.txt
biomed//gb-2001-2-2-research0004.txt
biomed//cc2160.txt
biomed//1472-6750-3-4.txt
biomed//1471-2202-3-5.txt
biomed//1471-2164-4-13.txt
biomed//1471-5945-2-13.txt
biomed//1471-2164-3-32.txt
biomed//1471-2164-3-26.txt
biomed//1471-2288-2-11.txt
biomed//1471-2180-3-4.txt
biomed//1472-6750-1-6.txt
biomed//gb-2003-4-6-r39.txt
biomed//1471-2458-2-25.txt
biomed//gb-2003-4-3-r20.txt
biomed//gb-2003-4-9-r57.txt
biomed//1471-2121-3-2.txt
biomed//1471-2407-2-23.txt
biomed//1471-2105-4-28.txt
biomed//1472-6947-2-7.txt
biomed//gb-2002-3-5-research0021.txt
biomed//ar407.txt
biomed//1471-2199-3-7.txt
biomed//1475-2867-3-2.txt
biomed//1475-925X-2-1.txt
biomed//1475-2867-3-3.txt
biomed//1471-2105-3-34.txt
biomed//gb-2002-3-5-research0020.txt
biomed//1471-2407-2-22.txt
biomed//1471-2121-2-15.txt
biomed//1471-2148-2-5.txt
biomed//cc1044.txt
biomed//1471-2091-4-5.txt
biomed//1471-2288-1-9.txt
biomed//rr37.txt
biomed//1472-6963-3-1.txt
biomed//1471-2172-2-9.txt
biomed//1471-2458-2-18.txt
biomed//1471-2180-3-5.txt
biomed//1471-2288-2-10.txt
biomed//1471-2164-3-4.txt
biomed//1472-6793-3-3.txt
biomed//gb-2002-3-12-research0075.txt
biomed//1471-2164-3-27.txt
biomed//1471-2164-3-33.txt
biomed//1471-2091-3-15.txt
biomed//1471-2202-3-4.txt
biomed//1472-6750-2-14.txt
biomed//1471-2180-1-7.txt
biomed//cc1497.txt
biomed//1471-2334-2-5.txt
biomed//1471-2199-3-17.txt
biomed//1471-2350-2-11.txt
biomed//1471-2334-2-7.txt
biomed//cc1495.txt
biomed//1475-9268-1-2.txt
biomed//1477-7827-1-46.txt
biomed//1471-2091-3-17.txt
biomed//ar799.txt
biomed//1471-2164-3-19.txt
biomed//1471-2164-3-31.txt
biomed//gb-2002-3-12-research0077.txt
biomed//1472-6963-3-14.txt
biomed//1475-2875-1-14.txt
biomed//1471-2164-3-6.txt
biomed//gb-2003-4-8-r51.txt
biomed//1475-2875-2-4.txt
biomed//1472-6963-1-11.txt
biomed//ar612.txt
biomed//1472-6793-2-19.txt
biomed//1471-230X-1-8.txt
biomed//1471-2148-2-7.txt
biomed//gb-2002-3-5-research0022.txt
biomed//1471-2288-3-9.txt
biomed//1471-2105-3-22.txt
biomed//1472-6947-2-4.txt
biomed//bcr317.txt
biomed//1475-925X-2-3.txt
biomed//bcr303.txt
biomed//1471-2105-3-23.txt
biomed//1471-2288-3-8.txt
biomed//bcr458.txt
biomed//1471-2105-3-37.txt
biomed//gb-2002-3-5-research0023.txt
biomed//1472-6793-2-18.txt
biomed//1471-2156-2-17.txt
biomed//1471-2369-4-1.txt
biomed//ar149.txt
biomed//gb-2002-3-6-research0029.txt
biomed//1471-2121-1-2.txt
biomed//1471-2180-1-34.txt
biomed//gb-2003-4-8-r50.txt
biomed//1471-2164-3-7.txt
biomed//1471-2164-3-30.txt
biomed//1471-2202-2-20.txt
biomed//1471-2164-3-24.txt
biomed//1471-2202-3-7.txt
biomed//1471-2091-3-16.txt
biomed//1471-2164-3-18.txt
biomed//1472-6750-3-6.txt
biomed//1472-6793-1-2.txt
biomed//1471-2334-2-6.txt
biomed//1471-213X-1-15.txt
biomed//cc350.txt
biomed//1471-2148-3-1.txt
biomed//bcr588.txt
biomed//1471-2199-2-2.txt
biomed//1475-2867-2-7.txt
biomed//1468-6708-3-4.txt
biomed//1471-2334-3-12.txt
biomed//1471-2202-4-6.txt
biomed//1471-2121-3-19.txt
biomed//1471-2164-4-6.txt
biomed//1471-2229-2-9.txt
biomed//gb-2002-3-9-research0049.txt
biomed//1471-2334-1-17.txt
biomed//1471-2180-2-1.txt
biomed//cc973.txt
biomed//1471-2326-2-4.txt
biomed//1471-2180-2-16.txt
biomed//1471-2121-4-1.txt
biomed//1471-213X-2-8.txt
biomed//1472-6793-1-12.txt
biomed//1471-2199-4-4.txt
biomed//1471-2199-4-5.txt
biomed//1471-2369-3-1.txt
biomed//1471-2164-2-1.txt
biomed//1471-2202-2-1.txt
biomed//gb-2002-3-9-research0048.txt
biomed//1471-2229-2-8.txt
biomed//1471-2474-4-8.txt
biomed//1471-2121-3-18.txt
biomed//1472-6882-1-11.txt
biomed//1471-2334-3-13.txt
biomed//cvm-2-1-038.txt
biomed//1471-2156-4-10.txt
biomed//1471-2199-2-3.txt
biomed//1476-4598-1-3.txt
biomed//1471-2172-2-10.txt
biomed//1471-2121-2-6.txt
biomed//1477-7827-1-21.txt
biomed//1477-7827-1-23.txt
biomed//1475-2891-1-2.txt
biomed//1468-6708-3-7.txt
biomed//1471-2199-2-1.txt
biomed//1471-2105-1-1.txt
biomed//1471-2202-4-5.txt
biomed//1471-2334-3-11.txt
biomed//1471-2164-4-5.txt
biomed//cvm-2-6-278.txt
biomed//cvm-2-4-180.txt
biomed//1471-2105-3-3.txt
biomed//1475-2883-2-11.txt
biomed//1475-2867-2-10.txt
biomed//1471-2202-2-3.txt
biomed//bcr602.txt
biomed//1471-2180-2-2.txt
biomed//gb-2001-2-12-research0055.txt
biomed//1478-1336-1-4.txt
biomed//1472-6793-2-4.txt
biomed//1471-2210-1-4.txt
biomed//1471-2121-4-2.txt
biomed//gb-2002-3-4-research0019.txt
biomed//1471-2202-3-10.txt
biomed//1471-2180-2-29.txt
biomed//1472-6750-2-2.txt
biomed//1476-511X-2-3.txt
biomed//cc1547.txt
biomed//1472-6793-1-11.txt
biomed//1471-2407-2-9.txt
biomed//1471-2407-2-8.txt
biomed//1476-4598-2-28.txt
biomed//1476-511X-2-2.txt
biomed//1471-2202-3-11.txt
biomed//1471-2121-4-3.txt
biomed//gb-2002-3-4-research0018.txt
biomed//1471-2261-2-11.txt
biomed//1472-6793-2-5.txt
biomed//1471-2164-2-2.txt
biomed//gb-2001-2-12-research0054.txt
biomed//ar104.txt
biomed//1471-2407-1-15.txt
biomed//1471-2202-2-2.txt
biomed//gb-2003-4-2-r8.txt
biomed//1472-6947-1-2.txt
biomed//1471-2229-2-11.txt
biomed//cvm-2-6-286.txt
biomed//1471-2148-1-1.txt
biomed//1471-2334-3-10.txt
biomed//1472-6882-1-12.txt
biomed//gb-2002-3-10-research0053.txt
biomed//1471-2156-2-8.txt
biomed//rr196.txt
biomed//1471-2148-3-3.txt
biomed//1472-6807-2-9.txt
biomed//1471-2148-3-7.txt
biomed//1471-213X-1-13.txt
biomed//1471-2121-2-1.txt
biomed//gb-2002-3-3-research0012.txt
biomed//1471-2156-3-22.txt
biomed//bcr571.txt
biomed//gb-2000-1-2-research0003.txt
biomed//1472-6955-2-1.txt
biomed//1471-2105-3-6.txt
biomed//1471-2474-3-23.txt
biomed//1472-6947-1-6.txt
biomed//1471-2407-3-14.txt
biomed//1471-2202-2-6.txt
biomed//1475-2867-2-15.txt
biomed//1472-6793-2-1.txt
biomed//gb-2002-3-8-research0039.txt
biomed//1471-2369-3-6.txt
biomed//bcr607.txt
biomed//1472-6874-2-8.txt
biomed//1471-2180-2-7.txt
biomed//1471-2164-2-6.txt
biomed//1471-2180-2-38.txt
biomed//1471-2210-3-3.txt
biomed//1471-2431-2-11.txt
biomed//1472-6793-1-15.txt
biomed//1471-2458-3-9.txt
biomed//1471-2121-4-6.txt
biomed//1471-2202-3-14.txt
biomed//1471-2164-2-7.txt
biomed//gb-2001-2-12-research0051.txt
biomed//gb-2002-3-8-research0038.txt
biomed//1471-244X-3-5.txt
biomed//1471-2202-2-7.txt
biomed//1471-2334-1-10.txt
biomed//1471-2407-3-15.txt
biomed//1471-2121-3-22.txt
biomed//1471-2334-3-15.txt
biomed//1471-2148-1-4.txt
biomed//1471-2199-2-5.txt
biomed//1468-6708-3-3.txt
biomed//bcr570.txt
biomed//gb-2002-3-10-research0056.txt
biomed//1472-6947-3-5.txt
biomed//cc343.txt
biomed//1471-213X-1-12.txt
biomed//1471-2296-3-3.txt
biomed//1477-7827-1-27.txt
biomed//1476-4598-1-5.txt
biomed//rr191.txt
biomed//1471-2148-3-4.txt
biomed//1471-2458-3-11.txt
biomed//1475-2875-1-5.txt
biomed//1477-7827-1-31.txt
biomed//1471-213X-1-10.txt
biomed//gb-2002-3-3-research0011.txt
biomed//gb-2002-3-10-research0054.txt
biomed//1468-6708-3-1.txt
biomed//1471-2148-1-6.txt
biomed//1471-2202-4-3.txt
biomed//1472-6947-1-5.txt
biomed//1471-2202-2-5.txt
biomed//1476-9433-1-2.txt
biomed//1471-2210-1-2.txt
biomed//1471-2458-1-9.txt
biomed//1472-6793-2-2.txt
biomed//gb-2001-2-12-research0053.txt
biomed//1478-1336-1-2.txt
biomed//1471-2202-3-16.txt
biomed//1471-2180-2-13.txt
biomed//1471-2121-4-4.txt
biomed//gb-2003-4-4-r28.txt
biomed//1471-230X-2-17.txt
biomed//1477-5956-1-1.txt
biomed//1471-2156-4-9.txt
biomed//1471-2431-2-12.txt
biomed//ar328.txt
biomed//1471-2210-3-1.txt
biomed//1471-2121-4-5.txt
biomed//1471-2350-2-8.txt
biomed//1471-2202-3-17.txt
biomed//1471-2407-1-13.txt
biomed//bcr605.txt
biomed//1478-1336-1-3.txt
biomed//1471-2164-2-4.txt
biomed//1471-2210-1-3.txt
biomed//1476-9433-1-3.txt
biomed//1471-2334-1-13.txt
biomed//1471-2407-3-16.txt
biomed//1471-2164-4-2.txt
biomed//cvm-2-4-187.txt
biomed//1471-2105-3-4.txt
biomed//1471-2121-3-21.txt
biomed//1471-2202-4-2.txt
biomed//1471-2172-3-9.txt
biomed//gb-2001-2-3-research0007.txt
biomed//1471-2199-2-6.txt
biomed//bcr567.txt
biomed//gb-2002-3-10-research0055.txt
biomed//1471-2121-2-3.txt
biomed//1471-213X-1-11.txt
biomed//1472-684X-1-5.txt
biomed//1476-4598-1-6.txt
```

Citation: https://man7.org/linux/man-pages/man1/find.1.html


3. `find directory/ -type d -maxdepth #`
The command finds all directories in a file directory that of a certain maxdepth. For this scenario it displays all the directories within the technical direcory of a maxdepth of 2.

```
(base) sanatsamal@Sanats-MacBook-Pro docsearch % find technical/ -type d -maxdepth 2 
technical/
technical//government
technical//government/About_LSC
technical//government/Env_Prot_Agen
technical//government/Alcohol_Problems
technical//government/Gen_Account_Office
technical//government/Post_Rate_Comm
technical//government/Media
technical//plos
technical//biomed
technical//911report
```

The command finds all directories in a file directory that of a certain maxdepth. For this scenario it displays all the directories within the technical direcory of a maxdepth of 1.
```
(base) sanatsamal@Sanats-MacBook-Pro docsearch % find technical/ -type d -maxdepth 1
technical/
technical//government
technical//plos
technical//biomed
technical//911report
```


Citation: https://man7.org/linux/man-pages/man1/find.1.html

