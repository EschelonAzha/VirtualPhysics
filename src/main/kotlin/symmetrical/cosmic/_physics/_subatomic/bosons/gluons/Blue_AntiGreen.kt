package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement


class Blue_AntiGreen (
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) : Gluon(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    ) init {
        color       = Blue()
        antiColor   = AntiGreen()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Blue_AntiGreen::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
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