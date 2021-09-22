package YouPart

import java.util.*

fun main(){
          val sc =  Scanner(System.`in`)
    var n= sc.next();
    for (i in 1..9){
        for (j in i..9){
            for(k in j..8){
                println("$i.$j.$k")
            }
        }
    }

}