package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.colors.Color

// ORIGINAL VALUE
open class AntiBlue : AntiColor {
    constructor()
    init {
        color = ANTI_BLUE
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