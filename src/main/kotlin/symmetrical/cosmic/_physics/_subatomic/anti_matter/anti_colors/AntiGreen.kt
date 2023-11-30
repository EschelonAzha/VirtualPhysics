package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

// ORIGINAL VALUE
open class AntiGreen : AntiColor {
    constructor()

    init {
        color = ANTI_GREEN
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