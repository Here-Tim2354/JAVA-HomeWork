package Experiment.Experiment5.task1.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtil {
    public static<T> T[] removeDuplicates(T[] array) {
        if(array==null||array.length==0){
            return array;
        }

        List<T> resultList=new ArrayList<>();

        for(T element:array){
            if(element!=null&&!resultList.contains(element)){
                resultList.add(element);
            };
        }

        return (T[]) resultList.toArray(Arrays.copyOf(array, resultList.size()));
    }

    public static <T extends Comparable<T>> T max(T[] array){
        T maxValue = null;
        if(array!=null&&array.length>0){
            maxValue = array[0];
            for(T element:array){
                if(element.compareTo(maxValue)>0){
                    maxValue = element;
                }
            }
        }
        return maxValue;
    }

    public static <T extends Comparable<T>> T min(T[] array){
        T minValue = null;
        if(array!=null&&array.length>0){
            minValue = array[0];
            for(T element:array){
                if(element.compareTo(minValue)<0){
                    minValue = element;
                }
            }
        }
        return minValue;
    }
}
