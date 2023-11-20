package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

// ORIGINAL VALUE
open class AntiBlue(
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) : AntiColor(),
    IQuantumEntanglement by fermion
{  // String
    constructor() : this(
        QuantumEntanglement()
    )
    init {
        color = ANTI_BLUE
    }


    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiBlue::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : AntiBlue {
        super.i()
        return this
    }
    override fun clone() : AntiBlue {
        var result      = AntiBlue()
        result.setValue(_value)
        return result
    }

}