package YouPart

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    //val array  = arrayOf()
    val n = sc.nextInt();
    val arr = IntArray(n);
    for (i in 0 until n){
        arr[i] = sc.nextInt();

    }
    for (i in n downTo 1){
       print("$i ")

    }
}
