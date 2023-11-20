package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

// ORIGINAL VALUE
open class AntiRed (
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) : AntiColor(),
    IQuantumEntanglement by fermion
{  // Byte
    constructor() : this(
        QuantumEntanglement()
    )

    init {
        color = ANTI_RED
    }


    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiRed::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : AntiRed {
        super.i()
        return this
    }
    override fun clone() : AntiRed {
        var result      = AntiRed()
        result.setValue(_value)
        return result
    }
}