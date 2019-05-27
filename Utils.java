package FST;

//
// Utils.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 08/04/19 11:38 AM.

import java.text.BreakIterator;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 A utilities class.
 */
public class Utils {

    /**
     The next valid integer from {@code sc} that satisfies the given {@code predicate}. Between invalid inputs, {@code
    invalidInputMessage} is printed.

     @param sc                  the scanner from which to request the input.
     @param invalidInputMessage the message to print between invalid input attempts.
     @param condition           the condition that constitutes a valid integer input.

     @return the next valid integer input from {@code sc}.
     */
    public static int nextValidInt(Scanner sc, String invalidInputMessage, Predicate<Integer> condition) {
        while (true) {
            if (sc.hasNextInt()) {
                var n = sc.nextInt();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(invalidInputMessage);
        }
    }

    /**
     The next valid {@code double} from {@code sc} that satisfies the given {@code predicate}. Between invalid inputs,
     {@code invalidInputMessage} is printed.

     @param sc                  the scanner from which to request the input.
     @param invalidInputMessage the message to print between invalid input attempts.
     @param condition           the condition that constitutes a valid {@code double} input.

     @return the next valid {@code double} input from {@code sc}.
     */
    public static double nextValidDouble(Scanner sc, String invalidInputMessage, Predicate<Double> condition) {
        while (true) {
            if (sc.hasNextDouble()) {
                var n = sc.nextDouble();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(invalidInputMessage);

        }
    }

    /**
     The next valid {@code float} from {@code sc} that satisfies the given {@code predicate}. Between invalid inputs,
     {@code invalidInputMessage} is printed.

     @param sc                  the scanner from which to request the input.
     @param invalidInputMessage the message to print between invalid input attempts.
     @param condition           the condition that constitutes a valid {@code float} input.

     @return the next valid {@code float} input from {@code sc}.
     */
    public static float nextValidFloat(Scanner sc, String invalidInputMessage, Predicate<Float> condition) {
        while (true) {
            if (sc.hasNextFloat()) {
                var n = sc.nextFloat();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(invalidInputMessage);

        }
    }

    /**
     The next valid {@code long} from {@code sc} that satisfies the given {@code predicate}. Between invalid inputs,
     {@code invalidInputMessage} is printed.

     @param sc                  the scanner from which to request the input.
     @param invalidInputMessage the message to print between invalid input attempts.
     @param condition           the condition that constitutes a valid {@code long} input.

     @return the next valid {@code long} input from {@code sc}.
     */
    public static long nextValidLong(Scanner sc, String invalidInputMessage, Predicate<Long> condition) {
        while (true) {
            if (sc.hasNextLong()) {
                var n = sc.nextLong();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(invalidInputMessage);

        }
    }

    /**
     The next valid {@code short} from {@code sc} that satisfies the given {@code predicate}. Between invalid inputs,
     {@code invalidInputMessage} is printed.

     @param sc                  the scanner from which to request the input.
     @param invalidInputMessage the message to print between invalid input attempts.
     @param condition           the condition that constitutes a valid {@code short} input.

     @return the next valid {@code short} input from {@code sc}.
     */
    public static short nextValidShort(Scanner sc, String invalidInputMessage, Predicate<Short> condition) {
        while (true) {
            if (sc.hasNextShort()) {
                var n = sc.nextShort();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(invalidInputMessage);

        }
    }

    /**
     The next valid {@code byte} from {@code sc} that satisfies the given {@code predicate}. Between invalid inputs,
     {@code invalidInputMessage} is printed.

     @param sc                  the scanner from which to request the input.
     @param invalidInputMessage the message to print between invalid input attempts.
     @param condition           the condition that constitutes a valid {@code byte} input.

     @return the next valid {@code byte} input from {@code sc}.
     */
    public static byte nextValidByte(Scanner sc, String invalidInputMessage, Predicate<Byte> condition) {
        while (true) {
            if (sc.hasNextByte()) {
                var n = sc.nextByte();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(invalidInputMessage);

        }
    }

    /**
     The next valid {@code boolean} from {@code sc} that satisfies the given {@code predicate}. Between invalid inputs,
     {@code invalidInputMessage} is printed.

     @param sc                  the scanner from which to request the input.
     @param invalidInputMessage the message to print between invalid input attempts.
     @param condition           the condition that constitutes a valid {@code boolean} input.

     @return the next valid {@code boolean} input from {@code sc}.
     */
    public static boolean nextValidBoolean(Scanner sc, String invalidInputMessage, Predicate<Boolean> condition) {
        while (true) {
            if (sc.hasNextBoolean()) {
                var n = sc.nextBoolean();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(invalidInputMessage);

        }
    }

    /**
     The next valid line from {@code sc} that satisfies the given {@code predicate}. Between invalid inputs, {@code
    invalidInputMessage} is printed.

     @param sc                  the scanner from which to request the input.
     @param invalidInputMessage the message to print between invalid input attempts.
     @param condition           the condition that constitutes a valid {@code String} input.

     @return a {@code String} of the next valid line from {@code sc}.
     */
    public static String nextValidLine(Scanner sc, String invalidInputMessage, Predicate<String> condition) {
        while (true) {
            if (sc.hasNextLine()) {
                var n = sc.nextLine();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(invalidInputMessage);

        }
    }

    /**
     The next valid {@code String} from {@code sc} that satisfies the given {@code predicate}. Between invalid inputs,
     {@code invalidInputMessage} is printed.

     @param sc                  the scanner from which to request the input.
     @param invalidInputMessage the message to print between invalid input attempts.
     @param condition           the condition that constitutes a valid {@code String} input.

     @return the next valid {@code String} input from {@code sc}.
     */
    public static String nextValid(Scanner sc, String invalidInputMessage, Predicate<String> condition) {
        while (true) {
            if (sc.hasNext()) {
                var n = sc.next();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(invalidInputMessage);

        }
    }

    /**
     The next valid input from {@code sc} that matches the given {@code predicate} and does not throw in its {@code
    isValid} generator function. Between invalid inputs, {@code invalidInputMessage} is printed.

     @param <T>                 the desired type produced in {@code isValid} from the {@code String} input.
     @param sc                  the scanner from which to request the input.
     @param predicate           the predicate that must be satisfied by the output of {@code isValid} to constitute a
     valid input.
     @param isValid             the function that converts the {@code String} input from scanner to the desired type. If
     an exceptionis thrown the input is classified as invalid and is requested again from
     {@code sc}.
     @param invalidInputMessage the message to print between invalid input attempts.

     @return the next valid value of type {@code T} that does not throw and satisfies the given {@code predicate} when
     produced froma {@code String} input from {@code sc} in {@code isValid}.
     */
    public static <T> T validInput(Scanner sc, Predicate<T> predicate, Function<String, T> isValid, String invalidInputMessage) {
        Function<String, Optional<T>> isValidThrowing = str -> {
            try {
                var input = isValid.apply(str);
                return Optional.of(input);
            } catch (Exception e) {
                return Optional.empty();
            }
        };
        while (true) {
            Optional<T> optionalInput;
            if (sc.hasNext("(.*)") && (optionalInput = isValidThrowing.apply(sc.match().group())).isPresent() && predicate.test(optionalInput.get())) {
                sc.next();
                return optionalInput.get();
            }
            System.out.println(invalidInputMessage);
            sc.next();
        }
    }

    /**
     The next valid input from {@code sc} that does not throw in its {@code isValid} generator function. Between invalid
     inputs, {@code invalidInputMessage} is printed.

     @param <T>                 the desired type produced in {@code isValid} from the {@code String} input.
     @param sc                  the scanner from which to request the input.
     @param isValid             the function that converts the {@code String} input from scanner to the desired type. If
     an exceptionis thrown the input is classified as invalid and is requested again from
     {@code sc}.
     @param invalidInputMessage the message to print between invalid input attempts.

     @return the next valid value of type {@code T} that does not throw when produced from a {@code String} input from
     {@code sc} in {@code isValid}.
     */
    public static <T> T validInput(Scanner sc, Function<String, T> isValid, String invalidInputMessage) {
        return validInput(sc, x -> true, isValid, invalidInputMessage);
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param <Element> the element type of the {@code arr}.
     @param arr       the array being joined to a string.
     @param separator the {@code String} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static <Element> String joined(Element[] arr, String separator) {
        if (arr.length == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : arr) {
            stringBuilder.append(element);
            if (i < arr.length - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param <Element> the element type of the {@code arr}.
     @param arr       the array being joined to a string.
     @param separator the {@code char} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static <Element> String joined(Element[] arr, char separator) {
        return joined(arr, "" + separator);
    }

    /**
     A {@code String} of {@code list}'s elements joined separated by the given {@code separator}.

     @param <Element> the element type of the {@code list}.
     @param list      the list being joined to a string.
     @param separator the {@code String} separator inserted between each element of {@code list} when being joined.

     @return a {@code String} of the joined elements of {@code list} separated by the {@code separator}.
     */
    public final static <Element> String joined(List<Element> list, String separator) {
        if (list.size() == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : list) {
            stringBuilder.append(element);
            if (i < list.size() - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /**
     A {@code String} of {@code list}'s elements joined separated by the given {@code separator}.

     @param <Element> the element type of the {@code list}.
     @param list      the list being joined to a string.
     @param separator the {@code char} separator inserted between each element of {@code list} when being joined.

     @return a {@code String} of the joined elements of {@code list} separated by the {@code separator}.
     */
    public final static <Element> String joined(List<Element> list, char separator) {
        return joined(list, "" + separator);
    }

    /**
     A {@code String} of {@code seq}'s elements joined separated by the given {@code separator}.

     @param <Element> the element type of the {@code seq}.
     @param seq       the iterable sequence being joined to a string.
     @param separator the {@code String} separator inserted between each element of {@code seq} when being joined.

     @return a {@code String} of the joined elements of {@code seq} separated by the {@code separator}.
     */
    public final static <Element> String joined(Iterable<Element> seq, String separator) {
        if (!seq.iterator().hasNext()) return "";
        var stringBuilder = new StringBuilder();
        var seqator = seq.iterator();
        while (seqator.hasNext()) {
            stringBuilder.append(seqator.next());
            if (seqator.hasNext()) {
                stringBuilder.append(separator);
            }
        }
        return stringBuilder.toString();
    }

    /**
     A {@code String} of {@code seq}'s elements joined separated by the given {@code separator}.

     @param <Element> the element type of the {@code seq}.
     @param seq       the iterable sequence being joined to a string.
     @param separator the {@code char} separator inserted between each element of {@code seq} when being joined.

     @return a {@code String} of the joined elements of {@code seq} separated by the {@code separator}.
     */
    public final static <Element> String joined(Iterable<Element> seq, char separator) {
        return joined(seq, "" + separator);
    }

    /**
     A {@code String} of {@code col}'s elements joined separated by the given {@code separator}.

     @param <Element> the element type of the {@code col}.
     @param col       the collection being joined to a string.
     @param separator the {@code String} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code col} separated by the {@code separator}.
     */
    public final static <Element> String joined(Collection<Element> col, String separator) {
        if (col.size() == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : col) {
            stringBuilder.append(element);
            if (i < col.size() - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /**
     A {@code String} of {@code col}'s elements joined separated by the given {@code separator}.

     @param <Element> the element type of the {@code col}.
     @param col       the collection being joined to a string.
     @param separator the {@code char} separator inserted between each element of {@code col} when being joined.

     @return a {@code String} of the joined elements of {@code col} separated by the {@code separator}.
     */
    public final static <Element> String joined(Collection<Element> col, char separator) {
        return joined(col, "" + separator);
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code String} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(int[] arr, String separator) {
        if (arr.length == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : arr) {
            stringBuilder.append(element);
            if (i < arr.length - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code char} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(int[] arr, char separator) {
        return joined(arr, "" + separator);
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code String} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(long[] arr, String separator) {
        if (arr.length == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : arr) {
            stringBuilder.append(element);
            if (i < arr.length - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code char} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(long[] arr, char separator) {
        return joined(arr, "" + separator);
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code String} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(double[] arr, String separator) {
        if (arr.length == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : arr) {
            stringBuilder.append(element);
            if (i < arr.length - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code char} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(double[] arr, char separator) {
        return joined(arr, "" + separator);
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code String} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(short[] arr, String separator) {
        if (arr.length == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : arr) {
            stringBuilder.append(element);
            if (i < arr.length - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code char} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(short[] arr, char separator) {
        return joined(arr, "" + separator);
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code String} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(float[] arr, String separator) {
        if (arr.length == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : arr) {
            stringBuilder.append(element);
            if (i < arr.length - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code char} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(float[] arr, char separator) {
        return joined(arr, "" + separator);
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code String} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(byte[] arr, String separator) {
        if (arr.length == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : arr) {
            stringBuilder.append(element);
            if (i < arr.length - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code char} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(byte[] arr, char separator) {
        return joined(arr, "" + separator);
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code String} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(char[] arr, String separator) {
        if (arr.length == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : arr) {
            stringBuilder.append(element);
            if (i < arr.length - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code char} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(char[] arr, char separator) {
        return joined(arr, "" + separator);
    }

    /**
     A {@code String} of {@code arr}'s elements joined separated by the given {@code separator}.

     @param arr       the array being joined to a string.
     @param separator the {@code String} separator inserted between each element of {@code arr} when being joined.

     @return a {@code String} of the joined elements of {@code arr} separated by the {@code separator}.
     */
    public final static String joined(boolean[] arr, String separator) {
        if (arr.length == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : arr) {
            stringBuilder.append(element);
            if (i < arr.length - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    // Contains

    /**
     Returns a boolean value indicating whether an {@code element} is contained within an array.

     @param <Element> the element type of {@code arr}.
     @param element   the element being searched for in {@code arr}.
     @param arr       the array being searched for {@code element}.

     @return {@code true} if {@code element} is contained within {@code arr}, otherwise returns {@code false}.
     */
    public final static <Element> boolean contains(Element element, Element[] arr) {
        return Arrays.asList(arr).contains(element);
    }

    /**
     Returns a boolean value indicating whether an {@code element} is contained within a list.

     @param <Element> the element type of {@code list}.
     @param element   the element being searched for in {@code list}.
     @param list      the list being searched for {@code element}.

     @return {@code true} if {@code element} is contained within {@code list}, otherwise returns {@code false}.
     */
    public final static <Element> boolean contains(Element element, List<Element> list) {
        return list.stream().anyMatch(e -> e.equals(element));
    }

    /**
     Returns a boolean value indicating whether an {@code element} is contained within an iterable sequence.

     @param <Element> the element type of {@code seq}.
     @param element   the element being searched for in {@code seq}.
     @param seq       the iterable sequence being searched for {@code element}.

     @return {@code true} if {@code element} is contained within {@code seq}, otherwise returns {@code false}.
     */
    public final static <Element> boolean contains(Element element, Iterable<Element> seq) {
        for (var e : seq) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     Returns a boolean value indicating whether an {@code element} is contained within a collection.

     @param <Element> the element type of {@code col}.
     @param element   the element being searched for in {@code col}.
     @param col       the collection being search for {@code element}.

     @return {@code true} if {@code element} is contained within {@code col}, otherwise returns {@code false}.
     */
    public final static <Element> boolean contains(Element element, Collection<Element> col) {
        return col.stream().anyMatch(e -> e.equals(element));
    }

    /**
     Returns a boolean value indicating whether an integer is contained within an array of integers.

     @param element the {@code int} being searched for in {@code arr}.
     @param arr     the array of integers being search for {@code element}.

     @return {@code true} if {@code element} is contained within {@code arr}, otherwise returns {@code false}.
     */
    public final static boolean contains(int element, int[] arr) {
        return Arrays.stream(arr).anyMatch(e -> e == element);
    }

    /**
     Returns a boolean value indicating whether a {@code long} value is contained within an array of {@code long}
     values.

     @param element the {@code long} being searched for in {@code arr}.
     @param arr     the array of {@code long} values being search for {@code element}.

     @return {@code true} if {@code element} is contained within {@code arr}, otherwise returns {@code false}.
     */
    public final static boolean contains(long element, long[] arr) {
        return Arrays.stream(arr).anyMatch(e -> e == element);
    }

    /**
     Returns a boolean value indicating whether a {@code double} value is contained within an array of doubles.

     @param element the {@code double} being searched for in {@code arr}.
     @param arr     the array of doubles being search for {@code element}.

     @return {@code true} if {@code element} is contained within {@code arr}, otherwise returns {@code false}.
     */
    public final static boolean contains(double element, double[] arr) {
        return Arrays.stream(arr).anyMatch(e -> e == element);
    }

    /**
     Returns a boolean value indicating whether a {@code short} value is contained within an array of {@code short}
     values.

     @param element the {@code short} being searched for in {@code arr}.
     @param arr     the array of {@code short} values being search for {@code element}.

     @return {@code true} if {@code element} is contained within {@code arr}, otherwise returns {@code false}.
     */
    public final static boolean contains(short element, short[] arr) {
        for (var e : arr) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }

    /**
     Returns a boolean value indicating whether a {@code float} value is contained within an array of {@code float}
     values.

     @param element the {@code float} being searched for in {@code arr}.
     @param arr     the array of {@code float} values being search for {@code element}.

     @return {@code true} if {@code element} is contained within {@code arr}, otherwise returns {@code false}.
     */
    public final static boolean contains(float element, float[] arr) {
        for (var e : arr) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }

    /**
     Returns a boolean value indicating whether a {@code byte} value is contained within an array of {@code byte}
     values.

     @param element the {@code byte} being searched for in {@code arr}.
     @param arr     the array of {@code byte} values being search for {@code element}.

     @return {@code true} if {@code element} is contained within {@code arr}, otherwise returns {@code false}.
     */
    public final static boolean contains(byte element, byte[] arr) {
        for (var e : arr) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }

    /**
     Returns a boolean value indicating whether a {@code char} value is contained within an array of {@code char}
     values.

     @param element the {@code char} being searched for in {@code arr}.
     @param arr     the array of {@code char} values being search for {@code element}.

     @return {@code true} if {@code element} is contained within {@code arr}, otherwise returns {@code false}.
     */
    public final static boolean contains(char element, char[] arr) {
        for (var e : arr) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }

    /**
     Returns a boolean value indicating whether a {@code boolean} value is contained within an array of {@code boolean}
     values.

     @param element the {@code boolean} being searched for in {@code arr}.
     @param arr     the array of {@code boolean} values being search for {@code element}.

     @return {@code true} if {@code element} is contained within {@code arr}, otherwise returns {@code false}.
     */
    public final static boolean contains(boolean element, boolean[] arr) {
        for (var e : arr) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }


    /**
     Returns a string with the combining low line character (U+0332) inserted under each character of {@code str}.

     @param str the {@code String} to return underlined.

     @return a {@code String} of {@code str} underlined.
     */
    public static String underlined(String str) {
        var length = graphemeClustersCount(str);
        var underlinedStringBuilder = new StringBuilder(length * 2);
        for (char c: str.toCharArray()) {
            underlinedStringBuilder.append(c);
            underlinedStringBuilder.append('̲');
        }
        return underlinedStringBuilder.toString();

    }

    /**
     The number of grapheme clusters in a given a string.

     @param of the string to count the grapheme clusters of.

     @return the number of grapheme clusters in the string.
     */
    public static int graphemeClustersCount(String of) {
        var it = BreakIterator.getCharacterInstance();
        it.setText(of);
        var emojiCount = 0;
        while (it.next() != BreakIterator.DONE) {
            emojiCount++;
        }
        return emojiCount;
    }

    /**
     Pads the string to the specified amount on the left.

     @param str      the string to pad.
     @param toLength the to length to pad {@code str} to.

     @return a {@code String} of {@code str} padded to the desired length on the left.
     */
    public static String padLeft    (String str, int toLength) {
        if (graphemeClustersCount(str) >= toLength) {
            return str;
        }

        var paddingLength = toLength - graphemeClustersCount(str);
        return " ".repeat(paddingLength) + str;
    }

    /**
     Pads the string to the specified amount on the right.

     @param str      the string to pad.
     @param toLength the to length to pad {@code str} to.

     @return a {@code String} of {@code str} padded to the desired length on the right.
     */
    public static String padRight   (String str, int toLength) {
        if (graphemeClustersCount(str) >= toLength) {
            return str;
        }

        var paddingLength = toLength - graphemeClustersCount(str);
        return str + " ".repeat(paddingLength);
    }

    /**
     Pads the string to the specified amount. Padding is distributed evenly on both sides of the string.

     @param str      the string to pad.
     @param toLength the to length to pad {@code str} to.

     @return a {@code String} of {@code str} padded to the desired length, with the extra padding on either side of
     {@code str}.
     */
    public static String padCentered(String str, int toLength) {
        if (graphemeClustersCount(str) >= toLength) {
            return str;
        }

        var paddingLength = toLength - graphemeClustersCount(str);
        var halfPadding = " ".repeat(paddingLength / 2);

        var paddedString = halfPadding + str + halfPadding;
        if (paddingLength % 2 != 0) {
            paddedString += " ";
        }

        return paddedString;
    }


}
