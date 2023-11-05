package websites.tests.alloys

import symmetrical.cosmic._physics.atomic.substance.Substance

interface Right : Substance {
    fun getValue()                      : String;
    fun getRightValue()                 : String
    fun setRightValue(value:String)     : Right;
}