package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

// ORIGINAL VALUE
open class AntiGreen (
    private val antiMatter: IAntiMatter = AntiMatter(AntiGreen::class),
) : AntiColor(),
    IAntiMatter by antiMatter
{ // Char
    constructor() : this(
        AntiMatter(AntiGreen::class),
    )

    init {
        color = ANTI_GREEN
    }


    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : AntiGreen {
        super.i()
        return this
    }
    override fun clone() : AntiGreen {
        var result      = AntiGreen()
        result.setValue(_value)
        return result
    }
}