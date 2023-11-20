package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Red_AntiBlue (
    private val fermion: IFermion = Fermion(),
) : Gluon(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    ) init {
        color       = Red()
        antiColor   = AntiBlue()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Red_AntiBlue::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Red_AntiBlue {
        super.i()
        return this
    }
    fun green(charge: Gluon) : Green_AntiGreen {
        var gluon = charge.green().green(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }
}