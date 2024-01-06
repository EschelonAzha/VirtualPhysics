package symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons

import symmetrical.cosmic.physics.subatomic.matter.quarks.Down
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_hadrons.anti_mesons.AntiMinusPion
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.Hadron

/*
https://en.wikipedia.org/wiki/Pion
 */
open class MinusPion (
    private val matter: IMatter = Matter(MinusPion::class, AntiMinusPion::class),
) : Hadron(),
    IMatter by matter
{

    constructor() : this(
        Matter(MinusPion::class, AntiMinusPion::class),
    ) init {
        super.i(2);
        this.set(0, Down())
        this.set(1, AntiUp())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
//    fun decay() : ElectronPositron {
//        return ElectronPositron().decay(this)
//    }this
}