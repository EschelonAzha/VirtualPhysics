package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Red_AntiGreen (
    private val fermion: ILuminescent = Luminescent(Red_AntiGreen::class),
) : Gluon(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(Red_AntiGreen::class),
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