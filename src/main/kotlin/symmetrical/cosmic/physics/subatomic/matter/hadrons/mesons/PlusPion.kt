package symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons

import symmetrical.cosmic.physics.subatomic.matter.quarks.Up
import symmetrical.cosmic.physics.subatomic.balanced.pairs.ElectronPositron
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_hadrons.anti_mesons.AntiPlusPion
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.AntiDown
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.Hadron

/*
https://en.wikipedia.org/wiki/Pion
 */
open class PlusPion(
    private val matter: IMatter = Matter(PlusPion::class, AntiPlusPion::class),
) : Hadron(),
    IMatter by matter
{
    // The plus pion binds Protons together by carrying the color
    // charge of one to the other
    constructor() : this(
        Matter(PlusPion::class, AntiPlusPion::class),
    )    init {
        super.i(2)
        this.set(0, Up())
        this.set(1, AntiDown())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
//    fun decay() : ElectronPositron<PlusPion> {
//        return ElectronPositron<PlusPion>().decay(this)
//    }
    fun decay() : ElectronPositron {
        return ElectronPositron().decay(this)
    }
}