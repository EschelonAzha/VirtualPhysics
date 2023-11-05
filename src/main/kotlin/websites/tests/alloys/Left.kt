package websites.tests.alloys

import symmetrical.cosmic._physics.atomic.substance.Substance


interface Left : Substance {
    fun getValue()                      : String
    fun getLeftValue()                  : String
    fun setLeftValue(value:String)      : Left
    fun start()                         : Unit
}