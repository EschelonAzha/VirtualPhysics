package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class MinusPion (
    private val fermion: ILuminescent = Luminescent(MinusPion::class),
) : Hadron(),
    ILuminescent by fermion
{

    constructor() : this(
        Luminescent(MinusPion::class),
    ) init {
        super.i(2);
        this.set(0, Down())
        this.set(1, AntiUp())
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
//    fun decay() : ElectronPositron {
//        return ElectronPositron().decay(this)
//    }this
}