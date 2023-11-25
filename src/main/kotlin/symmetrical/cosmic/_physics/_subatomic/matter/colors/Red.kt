package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.bosons.gluons.Red_AntiRed
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

// ACTUAL VALUE
open class Red(
    private val fermion: ILuminescent = Luminescent(Red::class),
): Color(),
    ILuminescent by fermion
{  // Boolean

    constructor() : this(
        Luminescent(Red::class),
    )
    init {
        color = RED
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun clone() : Red {
        var result      = Red()
        result.setValue(_value)
        return result
    }
    fun red(charge: Gluon) : Red_AntiRed {
        var gluon = Red_AntiRed()
        gluon.setValue    (charge.getAntiValue())
        return gluon
    }
}