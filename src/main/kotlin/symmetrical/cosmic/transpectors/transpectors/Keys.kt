package symmetrical.cosmic.transpectors.transpectors

import symmetrical.cosmic.transpectors.printable_characters.Base52
import kotlinx.datetime.Clock

object Keys {
    private var currentInstance = 1
    fun getUniqueId() : String {
        val longNumber:String  = Clock.System.now().toEpochMilliseconds().toString()
        val frontHalf :String  = Base52.toBase52(longNumber.substring(0, 7).toInt())
        val backHalf  :String  = Base52.toBase52(longNumber.substring(7).toInt())
        val instance  :String  = Base52.toBase52(nextInstance())
        val result = frontHalf+backHalf+instance
        return result
    }
    private fun nextInstance() : Int {
        currentInstance++;
        return currentInstance
    }
}