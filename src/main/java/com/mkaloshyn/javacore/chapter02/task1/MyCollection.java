package main.java.com.mkaloshyn.javacore.chapter02.task1;

import java.util.Arrays;

public class MyCollection {

    private Integer[] arr;

    public MyCollection(Integer[] arr) {
        this.arr = arr;
    }

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    //#1: adding element to the tail
    public void addElement(int element) {
        Integer[] newArr;
        Integer[] extendedArr;
        int numberToPutExtra = -1;

        if (arr.length < 10) {
            newArr = new Integer[10];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
        } else {
            newArr = arr;
        }

        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] == null) {
                numberToPutExtra = i;
                break;
            }
        }
        if (numberToPutExtra == -1) {
            extendedArr = new Integer[newArr.length * 3 / 2 + 1];
            System.arraycopy(newArr, 0, extendedArr, 0, newArr.length);
            extendedArr[newArr.length] = element;
        } else {
            extendedArr = newArr;
            extendedArr[numberToPutExtra] = element;
        }
        arr = extendedArr;
    }

    //#2: adding element to the tail and increasing the value of other elements by value of element added
    public void addElementIncremental(int element) {
        Integer[] newArr;
        Integer[] extendedArr;
        int numberToPutExtra = -1;

        if (arr.length < 10) {
            newArr = new Integer[10];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
        } else {
            newArr = arr;
        }

        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] == null) {
                numberToPutExtra = i;
                break;
            } else {
                newArr[i] += element;
            }
        }
        if (numberToPutExtra == -1) {
            extendedArr = new Integer[newArr.length * 3 / 2 + 1];
            System.arraycopy(newArr, 0, extendedArr, 0, newArr.length);
            extendedArr[newArr.length] = element;
        } else {
            extendedArr = newArr;
            extendedArr[numberToPutExtra] = element;
        }
        arr = extendedArr;
    }

    //#3: adding element to the determined position and increasing value of other elements by value of the element added
    public void addByIndexIncremental(int index, int element) {
        Integer[] newArr;
        Integer[] extendedArr;

        if (arr.length < 10) {
            newArr = new Integer[10];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
        } else {
            newArr = arr;
        }

        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] != null) {
                newArr[i] += element;
            }
        }

        if (newArr[newArr.length - 1] != null) {
            extendedArr = new Integer[newArr.length * 3 / 2 + 1];
            System.arraycopy(newArr, 0, extendedArr, 0, index);
            extendedArr[index] = element;
            System.arraycopy(newArr, index, extendedArr, index + 1, newArr.length - index);
        } else {
            extendedArr = newArr;
            System.arraycopy(extendedArr, index, extendedArr, index + 1, extendedArr.length - index - 1);
            extendedArr[index] = element;
        }
        arr = extendedArr;
    }

    //#4: deleting element by its index
    public void deleteByIndex(int index) {
        if (index >= arr.length) {
            System.out.println("Index is out of bound");
        } else {
            System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
            arr[arr.length - 1] = null;
        }
    }

    //#5: deleting element by its value (the first matching only)
    public void deleteByValue(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null && i != (arr.length - 1)) {
                continue;
            } else if ((i == arr.length - 1) && (arr[i] == null || arr[i] != value)) {
                System.out.println("There is no matching");
            } else if (arr[i] == value) {
                this.deleteByIndex(i);
                break;
            }
        }
    }


    //#6: deleting element by its index and decreasing value of other elements by value of the element deleted
    public void deleteByIndexDecremental(int index) {
        if (index >= arr.length) {
            System.out.println("Index is out of bound");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null && (i != index) && arr[index] != null) {
                    arr[i] = arr[i] - arr[index];
                }
            }
            System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
            arr[arr.length - 1] = null;
        }
    }

    //#7: deleting element by its value (first matching) and decreasing value of other elements by value of the element deleted
    public void deleteByValueDecremental(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i] == value) {
                deleteByIndexDecremental(i);
                break;
            } else if ((i == arr.length - 1) && (arr[i] == null || arr[i] != value)) {
                System.out.println("There is no matching");
            }
        }
    }

    //#8: finding element by its index
    public Integer findElementByIndex(int index) {
        if (index >= arr.length) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }


    //#9: finding index of element by its value (the first matching)
    public int findElementByValue(int value) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    //#10: finding min value among elements
    public Integer findMin() {
        Integer min = arr[0];
        for (Integer element : arr) {
            if (element != null && element < min) {
                min = element;
            }
        }
        return min;
    }

    //#11: finding max value among elements
    public Integer findMax() {
        Integer max = arr[0];
        for (Integer element : arr) {
            if (element != null && element > max) {
                max = element;
            }
        }
        return max;
    }

    //#12: finding average among not null elements
    public Double findAverage() {
        if (findMin() != null) {
            int counter = 0;
            int sum = 0;
            for (Integer element : arr) {
                if (element != null) {
                    counter++;
                    sum += element;
                }
            }
            return (double) sum / counter;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
