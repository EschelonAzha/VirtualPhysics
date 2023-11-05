package symmetrical.cosmic.__transpectors.transpectors

import symmetrical.cosmic.__transpectors.printable_characters.Base52

object Photons {
    fun chopClassId(emission:String) : String {
        return Strings.chop(2, emission)
    }

    fun parse(lthLength:Int, emission:String) : Pair<String, String> {
        val (base52Lth,line) = Strings.remainder(lthLength, emission)
        val lth = Base52.toInt(base52Lth)
        val (value, remainder) = Strings.remainder(lth, line)
        return Pair<String, String>(value, remainder)
    }
}