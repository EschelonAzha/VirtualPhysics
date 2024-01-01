package applications.tests.alloys

import symmetrical.cosmic._physics.atomic.substance.Substance

interface Right : Substance {
    fun getContent()                      : String;
    fun getRightContent()                 : String
    fun setRightContent(content:String)   : Right;
}