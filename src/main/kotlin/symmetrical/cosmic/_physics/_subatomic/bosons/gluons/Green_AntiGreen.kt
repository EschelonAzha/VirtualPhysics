package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Green_AntiGreen (
    private val luminescent: ILuminescent = Luminescent(Green_AntiGreen::class),
) : Gluon(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Green_AntiGreen::class),
    )
    init {
        color       = green()
        antiColor   = AntiGreen()
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : Green_AntiGreen {
        super.i()
        return this
    }
    fun green(charge: Gluon) : Green_AntiGreen {
        return this
    }
}