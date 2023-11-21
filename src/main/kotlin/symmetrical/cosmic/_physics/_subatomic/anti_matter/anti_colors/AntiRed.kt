package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

// ORIGINAL VALUE
open class AntiRed (
    private val fermion: IFermion = Fermion(AntiRed::class),
) : AntiColor(),
    IFermion by fermion
{  // Byte
    constructor() : this(
        Fermion(AntiRed::class),
    ) {
        fermion.setKClass(AntiRed::class)
    }

    init {
        color = ANTI_RED
    }


    override fun getClassId() : String {
        return fermion.getClassId()
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