package FST;

//
// Utils.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 08/04/19 11:38 AM.

import java.util.*;
import java.util.function.Predicate;


public class Utils {

    // Scanner methods
    public static int nextValidInt(Scanner sc, String message, Predicate<Integer> condition) {
        while (true) {
            if (sc.hasNextInt()) {
                var n = sc.nextInt();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(message);
        }
    }
    public static double nextValidDouble(Scanner sc, String message, Predicate<Double> condition) {
        while (true) {
            if (sc.hasNextDouble()) {
                var n = sc.nextDouble();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(message);

        }
    }
    public static float nextValidFloat(Scanner sc, String message, Predicate<Float> condition) {
        while (true) {
            if (sc.hasNextFloat()) {
                var n = sc.nextFloat();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(message);

        }
    }
    public static long nextValidLong(Scanner sc, String message, Predicate<Long> condition) {
        while (true) {
            if (sc.hasNextLong()) {
                var n = sc.nextLong();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(message);

        }
    }
    public static short nextValidShort(Scanner sc, String message, Predicate<Short> condition) {
        while (true) {
            if (sc.hasNextShort()) {
                var n = sc.nextShort();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(message);

        }
    }
    public static byte nextValidByte(Scanner sc, String message, Predicate<Byte> condition) {
        while (true) {
            if (sc.hasNextByte()) {
                var n = sc.nextByte();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(message);

        }
    }
    public static boolean nextValidBoolean(Scanner sc, String message, Predicate<Boolean> condition) {
        while (true) {
            if (sc.hasNextBoolean()) {
                var n = sc.nextBoolean();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(message);

        }
    }
    public static String nextValidLine(Scanner sc, String message, Predicate<String> condition) {
        while (true) {
            if (sc.hasNextLine()) {
                var n = sc.nextLine();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(message);

        }
    }
    public static String nextValid(Scanner sc, String message, Predicate<String> condition) {
        while (true) {
            if (sc.hasNext()) {
                var n = sc.next();
                if (condition.test(n)) {
                    return n;
                }
            } else {
                sc.next();
            }
            System.out.println(message);

        }
    }

    public static Optional<Integer> peekNextInt(Scanner sc) {
        return sc.hasNextInt() ? Optional.of(Integer.parseInt(sc.match().group())) : Optional.empty();
    }
    public static Optional<Double> peekNextDouble(Scanner sc) {
        return sc.hasNextDouble() ? Optional.of(Double.parseDouble(sc.match().group())) : Optional.empty();
    }
    public static Optional<Float> peekNextFloat(Scanner sc) {
        return sc.hasNextFloat() ? Optional.of(Float.parseFloat(sc.match().group())) : Optional.empty();
    }
    public static Optional<Long> peekNextLong(Scanner sc) {
        return sc.hasNextLong() ? Optional.of(Long.parseLong(sc.match().group())) : Optional.empty();
    }
    public static Optional<Short> peekNextShort(Scanner sc) {
        return sc.hasNextShort() ? Optional.of(Short.parseShort(sc.match().group())) : Optional.empty();
    }
    public static Optional<Byte> peekNextByte(Scanner sc) {
        return sc.hasNextByte() ? Optional.of(Byte.parseByte(sc.match().group())) : Optional.empty();
    }
    public static Optional<Boolean> peekNextBoolean(Scanner sc) {
        return sc.hasNextBoolean() ? Optional.of(Boolean.parseBoolean(sc.match().group())) : Optional.empty();
    }
    public static Optional<String> peekNextLine(Scanner sc) {
        return sc.hasNextLine() ? Optional.of(sc.match().group()) : Optional.empty();
    }
    public static Optional<String> peekNext(Scanner sc) {
        return sc.hasNext() ? Optional.of(sc.match().group()) : Optional.empty();
    }

    // Joining Methods
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
    public final static <Element> String joined(Element[] arr, char separator) {
        return joined(arr, "" + separator);
    }
    public final static <Element> String joined(List<Element> arr, String separator) {
        if (arr.size() == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : arr) {
            stringBuilder.append(element);
            if (i < arr.size() - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }
    public final static <Element> String joined(List<Element> arr, char separator) {
        return joined(arr, "" + separator);
    }
    public final static <Element> String joined(Iterable<Element> arr, String separator) {
        if (!arr.iterator().hasNext()) return "";
        var stringBuilder = new StringBuilder();
        var iterator = arr.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (iterator.hasNext()) {
                stringBuilder.append(separator);
            }
        }
        return stringBuilder.toString();
    }
    public final static <Element> String joined(Iterable<Element> arr, char separator) {
        return joined(arr, "" + separator);
    }
    public final static <Element> String joined(Collection<Element> arr, String separator) {
        if (arr.size() == 0) return "";
        var stringBuilder = new StringBuilder();
        var i = 0;
        for (var element : arr) {
            stringBuilder.append(element);
            if (i < arr.size() - 1) {
                stringBuilder.append(separator);
            }
            i++;
        }
        return stringBuilder.toString();
    }
    public final static <Element> String joined(Collection<Element> arr, char separator) {
        return joined(arr, "" + separator);
    }
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
    public final static String joined(int[] arr, char separator) {
        return joined(arr, "" + separator);
    }
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
    public final static String joined(long[] arr, char separator) {
        return joined(arr, "" + separator);
    }
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
    public final static String joined(double[] arr, char separator) {
        return joined(arr, "" + separator);
    }
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
    public final static String joined(short[] arr, char separator) {
        return joined(arr, "" + separator);
    }
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
    public final static String joined(float[] arr, char separator) {
        return joined(arr, "" + separator);
    }
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
    public final static String joined(byte[] arr, char separator) {
        return joined(arr, "" + separator);
    }
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
    public final static String joined(char[] arr, char separator) {
        return joined(arr, "" + separator);
    }
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

    // Choose
    public final static <T, U extends List<T>> HashSet<ArrayList<T>> choose(U list, int n) {
        var permutations = new HashSet<ArrayList<T>>();

        if (n >= list.size()) {
            permutations.add(new ArrayList<T>(list));
            return permutations;
        }
        if (n <= 0 && list.size() <= 0) {
            return permutations;
        }

        var previousElements = new HashSet<T>();

        for (var i = 0; i < list.size(); i++) {
            var element = list.get(i);
            if (previousElements.contains(element)) continue;
            var listCopy = new ArrayList<T>(list);
            previousElements.add(listCopy.remove(i));
            permutations.addAll(choose(listCopy, n));

        }
        return permutations;

    }
}

