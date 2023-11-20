package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Blue_AntiBlue(
    private val fermion: IFermion = Fermion(),
) : Gluon(),
    IFermion by fermion
{

    constructor() : this(
        Fermion()
    ) init {
        color       = Blue()
        antiColor   = AntiBlue()
    }


    private fun getLocalClassId() : String {
        return Absorber.getClassId(Blue_AntiBlue::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Blue_AntiBlue {
        super.i()
        return this
    }

    fun blue(charge: Gluon) : Blue_AntiBlue {
        return this
    }
}