# Sorting Algorithm in Kotlin
Kotlin uses the same algorithm as Java, that is "Dual-Pivot Quicksort" and "TimSort"

Depending on how you create the array the sort algorithm will be different

###TimSort

Tim sort is a hybrid stable sorting algorithm, derived from merge sort and intserion sort, designed to perform well on many kinds of real-world data.

Best Case Perf. | Worst Case Perf. | Average Perf. | Space Complexity
--- | --- | --- | ---
O(n) | O(n log n) | O(n log n) | O(n)

https://en.wikipedia.org/wiki/Timsort

```
val array = arrayOf(3,2,1)
array.sort()
```

Kotlin/JVM
```
public fun <T> Array<out T>.sort(): Unit {
    if (size > 1) java.util.Arrays.sort(this)
}
```

###Dual Pivot Quick Sort

Tim sort is a hybrid stable sorting algorithm, derived from merge sort and intserion sort, designed to perform well on many kinds of real-world data.

Best Case Perf. | Worst Case Perf. | Average Perf. | Space Complexity
--- | --- | --- | ---
O(n log n) | O(n^2) | O(n log n) | O(log n)

https://www.geeksforgeeks.org/dual-pivot-quicksort/

```
val array = intArrayOf(3,2,1)
array.sort()
```

Kotlin/JVM
```
public actual fun IntArray.sort(): Unit {
     if (size > 1) java.util.Arrays.sort(this)
}
```