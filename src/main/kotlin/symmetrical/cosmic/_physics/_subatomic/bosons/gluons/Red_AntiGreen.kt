package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Red_AntiGreen (
    private val antiMatter: IAntiMatter = AntiMatter(Red_AntiGreen::class),
) : Gluon(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Red_AntiGreen::class),
    )
    init {
        color       = Red()
        antiColor   = AntiGreen()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
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