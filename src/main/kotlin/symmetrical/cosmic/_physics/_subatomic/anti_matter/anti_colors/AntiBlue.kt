package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

// ORIGINAL VALUE
open class AntiBlue(
    private val antiMatter: IAntiMatter = AntiMatter(AntiBlue::class),
) : AntiColor(),
    IAntiMatter by antiMatter
{  // String
    constructor() : this(
        AntiMatter(AntiBlue::class),
    )
    init {
        color = ANTI_BLUE
    }


    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : AntiBlue {
        super.i()
        return this
    }
    override fun clone() : AntiBlue {
        var result      = AntiBlue()
        result.setValue(_value)
        return result
    }

}