package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


class Blue_AntiGreen (
    private val fermion: IFermion = Fermion(Blue_AntiGreen::class),
) : Gluon(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Blue_AntiGreen::class),
    )
    init {
        color       = Blue()
        antiColor   = AntiGreen()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Blue_AntiGreen {
        super.i()
        return this
    }
    fun red(charge: Gluon) : Red_AntiRed {
        var gluon = Red().red(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }
}