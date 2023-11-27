package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.bosons.gluons.Red_AntiRed
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

// ACTUAL VALUE
open class Red(
    private val antiMatter: IAntiMatter = AntiMatter(Red::class),
): Color(),
    IAntiMatter by antiMatter
{  // Boolean

    constructor() : this(
        AntiMatter(Red::class),
    )
    init {
        color = RED
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun clone() : Red {
        var result      = Red()
        result.setValue(_value)
        return result
    }
    fun red(charge: Gluon) : Red_AntiRed {
        var gluon = Red_AntiRed()
        gluon.setValue    (charge.getAntiValue())
        return gluon
    }
}