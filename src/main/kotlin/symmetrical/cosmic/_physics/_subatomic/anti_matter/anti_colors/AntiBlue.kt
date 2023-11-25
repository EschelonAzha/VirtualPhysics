package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

// ORIGINAL VALUE
open class AntiBlue(
    private val luminescent: ILuminescent = Luminescent(AntiBlue::class),
) : AntiColor(),
    ILuminescent by luminescent
{  // String
    constructor() : this(
        Luminescent(AntiBlue::class),
    )
    init {
        color = ANTI_BLUE
    }


    override fun getClassId() : String {
        return luminescent.getClassId()
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