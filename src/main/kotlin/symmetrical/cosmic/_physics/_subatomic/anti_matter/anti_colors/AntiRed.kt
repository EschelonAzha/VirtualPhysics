package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

// ORIGINAL VALUE
open class AntiRed (
    private val antiMatter: IAntiMatter = AntiMatter(AntiRed::class),
) : AntiColor(),
    IAntiMatter by antiMatter
{  // Byte
    constructor() : this(
        AntiMatter(AntiRed::class),
    ) {
        antiMatter.setKClass(AntiRed::class)
    }

    init {
        color = ANTI_RED
    }


    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : AntiRed {
        super.i()
        return this
    }
    override fun clone() : AntiRed {
        var result      = AntiRed()
        result.setValue(_value)
        return result
    }
}