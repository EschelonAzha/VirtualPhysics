package symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons

import symmetrical.cosmic.physics.subatomic.matter.quarks.Down
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_hadrons.anti_mesons.AntiNeutralDownPion
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.AntiDown
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.Hadron

/*
https://en.wikipedia.org/wiki/Pion
 */
open class NeutralDownPion(
    private val matter: IMatter = Matter(NeutralDownPion::class, AntiNeutralDownPion::class),
) : Hadron(),
    IMatter by matter
{
    constructor() : this(
        Matter(NeutralDownPion::class, AntiNeutralDownPion::class),
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