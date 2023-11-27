package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Green_AntiRed (
    private val antiMatter: IAntiMatter = AntiMatter(Green_AntiRed::class),
) : Gluon(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Green_AntiRed::class),
    )
    init {
        color       = green()
        antiColor   = AntiRed()
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : Green_AntiRed {
        super.i()
        return this
    }
    fun blue(charge: Gluon) : Blue_AntiBlue {
        var gluon = Blue().blue(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }
}