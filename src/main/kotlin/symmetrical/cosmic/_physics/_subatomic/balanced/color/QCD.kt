package symmetrical.cosmic._physics._subatomic.balanced.color

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class QCD (
    private val luminescent: ILuminescent = Luminescent(QCD::class),
) :
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(QCD::class),
    )
    /*
        ARRAY      A-???
        BOOLEAN    T-0/1
        BYTE       B-byte
        DOUBLE     D-nn-Value
        INT        I-nn-Value
        STRING     S-nnnnnnnn-value
     */



    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i() : QCD {
        return this
    }
    fun blue(value:Any?) : Any {
        if (value == null) {
            return "N"
        }
        if (value is Boolean) {
            var asString    = 0
            if (value)
                asString    = 1
            return "T-$asString"
        }
        if (value is Byte) {
            val asString    = value.toString()
            val count       = asString.length.toString()
            return "B-$asString"
        }
        if (value is Double) {
            val asString    = value.toString()
            val fixedLength = digits(2, asString)
            return "D-$fixedLength-$asString"
        }
        if (value is Int) {
            val asString    = value.toString()
            val fixedLength = digits(2, asString)
            return "I-$fixedLength-$asString"
        }
        if (value is String) {
            val asString    = value
            val fixedLength = digits(8, asString)
            return "S-$fixedLength-$asString"
        }

        println("QCD::blue(value)  Type cannot be translated")
    //    return Exit.exit(-1);
        return ""
    }

    fun green(value:Any?) : Any {
        if (value == null) {
            return "null"
        }
        if (value is Boolean) {
            return value.toString()
        }
        if (value is Byte) {
            return value.toString()
        }
        if (value is Double) {
            return value.toString()
        }
        if (value is Int) {
            return value.toString()
        }
        if (value is String) {
            return value
        }

        println("QCD::green(value)  Type cannot be translated")
    //    return Exit.exit(-1)
        return ""
    }


    private fun digits(digits:Int, value:String) : String {
        var length = value.length.toString().length
        var result = fixedString(digits-length, "0")
        return result+value.length
    }
    private fun fixedString(length:Int, init:String) : String {
        var i       =   0
        var result  =   ""
        while (i<length) {
            result += init
            i++
        }
        return result
    }
}