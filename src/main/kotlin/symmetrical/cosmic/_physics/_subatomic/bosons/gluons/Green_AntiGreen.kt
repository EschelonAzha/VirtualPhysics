package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Green_AntiGreen (
    private val fermion: IFermion = Fermion(),
) : Gluon(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    ) init {
        color       = green()
        antiColor   = AntiGreen()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Green_AntiGreen::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Green_AntiGreen {
        super.i()
        return this
    }
    fun green(charge: Gluon) : Green_AntiGreen {
        return this
    }
}