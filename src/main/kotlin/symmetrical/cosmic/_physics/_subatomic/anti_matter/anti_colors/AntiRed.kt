package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

// ORIGINAL VALUE
open class AntiRed (
    private val fermion: IFermion = Fermion(),
) : AntiColor(),
    IFermion by fermion
{  // Byte
    constructor() : this(
        Fermion()
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