package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_hadrons.anti_mesons.AntiNeutralDownPion
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiDown
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class NeutralDownPion(
    private val antiMatter: IAntiMatter = AntiMatter(NeutralDownPion::class, AntiNeutralDownPion::class),
) : Hadron(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(NeutralDownPion::class, AntiNeutralDownPion::class),
    )   init {
        super.i(2)
        this.set(0, Down())
        this.set(1, AntiDown())
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
//    fun decay() : ElectronPositron {
//        return ElectronPositron().decay(this)
//    }
}