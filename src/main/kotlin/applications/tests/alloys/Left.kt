package applications.tests.alloys

import symmetrical.cosmic._physics.atomic.substance.Substance


interface Left : Substance {
    fun getContent()                    : String
    fun getLeftContent()                : String
    fun setLeftContent(content:String)  : Left
    fun start()                         : Unit
}