package symmetrical.cosmic._physics._dimensions

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Charge {

    var charge:Byte = Static.ZERO

    object Static {
        const val PLUS:Byte  = +1
        const val ZERO:Byte  = 0
        const val MINUS:Byte = -1
    }


    fun i() : Charge {
        return this
    }
}