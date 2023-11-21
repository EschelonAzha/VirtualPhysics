package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

// ORIGINAL VALUE
open class AntiBlue(
    private val fermion: IFermion = Fermion(AntiBlue::class),
) : AntiColor(),
    IFermion by fermion
{  // String
    constructor() : this(
        Fermion(AntiBlue::class),
    )
    init {
        color = ANTI_BLUE
    }


    override fun getClassId() : String {
        return fermion.getClassId()
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