package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Green_AntiBlue (
    private val fermion: IFermion = Fermion(Green_AntiBlue::class),
) : Gluon(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Green_AntiBlue::class),
    )
    init {
        color       = green()
        antiColor   = AntiBlue()
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Green_AntiBlue {
        super.i()
        return this
    }
    fun red(charge: Gluon) : Red_AntiRed {
        var gluon = Red().red(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }
}