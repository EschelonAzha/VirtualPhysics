package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_hadrons.anti_mesons.AntiNeutralDownPion
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiDown
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter


open class NeutralDownPion(
    private val matter: IMatter = Matter(NeutralDownPion::class, AntiNeutralDownPion::class, true),
) : Hadron(),
    IMatter by matter
{
    constructor() : this(
        Matter(NeutralDownPion::class, AntiNeutralDownPion::class, true),
    )   init {
        super.i(2)
        this.set(0, Down())
        this.set(1, AntiDown())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
//    fun decay() : ElectronPositron {
//        return ElectronPositron().decay(this)
//    }
}