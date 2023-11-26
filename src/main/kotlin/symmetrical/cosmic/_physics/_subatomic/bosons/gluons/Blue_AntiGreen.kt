package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class Blue_AntiGreen (
    private val luminescent: ILuminescent = Luminescent(Blue_AntiGreen::class),
) : Gluon(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Blue_AntiGreen::class),
    )
    init {
        color       = Blue()
        antiColor   = AntiGreen()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
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