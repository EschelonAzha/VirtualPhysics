package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Red_AntiBlue (
    private val antiMatter: IAntiMatter = AntiMatter(Red_AntiBlue::class),
) : Gluon(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Red_AntiBlue::class),
    )
    init {
        color       = Red()
        antiColor   = AntiBlue()
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
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