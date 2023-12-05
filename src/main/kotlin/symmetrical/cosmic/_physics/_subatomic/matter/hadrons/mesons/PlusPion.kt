package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_hadrons.anti_mesons.AntiPlusPion
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiDown
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.balanced.pairs.ElectronPositron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class PlusPion(
    private val antiMatter: IAntiMatter = AntiMatter(PlusPion::class, AntiPlusPion::class),
) : Hadron(),
    IAntiMatter by antiMatter
{
    // The plus pion binds Protons together by carrying the color
    // charge of one to the other
    constructor() : this(
        AntiMatter(PlusPion::class, AntiPlusPion::class),
    )    init {
        super.i(2)
        this.set(0, Up())
        this.set(1, AntiDown())
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
//    fun decay() : ElectronPositron<PlusPion> {
//        return ElectronPositron<PlusPion>().decay(this)
//    }
    fun decay() : ElectronPositron {
        return ElectronPositron().decay(this)
    }
}