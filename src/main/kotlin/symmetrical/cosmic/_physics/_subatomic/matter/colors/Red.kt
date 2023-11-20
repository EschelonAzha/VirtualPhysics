package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.gluons.Red_AntiRed
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

// ACTUAL VALUE
open class Red(
    private val fermion: IQuantumEntanglement
): Color(),
    IQuantumEntanglement by fermion
{  // Boolean

    constructor() : this(
        QuantumEntanglement()
    ) init {
        color = RED
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Red::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
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