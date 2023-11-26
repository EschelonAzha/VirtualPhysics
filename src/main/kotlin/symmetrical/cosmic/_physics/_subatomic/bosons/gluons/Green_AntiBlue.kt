package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Green_AntiBlue (
    private val luminescent: ILuminescent = Luminescent(Green_AntiBlue::class),
) : Gluon(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Green_AntiBlue::class),
    )
    init {
        color       = green()
        antiColor   = AntiBlue()
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
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