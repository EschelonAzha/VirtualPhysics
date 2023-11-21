package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Blue_AntiRed  (
    private val fermion: IFermion = Fermion(Blue_AntiRed::class),
) : Gluon(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Blue_AntiRed::class),
    )
    init {
        color       = Blue()
        antiColor   = AntiRed()
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Blue_AntiRed {
        super.i()
        return this
    }
    fun green(charge: Gluon) : Green_AntiGreen {
        var gluon = charge.green().green(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }

}