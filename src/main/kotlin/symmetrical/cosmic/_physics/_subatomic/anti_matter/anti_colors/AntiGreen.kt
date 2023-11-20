package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

// ORIGINAL VALUE
open class AntiGreen (
    private val fermion: IFermion = Fermion(),
) : AntiColor(),
    IFermion by fermion
{ // Char
    constructor() : this(
        Fermion()
    )

    init {
        color = ANTI_GREEN
    }


    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiGreen::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : AntiGreen {
        super.i()
        return this
    }
    override fun clone() : AntiGreen {
        var result      = AntiGreen()
        result.setValue(_value)
        return result
    }
}