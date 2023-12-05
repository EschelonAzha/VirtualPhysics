package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_hadrons.anti_mesons.AntiMinusPion
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class MinusPion (
    private val antiMatter: IAntiMatter = AntiMatter(MinusPion::class, AntiMinusPion::class),
) : Hadron(),
    IAntiMatter by antiMatter
{

    constructor() : this(
        AntiMatter(MinusPion::class, AntiMinusPion::class),
    ) init {
        super.i(2);
        this.set(0, Down())
        this.set(1, AntiUp())
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
//    fun decay() : ElectronPositron {
//        return ElectronPositron().decay(this)
//    }this
}