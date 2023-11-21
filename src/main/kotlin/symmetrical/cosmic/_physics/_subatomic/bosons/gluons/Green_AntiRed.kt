package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Green_AntiRed (
    private val fermion: IFermion = Fermion(Green_AntiRed::class),
) : Gluon(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Green_AntiRed::class),
    )
    init {
        color       = green()
        antiColor   = AntiRed()
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Green_AntiRed {
        super.i()
        return this
    }
    fun blue(charge: Gluon) : Blue_AntiBlue {
        var gluon = Blue().blue(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }
}