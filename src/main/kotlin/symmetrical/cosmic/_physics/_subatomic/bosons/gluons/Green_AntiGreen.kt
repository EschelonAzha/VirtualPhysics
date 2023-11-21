package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Green_AntiGreen (
    private val fermion: IFermion = Fermion(Green_AntiGreen::class),
) : Gluon(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Green_AntiGreen::class),
    )
    init {
        color       = green()
        antiColor   = AntiGreen()
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Green_AntiGreen {
        super.i()
        return this
    }
    fun green(charge: Gluon) : Green_AntiGreen {
        return this
    }
}