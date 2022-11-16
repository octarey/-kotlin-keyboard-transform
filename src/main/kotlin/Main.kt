var menu = ""
var inputString = ""

inline fun<reified T> merge(vararg  arrays: Array<T>): Array<T>{
    val list: MutableList<T> = ArrayList()
    for (array in arrays){
        list.addAll(array.map { i -> i })
    }

    return list.toTypedArray()
}
var baris1 = arrayOf("1","2","3","4","5","6","7","8","9","0")
var baris2 = arrayOf("q","w","e","r","t","y","u","i","o","p")
var baris3 = arrayOf("a","s","d","f","g","h","j","k","l",";")
var baris4 = arrayOf("z","x","c","v","b","n","m",",",".","/")
val all = merge(baris1,baris2,baris3,baris4)
var transformString = mutableListOf<String>()
var step = ""


fun main() {
    print("Masukan string : ")
    inputString = readln().toLowerCase()

    menu()
}

private fun horizontalFlip(input :Array<String>){
    println("String input : $inputString")
    transformString.clear()
    for (element in input){
        if(baris1.indexOf(element) != -1) {
            val index = baris1.indexOf(element)
            transformString.add(baris1[baris1.size-1-index])
        } else if (baris2.indexOf(element) != -1){
            val index = baris2.indexOf(element)
            transformString.add(baris2[baris2.size-1-index])
        } else if (baris3.indexOf(element) != -1) {
            val index = baris3.indexOf(element)
            transformString.add(baris3[baris3.size - 1 - index])
        }else {
            val index = baris4.indexOf(element)
            transformString.add(baris4[baris4.size - 1 - index])
        }
    }
    print("String After Horizontal flip :")
    for (i in transformString.indices){
        print(transformString[i])
    }
    println("\n---------------------")
    inputString = transformString.joinToString("")
    menu()
}

private fun verticalFlip(input :Array<String>){
  //  println(arrayString.contentToString())
    println("String input : $inputString")
    transformString.clear()
    for (element in input){
        if(baris1.indexOf(element) != -1) {
            val index = baris1.indexOf(element)
            transformString.add(baris4[index])
        } else if (baris2.indexOf(element) != -1){
            val index = baris2.indexOf(element)
            transformString.add(baris3[index])
        } else if (baris3.indexOf(element) != -1) {
            val index = baris3.indexOf(element)
            transformString.add(baris2[index])
        }else {
            val index = baris4.indexOf(element)
            transformString.add(baris1[index])
        }
    }

    print("Vertical flip :")
    for (i in transformString.indices){
        print(transformString[i])
    }
    println("\n---------------------")
    inputString = transformString.joinToString("")
    menu()
}

private fun shift(step:Int, input: Array<String>){
   // println(arrayString.contentToString())
    println("String input : $inputString")
    transformString.clear()
    if (step > 0){
        for (element in input){
            val index = all.indexOf(element) + step
            //     print("index $index lalu ${index+step} max ${all.size}")
            if (index > all.size-1){
                transformString.add(all[index - all.size])
            }else{
                transformString.add(all[index])
            }
        }
    }else{
        for (element in input){
            val index = all.indexOf(element) + step
           // print("index $index lalu ${index+step} max ${all.size}")
            if (index < 0){
                transformString.add(all[all.size + index])
            }else{
                transformString.add(all[index])
            }
        }
    }

    print("String After Shift ($step) :")
    for (i in transformString.indices){
        print(transformString[i])
    }
    println("\n---------------------")
    inputString = transformString.joinToString("")
    menu()
}

private fun menu (){
    var arrayString = Array(inputString.length) { inputString[it].toString() }
    print("""
        H        -> Horizontal Flip
        V        -> Vertical Flip
        Else     -> Shift By (Number)
        
        Pilih Menu : """.trimIndent())
    menu = readln().toUpperCase()
    when (menu){
        "H" -> horizontalFlip(arrayString)
        "V" -> verticalFlip(arrayString)
        else -> {
            print("input number for shift: ")
            step = readln()
            shift(step.toInt(), arrayString)
        }
    }
}
