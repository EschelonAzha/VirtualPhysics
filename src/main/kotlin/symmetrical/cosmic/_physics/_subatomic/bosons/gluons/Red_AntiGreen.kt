package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Red_AntiGreen (
    private val fermion: IFermion = Fermion(Red_AntiGreen::class),
) : Gluon(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Red_AntiGreen::class),
    )
    init {
        color       = Red()
        antiColor   = AntiGreen()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Red_AntiGreen {
        super.i()
        return this
    }
    fun blue(charge: Gluon) : Blue_AntiBlue {
        var gluon = Blue().blue(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }
}