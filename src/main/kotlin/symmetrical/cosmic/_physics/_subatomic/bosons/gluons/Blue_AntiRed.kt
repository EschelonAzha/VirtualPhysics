package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Blue_AntiRed  (
    private val antiMatter: IAntiMatter = AntiMatter(Blue_AntiRed::class),
) : Gluon(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Blue_AntiRed::class),
    )
    init {
        color       = Blue()
        antiColor   = AntiRed()
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : Blue_AntiRed {
        super.i()
        return this
    }
    fun green(charge: Gluon) : Green_AntiGreen {
        var gluon = charge.green().green(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }

}