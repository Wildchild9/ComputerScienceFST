package FST;

//
// Utils.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 08/04/19 11:38 AM.

import java.util.*;
import java.util.function.Function;
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

    public static <T> T validOptionalInput(Scanner sc, Predicate<T> predicate, Function<String, Optional<T>> isValid, String message) {

        while (true) {
            Optional<T> optionalInput;
            if (sc.hasNext("(.*)") && (optionalInput = isValid.apply(sc.match().group())).isPresent() && predicate.test(optionalInput.get())) {
                sc.next();
                return optionalInput.get();
            }
            System.out.println(message);
            sc.next();
        }

    }
    public static <T> T validOptionalInput(Scanner sc, Function<String, Optional<T>> isValid, String message) {
        return validOptionalInput(sc, x -> true, isValid, message);
    }

    public static <T> T validInput(Scanner sc, Predicate<T> predicate, Function<String, T> isValid, String message) {
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
            System.out.println(message);
            sc.next();
        }
    }
    public static <T> T validInput(Scanner sc, Function<String, T> isValid, String message) {
        return validInput(sc, x -> true, isValid, message);
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

    // Contains

    public final static <Element> boolean contains(Element element, Element[] arr) {
        return Arrays.asList(arr).contains(element);
    }
    public final static <Element> boolean contains(Element element, List<Element> arr) {
        return arr.stream().anyMatch(e -> e.equals(element));
    }
    public final static <Element> boolean contains(Element element, Iterable<Element> arr) {
        for (var e : arr) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }
    public final static <Element> boolean contains(Element element, Collection<Element> arr) {
        return arr.stream().anyMatch(e -> e.equals(element));
    }
    public final static boolean contains(int element, int[] arr) {
        return Arrays.stream(arr).anyMatch(e -> e == element);
    }
    public final static boolean contains(long element, long[] arr) {
        return Arrays.stream(arr).anyMatch(e -> e == element);
    }
    public final static boolean contains(double element, double[] arr) {
        return Arrays.stream(arr).anyMatch(e -> e == element);
    }
    public final static boolean contains(short element, short[] arr) {
        for (var e : arr) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }
    public final static boolean contains(float element, float[] arr) {
        for (var e : arr) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }
    public final static boolean contains(byte element, byte[] arr) {
        for (var e : arr) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }
    public final static boolean contains(char element, char[] arr) {
        for (var e : arr) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }
    public final static boolean contains(boolean element, boolean[] arr) {
        for (var e : arr) {
            if (e == element) {
                return true;
            }
        }
        return false;
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

    // Underlined
    public static String underlined(String str) {
        var length = graphemeClustersLength(str);
        var underlinedStringBuilder = new StringBuilder(length * 2);
        for (char c: str.toCharArray()) {
            underlinedStringBuilder.append(c);
            underlinedStringBuilder.append('̲');
        }
        return underlinedStringBuilder.toString();

    }

    // Length of grapheme clusters in string
    public static int graphemeClustersLength(String of) {
        var it = java.text.BreakIterator.getCharacterInstance();
        it.setText(of);
        var emojiCount = 0;
        while (it.next() != java.text.BreakIterator.DONE) {
            emojiCount++;
        }
        return emojiCount;
    }

    // Pads a string to the specified length
    public static String padLeft    (String str, int toLength) {
        if (graphemeClustersLength(str) >= toLength) {
            return str;
        }

        var paddingLength = toLength - graphemeClustersLength(str);
        return " ".repeat(paddingLength) + str;
    }
    public static String padRight   (String str, int toLength) {
        if (graphemeClustersLength(str) >= toLength) {
            return str;
        }

        var paddingLength = toLength - graphemeClustersLength(str);
        return str + " ".repeat(paddingLength);
    }
    public static String padCentered(String str, int toLength) {
        if (graphemeClustersLength(str) >= toLength) {
            return str;
        }

        var paddingLength = toLength - graphemeClustersLength(str);
        var halfPadding = " ".repeat(paddingLength / 2);

        var paddedString = halfPadding + str + halfPadding;
        if (paddingLength % 2 != 0) {
            paddedString += " ";
        }

        return paddedString;
    }


}
