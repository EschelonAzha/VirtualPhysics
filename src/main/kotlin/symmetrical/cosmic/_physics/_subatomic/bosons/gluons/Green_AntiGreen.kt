package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Green_AntiGreen : Gluon {
    constructor()
    init {
        color       = green()
        antiColor   = AntiGreen()
    }

    override fun i() : Green_AntiGreen {
        super.i()
        return this
    }
    fun green(charge: Gluon) : Green_AntiGreen {
        return this
    }
}