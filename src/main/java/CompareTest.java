import com.objectcompare.Comparator;
import com.objectcompare.Example;
import com.objectcompare.NestedExample;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CompareTest {

    @Test
    public void noMismatches() {
        Comparator comparator = new Comparator();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        NestedExample nestedExample = new NestedExample("hello", Arrays.asList("test", "example"));
        Example example = new Example(10, list, nestedExample);
        String mismatches = comparator.compare(example, example);
        Assert.assertTrue(mismatches.isEmpty());
    }

    @Test
    public void intMismatch() {
        Comparator comparator = new Comparator();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        NestedExample nestedExample = new NestedExample("hello", Arrays.asList("test", "example"));
        Example example1 = new Example(10, list, nestedExample);
        Example example2 = new Example(6, list, nestedExample);
        String mismatches = comparator.compare(example1, example2);
        Assert.assertFalse(mismatches.isEmpty());
        System.out.println(mismatches);
    }

    @Test
    public void listMismatch() {
        Comparator comparator = new Comparator();
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 3, 2, 1));
        NestedExample nestedExample = new NestedExample("hello", Arrays.asList("test", "example"));
        Example example1 = new Example(10, list1, nestedExample);
        Example example2 = new Example(10, list2, nestedExample);
        String mismatches = comparator.compare(example1, example2);
        Assert.assertFalse(mismatches.isEmpty());
        System.out.println(mismatches);
    }

    @Test
    public void nestedStrMismatch() {
        Comparator comparator = new Comparator();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        NestedExample nestedExample1 = new NestedExample("hello", Arrays.asList("test", "example"));
        NestedExample nestedExample2 = new NestedExample("goodbye", Arrays.asList("test", "example"));
        Example example1 = new Example(10, list, nestedExample1);
        Example example2 = new Example(10, list, nestedExample2);
        String mismatches = comparator.compare(example1, example2);
        Assert.assertFalse(mismatches.isEmpty());
        System.out.println(mismatches);
    }

    @Test
    public void nestedListMismatch() {
        Comparator comparator = new Comparator();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        NestedExample nestedExample1 = new NestedExample("hello", Arrays.asList("test", "example"));
        NestedExample nestedExample2 = new NestedExample("hello", Arrays.asList("wrong", "list"));
        Example example1 = new Example(10, list, nestedExample1);
        Example example2 = new Example(10, list, nestedExample2);
        String mismatches = comparator.compare(example1, example2);
        Assert.assertFalse(mismatches.isEmpty());
        System.out.println(mismatches);
    }

    @Test
    public void allFieldsMismatch() {
        Comparator comparator = new Comparator();
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 3, 2, 1));
        NestedExample nestedExample1 = new NestedExample("hello", Arrays.asList("test", "example"));
        NestedExample nestedExample2 = new NestedExample("goodbye", Arrays.asList("wrong", "list"));
        Example example1 = new Example(10, list1, nestedExample1);
        Example example2 = new Example(6, list2, nestedExample2);
        String mismatches = comparator.compare(example1, example2);
        Assert.assertFalse(mismatches.isEmpty());
        System.out.println(mismatches);
    }

}
