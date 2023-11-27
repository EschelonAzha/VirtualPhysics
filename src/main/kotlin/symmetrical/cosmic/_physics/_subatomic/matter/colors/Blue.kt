package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.balanced.color.QCD
import symmetrical.cosmic._physics._subatomic.bosons.gluons.Blue_AntiBlue
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

// PHOTON VALUE
open class Blue(
    private val antiMatter: IAntiMatter = AntiMatter(Blue::class),
): Color(),
    IAntiMatter by antiMatter
{ // Double
    constructor() : this(
        AntiMatter(Blue::class),
    )  init {
        color = BLUE
    }


    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : Blue {
        super.i()
        return this
    }
    override fun clone() : Blue {
        var result      = Blue()
        result.setValue(_value)
        return result
    }
    fun blue(charge: Gluon) : Blue_AntiBlue {
        var gluon = Blue_AntiBlue()
        gluon.color.setValue    (QCD().blue(charge.getAntiValue()))
        gluon.antiColor.setValue(charge.getAntiValue())

        return gluon
    }

}