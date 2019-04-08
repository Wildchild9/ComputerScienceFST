package FST;


//
// Utils.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 08/04/19 11:38 AM.

import java.util.Collection;
import java.util.List;


public class Utils {

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
}
