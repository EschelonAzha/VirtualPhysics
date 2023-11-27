package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Blue_AntiBlue(
    private val antiMatter: IAntiMatter = AntiMatter(Blue_AntiBlue::class),
) : Gluon(),
    IAntiMatter by antiMatter
{

    constructor() : this(
        AntiMatter(Blue_AntiBlue::class),
    )
    init {
        color       = Blue()
        antiColor   = AntiBlue()
    }


    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : Blue_AntiBlue {
        super.i()
        return this
    }

    fun blue(charge: Gluon) : Blue_AntiBlue {
        return this
    }
}