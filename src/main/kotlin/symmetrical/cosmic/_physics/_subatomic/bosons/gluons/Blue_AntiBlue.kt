package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Blue_AntiBlue(
    private val fermion: IFermion = Fermion(Blue_AntiBlue::class),
) : Gluon(),
    IFermion by fermion
{

    constructor() : this(
        Fermion(Blue_AntiBlue::class),
    )
    init {
        color       = Blue()
        antiColor   = AntiBlue()
    }


    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Blue_AntiBlue {
        super.i()
        return this
    }

    fun blue(charge: Gluon) : Blue_AntiBlue {
        return this
    }
}